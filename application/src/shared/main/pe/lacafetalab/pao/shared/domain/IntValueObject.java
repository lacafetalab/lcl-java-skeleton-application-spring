package pe.lacafetalab.pao.shared.domain;

import java.util.Objects;

public abstract class IntValueObject {
    private Integer value;

    public IntValueObject(Integer value) {
        this.value = value;
    }

    public Integer value() {
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
        pe.lacafetalab.pao.shared.domain.IntValueObject that = (pe.lacafetalab.pao.shared.domain.IntValueObject) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
