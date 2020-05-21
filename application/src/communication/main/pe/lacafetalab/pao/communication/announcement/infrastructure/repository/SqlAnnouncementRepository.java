package pe.lacafetalab.pao.communication.announcement.infrastructure.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.communication.announcement.domain.*;
import pe.lacafetalab.pao.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class SqlAnnouncementRepository implements AnnouncementRepository {
    private AnnouncementSpringCrudRepository crudRepository;

    public SqlAnnouncementRepository(AnnouncementSpringCrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public void save(Announcement announcement) {
        crudRepository.save(new AnnouncementDao(announcement));
    }

    @Override
    public Optional<Announcement> findById(AnnouncementId id) {
        Optional<AnnouncementDao> announcement = crudRepository.findById(id.value());
        return announcement.map(AnnouncementDao::toDomain);
    }

    @Override
    public List<Announcement> findByAuthor(AnnouncementAuthorId authorId, Integer page, Integer perPage) {
        return map(crudRepository.findByAuthorId(authorId.value(), PageRequest.of((page - 1), perPage, Sort.by("publishAt").descending())).getContent());
    }

//    @Override
//    public List<Announcement> matching(Criteria criteria) {
//        //return map(crudRepository.findByNameAndUnityId(name.value(), unityId.value()));
//        return map(crudRepository.findAll());
//    }

    private List<Announcement> map(List<AnnouncementDao> announcementDaos) {
        return announcementDaos.stream().map(AnnouncementDao::toDomain).collect(Collectors.toList());
    }
}
