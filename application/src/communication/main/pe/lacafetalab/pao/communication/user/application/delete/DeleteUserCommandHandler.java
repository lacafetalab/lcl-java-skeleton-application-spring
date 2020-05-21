package pe.lacafetalab.pao.communication.user.application.delete;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.communication.user.domain.*;
import pe.lacafetalab.pao.shared.domain.bus.command.CommandHandler;

@Service
public final class DeleteUserCommandHandler implements CommandHandler<DeleteUserCommand> {

    private final DeleteUser service;

    public DeleteUserCommandHandler(DeleteUser service) {
        this.service = service;
    }

    @Override
    public void handle(DeleteUserCommand command) {
        UserId id = new UserId(command.id());

        service.execute(id);
    }
}
