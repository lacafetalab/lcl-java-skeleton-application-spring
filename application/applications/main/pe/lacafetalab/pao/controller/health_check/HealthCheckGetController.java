package pe.lacafetalab.pao.controller.health_check;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.lacafetalab.pao.shared.domain.bus.command.CommandBus;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryBus;
import pe.lacafetalab.pao.shared.framework.ApiController;
import pe.lacafetalab.pao.shared.response.RestResponse;
import java.util.HashMap;

@RestController
public final class HealthCheckGetController extends ApiController {
    public HealthCheckGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping("/health-check")
    public ResponseEntity<RestResponse> index() {
        HashMap<String, String> data = new HashMap<>();
        data.put("application", "communication");
        return RestResponse.ok(data);
    }
}
