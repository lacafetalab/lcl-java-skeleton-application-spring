package pe.lacafetalab.pao.communication.announcement.application.reader.total_not_seen;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.communication.announcement.domain.ReaderId;
import pe.lacafetalab.pao.communication.announcement.domain.reader.AnnouncementReader;
import pe.lacafetalab.pao.communication.announcement.domain.reader.AnnouncementReaderRepository;

import java.util.List;

@Service
public final class TotalReaderNotSeen {
    private final AnnouncementReaderRepository repository;

    public TotalReaderNotSeen(AnnouncementReaderRepository repository) {
        this.repository = repository;
    }

    public NotSeenResponse search(ReaderId readerId) {
        List<AnnouncementReader> announcementReaders = repository.findNotSeen(readerId);
        Integer total = announcementReaders.size();
        return new NotSeenResponse(total);
    }
}
