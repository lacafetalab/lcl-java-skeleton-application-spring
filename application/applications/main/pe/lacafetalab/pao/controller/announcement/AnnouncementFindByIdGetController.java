package pe.lacafetalab.pao.controller.announcement;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pe.lacafetalab.pao.communication.announcement.application.AnnouncementResponse;
import pe.lacafetalab.pao.communication.announcement.application.AnnouncementsResponse;
import pe.lacafetalab.pao.communication.announcement.application.author.search_author.SearchAuthorAnnouncementQuery;
import pe.lacafetalab.pao.communication.announcement.application.find_by_id.AnnouncementFindByIdQuery;
import pe.lacafetalab.pao.shared.domain.bus.command.CommandBus;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryBus;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryHandlerExecutionError;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryNotRegisteredError;
import pe.lacafetalab.pao.shared.framework.ApiController;
import pe.lacafetalab.pao.shared.response.RestResponse;

@RestController
public final class AnnouncementFindByIdGetController extends ApiController {
    public AnnouncementFindByIdGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping("/announcement/{id}")
    public ResponseEntity<RestResponse> index(@PathVariable String id) throws QueryHandlerExecutionError, QueryNotRegisteredError {
        AnnouncementResponse announcementResponse = ask(new AnnouncementFindByIdQuery(id));
        return RestResponse.data(announcementResponse);
    }

}