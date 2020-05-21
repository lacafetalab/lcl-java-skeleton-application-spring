package pe.lacafetalab.pao.shared.infrastructure;

import static reactor.bus.selector.Selectors.$;

import java.util.List;
import java.util.Set;

import pe.lacafetalab.pao.shared.application.events.DomainEventSubscriber;
import pe.lacafetalab.pao.shared.domain.events.DomainEvent;
import reactor.bus.Event;
import reactor.bus.EventBus;
import reactor.bus.selector.Selector;
import reactor.fn.Consumer;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class ReactorEventBus implements pe.lacafetalab.pao.shared.domain.events.EventBus {
	private final EventBus bus;

	public ReactorEventBus(final Set<DomainEventSubscriber> subscribers) {
		bus = EventBus.create();
		subscribers.forEach(this::registerOnEventBus);
	}

	@Override
	public void publish(final List<DomainEvent> events) {
		events.forEach(this::publish);
	}

	private void publish(final DomainEvent event) {
		Class<? extends DomainEvent> eventIdentifier = event.getClass();
		Event<DomainEvent> wrappedEvent = Event.wrap(event);
		bus.notify(eventIdentifier, wrappedEvent);
	}

	private void registerOnEventBus(final DomainEventSubscriber subscriber) {
		final Selector eventIdentifier = $(subscriber.subscribedTo());

		bus.on(eventIdentifier, eventConsumer(subscriber));
	}

	private Consumer<Event> eventConsumer(final DomainEventSubscriber subscriber) {
		return (Event reactorEvent) -> {
			DomainEvent unwrappedEvent = (DomainEvent) reactorEvent.getData();
			subscriber.consume(unwrappedEvent);
		};
	}
}
