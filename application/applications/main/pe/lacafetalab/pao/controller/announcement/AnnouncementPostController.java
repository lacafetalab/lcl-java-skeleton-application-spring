package pe.lacafetalab.pao.controller.announcement;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pe.lacafetalab.pao.shared.domain.Utils;
import pe.lacafetalab.pao.shared.domain.bus.command.CommandBus;
import pe.lacafetalab.pao.shared.domain.bus.command.CommandHandlerExecutionError;
import pe.lacafetalab.pao.shared.domain.bus.command.CommandNotRegisteredError;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryBus;
import pe.lacafetalab.pao.shared.response.RestResponse;
import pe.lacafetalab.pao.shared.framework.ApiController;
import pe.lacafetalab.pao.communication.announcement.application.create.CreateAnnouncementCommand;

@RestController
public final class AnnouncementPostController extends ApiController {
    public AnnouncementPostController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/announcement")
    public ResponseEntity<RestResponse> index(@RequestBody Request request) throws CommandHandlerExecutionError, CommandNotRegisteredError {
        String id = Utils.uuidRandom();
        dispatch(new CreateAnnouncementCommand(
            id,
            request.getTitle(),
            request.getDescription(),
            request.getAuthorId(),
            request.getClassRoomId(),
            request.getPublishAt()));
        return RestResponse.created(id);
    }

}

@Setter
@Getter
final class Request {
    private String title;
    private String description;
    private String publishAt;
    private String authorId;
    private String classRoomId;
}
