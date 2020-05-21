package pe.lacafetalab.pao.communication.announcement.application.reader.total_not_seen;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pe.lacafetalab.pao.communication.announcement.AnnouncementModuleUnitTestCase;
import pe.lacafetalab.pao.communication.announcement.application.reader.search_reader.*;
import pe.lacafetalab.pao.communication.announcement.domain.ReaderIdMother;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

class GetReaderNotSeenQueryHandlerShould extends AnnouncementModuleUnitTestCase {
    private GetReaderNotSeenQueryHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new GetReaderNotSeenQueryHandler(new TotalReaderNotSeen(announcementReaderRepository));
    }

    @Test
    void create_a_search_announcement() {
        GetReaderNotSeenQuery query = GetReaderNotSeenQueryMother.random();
        NotSeenResponse notSeenResponse = handler.handle(query);
        verify(announcementReaderRepository, atLeastOnce()).findNotSeen(ReaderIdMother.create(query.readerId()));
    }
}