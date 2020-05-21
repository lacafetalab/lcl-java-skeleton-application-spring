package pe.lacafetalab.pao.shared.domain.types;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class TypeList<T> extends TypeBase<List<T>> {

	public TypeList(List<T> values) {
		super(Optional.ofNullable(values).orElse(new ArrayList<>()));
	}

	public List<T> values() {
		return value();
	}

	public boolean isEmpty() {
		return values() == null || values().isEmpty();
	}

	public boolean areAllUnique() {
		if (isEmpty()) {
			return true;
		}
		Set<T> set = new HashSet<>();
		return values().stream().allMatch(t -> set.add(t));
	}

	public List<T> distinct() {
		return new ArrayList<>(new HashSet<>(values()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((values() == null) ? 0 : values().hashCode());
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
		TypeList other = (TypeList) obj;
		if (values() == null) {
			if (other.values() != null)
				return false;
		} else if (!values().equals(other.values()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return values().toString();
	}
}
