package pe.lacafetalab.pao.communication.user.domain;

import pe.lacafetalab.pao.sharedtest.domain.WordMother;

public final class UserDescriptionMother {
    public static UserDescription create(String value) {
        return new UserDescription(value);
    }

    public static UserDescription random() {
        return create(WordMother.random());
    }
}
