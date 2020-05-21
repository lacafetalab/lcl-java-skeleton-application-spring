package pe.lacafetalab.pao.communication.announcement.infrastructure.repository.reader;


import org.junit.jupiter.api.Test;
import pe.lacafetalab.pao.communication.announcement.AnnouncementModuleInfrastructureTestCase;
import pe.lacafetalab.pao.communication.announcement.domain.reader.AnnouncementReader;
import pe.lacafetalab.pao.communication.announcement.domain.reader.AnnouncementReaderMother;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
class SqlAnnouncementReaderRepositoryShould extends AnnouncementModuleInfrastructureTestCase {

    @Test
    void save_a_announcement() {
        AnnouncementReader announcementReader = AnnouncementReaderMother.random();
        sqlAnnouncementReaderRepository.saveAll(List.of(announcementReader));
        Optional<AnnouncementReader> announcementReader1  = sqlAnnouncementReaderRepository.findById(announcementReader.id());
        assertTrue(announcementReader1.isPresent());
        assertEquals(announcementReader, announcementReader1.get());
    }

    @Test
    void find_not_seen() {
        AnnouncementReader announcementReader = AnnouncementReaderMother.random();
        sqlAnnouncementReaderRepository.saveAll(List.of(announcementReader));
        List<AnnouncementReader> announcementReader1  = sqlAnnouncementReaderRepository.findNotSeen(announcementReader.readerId());
        assertEquals(1, announcementReader1.size());
    }

    @Test
    void reader_to_seen() {
        AnnouncementReader announcementReader = AnnouncementReaderMother.random();
        sqlAnnouncementReaderRepository.saveAll(List.of(announcementReader));
        AnnouncementReader announcementReader1  = sqlAnnouncementReaderRepository.findById(announcementReader.id()).get();

        announcementReader1.toSeen();
        sqlAnnouncementReaderRepository.save(announcementReader1);

        AnnouncementReader announcementReader2  = sqlAnnouncementReaderRepository.findById(announcementReader.id()).get();


        assertEquals(announcementReader1, announcementReader2);


    }

}