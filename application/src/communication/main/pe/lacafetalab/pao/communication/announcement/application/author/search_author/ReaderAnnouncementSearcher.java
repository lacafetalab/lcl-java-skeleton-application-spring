package pe.lacafetalab.pao.communication.announcement.application.author.search_author;


import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.communication.announcement.application.AnnouncementResponse;
import pe.lacafetalab.pao.communication.announcement.application.AnnouncementsResponse;
import pe.lacafetalab.pao.communication.announcement.domain.AnnouncementAuthorId;
import pe.lacafetalab.pao.communication.announcement.domain.AnnouncementRepository;
import pe.lacafetalab.pao.communication.announcement.domain.ReaderId;

import java.util.stream.Collectors;

@Service
public final class ReaderAnnouncementSearcher {
    private final AnnouncementRepository repository;

    public ReaderAnnouncementSearcher(AnnouncementRepository repository) {
        this.repository = repository;
    }

    public AnnouncementsResponse search(AnnouncementAuthorId authorId, Integer page) {

        //TODO mover a un valueObject
        Integer perPage = 20;

        return new AnnouncementsResponse(
                repository.findByAuthor(authorId, page, perPage).stream().map(AnnouncementResponse::fromAggregate).collect(Collectors.toList())
        );
    }

}
