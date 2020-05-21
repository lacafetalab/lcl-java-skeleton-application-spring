package pe.lacafetalab.pao.communication.announcement.application.reader.to_seen;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.communication.announcement.domain.ReaderId;
import pe.lacafetalab.pao.communication.announcement.domain.reader.AnnouncementReader;
import pe.lacafetalab.pao.communication.announcement.domain.reader.AnnouncementReaderId;
import pe.lacafetalab.pao.communication.announcement.domain.reader.AnnouncementReaderRepository;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

@Service
public final class ReaderToSeen {
    private final AnnouncementReaderRepository repository;

    public ReaderToSeen(AnnouncementReaderRepository repository) {
        this.repository = repository;
    }

    public void update(AnnouncementReaderId announcementReaderId, ReaderId readerId) {

        AnnouncementReader announcementReader = repository.findById(announcementReaderId)
                .orElseThrow(() -> new BadRequestException("404", "No existe el anuncio."));

        if (!announcementReader.readerId().equals(readerId)) {
            throw new BadRequestException("401", "no puedes modificar anuncios de otras personas");
        }

        announcementReader.toSeen();

        repository.save(announcementReader);

    }
}
