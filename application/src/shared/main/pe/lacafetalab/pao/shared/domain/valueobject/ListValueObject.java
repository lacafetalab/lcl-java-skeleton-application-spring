package pe.lacafetalab.pao.shared.domain.valueobject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class ListValueObject<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<T> values;

	protected ListValueObject() {
	}

	public ListValueObject(List<T> values) {
		this.values = Optional.ofNullable(values).orElse(new ArrayList<>());
	}

	public List<T> values() {
		return values;
	}

	public boolean isEmpty() {
		return values == null || values.isEmpty();
	}

	public boolean areAllUnique() {
		if (isEmpty()) {
			return true;
		}
		Set<T> set = new HashSet<>();
		return values.stream().allMatch(t -> set.add(t));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((values == null) ? 0 : values.hashCode());
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
		ListValueObject other = (ListValueObject) obj;
		if (values == null) {
			if (other.values != null)
				return false;
		} else if (!values.equals(other.values))
			return false;
		return true;
	}
}
