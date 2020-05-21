package pe.lacafetalab.pao.shared.domain.valueobject;

import java.io.Serializable;
import java.util.Date;

import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

public class DateValueObject implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date value;

	protected DateValueObject() {
	}

	public DateValueObject(Date value) {
		this(value, new BadRequestException("the date value can not be null"));
	}

	public DateValueObject(Date value, BadRequestException ex) {
		if (value == null) {
			throw ex;
		}
		this.value = value;
	}

	public Date value() {
		return value;
	}

	public Long time() {
		return value != null ? value.getTime() : null;
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
		DateValueObject other = (DateValueObject) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
