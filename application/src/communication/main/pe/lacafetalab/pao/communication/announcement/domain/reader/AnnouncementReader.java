package pe.lacafetalab.pao.communication.announcement.domain.reader;

import pe.lacafetalab.pao.communication.announcement.domain.AnnouncementId;
import pe.lacafetalab.pao.communication.announcement.domain.AnnouncementPublishAt;
import pe.lacafetalab.pao.communication.announcement.domain.ReaderId;

import java.util.Objects;

public final class AnnouncementReader {
    private final AnnouncementReaderId id;
    private final ReaderId readerId;
    private final AnnouncementId announcementId;
    private AnnouncementReaderSeen announcementReaderSeen;
    private final AnnouncementPublishAt announcementPublishAt;

    public AnnouncementReader(AnnouncementReaderId id, ReaderId readerId, AnnouncementId announcementId, AnnouncementReaderSeen announcementReaderSeen, AnnouncementPublishAt announcementPublishAt) {
        this.id = id;
        this.readerId = readerId;
        this.announcementId = announcementId;
        this.announcementReaderSeen = announcementReaderSeen;
        this.announcementPublishAt = announcementPublishAt;
    }

    public static AnnouncementReader create(AnnouncementReaderId id,
                                            ReaderId readerId,
                                            AnnouncementId announcementId,
                                            AnnouncementPublishAt announcementPublishAt) {
        return new AnnouncementReader(id, readerId, announcementId, new AnnouncementReaderSeen(false), announcementPublishAt);
    }

    public AnnouncementReaderId id() {
        return id;
    }

    public ReaderId readerId() {
        return readerId;
    }

    public AnnouncementId announcementId() {
        return announcementId;
    }

    public AnnouncementReaderSeen announcementReaderSeen() {
        return announcementReaderSeen;
    }

    public AnnouncementPublishAt announcementPublishAt() {
        return announcementPublishAt;
    }

    public void toSeen() {
        this.announcementReaderSeen = new AnnouncementReaderSeen(true);
    }

    //todo: da erro ren los test porque el id es random, cambiar aque se genre por nombres
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnnouncementReader)) return false;
        AnnouncementReader that = (AnnouncementReader) o;
        return  Objects.equals(readerId, that.readerId) &&
                Objects.equals(announcementId, that.announcementId) &&
                Objects.equals(announcementReaderSeen, that.announcementReaderSeen) &&
                Objects.equals(announcementPublishAt, that.announcementPublishAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, readerId, announcementId, announcementReaderSeen, announcementPublishAt);
    }
}
