package pe.lacafetalab.pao.shared.domain.types;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TypeDateTimeOld extends TypeBase<LocalDateTime> {

    public TypeDateTimeOld(LocalDateTime value) {
        super(value);
    }

    //public static String dateToString(Timestamp timestamp) {
    //    return dateToString(timestamp.toLocalDateTime());
    //}
    public String formatDate() {
        if (this.isNull()) {
            return "";
        }
        return this.value().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public String formatDateTime() {
        if (this.isNull()) {
            return "";
        }
        return this.value().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    @Override
    public String toString() {
        return this.formatDateTime();
    }
}
