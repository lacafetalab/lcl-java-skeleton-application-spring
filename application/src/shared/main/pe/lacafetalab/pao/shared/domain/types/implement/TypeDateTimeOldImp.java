package pe.lacafetalab.pao.shared.domain.types.implement;

import java.time.LocalDateTime;

import pe.lacafetalab.pao.shared.domain.types.TypeDateTimeOld;

public class TypeDateTimeOldImp extends TypeDateTimeOld {
	public TypeDateTimeOldImp(LocalDateTime value) {
		super(value);
	}

	public static TypeDateTimeOld create(int year, int month, int day) {
		LocalDateTime dateTime = LocalDateTime.of(year, month, day, 0, 0, 0);
		return new TypeDateTimeOldImp(dateTime);
	}

	public static TypeDateTimeOld create(int year, int month, int day, int hour, int minute, int second) {
		LocalDateTime dateTime = LocalDateTime.of(year, month, day, hour, minute, second);
		return new TypeDateTimeOldImp(dateTime);
	}

	public static TypeDateTimeOld now() {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime dateTime = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), now.getHour(),
				now.getMinute(), now.getSecond());
		return new TypeDateTimeOldImp(dateTime);
	}
}
