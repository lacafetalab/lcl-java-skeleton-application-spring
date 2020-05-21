package pe.lacafetalab.pao.shared.domain.events;

import java.util.List;

public interface EventBus {

	void publish(final List<DomainEvent> events);

}
