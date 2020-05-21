package pe.lacafetalab.pao.communication.announcement.application.find_by_id;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pe.lacafetalab.pao.communication.announcement.AnnouncementModuleUnitTestCase;
import pe.lacafetalab.pao.communication.announcement.application.AnnouncementResponse;
import pe.lacafetalab.pao.communication.announcement.domain.Announcement;
import pe.lacafetalab.pao.communication.announcement.domain.AnnouncementMother;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


class AnnouncementFindByIdQueryHandlerShould extends AnnouncementModuleUnitTestCase {
    private AnnouncementFindByIdQueryHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new AnnouncementFindByIdQueryHandler(new AnnouncementFindById(repository));
    }

    @Test()
    void find_by_id() {
        Announcement announcement = AnnouncementMother.random();
        when(repository.findById(announcement.id())).thenReturn(Optional.of(announcement));

        AnnouncementFindByIdQuery query = AnnouncementFindByIdQueryMother.create(announcement.id());
        AnnouncementResponse announcementResponse = handler.handle(query);

        verify(repository, atLeastOnce()).findById(announcement.id());

        assertEquals(announcementResponse, AnnouncementResponse.fromAggregate(announcement));

    }

    @Test()
    void find_by_id_not_found() {
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            AnnouncementFindByIdQuery query = AnnouncementFindByIdQueryMother.random();
            handler.handle(query);
        });
    }
}