package pe.lacafetalab.pao.communication.announcement.application.reader.search_reader;


import pe.lacafetalab.pao.communication.announcement.domain.ReaderId;
import pe.lacafetalab.pao.communication.announcement.domain.ReaderIdMother;
import pe.lacafetalab.pao.sharedtest.domain.IntegerMother;

public class SearchReaderQueryMother {
    public static SearchReaderQuery create(ReaderId readerId, Integer page) {
        return new SearchReaderQuery(readerId.value(), page);
    }

    public static SearchReaderQuery random() {
        return create(ReaderIdMother.random(), IntegerMother.random());
    }
}