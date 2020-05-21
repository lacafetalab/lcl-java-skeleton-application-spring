package pe.lacafetalab.pao.communication.announcement.domain;

import org.junit.jupiter.api.Test;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnnouncementTitleShould {
    private String expectedMessage() {
        return "El titulo es requerido";
    }

    @Test
    void createNullAnnouncementTitle() {
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            AnnouncementTitleMother.create(null);
        });
        assertEquals("null TypeString", exception.getMessage());
        assertEquals(expectedMessage(), exception.getData());
    }

    @Test
    void createEmptyAnnouncementTitle() {
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            AnnouncementTitleMother.create("");
        });
        assertEquals("null TypeString", exception.getMessage());
        assertEquals(expectedMessage(), exception.getData());
    }

    @Test
    void createBlankAnnouncementTitle() {
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            AnnouncementTitleMother.create(" ");
        });
        assertEquals("null TypeString", exception.getMessage());
        assertEquals(expectedMessage(), exception.getData());
    }
}
