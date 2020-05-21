package pe.lacafetalab.pao.communication.announcement.infrastructure.persistence;

import org.junit.jupiter.api.Test;
import pe.lacafetalab.pao.communication.announcement.AnnouncementModuleInfrastructureTestCase;
import pe.lacafetalab.pao.communication.announcement.domain.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
class SqlAnnouncementRepositoryShould extends AnnouncementModuleInfrastructureTestCase {
    @Test
    void save_a_announcement() {
        Announcement announcement = AnnouncementMother.random();
        sqlAnnouncementRepository.save(announcement);

        Optional<Announcement> announcement1Sql = sqlAnnouncementRepository.findById(announcement.id());
        assertTrue(announcement1Sql.isPresent());
        assertEquals(announcement, announcement1Sql.get());
    }

    @Test
    void find_all_by_author_id() {
        Announcement announcement = AnnouncementMother.random();
        sqlAnnouncementRepository.save(announcement);
        List<Announcement> announcements = sqlAnnouncementRepository.findByAuthor(announcement.authorId(), 1, 20);
        assertEquals(1, announcements.size());
        assertEquals(announcement, announcements.get(0));
    }

    @Test
    void find_all_zero_by_author_id_random() {
        Announcement announcement = AnnouncementMother.random();
        sqlAnnouncementRepository.save(announcement);
        List<Announcement> announcements = sqlAnnouncementRepository.findByAuthor(AnnouncementAuthorIdMother.random(), 1, 20);
        assertEquals(0, announcements.size());
    }

    @Test
    void find_by_by_not_found() {

        Optional<Announcement> announcement1Sql = sqlAnnouncementRepository.findById(AnnouncementIdMother.random());
        assertFalse(announcement1Sql.isPresent());
    }
}
