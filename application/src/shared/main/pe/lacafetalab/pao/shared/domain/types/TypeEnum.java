package pe.lacafetalab.pao.shared.domain.types;

public abstract class TypeEnum<E extends Enum<E>> extends TypeBase<Enum<E>> {

	public TypeEnum(E value) {
		super(value);
	}

	public String name() {
		return value().name();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value() == null) ? 0 : value().hashCode());
		return result;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeEnum other = (TypeEnum) obj;
		if (value() == null) {
			if (other.value() != null)
				return false;
		} else if (!value().equals(other.value()))
			return false;
		return true;
	}

}