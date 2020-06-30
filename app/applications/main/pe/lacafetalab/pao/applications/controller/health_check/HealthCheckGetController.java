package pe.lacafetalab.pao.applications.controller.health_check;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckGetController {

    @GetMapping("/health-check")
    public String index() {
        return "ok";
    }
}
