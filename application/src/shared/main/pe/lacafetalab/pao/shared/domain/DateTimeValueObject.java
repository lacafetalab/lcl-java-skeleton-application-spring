package pe.lacafetalab.pao.shared.domain;

import lombok.NoArgsConstructor;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@NoArgsConstructor
public abstract class DateTimeValueObject {
    private Date value;

    public DateTimeValueObject(Date value) {
        this.value = value;
    }

    public DateTimeValueObject(String value) {
        if (value == null) {
            return;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            this.value = formatter.parse(value);
        } catch (ParseException e) {
            throw new BadRequestException("vo datetime", "El formato de fecha no es correcto");
        }
    }

    protected boolean isNull() {
        return this.value() == null;
    }

    protected void setNow() {
        this.value = new Date();
    }

    public Date value() {
        return value;
    }

    public String formatDateTime() {
        if (this.isNull()) {
            return "";
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(this.value);
    }

    @Override
    public String toString() {
        return this.formatDateTime();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof pe.lacafetalab.pao.shared.domain.DateTimeValueObject)) return false;
        pe.lacafetalab.pao.shared.domain.DateTimeValueObject that = (pe.lacafetalab.pao.shared.domain.DateTimeValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
