package pe.lacafetalab.pao.controller.health_check;

import org.junit.jupiter.api.Test;
import pe.lacafetalab.pao.ApplicationTestCase;

public final class HealthCheckGetControllerShould extends ApplicationTestCase {
    @Test
    void check_the_app_is_working_ok() throws Exception {
        assertResponse(
                "/health-check",
                200,
                "{'success': true,'code': 2,'message': '','data': {'application':'communication'}}"
        );
    }
}
