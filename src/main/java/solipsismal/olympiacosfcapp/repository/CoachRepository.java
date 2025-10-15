package solipsismal.olympiacosfcapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import solipsismal.olympiacosfcapp.model.Coach;

import java.util.Optional;

public interface CoachRepository extends JpaRepository<Coach, String>, JpaSpecificationExecutor<Coach> {
    Optional<Coach> findByLastname(String lastname);
}
