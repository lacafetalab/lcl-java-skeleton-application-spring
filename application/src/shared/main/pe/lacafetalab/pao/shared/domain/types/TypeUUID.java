package pe.lacafetalab.pao.shared.domain.types;

import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

import java.util.UUID;

public abstract class TypeUUID extends TypeString {

	public TypeUUID(String uuid) {
		super(uuid);
		isValidate();
	}

	private void isValidate() {
		if (isNull()) {
			return;
		}
		try {
			UUID.fromString(value());
		} catch (IllegalArgumentException exception) {
			throw new BadRequestException("valid TypeId", errorUuidValueNotValid());
		}
	}

	protected String errorUuidValueNotValid() {
		return "El uuid no es un valor válido";
	}
}
