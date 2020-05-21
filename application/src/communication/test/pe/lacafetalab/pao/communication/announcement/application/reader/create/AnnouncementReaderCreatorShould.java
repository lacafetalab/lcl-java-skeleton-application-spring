package pe.lacafetalab.pao.communication.announcement.application.reader.create;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pe.lacafetalab.pao.communication.announcement.domain.*;
import pe.lacafetalab.pao.communication.announcement.domain.reader.AnnouncementReader;
import pe.lacafetalab.pao.communication.announcement.domain.reader.AnnouncementReaderId;
import pe.lacafetalab.pao.communication.announcement.domain.reader.AnnouncementReaderRepository;
import pe.lacafetalab.pao.communication.announcement.domain.reader.ReaderByClassRoomService;
import pe.lacafetalab.pao.shared.domain.types.implement.TypeUUIDImp;
import pe.lacafetalab.pao.sharedtest.infrastructure.UnitTestCase;

import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.*;


class AnnouncementReaderCreatorShould extends UnitTestCase {
    protected AnnouncementReaderRepository announcementReaderRepository;
    protected ReaderByClassRoomService readerByClassRoomService;

    private AnnouncementReaderCreator service;

    private List<ReaderId> ids;
    private AnnouncementCreatedDomainEvent event;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        ids = AnnouncementReaderCreatorListReaderIdsMother.random();
        event = AnnouncementCreatedDomainEventMother.random();

        announcementReaderRepository = mock(AnnouncementReaderRepository.class);

        readerByClassRoomService = mock(ReaderByClassRoomService.class);
        when(readerByClassRoomService.findByClassRoomId(AnnouncementClassRoomIdMother.create(event.classRoomId()))).thenReturn(ids);

        service = new AnnouncementReaderCreator(announcementReaderRepository, readerByClassRoomService);
    }

    @Test
    void create_a_valid_course() {
        service.create(
                AnnouncementIdMother.create(event.aggregateId()),
                AnnouncementClassRoomIdMother.create(event.classRoomId()),
                AnnouncementPublishAtMother.create(event.publishAt())
        );

        List<AnnouncementReader> announcementReaders = ids.stream().map(readerId -> AnnouncementReader.create(
                new AnnouncementReaderId(TypeUUIDImp.randon().value()),
                readerId,
                new AnnouncementId(event.aggregateId()),
                new AnnouncementPublishAt(event.publishAt())
        )).collect(Collectors.toList());

        verify(readerByClassRoomService, atLeastOnce()).findByClassRoomId(AnnouncementClassRoomIdMother.create(event.classRoomId()));

        verify(announcementReaderRepository, atLeastOnce()).saveAll(announcementReaders);
    }

}