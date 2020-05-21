package pe.lacafetalab.pao.communication.announcement.domain;

import pe.lacafetalab.pao.sharedtest.domain.UuidMother;

public final class AnnouncementClassRoomIdMother {
    public static AnnouncementClassRoomId create(String value) {
        return new AnnouncementClassRoomId(value);
    }

    public static AnnouncementClassRoomId random() {
        return create(UuidMother.random());
    }
}
