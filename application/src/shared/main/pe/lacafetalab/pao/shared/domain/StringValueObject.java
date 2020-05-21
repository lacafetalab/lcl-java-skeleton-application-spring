package pe.lacafetalab.pao.shared.domain;

import java.util.Objects;

public abstract class StringValueObject {
    private String value;

    public StringValueObject(String value) {
        this.value = value;
    }
    protected void sanitize() {
        if (this.isNull()){
            return;
        }
        this.value = this.value.trim();
    }
    protected boolean isNull() {
        return this.value() == null;
    }

    protected boolean isEmpty() {
        return this.value().equals("");
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return this.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof pe.lacafetalab.pao.shared.domain.StringValueObject)) {
            return false;
        }
        pe.lacafetalab.pao.shared.domain.StringValueObject that = (pe.lacafetalab.pao.shared.domain.StringValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
