package pe.lacafetalab.pao.communication.user.domain;

import pe.lacafetalab.pao.shared.domain.bus.event.DomainEvent;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public final class UserCreatedDomainEvent extends DomainEvent {
    private final String name;
    private final String lastname;
    private final String description;
    private final String birthdate;

    public UserCreatedDomainEvent() {
        super(null);
        this.name = null;
        this.lastname = null;
        this.description = null;
        this.birthdate = null;
    }

    public UserCreatedDomainEvent(String aggregateId, String name, String lastname, String description, String birthdate) {
        super(aggregateId);
        this.name = name;
        this.lastname = lastname;
        this.description = description;
        this.birthdate = birthdate;
    }

    public UserCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String name, String lastname, String description, String birthdate) {
        super(aggregateId, eventId, occurredOn);
        this.name = name;
        this.lastname = lastname;
        this.description = description;
        this.birthdate = birthdate;
    }

    @Override
    public String eventName() {
        return "comunication.user.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("name", name);
            put("lastname", lastname);
            put("description", description);
            put("birthdate", birthdate);
        }};
    }

    @Override
    public UserCreatedDomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new UserCreatedDomainEvent(aggregateId, eventId, occurredOn, (String) body.get("name"), (String) body.get("lastname"), (String) body.get("description"), (String) body.get("birthdate"));
    }

    public String name() {
        return name;
    }

    public String lastname() {
        return lastname;
    }

    public String description() {
        return description;
    }

    public String birthdate() {
        return birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserCreatedDomainEvent)) return false;
        UserCreatedDomainEvent that = (UserCreatedDomainEvent) o;
        return Objects.equals(name, that.name) && Objects.equals(lastname, that.lastname) && Objects.equals(description, that.description) && Objects.equals(birthdate, that.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname, description, birthdate);
    }
}
