package pe.lacafetalab.pao.communication.announcement.application.reader.to_seen;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.communication.announcement.domain.ReaderId;
import pe.lacafetalab.pao.communication.announcement.domain.reader.AnnouncementReaderId;
import pe.lacafetalab.pao.shared.domain.bus.command.CommandHandler;

@Service
public final class ReaderToSeenCommandHandler implements CommandHandler<ReaderToSeenCommand> {

    private final ReaderToSeen service;

    public ReaderToSeenCommandHandler(ReaderToSeen service) {
        this.service = service;
    }

    @Override
    public void handle(ReaderToSeenCommand command) {

        AnnouncementReaderId announcementReaderId = new AnnouncementReaderId(command.announcementReaderId());
        ReaderId readerId = new ReaderId(command.readerId());

        service.update(announcementReaderId, readerId);
    }
}
