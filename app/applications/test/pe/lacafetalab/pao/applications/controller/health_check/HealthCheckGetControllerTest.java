package pe.lacafetalab.pao.applications.controller.health_check;

import org.junit.jupiter.api.Test;
import pe.lacafetalab.pao.applications.ApplicationTestCase;

class HealthCheckGetControllerTest extends ApplicationTestCase {
	@Test
	void check_health_check() throws Exception {
		assertResponse("/health-check", 200, "{'success':true,'code':2,'message':'','data':'ok'}");
	}
}//{'success':true,'code':2,'message':','data':'ok'}