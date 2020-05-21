package pe.lacafetalab.pao.shared.application.bus.command;

import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.bus.command.Command;

@Getter
public class VerifyExistsUnityCommand implements Command {

	private String courseId;
	private String unityId;

	public VerifyExistsUnityCommand(String courseId, String unityId) {
		super();
		this.courseId = courseId;
		this.unityId = unityId;
	}
}