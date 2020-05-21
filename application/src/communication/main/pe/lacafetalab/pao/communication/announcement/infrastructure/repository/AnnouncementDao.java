package pe.lacafetalab.pao.communication.announcement.infrastructure.repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pe.lacafetalab.pao.communication.announcement.domain.*;
import pe.lacafetalab.pao.shared.infrastructure.dao.GeneralEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity(name = "Announcement")
@Table(name = "announcement")
public class AnnouncementDao extends GeneralEntity<Announcement> {

    private static final long serialVersionUID = 1L;
    public static String SEPARATOR = "|";

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "title", columnDefinition = "text")
    private String title;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "author_id", length = 36)
    private String authorId;

    @Column(name = "classroom_id", length = 36)
    private String classRoomId;

    @Column(name = "publish_at")
    private Date publishAt;

    public AnnouncementDao(Announcement entity) {
        super();
        this.id = entity.id().value();
        this.title = entity.title().value();
        this.description = entity.description().value();
        this.authorId = entity.authorId().value();
        this.classRoomId = entity.classRoomId().value();
        this.publishAt = entity.publishAt().value();
    }

    @Override
    public Announcement toDomain() {
        return new Announcement(new AnnouncementId(this.id), new AnnouncementTitle(this.title), new AnnouncementDescription(this.description), new AnnouncementAuthorId(this.authorId), new AnnouncementClassRoomId(this.classRoomId), new AnnouncementPublishAt(this.publishAt));
    }
}
