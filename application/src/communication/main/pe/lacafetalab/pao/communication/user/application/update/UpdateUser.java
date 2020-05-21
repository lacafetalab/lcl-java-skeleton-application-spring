package pe.lacafetalab.pao.communication.user.application.update;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.communication.user.domain.*;
import pe.lacafetalab.pao.shared.domain.bus.event.EventBus;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

@Service
public final class UpdateUser {
    private final UserRepository repository;
    private final EventBus eventBus;

    public UpdateUser(UserRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void execute(UserId id, UserName name, UserLastname lastname, UserDescription description, UserBirthdate birthdate) {
        User user = repository.findById(id).orElseThrow(()-> new BadRequestException("404","User not found"));
        repository.save(user);
        eventBus.publish(user.pullDomainEvents());
    }
}
