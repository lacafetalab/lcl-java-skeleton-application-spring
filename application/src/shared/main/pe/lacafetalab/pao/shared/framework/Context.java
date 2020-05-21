package pe.lacafetalab.pao.shared.framework;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import pe.lacafetalab.pao.shared.domain.UserIdentification;

@Getter
@Setter
public class Context implements Serializable {
	private static final long serialVersionUID = 1L;

	private String transactionId;
	private String address;
	private UserIdentification user;

}
