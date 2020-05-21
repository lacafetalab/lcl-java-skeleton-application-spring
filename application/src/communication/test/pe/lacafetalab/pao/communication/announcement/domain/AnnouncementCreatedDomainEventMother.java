package pe.lacafetalab.pao.communication.announcement.domain;

public final class AnnouncementCreatedDomainEventMother {
    public static AnnouncementCreatedDomainEvent create(AnnouncementId id,
                                                        AnnouncementTitle title,
                                                        AnnouncementDescription description,
                                                        AnnouncementAuthorId authorId,
                                                        AnnouncementClassRoomId classRoomId,
                                                        AnnouncementPublishAt publishAt) {
        return new AnnouncementCreatedDomainEvent(
                id.value(),
                title.value(),
                description.value(),
                authorId.value(),
                classRoomId.value(),
                publishAt.toString());
    }

    public static AnnouncementCreatedDomainEvent fromAnnouncement(Announcement announcement) {
        return create(
                announcement.id(),
                announcement.title(),
                announcement.description(),
                announcement.authorId(),
                announcement.classRoomId(),
                announcement.publishAt());
    }

    public static AnnouncementCreatedDomainEvent random() {
        return create(
                AnnouncementIdMother.random(),
                AnnouncementTitleMother.random(),
                AnnouncementDescriptionMother.random(),
                AnnouncementAuthorIdMother.random(),
                AnnouncementClassRoomIdMother.random(),
                AnnouncementPublishAtMother.random());
    }

}
