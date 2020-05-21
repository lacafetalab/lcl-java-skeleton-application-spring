package pe.lacafetalab.pao.communication.user.application.update;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.communication.user.domain.*;
import pe.lacafetalab.pao.shared.domain.bus.command.CommandHandler;

@Service
public final class UpdateUserCommandHandler implements CommandHandler<UpdateUserCommand> {

    private final UpdateUser service;

    public UpdateUserCommandHandler(UpdateUser service) {
        this.service = service;
    }

    @Override
    public void handle(UpdateUserCommand command) {
        UserId id = new UserId(command.id());
        UserName name = new UserName(command.name());
        UserLastname lastname = new UserLastname(command.lastname());
        UserDescription description = new UserDescription(command.description());
        UserBirthdate birthdate = new UserBirthdate(command.birthdate());

        service.execute(id, name, lastname, description, birthdate);
    }
}
