package pe.lacafetalab.pao.communication.user.infrastructure.persistence;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.communication.user.domain.User;
import pe.lacafetalab.pao.communication.user.domain.UserId;
import pe.lacafetalab.pao.communication.user.domain.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class UserSqlRepository implements UserRepository {
    private final UserJpaRepository crudRepository;

    public UserSqlRepository(UserJpaRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public void save(User user) {
        crudRepository.save(new UserDao(user));
    }

    @Override
    public void saveAll(List<User> listUser) {
        Iterable<UserDao> iterables = listUser.stream().map(UserDao::new).collect(Collectors.toList());
        crudRepository.saveAll(iterables);
    }

    @Override
    public Optional<User> findById(UserId id) {
        Optional<UserDao> entityDao = crudRepository.findById(id.value());
        return entityDao.map(UserDao::toDomain);
    }

    @Override
    public List<User> findAll() {
        return map(crudRepository.findAll());
    }

    @Override
    public List<User> findAllById(List<UserId> ids) {
        Iterable<String> iterables = ids.stream().map(UserId::value).collect(Collectors.toList());
        return map(crudRepository.findAllById(iterables));
    }

    @Override
    public void deleteById(UserId id) {
        crudRepository.deleteById(id.value());
    }

    private List<User> map(List<UserDao> listUserDao) {
        return listUserDao.stream().map(UserDao::toDomain).collect(Collectors.toList());
    }
}
