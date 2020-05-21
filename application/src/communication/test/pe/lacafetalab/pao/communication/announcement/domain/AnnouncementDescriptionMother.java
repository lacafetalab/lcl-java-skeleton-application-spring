package pe.lacafetalab.pao.communication.announcement.domain;

import pe.lacafetalab.pao.sharedtest.domain.WordMother;

public final class AnnouncementDescriptionMother {
    public static AnnouncementDescription create(String value) {
        return new AnnouncementDescription(value);
    }

    public static AnnouncementDescription random() {
        return create(WordMother.random());
    }
}
