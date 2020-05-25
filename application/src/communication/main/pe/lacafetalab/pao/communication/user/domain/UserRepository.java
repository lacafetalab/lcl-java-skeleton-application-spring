package pe.lacafetalab.pao.communication.user.domain;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void save(User user);

    void saveAll(List<User> listUser);

    Optional<User> findById(UserId id);

    List<User> findAll();

    List<User> findAllById(List<UserId> ids);

    void deleteById(UserId id);
}
