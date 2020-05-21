package pe.lacafetalab.pao.communication.announcement.domain;

import pe.lacafetalab.pao.communication.announcement.application.create.CreateAnnouncementCommand;

public final class AnnouncementMother {
    public static Announcement create(AnnouncementId id, AnnouncementTitle title, AnnouncementDescription description, AnnouncementAuthorId authorId, AnnouncementClassRoomId classRoomId, AnnouncementPublishAt publishAt) {
        return new Announcement(id, title, description, authorId, classRoomId, publishAt);
    }

    public static Announcement fromRequest(CreateAnnouncementCommand command) {
        return create(AnnouncementIdMother.create(command.id()), AnnouncementTitleMother.create(command.title()), AnnouncementDescriptionMother.create(command.description()), AnnouncementAuthorIdMother.create(command.authorId()), AnnouncementClassRoomIdMother.create(command.classRoomId()), AnnouncementPublishAtMother.create(command.publishAt()));
    }

    public static Announcement random() {
        return create(AnnouncementIdMother.random(), AnnouncementTitleMother.random(), AnnouncementDescriptionMother.random(), AnnouncementAuthorIdMother.random(), AnnouncementClassRoomIdMother.random(), AnnouncementPublishAtMother.random());
    }
}
