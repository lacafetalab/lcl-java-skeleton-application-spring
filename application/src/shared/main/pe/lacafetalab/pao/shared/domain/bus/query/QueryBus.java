package pe.lacafetalab.pao.shared.domain.bus.query;

public interface QueryBus {
    <R> R ask(Query query) throws QueryHandlerExecutionError, QueryNotRegisteredError;
}
