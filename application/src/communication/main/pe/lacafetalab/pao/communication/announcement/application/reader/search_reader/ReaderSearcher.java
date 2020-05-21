package pe.lacafetalab.pao.communication.announcement.application.reader.search_reader;
import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.communication.announcement.domain.Announcement;
import pe.lacafetalab.pao.communication.announcement.domain.AnnouncementRepository;
import pe.lacafetalab.pao.communication.announcement.domain.ReaderId;
import pe.lacafetalab.pao.communication.announcement.domain.reader.AnnouncementReader;
import pe.lacafetalab.pao.communication.announcement.domain.reader.AnnouncementReaderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public final class ReaderSearcher {
    private final AnnouncementRepository announcementRepository;
    private final AnnouncementReaderRepository repository;

    public ReaderSearcher(AnnouncementRepository announcementRepository, AnnouncementReaderRepository repository) {
        this.announcementRepository = announcementRepository;
        this.repository = repository;
    }

    public ReadersResponse search(ReaderId readerId, Integer page) {

        //TODO mover a un valueObject
        Integer perPage = 20;

        List<AnnouncementReader> readers = repository.findByReaderId(readerId, page, perPage);

        List<ReaderResponse> readerResponses = readers.stream().map(announcementReader -> {
            Announcement announcement = this.announcementRepository.findById(announcementReader.announcementId()).get();
            return new ReaderResponse(announcementReader, announcement);
        }).collect(Collectors.toList());

        return new ReadersResponse(readerResponses);
    }

}
