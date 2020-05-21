package pe.lacafetalab.pao.communication.announcement.application.reader.total_not_seen;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.communication.announcement.domain.ReaderId;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryHandler;

@Service
public final class GetReaderNotSeenQueryHandler implements QueryHandler<GetReaderNotSeenQuery, NotSeenResponse> {

    private final TotalReaderNotSeen service;

    public GetReaderNotSeenQueryHandler(TotalReaderNotSeen service) {
        this.service = service;
    }

    @Override
    public NotSeenResponse handle(GetReaderNotSeenQuery query) {
        ReaderId readerId = new ReaderId(query.readerId());
        return this.service.search(readerId);
    }
}
