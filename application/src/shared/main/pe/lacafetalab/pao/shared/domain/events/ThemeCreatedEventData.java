package pe.lacafetalab.pao.shared.domain.events;

import lombok.Getter;

@Getter
public class ThemeCreatedEventData {

	private String themeId;
	private String unityId;
	private String name;
	private Integer order;
	private Integer duration;
	private Integer weekNumber;

}