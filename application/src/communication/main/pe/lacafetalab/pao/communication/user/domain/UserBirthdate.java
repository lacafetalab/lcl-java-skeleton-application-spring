package pe.lacafetalab.pao.communication.user.domain;

import pe.lacafetalab.pao.shared.domain.types.TypeDateTime;

import java.util.Date;

public final class UserBirthdate extends TypeDateTime {
    public UserBirthdate(String value) {
        super(value);
        if (this.isNull()) {
            this.setNow();
        }
    }

    public UserBirthdate(Date value) {
        super(value);
    }
}
