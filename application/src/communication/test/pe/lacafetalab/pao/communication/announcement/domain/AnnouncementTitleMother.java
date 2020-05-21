package pe.lacafetalab.pao.communication.announcement.domain;

import pe.lacafetalab.pao.sharedtest.domain.WordMother;

public final class AnnouncementTitleMother {
    public static AnnouncementTitle create(String value) {
        return new AnnouncementTitle(value);
    }

    public static AnnouncementTitle random() {
        return create(WordMother.random());
    }
}
