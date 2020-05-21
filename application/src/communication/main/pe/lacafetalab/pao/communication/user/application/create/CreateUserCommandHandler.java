package pe.lacafetalab.pao.communication.user.application.create;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.communication.user.domain.*;
import pe.lacafetalab.pao.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateUserCommandHandler implements CommandHandler<CreateUserCommand> {

    private final CreateUser service;

    public CreateUserCommandHandler(CreateUser service) {
        this.service = service;
    }

    @Override
    public void handle(CreateUserCommand command) {
        UserId id = new UserId(command.id());
        UserName name = new UserName(command.name());
        UserLastname lastname = new UserLastname(command.lastname());
        UserDescription description = new UserDescription(command.description());
        UserBirthdate birthdate = new UserBirthdate(command.birthdate());

        service.execute(id, name, lastname, description, birthdate);
    }
}
