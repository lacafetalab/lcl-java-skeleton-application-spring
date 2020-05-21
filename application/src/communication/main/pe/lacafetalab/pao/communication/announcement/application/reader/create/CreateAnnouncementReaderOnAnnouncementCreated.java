package pe.lacafetalab.pao.communication.announcement.application.reader.create;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.communication.announcement.domain.*;

@Service
public final class CreateAnnouncementReaderOnAnnouncementCreated {
    private final AnnouncementReaderCreator creator;

    public CreateAnnouncementReaderOnAnnouncementCreated(AnnouncementReaderCreator creator) {
        this.creator = creator;
    }

    @EventListener
    public void on(AnnouncementCreatedDomainEvent event) {

        AnnouncementId announcementId = new AnnouncementId(event.aggregateId());
        AnnouncementClassRoomId announcementClassRoomId = new AnnouncementClassRoomId(event.classRoomId());
        AnnouncementPublishAt announcementPublishAt = new AnnouncementPublishAt(event.publishAt());

        this.creator.create(announcementId, announcementClassRoomId, announcementPublishAt);
    }

}
