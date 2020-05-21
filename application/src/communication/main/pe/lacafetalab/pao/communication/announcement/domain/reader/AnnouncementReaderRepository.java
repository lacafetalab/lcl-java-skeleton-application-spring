package pe.lacafetalab.pao.communication.announcement.domain.reader;

import pe.lacafetalab.pao.communication.announcement.domain.ReaderId;

import java.util.List;
import java.util.Optional;

public interface AnnouncementReaderRepository {
    void save(AnnouncementReader announcementReader);

    void saveAll(List<AnnouncementReader> announcementReader);

    Optional<AnnouncementReader> findById(AnnouncementReaderId id);

    List<AnnouncementReader> findByReaderId(ReaderId readerId, Integer page, Integer perPage);

    List<AnnouncementReader> findNotSeen(ReaderId readerId);
}
