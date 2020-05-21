package pe.lacafetalab.pao.communication.announcement.domain;

import pe.lacafetalab.pao.shared.domain.bus.event.DomainEvent;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public final class AnnouncementCreatedDomainEvent extends DomainEvent {
    private final String title;
    private final String description;
    private final String authorId;
    private final String classRoomId;
    private final String publishAt;

    public AnnouncementCreatedDomainEvent() {
        super(null);
        this.title = null;
        this.description = null;
        this.authorId = null;
        this.classRoomId = null;
        this.publishAt = null;
    }

    public AnnouncementCreatedDomainEvent(String aggregateId, String title, String description, String authorId, String classRoomId, String publishAt) {
        super(aggregateId);
        this.title = title;
        this.description = description;
        this.authorId = authorId;
        this.classRoomId = classRoomId;
        this.publishAt = publishAt;
    }

    public AnnouncementCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String title, String description, String authorId, String classRoomId, String publishAt) {
        super(aggregateId, eventId, occurredOn);
        this.title = title;
        this.description = description;
        this.authorId = authorId;
        this.classRoomId = classRoomId;
        this.publishAt = publishAt;
    }

    @Override
    public String eventName() {
        return "comunication.announcement.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("title", title);
            put("description", description);
            put("authorId", authorId);
            put("classRoomId", classRoomId);
            put("publishAt", publishAt);
        }};
    }

    @Override
    public AnnouncementCreatedDomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new AnnouncementCreatedDomainEvent(aggregateId, eventId, occurredOn, (String) body.get("title"), (String) body.get("description"), (String) body.get("authorId"), (String) body.get("classRoomId"), (String) body.get("publishAt"));
    }

    public String title() {
        return title;
    }

    public String description() {
        return description;
    }

    public String authorId() {
        return authorId;
    }

    public String classRoomId() {
        return classRoomId;
    }

    public String publishAt() {
        return publishAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnnouncementCreatedDomainEvent)) return false;
        AnnouncementCreatedDomainEvent that = (AnnouncementCreatedDomainEvent) o;
        return Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(authorId, that.authorId) && Objects.equals(classRoomId, that.classRoomId) && Objects.equals(publishAt, that.publishAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, authorId, classRoomId, publishAt);
    }
}
