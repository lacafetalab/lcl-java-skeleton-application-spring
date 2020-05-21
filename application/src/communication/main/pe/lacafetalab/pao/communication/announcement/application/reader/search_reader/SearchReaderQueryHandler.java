package pe.lacafetalab.pao.communication.announcement.application.reader.search_reader;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.communication.announcement.domain.ReaderId;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchReaderQueryHandler implements QueryHandler<SearchReaderQuery, ReadersResponse> {

    private final ReaderSearcher searcher;

    public SearchReaderQueryHandler(ReaderSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public ReadersResponse handle(SearchReaderQuery query) {
        ReaderId readerId = new ReaderId(query.readerId());
        return this.searcher.search(readerId, query.page());
    }
}
