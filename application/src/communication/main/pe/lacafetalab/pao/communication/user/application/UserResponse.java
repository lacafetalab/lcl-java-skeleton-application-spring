package pe.lacafetalab.pao.communication.user.application;

import lombok.Getter;
import pe.lacafetalab.pao.communication.user.domain.User;
import pe.lacafetalab.pao.shared.domain.bus.query.Response;

import java.util.Objects;

@Getter
final public class UserResponse implements Response {
    private final String id;
    private final String name;
    private final String lastname;
    private final String description;
    private final String birthdate;

    public UserResponse(String id, String name, String lastname, String description, String birthdate) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.description = description;
        this.birthdate = birthdate;
    }

    public static UserResponse fromAggregate(User user) {
        return new UserResponse(user.id().toString(), user.name().toString(), user.lastname().toString(), user.description().toString(), user.birthdate().toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserResponse)) return false;
        UserResponse that = (UserResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(lastname, that.lastname) && Objects.equals(description, that.description) && Objects.equals(birthdate, that.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, description, birthdate);
    }
}
