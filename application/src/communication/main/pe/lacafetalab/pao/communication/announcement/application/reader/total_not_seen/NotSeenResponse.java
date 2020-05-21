package pe.lacafetalab.pao.communication.announcement.application.reader.total_not_seen;

import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.bus.query.Response;

@Getter
public final class NotSeenResponse implements Response {
    private final Integer total;

    public NotSeenResponse(Integer total) {
        this.total = total;
    }
}
