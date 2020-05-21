package pe.lacafetalab.pao.communication.user.domain;

import pe.lacafetalab.pao.sharedtest.domain.DateTimeMother;

public final class UserBirthdateMother {
    public static UserBirthdate create(String value) {
        return new UserBirthdate(value);
    }

    public static UserBirthdate random() {
        return create(DateTimeMother.randomString());
    }
}
