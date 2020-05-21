package pe.lacafetalab.pao.shared.application.video.create;

import lombok.Getter;
import lombok.Setter;
import pe.lacafetalab.pao.shared.domain.video.VideoDescription;
import pe.lacafetalab.pao.shared.domain.video.VideoName;
import pe.lacafetalab.pao.shared.domain.video.VideoSize;

@Getter
@Setter
public class CreateVideoInput {
	private VideoName name;
	private VideoDescription description;
	private VideoSize size;

	public CreateVideoInput(CreateVideoCommand command) {
		this.name = new VideoName(command.getName());
		this.description = new VideoDescription(command.getDescription());
		this.size = new VideoSize(command.getSize());
	}
}