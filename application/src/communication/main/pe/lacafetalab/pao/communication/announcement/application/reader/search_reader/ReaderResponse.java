package pe.lacafetalab.pao.communication.announcement.application.reader.search_reader;

import lombok.Getter;
import pe.lacafetalab.pao.communication.announcement.application.AnnouncementResponse;
import pe.lacafetalab.pao.communication.announcement.domain.Announcement;
import pe.lacafetalab.pao.communication.announcement.domain.reader.AnnouncementReader;
import pe.lacafetalab.pao.shared.domain.bus.query.Response;

@Getter
public final class ReaderResponse implements Response {
    private final String id;
    private final Boolean seen;
    private final AnnouncementResponse announcement;

    public ReaderResponse(AnnouncementReader announcementReader, Announcement announcement) {
        this.id = announcementReader.id().value();
        this.seen = announcementReader.announcementReaderSeen().value();
        this.announcement = AnnouncementResponse.fromAggregate(announcement);
    }


}
