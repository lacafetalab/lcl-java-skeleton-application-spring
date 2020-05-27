package pe.lacafetalab.pao.communication.user.application.search_criteria;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.communication.user.application.ListUserResponse;
import pe.lacafetalab.pao.communication.user.application.UserResponse;
import pe.lacafetalab.pao.communication.user.domain.*;
import pe.lacafetalab.pao.shared.domain.bus.event.EventBus;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

import java.util.stream.Collectors;

@Service
public final class SearchCriteriaUser {
    private final UserRepository repository;
    private final EventBus eventBus;

    public SearchCriteriaUser(UserRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public ListUserResponse execute(UserId id, UserName name, UserLastname lastname, UserDescription description, UserBirthdate birthdate) {
        return new ListUserResponse(
                repository.findAll().stream().map(UserResponse::fromAggregate).collect(Collectors.toList())
        );
    }
}
