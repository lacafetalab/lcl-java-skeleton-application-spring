package pe.lacafetalab.pao.communication.announcement.application.author.search_author;

import pe.lacafetalab.pao.communication.announcement.domain.ReaderId;
import pe.lacafetalab.pao.communication.announcement.domain.ReaderIdMother;
import pe.lacafetalab.pao.sharedtest.domain.IntegerMother;

public class SearchReaderAnnouncementQueryMother {
    public static SearchAuthorAnnouncementQuery create(ReaderId readerId, Integer page) {
        return new SearchAuthorAnnouncementQuery(readerId.value(), page);
    }

    public static SearchAuthorAnnouncementQuery random() {
        return create(ReaderIdMother.random(), IntegerMother.random());
    }

}