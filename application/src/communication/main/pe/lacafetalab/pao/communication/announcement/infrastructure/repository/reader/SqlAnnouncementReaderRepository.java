package pe.lacafetalab.pao.communication.announcement.infrastructure.repository.reader;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.communication.announcement.domain.ReaderId;
import pe.lacafetalab.pao.communication.announcement.domain.reader.AnnouncementReader;
import pe.lacafetalab.pao.communication.announcement.domain.reader.AnnouncementReaderId;
import pe.lacafetalab.pao.communication.announcement.domain.reader.AnnouncementReaderRepository;
import pe.lacafetalab.pao.communication.announcement.infrastructure.repository.AnnouncementDao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class SqlAnnouncementReaderRepository implements AnnouncementReaderRepository {
    private final AnnouncementReaderSpringCrudRepository crudRepository;

    public SqlAnnouncementReaderRepository(AnnouncementReaderSpringCrudRepository repository) {
        this.crudRepository = repository;
    }

    @Override
    public void save(AnnouncementReader announcementReader) {
        crudRepository.save(new AnnouncementReaderDao(announcementReader));
    }

    @Override
    public void saveAll(List<AnnouncementReader> announcementReader) {
        crudRepository.saveAll(announcementReader.stream().map(AnnouncementReaderDao::new).collect(Collectors.toList()));
    }

    @Override
    public Optional<AnnouncementReader> findById(AnnouncementReaderId id) {
        Optional<AnnouncementReaderDao> announcementReaderDao = crudRepository.findById(id.value());
        return announcementReaderDao.map(AnnouncementReaderDao::toDomain);
    }

    @Override
    public List<AnnouncementReader> findByReaderId(ReaderId readerId, Integer page, Integer perPage) {

        return map(crudRepository.findByReaderId(readerId.value(), PageRequest.of((page - 1), perPage, Sort.by("announcementPublishAt").descending())).getContent());
    }

    @Override
    public List<AnnouncementReader> findNotSeen(ReaderId readerId) {
        return map(crudRepository.findByReaderIdAndAnnouncementReaderSeen(readerId.value(), false));
    }

    private List<AnnouncementReader> map(List<AnnouncementReaderDao> announcementReaderDaos) {
        return announcementReaderDaos.stream().map(AnnouncementReaderDao::toDomain).collect(Collectors.toList());
    }
}
