package pe.lacafetalab.pao.shared.domain;

import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
public final class PropertyDate extends DateTimeValueObject {
    public PropertyDate(Date value) {
        super(value);
    }
}
