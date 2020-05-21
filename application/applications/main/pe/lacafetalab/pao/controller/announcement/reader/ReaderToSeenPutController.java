package pe.lacafetalab.pao.controller.announcement.reader;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.lacafetalab.pao.communication.announcement.application.create.CreateAnnouncementCommand;
import pe.lacafetalab.pao.communication.announcement.application.reader.to_seen.ReaderToSeenCommand;
import pe.lacafetalab.pao.shared.domain.Utils;
import pe.lacafetalab.pao.shared.domain.bus.command.CommandBus;
import pe.lacafetalab.pao.shared.domain.bus.command.CommandHandlerExecutionError;
import pe.lacafetalab.pao.shared.domain.bus.command.CommandNotRegisteredError;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryBus;
import pe.lacafetalab.pao.shared.framework.ApiController;
import pe.lacafetalab.pao.shared.response.RestResponse;

@RestController
public final class ReaderToSeenPutController extends ApiController {
    public ReaderToSeenPutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/announcement/reader/{id}/to-seen")
    public ResponseEntity<RestResponse> index(@PathVariable String id, @RequestBody Request request) throws CommandHandlerExecutionError, CommandNotRegisteredError {
        dispatch(new ReaderToSeenCommand(request.getAnnouncementReaderId(), id));
        return RestResponse.ok();
    }

}

@Setter
@Getter
final class Request {
    private String announcementReaderId;
}
