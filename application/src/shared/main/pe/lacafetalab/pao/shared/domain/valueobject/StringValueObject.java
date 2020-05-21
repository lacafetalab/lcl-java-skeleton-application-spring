package pe.lacafetalab.pao.shared.domain.valueobject;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.StringUtils;

import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

@MappedSuperclass
public class StringValueObject implements Serializable {
	private static final long serialVersionUID = 1L;

	private String value;

	protected StringValueObject() {
	}

	public StringValueObject(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}

	public void verifyIsNotBlank(String name, int errorCode) {
		if (StringUtils.isBlank(value())) {
			throw new BadRequestException(String.format("The %s must not be empty", name), errorCode);
		}
	}

	public void verifyLength(String name, int maxLength, int errorCode) {
		if (value().length() > maxLength) {
			throw new BadRequestException(String.format("The %s should be [%d] characters maximun", name, maxLength), errorCode);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		StringValueObject other = (StringValueObject) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
