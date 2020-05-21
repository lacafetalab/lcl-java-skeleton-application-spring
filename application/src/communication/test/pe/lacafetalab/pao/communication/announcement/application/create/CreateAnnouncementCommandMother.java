package pe.lacafetalab.pao.communication.announcement.application.create;

import pe.lacafetalab.pao.communication.announcement.domain.*;


public final class CreateAnnouncementCommandMother {
    public static CreateAnnouncementCommand create(AnnouncementId id,
                                                   AnnouncementTitle title,
                                                   AnnouncementDescription description,
                                                   AnnouncementAuthorId authorId,
                                                   AnnouncementClassRoomId classRoomId,
                                                   AnnouncementPublishAt publishAt) {
        return new CreateAnnouncementCommand(id.value(), title.value(), description.value(), authorId.value(), classRoomId.value(), publishAt.toString());
    }

    public static CreateAnnouncementCommand random() {
        return create(AnnouncementIdMother.random(),
            AnnouncementTitleMother.random(),
            AnnouncementDescriptionMother.random(),
            AnnouncementAuthorIdMother.random(),
            AnnouncementClassRoomIdMother.random(),
            AnnouncementPublishAtMother.random());
    }
}
