package pe.lacafetalab.pao.applications.controller.health_check;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.lacafetalab.pao.shared.infrastructure.response.RestResponse;

@RestController
public class HealthCheckGetController {

    @GetMapping("/health-check")
    public ResponseEntity<RestResponse> index() {
        return RestResponse.ok();
    }
}
