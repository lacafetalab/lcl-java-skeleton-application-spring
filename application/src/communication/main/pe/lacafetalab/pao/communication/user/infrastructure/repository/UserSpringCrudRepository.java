package pe.lacafetalab.pao.communication.user.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSpringCrudRepository extends JpaRepository<UserDao, String> {
}
