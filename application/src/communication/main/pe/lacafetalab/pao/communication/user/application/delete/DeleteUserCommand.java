package pe.lacafetalab.pao.communication.user.application.delete;

import pe.lacafetalab.pao.shared.domain.bus.command.Command;

public final class DeleteUserCommand implements Command {
    private final String id;

    public DeleteUserCommand(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
