package pe.lacafetalab.pao.shared.application.bus.query;

import java.util.List;

import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.bus.query.Query;

@Getter
public class CountThemesQuery implements Query {

	private List<String> unitiesId;

	public CountThemesQuery(List<String> unitiesId) {
		super();
		this.unitiesId = unitiesId;
	}
}