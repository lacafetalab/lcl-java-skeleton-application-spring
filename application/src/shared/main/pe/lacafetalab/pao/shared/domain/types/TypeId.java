package pe.lacafetalab.pao.shared.domain.types;


import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

public abstract class TypeId extends TypeUUID {

	public TypeId(String id) {
		super(id);
		if (isNull()) {
			throw new BadRequestException("null TypeId", errorIdCannotBeNull());
		}
	}

	protected String errorIdCannotBeNull() {
		return "El id es requerido";
	}

	@Override
	protected String errorUuidValueNotValid() {
		return "El id no es un valor válido";
	}
}
