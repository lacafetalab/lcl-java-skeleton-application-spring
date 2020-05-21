package pe.lacafetalab.pao.communication.announcement.application.create;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pe.lacafetalab.pao.communication.announcement.AnnouncementModuleUnitTestCase;
import pe.lacafetalab.pao.communication.announcement.domain.Announcement;
import pe.lacafetalab.pao.communication.announcement.domain.AnnouncementCreatedDomainEvent;
import pe.lacafetalab.pao.communication.announcement.domain.AnnouncementCreatedDomainEventMother;
import pe.lacafetalab.pao.communication.announcement.domain.AnnouncementMother;
import pe.lacafetalab.pao.shared.domain.criteria.Criteria;

class CreateAnnouncementCommandHandlerShould extends AnnouncementModuleUnitTestCase {
    private CreateAnnouncementCommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new CreateAnnouncementCommandHandler(new AnnouncementCreator(repository, eventBus));
    }

    @Test
    void create_a_valid_course() {
        CreateAnnouncementCommand command = CreateAnnouncementCommandMother.random();
        Announcement announcement = AnnouncementMother.fromRequest(command);
        AnnouncementCreatedDomainEvent domainEvent = AnnouncementCreatedDomainEventMother.fromAnnouncement(announcement);

        handler.handle(command);

        shouldHaveSaved(announcement);
        shouldHavePublished(domainEvent);
    }
}
