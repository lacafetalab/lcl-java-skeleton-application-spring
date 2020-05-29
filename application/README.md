
## Se usan 3 tipos de test

1. **Aceptación :** Se testean los endpoint y domain event.
2. **Integración :** Se testean las clases que persisten data o se comunican con otros servicios.
3. **Unitarios     :** Se testean los servicios de applicacion (casos de uso).

---

# Test de Aceptación

Son los test más pesados a nivel de recursos y tiempo, por ese motivo son pocos test de este tipo, solo estamos testeando los happy test (test que solo validan un flujo váido).

Estos test estan en la carpeta /appications/test 

Tenemos una clase que nos ayuda en esta tarea [ApplicationTestCase](https://github.com/lacafetalab/lcl-java-skeleton-application-spring/blob/master/application/applications/test/pe/lacafetalab/pao/ApplicationTestCase.java) 

```java
package pe.lacafetalab.pao.controller.announcement;

import org.junit.jupiter.api.Test;
import pe.lacafetalab.pao.ApplicationTestCase;

public final class AnnouncementPostControllerShould extends ApplicationTestCase {
    @Test
    void create_a_valid_non_existing_course() throws Exception {
        assertRequestCreated(
                "POST",
                "/announcement",
                "{\"title\": \"Title\", \"description\": \"alguna descripcion\", \"authorId\": \"d4df3fba-802a-4cde-a99a-0e4f84cf41ac\", \"classRoomId\": \"b3a7b9de-cb4e-42c9-984b-bf331f4871ce\", \"publishAt\": \"2020-04-14 21:06:49\"}"
        );
    }
}
```

a veces es necesario crear datos para que un test pase, para esto se puede ejecutar un endpoint o un evento

```java
@Test
void get_the_counter_with_one_course() throws Exception {
    givenISendEventsToTheBus(
        new CourseCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "DDD en Java", "7 days")
    );

    assertResponse("/courses-counter", 200, "{'total': 1}");
}
```

# Test de Integracíon

Estos test estan diseñados para testear la persistencia de datos y la coneccion con otros servicios. Estos test aun son pesados porque que tienen que iniciar infraestructura (base de datos, redis cache, elasticksearch, etc), estan diseñados para testear la implementacion de la "Interface" de un aggregate. No se debe testear lógica de negocio en este tipo de test, solo debemos asegurar que este trabajando según el contrato de Repositorio que se creó.

Estos test estan dentro de cada modulo /src/module_name/test

Se usa el patrón ObjectMother para la generación de data, esto se usa para no tener test flágiles

[bliki: ObjectMother](https://martinfowler.com/bliki/ObjectMother.html)

```java
@Test
void save_a_announcement() {
    Announcement announcement = AnnouncementMother.random();
    sqlAnnouncementRepository.save(announcement);

    Optional<Announcement> announcement1Sql = sqlAnnouncementRepository.findById(announcement.id());
    assertTrue(announcement1Sql.isPresent());
    assertEquals(announcement, announcement1Sql.get());
}
```

[aqui el ejemplo completo](https://github.com/lacafetalab/lcl-java-skeleton-application-spring/blob/master/application/src/communication/test/pe/lacafetalab/pao/communication/announcement/infrastructure/persistence/SqlAnnouncementRepositoryShould.java) 

# Test Unitarios

No dejemos que el nombre "unitario" nos engañe un poco, estos test  **NO**  es estan diseñados para testear una clase o una funcion. Aquí vamos a testear los **casos de uso** (servicios de dominio) de nuestra aplicacion, solo que vamos a mokear el repositorio (no vamos a inicar nungun servio externo), esto ayuda a correr muchos test en forma rápida, aqui debemos poner todo nuestro esfuerzo para cubrir logica de negocio, y son los test mas abundantes dentro del desarrollo.

En estos test cubrimos comman, query, Handler, y servicio de applicaciion

```java
@Test
void create_a_valid_course() {
    CreateAnnouncementCommand command = CreateAnnouncementCommandMother.random();
    Announcement announcement = AnnouncementMother.fromRequest(command);
    AnnouncementCreatedDomainEvent domainEvent = AnnouncementCreatedDomainEventMother.fromAnnouncement(announcement);

    handler.handle(command);

    shouldHaveSaved(announcement);
    shouldHavePublished(domainEvent);
}
```

Nos aseguramos que la data de un query o command llegue bien al handler y este a la vez mande la data correcta al servicio. Ademas que se envien bien los eventos de dominio, en la parte de repositorio, nos aseguramos que envie bien la data al repositorio. [Aqui el ejemplo completo](https://github.com/lacafetalab/lcl-java-skeleton-application-spring/blob/master/application/src/communication/test/pe/lacafetalab/pao/communication/announcement/application/create/CreateAnnouncementCommandHandlerShould.java)

Para estos test se usan mucho los objectMother, para generar data

---

> para correr todos estos test, hay un solo comando

```java
./gradlew test --warning-mode all
```
