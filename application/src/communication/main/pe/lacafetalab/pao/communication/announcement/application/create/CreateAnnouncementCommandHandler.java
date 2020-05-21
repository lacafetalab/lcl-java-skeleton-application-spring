package pe.lacafetalab.pao.communication.announcement.application.create;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.communication.announcement.domain.*;

import pe.lacafetalab.pao.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateAnnouncementCommandHandler implements CommandHandler<CreateAnnouncementCommand> {

    private final AnnouncementCreator creator;

    public CreateAnnouncementCommandHandler(AnnouncementCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateAnnouncementCommand command) {
        AnnouncementId id = new AnnouncementId(command.id());
        AnnouncementTitle title = new AnnouncementTitle(command.title());
        AnnouncementDescription description = new AnnouncementDescription(command.description());
        AnnouncementAuthorId authorId = new AnnouncementAuthorId(command.authorId());
        AnnouncementClassRoomId classRoomId = new AnnouncementClassRoomId(command.classRoomId());
        AnnouncementPublishAt publishAt = new AnnouncementPublishAt(command.publishAt());

        creator.create(id, title, description, authorId, classRoomId, publishAt);
    }
}
