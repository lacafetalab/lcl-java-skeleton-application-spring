package pe.lacafetalab.pao.communication.announcement.application.author.search_author;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.communication.announcement.application.AnnouncementsResponse;
import pe.lacafetalab.pao.communication.announcement.domain.AnnouncementAuthorId;
import pe.lacafetalab.pao.communication.announcement.domain.ReaderId;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchAuthorAnnouncementQueryHandler implements QueryHandler<SearchAuthorAnnouncementQuery, AnnouncementsResponse> {

    private final ReaderAnnouncementSearcher searcher;

    public SearchAuthorAnnouncementQueryHandler(ReaderAnnouncementSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public AnnouncementsResponse handle(SearchAuthorAnnouncementQuery query) {
        AnnouncementAuthorId authorId = new AnnouncementAuthorId(query.authorId());
        return this.searcher.search(authorId, query.page());
    }
}
