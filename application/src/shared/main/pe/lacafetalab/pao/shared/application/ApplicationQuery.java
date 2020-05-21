package pe.lacafetalab.pao.shared.application;

public interface ApplicationQuery<R extends Object, C extends QueryBase> {

	public R execute(C command);

}
