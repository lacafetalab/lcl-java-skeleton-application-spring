package pe.lacafetalab.pao.shared.model;

import java.io.Serializable;
import java.util.ArrayList;

public class EmptyList extends ArrayList<EmptyObject> implements Serializable {
	private static final long serialVersionUID = 1L;

	public EmptyList() {
		super(new ArrayList<>());
	}
}
