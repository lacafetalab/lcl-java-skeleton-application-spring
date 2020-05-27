package pe.lacafetalab.pao.communication.user.application.find_by_id;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.communication.user.application.ListUserResponse;
import pe.lacafetalab.pao.communication.user.application.UserResponse;
import pe.lacafetalab.pao.communication.user.domain.*;
import pe.lacafetalab.pao.shared.domain.bus.event.EventBus;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

import java.util.stream.Collectors;

@Service
public final class FindByIdUser {
    private final UserRepository repository;
    private final EventBus eventBus;

    public FindByIdUser(UserRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public UserResponse execute(UserId id) {
        User user = repository.findById(id).orElseThrow(()-> new BadRequestException("404","User not found"));
        eventBus.publish(user.pullDomainEvents());
        return UserResponse.fromAggregate(user);
    }
}
