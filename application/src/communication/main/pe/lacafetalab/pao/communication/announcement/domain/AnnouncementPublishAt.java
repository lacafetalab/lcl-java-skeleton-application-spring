package pe.lacafetalab.pao.communication.announcement.domain;

import pe.lacafetalab.pao.shared.domain.types.TypeDateTime;

import java.util.Date;

public final class AnnouncementPublishAt extends TypeDateTime {
    public AnnouncementPublishAt(String value) {
        super(value);
        if (this.isNull()) {
            this.setNow();
        }
    }

    public AnnouncementPublishAt(Date value) {
        super(value);
    }
}
