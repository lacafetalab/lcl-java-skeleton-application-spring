package pe.lacafetalab.pao.communication.announcement.domain;

import pe.lacafetalab.pao.sharedtest.domain.UuidMother;

public final class AnnouncementIdMother {
    public static AnnouncementId create(String value) {
        return new AnnouncementId(value);
    }

    public static AnnouncementId random() {
        return create(UuidMother.random());
    }
}
