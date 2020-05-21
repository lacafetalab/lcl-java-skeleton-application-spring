package pe.lacafetalab.pao.shared.domain;

import lombok.Builder;
import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.valueobject.Role;
import pe.lacafetalab.pao.shared.domain.valueobject.UserId;

@Getter
@Builder
public class UserIdentification {

	private UserId userId;
	private Role role;

	public UserIdentification(UserId userId, Role role) {
		this.userId = userId;
		this.role = role;
	}
}