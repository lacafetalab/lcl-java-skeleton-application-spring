package pe.lacafetalab.pao.shared.infrastructure;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Getter;
import pe.lacafetalab.pao.shared.application.CommandBase;

@Getter
@Builder
public class GeneralRequestEventData implements CommandBase {

	@SerializedName("transaction_id")
	private String transactionId;
	private String name;
	private Object attributes;
}
