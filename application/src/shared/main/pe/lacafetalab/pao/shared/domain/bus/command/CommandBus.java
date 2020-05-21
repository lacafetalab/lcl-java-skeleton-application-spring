package pe.lacafetalab.pao.shared.domain.bus.command;

public interface CommandBus {
    void dispatch(Command command) throws CommandHandlerExecutionError, CommandNotRegisteredError;
}
