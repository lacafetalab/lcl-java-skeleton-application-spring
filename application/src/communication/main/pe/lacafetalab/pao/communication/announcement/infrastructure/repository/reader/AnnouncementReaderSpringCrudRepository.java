package pe.lacafetalab.pao.communication.announcement.infrastructure.repository.reader;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AnnouncementReaderSpringCrudRepository extends PagingAndSortingRepository<AnnouncementReaderDao, String> {
    Page<AnnouncementReaderDao> findByReaderId(String readerId, Pageable pageable);

    List<AnnouncementReaderDao> findByReaderIdAndAnnouncementReaderSeen(String readerId, Boolean announcementReaderSeen);
}
