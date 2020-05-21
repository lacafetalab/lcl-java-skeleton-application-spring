package pe.lacafetalab.pao.shared.application.bus.command;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.bus.command.Command;

@Getter
public class UpdateSectionsCommand implements Command {

	private String courseId;
	private Map<String, List<UpdateSectionsCommand.EvaluationData>> mapBySectionType;

	protected UpdateSectionsCommand() {
	}

	public UpdateSectionsCommand(String courseId, Map<String, List<EvaluationData>> mapBySectionType) {
		super();
		this.courseId = courseId;
		this.mapBySectionType = mapBySectionType;
	}

	@Getter
	public static class EvaluationData {
		private String evaluationId;
		private String evaluationType;
		private List<String> questionTypes;

		public EvaluationData(String evaluationId, String evaluationType, List<String> questionTypes) {
			super();
			this.evaluationId = evaluationId;
			this.evaluationType = evaluationType;
			this.questionTypes = questionTypes;
		}
	}
}