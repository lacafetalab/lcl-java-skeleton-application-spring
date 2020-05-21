package pe.lacafetalab.pao.shared.framework;

import pe.lacafetalab.pao.shared.domain.bus.command.Command;
import pe.lacafetalab.pao.shared.domain.bus.command.CommandBus;
import pe.lacafetalab.pao.shared.domain.bus.command.CommandHandlerExecutionError;
import pe.lacafetalab.pao.shared.domain.bus.command.CommandNotRegisteredError;
import pe.lacafetalab.pao.shared.domain.bus.query.Query;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryBus;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryHandlerExecutionError;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryNotRegisteredError;


public abstract class ApiController {
    private final QueryBus   queryBus;
    private final CommandBus commandBus;

    public ApiController(QueryBus queryBus, CommandBus commandBus) {
        this.queryBus   = queryBus;
        this.commandBus = commandBus;
    }

    protected void dispatch(Command command) throws CommandHandlerExecutionError, CommandNotRegisteredError {
        commandBus.dispatch(command);
    }

    protected <R> R ask(Query query) throws QueryHandlerExecutionError, QueryNotRegisteredError {
        return queryBus.ask(query);
    }

}
