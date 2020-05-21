package pe.lacafetalab.pao.communication.announcement.infrastructure.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import pe.lacafetalab.pao.communication.announcement.infrastructure.repository.reader.AnnouncementReaderDao;

import java.util.List;

public interface AnnouncementSpringCrudRepository extends PagingAndSortingRepository<AnnouncementDao, String> {
    //Page<AnnouncementDao> findAll(Pageable pageable);
    Page<AnnouncementDao> findByAuthorId(String AuthorId, Pageable pageable);
}
