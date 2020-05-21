package pe.lacafetalab.pao.controller.announcement.reader;

import org.junit.jupiter.api.Test;
import pe.lacafetalab.pao.ApplicationTestCase;
import pe.lacafetalab.pao.communication.announcement.domain.AnnouncementCreatedDomainEvent;


public final class SearchReaderGetControllerShould extends ApplicationTestCase {
    @Test
    void event_create_announcement_on_generate_reader_list() throws Exception {
        executeRequest(
                "POST",
                "/announcement",
                "{\"title\": \"Title\", \"description\": \"alguna descripcion\", \"authorId\": \"d4df3fba-802a-4cde-a99a-0e4f84cf41ac\", \"classRoomId\": \"b3a7b9de-cb4e-42c9-984b-bf331f4871ce\", \"publishAt\": \"2020-04-14 21:06:49\"}"
        );
        /* todo: genrar un announcement y regresar el id, programr una funcion que regres el id
        *  solo enviar un evento
         * */
//        givenISendEventsToTheBus(
//                new AnnouncementCreatedDomainEvent(
//                        "8f34bc99-e0e2-4296-a008-75f51f03aeb4",
//                        "titulo anuncio",
//                        "titulo descripcion",
//                        "4b860f4d-4427-4010-864d-fb61e14191ea",
//                        "7e1bd9ee-7b5c-4357-9051-6ee7b054de06",
//                        "2020-04-14 21:06:49")
//        );
        assertRequest(
                "GET",
                "/announcement/reader/19ad377a-7d39-409a-ab55-c7c29814d488/1",
                200
        );
    }
}