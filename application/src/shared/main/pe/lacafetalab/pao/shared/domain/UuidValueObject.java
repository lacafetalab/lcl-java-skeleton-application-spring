package pe.lacafetalab.pao.shared.domain;

import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public abstract class UuidValueObject implements Serializable {
    final protected String value;

    public UuidValueObject(String value, String messageError) {
        this.value = value;
        isValidate(messageError);
    }

    protected UuidValueObject() {
        this.value = null;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        pe.lacafetalab.pao.shared.domain.UuidValueObject that = (pe.lacafetalab.pao.shared.domain.UuidValueObject) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }


    public boolean isNull() {
        return this.value == null;
    }

    private void isValidate(String messageError) {
        if (isNull()) {
            return;
        }
        try {
            UUID.fromString(value());
        } catch (IllegalArgumentException exception) {
            throw new BadRequestException("vo Identifier", messageError);
        }

    }
}
