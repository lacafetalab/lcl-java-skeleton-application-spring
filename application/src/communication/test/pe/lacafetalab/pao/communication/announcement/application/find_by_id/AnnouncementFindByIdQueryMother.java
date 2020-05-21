package pe.lacafetalab.pao.communication.announcement.application.find_by_id;

import pe.lacafetalab.pao.communication.announcement.domain.AnnouncementId;
import pe.lacafetalab.pao.communication.announcement.domain.AnnouncementIdMother;

class AnnouncementFindByIdQueryMother {
    public static AnnouncementFindByIdQuery create(AnnouncementId announcementId) {
        return new AnnouncementFindByIdQuery(announcementId.value());
    }

    public static AnnouncementFindByIdQuery random() {
        return create(AnnouncementIdMother.random());
    }
}