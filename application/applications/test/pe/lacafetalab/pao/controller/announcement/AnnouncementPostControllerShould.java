package pe.lacafetalab.pao.controller.announcement;

import org.junit.jupiter.api.Test;
import pe.lacafetalab.pao.ApplicationTestCase;


public final class AnnouncementPostControllerShould extends ApplicationTestCase {
    @Test
    void create_a_valid_non_existing_course() throws Exception {
        assertRequestCreated(
                "POST",
                "/announcement",
                "{\"title\": \"Title\", \"description\": \"alguna descripcion\", \"authorId\": \"d4df3fba-802a-4cde-a99a-0e4f84cf41ac\", \"classRoomId\": \"b3a7b9de-cb4e-42c9-984b-bf331f4871ce\", \"publishAt\": \"2020-04-14 21:06:49\"}"
        );
    }
}