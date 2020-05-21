package pe.lacafetalab.pao.communication.announcement.domain;

import org.junit.jupiter.api.Test;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnnouncementDescriptionShould {
    private String expectedMessage() {
        return "La descripcion es requerida";
    }

    @Test
    void createNullAnnouncementDescription() {
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            AnnouncementDescriptionMother.create(null);
        });
        assertEquals("null TypeString", exception.getMessage());
        assertEquals(expectedMessage(), exception.getData());
    }

    @Test
    void createEmptyAnnouncementDescription() {
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            AnnouncementDescriptionMother.create("");
        });
        assertEquals("null TypeString", exception.getMessage());
        assertEquals(expectedMessage(), exception.getData());
    }

    @Test
    void createBlankAnnouncementDescription() {
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            AnnouncementDescriptionMother.create(" ");
        });
        assertEquals("null TypeString", exception.getMessage());
        assertEquals(expectedMessage(), exception.getData());
    }
}
