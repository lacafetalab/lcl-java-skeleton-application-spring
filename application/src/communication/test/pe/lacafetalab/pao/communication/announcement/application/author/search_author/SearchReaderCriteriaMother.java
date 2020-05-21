package pe.lacafetalab.pao.communication.announcement.application.author.search_author;

import pe.lacafetalab.pao.shared.domain.criteria.Criteria;
import pe.lacafetalab.pao.shared.domain.criteria.Filters;
import pe.lacafetalab.pao.shared.domain.criteria.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public final class SearchReaderCriteriaMother {


    public static Criteria fromQuery(SearchAuthorAnnouncementQuery query) {
        List<HashMap<String, String>> filters = new ArrayList<>();

        filters.add(new HashMap<String, String>() {{
            put("field", "reader_id");
            put("operator", "and");
            put("value", query.authorId());
        }});

        Integer perPage = 20;
        Integer offset = (query.page() - 1) * perPage;

        return new Criteria(
                Filters.fromValues(filters),
                Order.fromValues(Optional.of("createdAt"),Optional.of("ASC")),
                Optional.of(perPage),
                Optional.of(offset)
        );
    }

    public static Criteria empty(){
        return new Criteria(
                Filters.none(),
                Order.none(),
                Optional.empty(),
                Optional.empty()
        );
    }
}
