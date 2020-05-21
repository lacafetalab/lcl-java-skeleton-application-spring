package pe.lacafetalab.pao.shared.domain.valueobject;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

@MappedSuperclass
public class DoubleValueObject implements Serializable {
	private static final long serialVersionUID = 1L;

	private Double value;

	protected DoubleValueObject() {
	}

	public DoubleValueObject(Double value) {
		this.value = value;
	}

	public DoubleValueObject(String value, BadRequestException ex) {
		this(value, ex, false);
	}

	public DoubleValueObject(String value, BadRequestException ex, boolean allowNull) {
		if (StringUtils.isNotBlank(value) && (NumberUtils.isDigits(value) || value.contains("."))) {
			this.value = Double.valueOf(value);
		} else if (allowNull && value == null) {
			this.value = null;
		} else {
			throw ex;
		}
	}

	public void verifyGreaterThanZero(BadRequestException ex) {
		if (value() == null || value() <= 0.0) {
			throw ex;
		}
	}

	public Double value() {
		return value;
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
		DoubleValueObject other = (DoubleValueObject) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
