package pe.lacafetalab.pao.communication.announcement.application.reader.create;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.communication.announcement.domain.*;
import pe.lacafetalab.pao.communication.announcement.domain.reader.*;
import pe.lacafetalab.pao.shared.domain.types.implement.TypeUUIDImp;

import java.util.List;
import java.util.stream.Collectors;

@Service
public final class AnnouncementReaderCreator {
    private final AnnouncementReaderRepository repository;
    private final ReaderByClassRoomService courseService;

    public AnnouncementReaderCreator(AnnouncementReaderRepository repository, ReaderByClassRoomService courseService) {
        this.repository = repository;
        this.courseService = courseService;
    }

    public void create(AnnouncementId announcementId,
                       AnnouncementClassRoomId classRoomId,
                       AnnouncementPublishAt announcementPublishAt) {

        List<ReaderId> ids = courseService.findByClassRoomId(classRoomId);
        // todo filtrar los ids para que no se dupliquen al momento de ingresarlo, para cambiar le random por uno genrado por uuid readerid y annoumentid

        
        List<AnnouncementReader> announcementReaders = ids.stream().map(readerId -> AnnouncementReader.create(
                new AnnouncementReaderId(TypeUUIDImp.randon().value()),
                readerId,
                announcementId,
                announcementPublishAt
        )).collect(Collectors.toList());

        this.repository.saveAll(announcementReaders);

    }
}
