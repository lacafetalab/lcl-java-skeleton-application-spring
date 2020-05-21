package pe.lacafetalab.pao.communication.announcement.application.reader.search_reader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pe.lacafetalab.pao.communication.announcement.AnnouncementModuleUnitTestCase;
import pe.lacafetalab.pao.communication.announcement.domain.ReaderIdMother;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

class SearchReaderQueryHandlerShould extends AnnouncementModuleUnitTestCase {
    private SearchReaderQueryHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new SearchReaderQueryHandler(new ReaderSearcher(repository, announcementReaderRepository));
    }

    @Test
    void create_a_search_announcement() {
        SearchReaderQuery query = SearchReaderQueryMother.random();
        ReadersResponse readersResponse = handler.handle(query);
        verify(announcementReaderRepository, atLeastOnce()).findByReaderId(ReaderIdMother.create(query.readerId()), query.page(), 20);
    }


}