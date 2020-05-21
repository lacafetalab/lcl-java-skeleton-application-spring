package pe.lacafetalab.pao.communication.announcement.application.reader.total_not_seen;

import pe.lacafetalab.pao.shared.domain.bus.query.Query;

public final class GetReaderNotSeenQuery implements Query {
    private final String readerId;

    public GetReaderNotSeenQuery(String readerId) {
        this.readerId = readerId;
    }

    public String readerId() {
        return readerId;
    }
}




