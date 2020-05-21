package pe.lacafetalab.pao.shared.domain.types;

import org.apache.commons.lang3.StringUtils;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;


public abstract class TypeString extends TypeBase<String> {

	public TypeString(String value) {
		super(value);
	}

	public int length() {
		if (this.isNull()) {
			return 0;
		}
		return this.value().length();
	}

	public void verifyNotBlank(BadRequestException ex) {
		if (StringUtils.isBlank(value())) {
			throw ex;
		}
	}

	public void verifyLength(int maxLength, BadRequestException ex) {
		if (value().length() > maxLength) {
			throw ex;
		}
	}

	protected void sanitize() {
		if (this.isNull()){
			return;
		}
		this.setValue(this.value().trim());
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
		TypeString other = (TypeString) obj;
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
		return this.value();
	}
}
