package pe.lacafetalab.pao.controller.announcement.author;

import org.junit.jupiter.api.Test;
import pe.lacafetalab.pao.ApplicationTestCase;


public final class SearchAuthorGetControllerShould extends ApplicationTestCase {
    @Test
    void list_announcement_created() throws Exception {
        executeRequest(
                "POST",
                "/announcement",
                "{\"title\": \"Title\", \"description\": \"alguna descripcion\", \"authorId\": \"d4df3fba-802a-4cde-a99a-0e4f84cf41ac\", \"classRoomId\": \"b3a7b9de-cb4e-42c9-984b-bf331f4871ce\", \"publishAt\": \"2020-04-14 21:06:49\"}"
        );
        assertRequest(
                "GET",
                "/announcement/author/19ad377a-7d39-409a-ab55-c7c29814d488/1",
                200
        );
    }
}