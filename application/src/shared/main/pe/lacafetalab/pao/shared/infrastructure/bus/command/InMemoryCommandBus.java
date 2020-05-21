package pe.lacafetalab.pao.shared.infrastructure.bus.command;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.shared.domain.bus.command.Command;
import pe.lacafetalab.pao.shared.domain.bus.command.CommandBus;
import pe.lacafetalab.pao.shared.domain.bus.command.CommandHandler;
import pe.lacafetalab.pao.shared.domain.bus.command.CommandHandlerExecutionError;
import pe.lacafetalab.pao.shared.domain.bus.command.CommandNotRegisteredError;

@Service
public final class InMemoryCommandBus implements CommandBus {
    private final CommandHandlersInformation information;
    private final ApplicationContext context;

    public InMemoryCommandBus(CommandHandlersInformation information, ApplicationContext context) {
        this.information = information;
        this.context     = context;
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void dispatch(Command command) throws CommandNotRegisteredError, CommandHandlerExecutionError {
        Class<? extends CommandHandler> commandHandlerClass = information.search(command.getClass());
        CommandHandler handler = context.getBean(commandHandlerClass);
        handler.handle(command);
    }
}