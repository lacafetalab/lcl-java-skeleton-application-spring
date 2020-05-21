package pe.lacafetalab.pao.communication.user.domain;

import pe.lacafetalab.pao.sharedtest.domain.UuidMother;

public final class UserIdMother {
    public static UserId create(String value) {
        return new UserId(value);
    }

    public static UserId random() {
        return create(UuidMother.random());
    }
}
