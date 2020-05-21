package pe.lacafetalab.pao.communication.announcement.application.reader.to_seen;

import pe.lacafetalab.pao.shared.domain.bus.command.Command;

public final class ReaderToSeenCommand implements Command {
    private final String announcementReaderId;
    private final String readerId;

    public ReaderToSeenCommand(String announcementReaderId, String readerId) {
        this.announcementReaderId = announcementReaderId;
        this.readerId = readerId;
    }

    public String announcementReaderId() {
        return announcementReaderId;
    }

    public String readerId() {
        return readerId;
    }
}
