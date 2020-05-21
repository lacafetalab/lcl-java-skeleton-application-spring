package pe.lacafetalab.pao.communication.announcement.domain;

import pe.lacafetalab.pao.sharedtest.domain.DateTimeMother;

public final class AnnouncementPublishAtMother {
    public static AnnouncementPublishAt create(String value) {
        return new AnnouncementPublishAt(value);
    }

    public static AnnouncementPublishAt random() {
        return create(DateTimeMother.randomString());
    }
}
