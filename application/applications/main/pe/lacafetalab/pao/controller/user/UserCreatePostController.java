package pe.lacafetalab.pao.controller.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pe.lacafetalab.pao.shared.domain.bus.command.CommandBus;
import pe.lacafetalab.pao.shared.domain.bus.command.CommandHandlerExecutionError;
import pe.lacafetalab.pao.shared.domain.bus.command.CommandNotRegisteredError;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryBus;
import pe.lacafetalab.pao.shared.domain.types.implement.TypeUUIDImp;
import pe.lacafetalab.pao.shared.response.RestResponse;
import pe.lacafetalab.pao.shared.framework.ApiController;
import pe.lacafetalab.pao.communication.user.application.create.CreateUserCommand;

@RestController
public final class UserCreatePostController extends ApiController {
    public UserCreatePostController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/user")
    public ResponseEntity<RestResponse> index(@RequestBody Request request) throws CommandHandlerExecutionError, CommandNotRegisteredError {
        request.setId(TypeUUIDImp.randon().toString());
        dispatch(new CreateUserCommand(request.getId(), request.getName(), request.getLastname(), request.getDescription(), request.getBirthdate()));
        return RestResponse.created(request.getId());
    }

}

@Setter
@Getter
final class Request {
    private String id;
    private String name;
    private String lastname;
    private String description;
    private String birthdate;
}
