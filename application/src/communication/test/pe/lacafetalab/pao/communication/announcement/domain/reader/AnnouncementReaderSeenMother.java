package pe.lacafetalab.pao.communication.announcement.domain.reader;

import pe.lacafetalab.pao.sharedtest.domain.BooleanMother;

public class AnnouncementReaderSeenMother {
    public static AnnouncementReaderSeen create(Boolean value) {
        return new AnnouncementReaderSeen(value);
    }

    public static AnnouncementReaderSeen random() {
        return create(BooleanMother.random());
    }
}