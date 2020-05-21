package pe.lacafetalab.pao.communication.announcement.domain;

import pe.lacafetalab.pao.shared.domain.AggregateRoot;

import java.util.Objects;

public final class Announcement extends AggregateRoot {
    private final AnnouncementId id;
    private final AnnouncementTitle title;
    private final AnnouncementDescription description;
    private final AnnouncementAuthorId authorId;
    private final AnnouncementClassRoomId classRoomId;
    private final AnnouncementPublishAt publishAt;

    public Announcement(AnnouncementId id, AnnouncementTitle title, AnnouncementDescription description, AnnouncementAuthorId authorId, AnnouncementClassRoomId classRoomId, AnnouncementPublishAt publishAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.authorId = authorId;
        this.classRoomId = classRoomId;
        this.publishAt = publishAt;
    }

    public static Announcement create(AnnouncementId id, AnnouncementTitle title, AnnouncementDescription description, AnnouncementAuthorId authorId, AnnouncementClassRoomId classRoomId, AnnouncementPublishAt publishAt) {
        Announcement entity = new Announcement(id, title, description, authorId, classRoomId, publishAt);
        entity.record(new AnnouncementCreatedDomainEvent(id.toString(), title.toString(), description.toString(), authorId.toString(), classRoomId.toString(), publishAt.toString()));
        return entity;
    }

    public AnnouncementId id() {
        return id;
    }

    public AnnouncementTitle title() {
        return title;
    }

    public AnnouncementDescription description() {
        return description;
    }

    public AnnouncementAuthorId authorId() {
        return authorId;
    }

    public AnnouncementClassRoomId classRoomId() {
        return classRoomId;
    }

    public AnnouncementPublishAt publishAt() {
        return publishAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Announcement)) return false;
        Announcement that = (Announcement) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(authorId, that.authorId) && Objects.equals(classRoomId, that.classRoomId) && Objects.equals(publishAt, that.publishAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, authorId, classRoomId, publishAt);
    }
}
