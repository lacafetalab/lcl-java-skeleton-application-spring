package pe.lacafetalab.pao.controller.announcement.reader;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pe.lacafetalab.pao.communication.announcement.application.reader.search_reader.ReadersResponse;
import pe.lacafetalab.pao.communication.announcement.application.reader.search_reader.SearchReaderQuery;
import pe.lacafetalab.pao.shared.domain.bus.command.CommandBus;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryBus;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryHandlerExecutionError;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryNotRegisteredError;
import pe.lacafetalab.pao.shared.domain.types.implement.TypeUUIDImp;
import pe.lacafetalab.pao.shared.framework.ApiController;
import pe.lacafetalab.pao.shared.response.RestResponse;

@RestController
public final class SearchReaderGetController extends ApiController {
    public SearchReaderGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping("/announcement/reader/{id}/{page}")
    public ResponseEntity<RestResponse> index(@PathVariable String id,@PathVariable Integer page) throws QueryHandlerExecutionError, QueryNotRegisteredError {
        String idDemo = TypeUUIDImp.fromString("AlumnoDemo").toString();
        ReadersResponse readersResponse= ask(new SearchReaderQuery(idDemo, page));
        return RestResponse.list(readersResponse.readerResponses());
    }

}