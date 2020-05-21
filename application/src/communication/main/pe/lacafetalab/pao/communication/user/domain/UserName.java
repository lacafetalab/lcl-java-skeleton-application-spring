package pe.lacafetalab.pao.communication.user.domain;

import pe.lacafetalab.pao.shared.domain.types.TypeString;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

public final class UserName extends TypeString {
    public UserName(String value) {
        super(value);
        this.sanitize();
        this.verifyNotBlank(new BadRequestException("null TypeString", "El nombre es requerido"));
    }
}
