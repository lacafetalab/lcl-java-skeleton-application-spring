package pe.lacafetalab.pao.communication.user.domain;

import pe.lacafetalab.pao.shared.domain.types.TypeString;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

public final class UserDescription extends TypeString {
    public UserDescription(String value) {
        super(value);
        this.sanitize();
        this.verifyNotBlank(new BadRequestException("null TypeString", ""));
    }
}
