package pe.lacafetalab.pao.communication.announcement.application.author.search_author;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pe.lacafetalab.pao.communication.announcement.AnnouncementModuleUnitTestCase;
import pe.lacafetalab.pao.communication.announcement.application.AnnouncementsResponse;
import pe.lacafetalab.pao.communication.announcement.domain.AnnouncementAuthorIdMother;
import pe.lacafetalab.pao.communication.announcement.domain.ReaderIdMother;

import static org.mockito.Mockito.*;


class SearchAuthorAnnouncementQueryHandlerShould extends AnnouncementModuleUnitTestCase {
    private SearchAuthorAnnouncementQueryHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        //when(repository.matching(SearchReaderCriteriaMother.empty())).thenReturn();
        handler = new SearchAuthorAnnouncementQueryHandler(new ReaderAnnouncementSearcher(repository));
    }

    @Test
    void create_a_search_announcement() {
        SearchAuthorAnnouncementQuery query = SearchReaderAnnouncementQueryMother.random();
        AnnouncementsResponse announcementsResponse = handler.handle(query);
        verify(repository, atLeastOnce()).findByAuthor(AnnouncementAuthorIdMother.create(query.authorId()), query.page(), 20);
    }


}