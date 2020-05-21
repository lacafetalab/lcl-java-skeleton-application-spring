package pe.lacafetalab.pao.communication.announcement.domain.reader;

import pe.lacafetalab.pao.sharedtest.domain.UuidMother;

public class AnnouncementReaderIdMother {
    public static AnnouncementReaderId create(String value) {
        return new AnnouncementReaderId(value);
    }

    public static AnnouncementReaderId random() {
        return create(UuidMother.random());
    }

}