package pe.lacafetalab.pao.shared.domain.types;

public abstract class TypeBase<T> {
    private T value;

    public TypeBase(T value) {
        this.value = value;
    }

    public T value() {
        return this.value;
    }

    public boolean isNull() {
        return this.value == null;
    }

    protected void setValue(T value) {
        this.value = value;
    }

    @Override
    abstract public String toString();
}
