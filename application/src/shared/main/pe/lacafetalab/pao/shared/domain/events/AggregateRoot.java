package pe.lacafetalab.pao.shared.domain.events;

import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public abstract class AggregateRoot {

	@JsonProperty(access = Access.READ_ONLY)
	private List<DomainEvent> recordedDomainEvents = new LinkedList<>();

	final public List<DomainEvent> pullDomainEvents() {
		final var recordedDomainEvents = this.recordedDomainEvents;
		this.recordedDomainEvents = new LinkedList<>();
		return recordedDomainEvents;
	}

	final protected void record(DomainEvent event) {
		this.recordedDomainEvents.add(event);
	}
}
