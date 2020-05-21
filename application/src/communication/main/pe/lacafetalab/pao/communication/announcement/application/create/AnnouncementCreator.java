package pe.lacafetalab.pao.communication.announcement.application.create;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.communication.announcement.domain.*;
import pe.lacafetalab.pao.shared.domain.bus.event.EventBus;
@Service
public final class AnnouncementCreator {
    private final AnnouncementRepository repository;
    private final EventBus eventBus;

    public AnnouncementCreator(AnnouncementRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void create(AnnouncementId id,
                       AnnouncementTitle title,
                       AnnouncementDescription description,
                       AnnouncementAuthorId authorId,
                       AnnouncementClassRoomId classRoomId,
                       AnnouncementPublishAt publishAt) {

        Announcement announcement = Announcement.create(id, title, description, authorId, classRoomId, publishAt);

        repository.save(announcement);
        eventBus.publish(announcement.pullDomainEvents());
    }
}
