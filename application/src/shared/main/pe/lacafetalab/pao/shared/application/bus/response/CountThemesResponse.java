package pe.lacafetalab.pao.shared.application.bus.response;

import java.util.Map;

import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.bus.query.Response;

@Getter
public class CountThemesResponse implements Response {

	private Integer numThemes;
	private Integer duration;
	private Map<String, Integer> unitiesDuration;

	public CountThemesResponse(Integer numThemes, Integer duration, Map<String, Integer> unitiesDuration) {
		super();
		this.numThemes = numThemes;
		this.duration = duration;
		this.unitiesDuration = unitiesDuration;
	}

}
