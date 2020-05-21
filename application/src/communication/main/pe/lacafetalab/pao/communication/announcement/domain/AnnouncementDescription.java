package pe.lacafetalab.pao.communication.announcement.domain;

import pe.lacafetalab.pao.shared.domain.types.TypeString;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

public final class AnnouncementDescription extends TypeString {
    public AnnouncementDescription(String value) {
        super(value);
        this.sanitize();
        this.verifyNotBlank(new BadRequestException("null TypeString", "La descripcion es requerida"));
    }
}
