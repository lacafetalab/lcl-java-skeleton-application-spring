package pe.lacafetalab.pao.shared.application.video.create;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class CreateVideoCommand implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	private String size;

	protected CreateVideoCommand() {
	}
}
