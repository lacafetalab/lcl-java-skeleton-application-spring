package pe.lacafetalab.pao.communication.announcement.application.reader.to_seen;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pe.lacafetalab.pao.communication.announcement.domain.reader.AnnouncementReader;
import pe.lacafetalab.pao.communication.announcement.domain.reader.AnnouncementReaderMother;
import pe.lacafetalab.pao.communication.announcement.domain.reader.AnnouncementReaderRepository;
import pe.lacafetalab.pao.sharedtest.infrastructure.UnitTestCase;

import java.util.Optional;

import static org.mockito.Mockito.*;

class ReaderToSeenCommandHandlerShould extends UnitTestCase {

    protected AnnouncementReaderRepository announcementReaderRepository;
    private ReaderToSeenCommandHandler handler;
    private AnnouncementReader announcementReader;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        announcementReader = AnnouncementReaderMother.random();
        announcementReaderRepository = mock(AnnouncementReaderRepository.class);
        when(announcementReaderRepository.findById(announcementReader.id())).thenReturn(Optional.of(announcementReader));

        handler = new ReaderToSeenCommandHandler(new ReaderToSeen(announcementReaderRepository));
    }

    @Test
    void create_a_valid_course() {
        handler.handle(new ReaderToSeenCommand(announcementReader.id().value(), announcementReader.readerId().value()));

        verify(announcementReaderRepository, atLeastOnce()).findById(announcementReader.id());
        // todo: aqui hay algo raro, esto deberia fallar si se quita el toSeen
        announcementReader.toSeen();
        verify(announcementReaderRepository, atLeastOnce()).save(announcementReader);
    }
}