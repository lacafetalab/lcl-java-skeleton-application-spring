package pe.lacafetalab.pao.communication.announcement.application;

import pe.lacafetalab.pao.shared.domain.bus.query.Response;

import java.util.List;

public final class AnnouncementsResponse implements Response {
    private List<AnnouncementResponse> announcements;

    public AnnouncementsResponse(List<AnnouncementResponse> announcements) {
        this.announcements = announcements;
    }

    public List<AnnouncementResponse> announcements() {
        return announcements;
    }
}
