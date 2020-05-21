package pe.lacafetalab.pao.communication.announcement.domain;

import pe.lacafetalab.pao.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface AnnouncementRepository {
    void save(Announcement announcement);

    Optional<Announcement> findById(AnnouncementId id);

    List<Announcement> findByAuthor(AnnouncementAuthorId authorId, Integer page, Integer perPage);
}
