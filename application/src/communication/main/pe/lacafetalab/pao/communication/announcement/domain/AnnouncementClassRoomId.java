package pe.lacafetalab.pao.communication.announcement.domain;

import pe.lacafetalab.pao.shared.domain.types.TypeId;

public final class AnnouncementClassRoomId extends TypeId {
    public AnnouncementClassRoomId(String value) {
        super(value);
    }

    @Override
    protected String errorIdCannotBeNull() {
        return "El classRoomId es requerido";
    }

    @Override
    protected String errorUuidValueNotValid() {
        return "El classRoomId no es un valor válido";
    }
}
