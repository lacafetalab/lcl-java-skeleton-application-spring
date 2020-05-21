package pe.lacafetalab.pao.communication.announcement.application.find_by_id;

import pe.lacafetalab.pao.shared.domain.bus.query.Query;

public final class AnnouncementFindByIdQuery implements Query {
    private final String announcemntId;

    public AnnouncementFindByIdQuery(String announcemntId) {
        this.announcemntId = announcemntId;
    }

    public String announcemntId() {
        return announcemntId;
    }
}
