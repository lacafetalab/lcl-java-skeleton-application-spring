package pe.lacafetalab.pao.communication.user.domain;

import pe.lacafetalab.pao.shared.domain.AggregateRoot;

import java.util.Objects;

public final class User extends AggregateRoot {
    private final UserId id;
    private final UserName name;
    private final UserLastname lastname;
    private final UserDescription description;
    private final UserBirthdate birthdate;

    public User(UserId id, UserName name, UserLastname lastname, UserDescription description, UserBirthdate birthdate) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.description = description;
        this.birthdate = birthdate;
    }

    public static User create(UserId id, UserName name, UserLastname lastname, UserDescription description, UserBirthdate birthdate) {
        User entity = new User(id, name, lastname, description, birthdate);
        entity.record(new UserCreatedDomainEvent(id.toString(), name.toString(), lastname.toString(), description.toString(), birthdate.toString()));
        return entity;
    }

    public UserId id() {
        return id;
    }

    public UserName name() {
        return name;
    }

    public UserLastname lastname() {
        return lastname;
    }

    public UserDescription description() {
        return description;
    }

    public UserBirthdate birthdate() {
        return birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User that = (User) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(lastname, that.lastname) && Objects.equals(description, that.description) && Objects.equals(birthdate, that.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, description, birthdate);
    }
}
