package pe.lacafetalab.pao.communication.user.application.find_by_id;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.communication.user.application.UserResponse;
import pe.lacafetalab.pao.communication.user.domain.*;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryHandler;

@Service
public final class UserFindByIdQueryHandler implements QueryHandler<UserFindByIdQuery, UserResponse> {
    private final UserFindById service;

    public UserFindByIdQueryHandler(UserFindById service) {
        this.service = service;
    }

    @Override
    public UserResponse handle(UserFindByIdQuery query) {
        UserId id = new UserId(query.id());

        return this.service.execute(id);
    }
}
