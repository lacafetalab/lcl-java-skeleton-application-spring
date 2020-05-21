package pe.lacafetalab.pao.shared.infrastructure;

import lombok.Getter;

@Getter
public class GeneralResponseEventData {

	private String transaction_id;
	private String event;
	private Object attributes;

	protected GeneralResponseEventData() {
	}
}
