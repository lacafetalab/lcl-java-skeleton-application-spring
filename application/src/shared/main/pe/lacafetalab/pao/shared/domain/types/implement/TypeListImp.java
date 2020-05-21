package pe.lacafetalab.pao.shared.domain.types.implement;

import java.util.List;

import pe.lacafetalab.pao.shared.domain.types.TypeList;

final public class TypeListImp<T> extends TypeList<T> {
	TypeListImp(List<T> values) {
		super(values);
	}

	public static <T> TypeList<T> empty() {
		return new TypeListImp<T>(null);
	}

	public static <T> TypeList<T> create(List<T> values) {
		return new TypeListImp<T>(values);
	}
}