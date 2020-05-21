package pe.lacafetalab.pao.shared.domain.valueobject;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.StringUtils;

import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

@MappedSuperclass
public class UUIDValueObject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length = 36)
	private String value;

	protected UUIDValueObject() {
	}

	public UUIDValueObject(String uuid) {
		isValidate(uuid);
		this.value = uuid;
	}

	public static UUIDValueObject empty() {
		return new UUIDValueObject();
	}

	private void isValidate(String uuid) {
		if (uuid == null) {
			throw new BadRequestException("Uuid value no valid");
		}
		try {
			UUID.fromString(uuid);
		} catch (IllegalArgumentException exception) {
			throw new BadRequestException("Uuid value no valid");
		}
	}

	public String value() {
		return value;
	}

	public boolean isEmpty() {
		return StringUtils.isBlank(value());
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
		UUIDValueObject other = (UUIDValueObject) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
}
