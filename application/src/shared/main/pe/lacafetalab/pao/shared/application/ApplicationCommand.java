package pe.lacafetalab.pao.shared.application;

public interface ApplicationCommand<C extends CommandBase> {

	public void execute(C command);

}
