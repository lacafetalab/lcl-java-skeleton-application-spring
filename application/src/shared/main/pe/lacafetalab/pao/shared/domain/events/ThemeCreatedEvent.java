package pe.lacafetalab.pao.shared.domain.events;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ThemeCreatedEvent extends AggregateRoot implements DomainEvent, Serializable {
	private static final long serialVersionUID = 1L;
	private static final String FULL_QUALIFIED_EVENT_NAME = "pao.course.theme.create.end";

	private String themeId;
	private String unityId;
	private String name;
	private Integer order;
	private Integer duration;
	private Integer weekNumber;

	public static ThemeCreatedEvent buildFromData(ThemeCreatedEventData theme) {
		return ThemeCreatedEvent.builder().themeId(theme.getThemeId()).unityId(theme.getUnityId()).name(theme.getName())
				.order(theme.getOrder()).duration(theme.getDuration()).weekNumber(theme.getWeekNumber()).build();
	}

	@Override
	public String fullQualifiedEventName() {
		return FULL_QUALIFIED_EVENT_NAME;
	}

	public void record() {
		record(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((themeId == null) ? 0 : themeId.hashCode());
		result = prime * result + ((unityId == null) ? 0 : unityId.hashCode());
		result = prime * result + ((weekNumber == null) ? 0 : weekNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ThemeCreatedEvent other = (ThemeCreatedEvent) obj;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (themeId == null) {
			if (other.themeId != null)
				return false;
		} else if (!themeId.equals(other.themeId))
			return false;
		if (unityId == null) {
			if (other.unityId != null)
				return false;
		} else if (!unityId.equals(other.unityId))
			return false;
		if (weekNumber == null) {
			if (other.weekNumber != null)
				return false;
		} else if (!weekNumber.equals(other.weekNumber))
			return false;
		return true;
	}

}
