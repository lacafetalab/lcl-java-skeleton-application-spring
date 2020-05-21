package pe.lacafetalab.pao.communication.announcement.domain;

import pe.lacafetalab.pao.shared.domain.types.TypeId;

public final class AnnouncementAuthorId extends TypeId {
    public AnnouncementAuthorId(String value) {
        super(value);
    }

    @Override
    protected String errorIdCannotBeNull() {
        return "El authorId es requerido";
    }

    @Override
    protected String errorUuidValueNotValid() {
        return "El authorId no es un valor válido";
    }
}
