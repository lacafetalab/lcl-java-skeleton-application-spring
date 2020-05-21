package pe.lacafetalab.pao.shared.application;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.bus.query.Response;

@Getter
@Builder
public class CreateIdResponse implements Serializable, Response {
	private static final long serialVersionUID = 1L;

	private String id;

	public static CreateIdResponse build(String id) {
		return CreateIdResponse.builder().id(id).build();
	}
}
