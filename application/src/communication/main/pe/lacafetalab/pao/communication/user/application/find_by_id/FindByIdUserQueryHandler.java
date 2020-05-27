package pe.lacafetalab.pao.communication.user.application.find_by_id;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.communication.user.application.UserResponse;
import pe.lacafetalab.pao.communication.user.domain.*;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryHandler;

@Service
public final class FindByIdUserQueryHandler implements QueryHandler<FindByIdUserQuery, UserResponse> {
    private final FindByIdUser service;

    public FindByIdUserQueryHandler(FindByIdUser service) {
        this.service = service;
    }

    @Override
    public UserResponse handle(FindByIdUserQuery query) {
        UserId id = new UserId(query.id());

        return this.service.execute(id);
    }
}
