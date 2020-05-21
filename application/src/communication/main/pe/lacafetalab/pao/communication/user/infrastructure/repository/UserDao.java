package pe.lacafetalab.pao.communication.user.infrastructure.repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pe.lacafetalab.pao.communication.user.domain.*;
import pe.lacafetalab.pao.shared.infrastructure.dao.GeneralEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity(name = "User")
@Table(name = "users")
public class UserDao extends GeneralEntity<User> {

    private static final long serialVersionUID = 1L;
    public static String SEPARATOR = "|";

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "name", columnDefinition = "text")
    private String name;

    @Column(name = "lastname", columnDefinition = "text")
    private String lastname;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "birth_date")
    private Date birthdate;

    public UserDao(User entity) {
        super();
        this.id = entity.id().value();
        this.name = entity.name().value();
        this.lastname = entity.lastname().value();
        this.description = entity.description().value();
        this.birthdate = entity.birthdate().value();
    }

    @Override
    public User toDomain() {
        return new User(new UserId(this.id), new UserName(this.name), new UserLastname(this.lastname), new UserDescription(this.description), new UserBirthdate(this.birthdate));
    }
}
