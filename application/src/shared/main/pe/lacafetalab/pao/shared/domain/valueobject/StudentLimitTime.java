package pe.lacafetalab.pao.shared.domain.valueobject;

import java.util.Date;

import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

public class StudentLimitTime extends DateValueObject {
	private static final long serialVersionUID = 1L;

	public StudentLimitTime(Date value, BadRequestException ex) {
		super(value, ex);
	}

	public StudentLimitTime(Date value) {
		super(value, new BadRequestException("Invalid value for studentLimitTime field"));
	}
}