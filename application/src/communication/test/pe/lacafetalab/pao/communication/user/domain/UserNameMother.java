package pe.lacafetalab.pao.communication.user.domain;

import pe.lacafetalab.pao.sharedtest.domain.WordMother;

public final class UserNameMother {
    public static UserName create(String value) {
        return new UserName(value);
    }

    public static UserName random() {
        return create(WordMother.random());
    }
}
