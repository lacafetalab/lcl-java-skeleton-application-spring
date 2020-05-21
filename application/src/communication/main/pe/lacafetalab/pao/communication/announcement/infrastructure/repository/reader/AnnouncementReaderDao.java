package pe.lacafetalab.pao.communication.announcement.infrastructure.repository.reader;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pe.lacafetalab.pao.communication.announcement.domain.*;
import pe.lacafetalab.pao.communication.announcement.domain.reader.AnnouncementReader;
import pe.lacafetalab.pao.communication.announcement.domain.reader.AnnouncementReaderId;
import pe.lacafetalab.pao.communication.announcement.domain.reader.AnnouncementReaderSeen;
import pe.lacafetalab.pao.shared.infrastructure.dao.GeneralEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity(name = "AnnouncementReader")
@Table(name = "announcement_reader")
public class AnnouncementReaderDao extends GeneralEntity<AnnouncementReader> {
    private static final long serialVersionUID = 1L;

    public static String SEPARATOR = "|";

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "reader_id", length = 36)
    private String readerId;

    @Column(name = "announcement_id", length = 36)
    private String announcementId;

    @Column(name = "seen")
    private Boolean announcementReaderSeen;

    @Column(name = "announcement_publish_at")
    private Date announcementPublishAt;


    public AnnouncementReaderDao(AnnouncementReader announcementReader) {
        super();
        this.id = announcementReader.id().value();
        this.readerId = announcementReader.readerId().value();
        this.announcementId = announcementReader.announcementId().value();
        this.announcementReaderSeen = announcementReader.announcementReaderSeen().value();
        this.announcementPublishAt = announcementReader.announcementPublishAt().value();
    }

    @Override
    public AnnouncementReader toDomain() {
        return new AnnouncementReader(
                new AnnouncementReaderId(this.id),
                new ReaderId(this.readerId),
                new AnnouncementId(this.announcementId),
                new AnnouncementReaderSeen(this.announcementReaderSeen),
                new AnnouncementPublishAt(this.announcementPublishAt)
        );
    }

}


