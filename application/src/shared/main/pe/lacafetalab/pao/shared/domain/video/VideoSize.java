package pe.lacafetalab.pao.shared.domain.video;

import javax.persistence.Embeddable;

import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;
import pe.lacafetalab.pao.shared.domain.valueobject.LongValueObject;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

@Getter
@Embeddable
public class VideoSize extends LongValueObject {
	private static final long serialVersionUID = 1L;

	protected VideoSize() {
	}

	public VideoSize(Long value) {
		super(value);
		validateValue();
	}

	public VideoSize(String value) {
		super(value, new BadRequestException("The video size must be a integer number greater than zero",
				ErrorConstantsShared.BAD_VIDEO_SIZE));
		validateValue();
	}

	private void validateValue() {
		if (value() == null || value() <= 0) {
			throw new BadRequestException("The video size must be a integer number greater than zero",
					ErrorConstantsShared.BAD_VIDEO_SIZE);
		}
	}
}