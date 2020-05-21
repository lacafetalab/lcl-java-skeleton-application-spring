package pe.lacafetalab.pao.communication.announcement.application;

import lombok.Getter;
import pe.lacafetalab.pao.communication.announcement.domain.*;
import pe.lacafetalab.pao.shared.domain.bus.query.Response;

import java.util.Objects;

@Getter
final public class AnnouncementResponse implements Response {
    private final String id;
    private final String title;
    private final String description;
    private final String publishAt;

    public AnnouncementResponse(String id, String title, String description, String publishAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.publishAt = publishAt;
    }

    public static AnnouncementResponse fromAggregate(Announcement announcement){
        return new AnnouncementResponse(
                announcement.id().value(),
                announcement.title().value(),
                announcement.description().value(),
                announcement.publishAt().toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnnouncementResponse)) return false;
        AnnouncementResponse that = (AnnouncementResponse) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getPublishAt(), that.getPublishAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getDescription(), getPublishAt());
    }
}


