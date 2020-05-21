package pe.lacafetalab.pao.shared.domain.types;


import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

public abstract class TypeLong extends TypeBase<Long> {

	public TypeLong(Long value) {
		super(value);
	}

	public void verifyGreaterThanZero(BadRequestException ex) {
		if (value() == null || value() <= 0) {
			throw ex;
		}
	}

	public void verifyMinorThanZero(BadRequestException ex) {
		if (value() == null || value() >= 0) {
			throw ex;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value() == null) ? 0 : value().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeLong other = (TypeLong) obj;
		if (value() == null) {
			if (other.value() != null)
				return false;
		} else if (!value().equals(other.value()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		if (this.isNull()) {
			return "";
		}
		return Long.toString(this.value());
	}
}
