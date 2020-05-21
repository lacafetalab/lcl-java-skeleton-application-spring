package pe.lacafetalab.pao.shared.domain.valueobject;

import javax.persistence.Embeddable;

import lombok.Getter;

@Getter
@Embeddable
public class Duration extends IntegerValueObject {
	private static final long serialVersionUID = 1L;

	protected Duration() {
	}

	public Duration(Integer value) {
		super(value != null ? value : Integer.valueOf(0));
	}
}