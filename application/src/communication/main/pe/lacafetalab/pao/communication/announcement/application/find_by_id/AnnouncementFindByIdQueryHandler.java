package pe.lacafetalab.pao.communication.announcement.application.find_by_id;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.communication.announcement.application.AnnouncementResponse;
import pe.lacafetalab.pao.communication.announcement.domain.AnnouncementId;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryHandler;

@Service
public final class AnnouncementFindByIdQueryHandler implements QueryHandler<AnnouncementFindByIdQuery, AnnouncementResponse> {

    private final AnnouncementFindById service;

    public AnnouncementFindByIdQueryHandler(AnnouncementFindById service) {
        this.service = service;
    }

    @Override
    public AnnouncementResponse handle(AnnouncementFindByIdQuery query) {
        AnnouncementId announcementId = new AnnouncementId(query.announcemntId());
        return this.service.findById(announcementId);
    }
}
