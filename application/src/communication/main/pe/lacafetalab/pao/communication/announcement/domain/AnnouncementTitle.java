package pe.lacafetalab.pao.communication.announcement.domain;

import pe.lacafetalab.pao.shared.domain.types.TypeString;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

public final class AnnouncementTitle extends TypeString {
    public AnnouncementTitle(String value) {
        super(value);
        this.sanitize();
        this.verifyNotBlank(new BadRequestException("null TypeString", "El titulo es requerido"));
    }
}
