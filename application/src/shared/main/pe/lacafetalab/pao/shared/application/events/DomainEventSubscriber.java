package pe.lacafetalab.pao.shared.application.events;

import pe.lacafetalab.pao.shared.domain.events.DomainEvent;

public interface DomainEventSubscriber<EventType extends DomainEvent> {

	Class<EventType> subscribedTo();

	void consume(EventType event);
}
