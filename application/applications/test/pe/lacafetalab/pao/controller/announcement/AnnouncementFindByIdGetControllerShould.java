package pe.lacafetalab.pao.controller.announcement;

import org.junit.jupiter.api.Test;
import pe.lacafetalab.pao.ApplicationTestCase;


public final class AnnouncementFindByIdGetControllerShould extends ApplicationTestCase {
    @Test
    void create_a_valid_non_existing_course() throws Exception {
        //todo: crear la funcion de crear y mejorar este test
        assertRequest(
                "GET",
                "/announcement/19ad377a-7d39-409a-ab55-c7c29814d488",
                400
        );
    }
}