package pe.lacafetalab.pao.shared.domain.valueobject;

import java.util.Date;

import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

public class FeedbackLimitTime extends DateValueObject {
	private static final long serialVersionUID = 1L;

	public static FeedbackLimitTime empty() {
		return new FeedbackLimitTime();
	}

	protected FeedbackLimitTime() {
		super();
	}

	public FeedbackLimitTime(Date value) {
		super(value, new BadRequestException("Invalid value for feedbackLimitTime field"));
	}
}