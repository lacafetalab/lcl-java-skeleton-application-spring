package pe.lacafetalab.pao.communication.announcement;

import org.junit.jupiter.api.BeforeEach;
import pe.lacafetalab.pao.communication.announcement.domain.Announcement;
import pe.lacafetalab.pao.communication.announcement.domain.AnnouncementRepository;
import pe.lacafetalab.pao.communication.announcement.domain.reader.AnnouncementReaderRepository;
import pe.lacafetalab.pao.shared.domain.criteria.Criteria;
import pe.lacafetalab.pao.sharedtest.infrastructure.UnitTestCase;

import static org.mockito.Mockito.*;

public abstract class AnnouncementModuleUnitTestCase extends UnitTestCase {
    protected AnnouncementRepository repository;
    protected AnnouncementReaderRepository announcementReaderRepository;


    @BeforeEach
    protected void setUp() {
        super.setUp();
        repository = mock(AnnouncementRepository.class);
        announcementReaderRepository = mock(AnnouncementReaderRepository.class);

    }
    public void shouldHaveSaved(Announcement announcement) {
        verify(repository, atLeastOnce()).save(announcement);
    }
//    public void shouldHaveSearchByCriteria(Criteria criteria) {
//        verify(repository, atLeastOnce()).matching(criteria);
//    }
}
