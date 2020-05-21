package pe.lacafetalab.pao.shared.domain.events;

import pe.lacafetalab.pao.shared.application.CommandBase;

public interface DomainEvent extends CommandBase {

	String fullQualifiedEventName();

}
