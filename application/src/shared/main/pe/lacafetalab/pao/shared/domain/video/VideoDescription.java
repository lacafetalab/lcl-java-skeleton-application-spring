package pe.lacafetalab.pao.shared.domain.video;

import javax.persistence.Embeddable;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;
import pe.lacafetalab.pao.shared.domain.valueobject.StringValueObject;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

@Getter
@Embeddable
public class VideoDescription extends StringValueObject {
	private static final long serialVersionUID = 1L;
	private static final int MAX_LENGTH = 5000;

	protected VideoDescription() {
	}

	public VideoDescription(String value) {
		super(value);
		if (StringUtils.isBlank(value)) {
			throw new BadRequestException("The video description must not be empty",
					ErrorConstantsShared.BAD_VIDEO_DESCRIPTION);
		}
		if (value.length() > MAX_LENGTH) {
			throw new BadRequestException(
					String.format("The video description can not exceed %d characters", MAX_LENGTH),
					ErrorConstantsShared.BAD_VIDEO_DESCRIPTION);
		}
	}
}