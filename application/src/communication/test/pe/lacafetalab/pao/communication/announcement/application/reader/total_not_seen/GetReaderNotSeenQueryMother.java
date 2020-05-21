package pe.lacafetalab.pao.communication.announcement.application.reader.total_not_seen;

import pe.lacafetalab.pao.communication.announcement.domain.ReaderId;
import pe.lacafetalab.pao.communication.announcement.domain.ReaderIdMother;

class GetReaderNotSeenQueryMother {
    public static GetReaderNotSeenQuery create(ReaderId id) {
        return new GetReaderNotSeenQuery(id.value());
    }

    public static GetReaderNotSeenQuery random() {
        return create(ReaderIdMother.random());
    }
}