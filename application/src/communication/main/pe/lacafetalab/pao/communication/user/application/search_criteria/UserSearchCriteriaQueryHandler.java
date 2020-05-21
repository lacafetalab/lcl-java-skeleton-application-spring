package pe.lacafetalab.pao.communication.user.application.search_criteria;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.communication.user.application.ListUserResponse;
import pe.lacafetalab.pao.communication.user.domain.*;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryHandler;

@Service
public final class UserSearchCriteriaQueryHandler implements QueryHandler<UserSearchCriteriaQuery, ListUserResponse> {
    private final UserSearchCriteria service;

    public UserSearchCriteriaQueryHandler(UserSearchCriteria service) {
        this.service = service;
    }

    @Override
    public ListUserResponse handle(UserSearchCriteriaQuery query) {
        UserId id = new UserId(query.id());
        UserName name = new UserName(query.name());
        UserLastname lastname = new UserLastname(query.lastname());
        UserDescription description = new UserDescription(query.description());
        UserBirthdate birthdate = new UserBirthdate(query.birthdate());

        return this.service.execute(id, name, lastname, description, birthdate);
    }
}
