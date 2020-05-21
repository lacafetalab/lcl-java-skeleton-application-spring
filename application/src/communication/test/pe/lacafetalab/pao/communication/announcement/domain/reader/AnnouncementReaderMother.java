package pe.lacafetalab.pao.communication.announcement.domain.reader;

import pe.lacafetalab.pao.communication.announcement.domain.*;

public class AnnouncementReaderMother {
    public static AnnouncementReader create(AnnouncementReaderId id,
                                            ReaderId readerId,
                                            AnnouncementId announcementId,
                                            AnnouncementReaderSeen announcementReaderSeen,
                                            AnnouncementPublishAt announcementPublishAt) {
        return AnnouncementReader.create(id, readerId, announcementId, announcementPublishAt);
    }

    public static AnnouncementReader random() {
        return create(
                AnnouncementReaderIdMother.random(),
                ReaderIdMother.random(),
                AnnouncementIdMother.random(),
                AnnouncementReaderSeenMother.random(),
                AnnouncementPublishAtMother.random());
    }
}

