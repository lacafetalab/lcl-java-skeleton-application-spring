package pe.lacafetalab.pao.shared.domain.types;

import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public abstract class TypeDateTime extends TypeBase<Date> {
    public TypeDateTime(Date value) {
        super(value);
    }

    public TypeDateTime(String value) {
        super(null);
        if (value == null) {
            return;
        }
        try {
            this.setValue(formatter().parse(value));
        } catch (ParseException e) {
            throw new BadRequestException("vo datetime", "El formato de fecha no es correcto");
        }
    }

    protected void setNow() {
        this.setValue(new Date());
    }

    public String formatDate() {
        if (this.isNull()) {
            return "";
        }
        return formatter().format(this.value());
    }

    private SimpleDateFormat formatter() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    @Override
    public String toString() {
        return this.formatDate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeDateTime)) return false;
        TypeDateTime that = (TypeDateTime) o;
        return Objects.equals(value(), that.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value());
    }
}
