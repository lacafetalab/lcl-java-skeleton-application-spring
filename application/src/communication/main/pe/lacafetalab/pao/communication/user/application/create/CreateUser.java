package pe.lacafetalab.pao.communication.user.application.create;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.communication.user.domain.*;
import pe.lacafetalab.pao.shared.domain.bus.event.EventBus;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

@Service
public final class CreateUser {
    private final UserRepository repository;
    private final EventBus eventBus;

    public CreateUser(UserRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void execute(UserId id, UserName name, UserLastname lastname, UserDescription description, UserBirthdate birthdate) {
        User user = User.create(id, name, lastname, description, birthdate);
        repository.save(user);
        eventBus.publish(user.pullDomainEvents());
    }
}
