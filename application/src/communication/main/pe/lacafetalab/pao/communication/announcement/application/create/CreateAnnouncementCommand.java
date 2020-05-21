package pe.lacafetalab.pao.communication.announcement.application.create;

import pe.lacafetalab.pao.shared.domain.bus.command.Command;

public final class CreateAnnouncementCommand implements Command {
    private final String id;
    private final String title;
    private final String description;
    private final String authorId;
    private final String classRoomId;
    private final String publishAt;

    public CreateAnnouncementCommand(String id,
                                     String title,
                                     String description,
                                     String authorId,
                                     String classRoomId,
                                     String publishAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.authorId = authorId;
        this.classRoomId = classRoomId;
        this.publishAt = publishAt;
    }

    public String id() {
        return id;
    }

    public String title() {
        return title;
    }

    public String description() {
        return description;
    }

    public String publishAt() {
        return publishAt;
    }

    public String authorId() {
        return authorId;
    }

    public String classRoomId() {
        return classRoomId;
    }
}
