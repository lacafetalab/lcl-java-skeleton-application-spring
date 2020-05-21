package pe.lacafetalab.pao.communication.user.application.delete;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.communication.user.domain.*;
import pe.lacafetalab.pao.shared.domain.bus.event.EventBus;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

@Service
public final class DeleteUser {
    private final UserRepository repository;
    private final EventBus eventBus;

    public DeleteUser(UserRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void execute(UserId id) {
        User user = repository.findById(id).orElseThrow(()-> new BadRequestException("404","User not found"));
        repository.deleteById(user.id());
        eventBus.publish(user.pullDomainEvents());
    }
}
