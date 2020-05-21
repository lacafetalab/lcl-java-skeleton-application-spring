package pe.lacafetalab.pao.communication.user.domain;

import pe.lacafetalab.pao.sharedtest.domain.WordMother;

public final class UserLastnameMother {
    public static UserLastname create(String value) {
        return new UserLastname(value);
    }

    public static UserLastname random() {
        return create(WordMother.random());
    }
}
