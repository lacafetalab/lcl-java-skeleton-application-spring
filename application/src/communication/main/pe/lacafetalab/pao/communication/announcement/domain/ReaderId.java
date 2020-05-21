package pe.lacafetalab.pao.communication.announcement.domain;

import pe.lacafetalab.pao.shared.domain.types.TypeId;

public final class ReaderId extends TypeId {

    public ReaderId(String value) {
        super(value);
    }

    @Override
    protected String errorIdCannotBeNull() {
        return "El ReaderId es requerido";
    }

    @Override
    protected String errorUuidValueNotValid() {
        return "El ReaderId no es un valor válido";
    }
}
