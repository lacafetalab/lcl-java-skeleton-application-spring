package pe.lacafetalab.pao.communication.announcement.application.find_by_id;


import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.communication.announcement.application.AnnouncementResponse;
import pe.lacafetalab.pao.communication.announcement.domain.Announcement;
import pe.lacafetalab.pao.communication.announcement.domain.AnnouncementId;
import pe.lacafetalab.pao.communication.announcement.domain.AnnouncementRepository;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

@Service
public final class AnnouncementFindById {
    private final AnnouncementRepository repository;

    public AnnouncementFindById(AnnouncementRepository repository) {
        this.repository = repository;
    }

    public AnnouncementResponse findById(AnnouncementId announcementId) {

        Announcement announcement = repository.findById(announcementId).orElseThrow(() -> new BadRequestException("404", "announcement not found"));

        return AnnouncementResponse.fromAggregate(announcement);
    }

}
