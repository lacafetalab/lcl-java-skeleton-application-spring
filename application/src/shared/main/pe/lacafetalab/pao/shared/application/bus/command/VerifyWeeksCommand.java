package pe.lacafetalab.pao.shared.application.bus.command;

import java.util.List;

import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.bus.command.Command;

@Getter
public class VerifyWeeksCommand implements Command {

	private List<VerifyWeeksCommand.UnityIdOrder> unities;
	private String unityId;
	private Integer themeOrder;
	private Integer weekNumber;

	@Getter
	public static class UnityIdOrder {
		private String unityId;
		private String order;
	}

}
