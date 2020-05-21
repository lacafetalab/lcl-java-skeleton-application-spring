package pe.lacafetalab.pao.controller.announcement.reader;

import org.junit.jupiter.api.Test;
import pe.lacafetalab.pao.ApplicationTestCase;
import pe.lacafetalab.pao.communication.announcement.domain.AnnouncementCreatedDomainEvent;


class TotalNotSeenReaderGetControllerShould extends ApplicationTestCase {
    @Test
    void test_load_search_total_ok() throws Exception {

        assertRequest(
                "GET",
                "/announcement/reader/19ad377a-7d39-409a-ab55-c7c29814d488/total-not-seen",
                200
        );
    }
}