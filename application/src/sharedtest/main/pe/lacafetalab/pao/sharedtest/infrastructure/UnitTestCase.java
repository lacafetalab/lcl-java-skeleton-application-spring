package pe.lacafetalab.pao.sharedtest.infrastructure;

import org.junit.jupiter.api.BeforeEach;
import pe.lacafetalab.pao.shared.domain.UuidGenerator;
import pe.lacafetalab.pao.shared.domain.bus.event.DomainEvent;
import pe.lacafetalab.pao.shared.domain.bus.event.EventBus;
import pe.lacafetalab.pao.shared.domain.bus.query.Query;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryBus;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryNotRegisteredError;
import pe.lacafetalab.pao.shared.domain.bus.query.Response;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public abstract class UnitTestCase {
    protected EventBus      eventBus;
    protected QueryBus      queryBus;
    protected UuidGenerator uuidGenerator;

    @BeforeEach
    protected void setUp() {
        eventBus      = mock(EventBus.class);
        queryBus      = mock(QueryBus.class);
        uuidGenerator = mock(UuidGenerator.class);
    }

    public void shouldHavePublished(List<DomainEvent> domainEvents) {
        verify(eventBus, atLeastOnce()).publish(domainEvents);
    }

    public void shouldHavePublished(DomainEvent domainEvent) {
        shouldHavePublished(Collections.singletonList(domainEvent));
    }

    public void shouldGenerateUuid(String uuid) {
        when(uuidGenerator.generate()).thenReturn(uuid);
    }

    public void shouldGenerateUuids(String uuid, String... others) {
        when(uuidGenerator.generate()).thenReturn(uuid, others);
    }

    public void shouldAsk(Query query, Response response) throws QueryNotRegisteredError {
        when(queryBus.ask(query)).thenReturn(response);
    }
}
