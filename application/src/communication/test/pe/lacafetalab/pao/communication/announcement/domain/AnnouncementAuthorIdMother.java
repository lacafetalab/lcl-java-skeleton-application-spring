package pe.lacafetalab.pao.communication.announcement.domain;

import pe.lacafetalab.pao.sharedtest.domain.UuidMother;

public final class AnnouncementAuthorIdMother {
    public static AnnouncementAuthorId create(String value) {
        return new AnnouncementAuthorId(value);
    }

    public static AnnouncementAuthorId random() {
        return create(UuidMother.random());
    }
}
