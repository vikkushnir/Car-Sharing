package car.sharing.repository;

import static car.sharing.model.Role.RoleType;

import car.sharing.model.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleType(RoleType type);
}
