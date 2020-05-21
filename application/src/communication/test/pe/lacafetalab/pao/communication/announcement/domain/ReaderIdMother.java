package pe.lacafetalab.pao.communication.announcement.domain;

import pe.lacafetalab.pao.sharedtest.domain.UuidMother;


public class ReaderIdMother {
    public static ReaderId create(String value) {
        return new ReaderId(value);
    }

    public static ReaderId random() {
        return create(UuidMother.random());
    }
}