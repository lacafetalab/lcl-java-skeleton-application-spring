package pe.lacafetalab.pao.shared.infrastructure.dao;

import java.io.Serializable;

public interface BaseDao<T> extends Serializable {

	public T toDomain();

}
