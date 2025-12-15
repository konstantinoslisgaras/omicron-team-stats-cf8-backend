package solipsismal.olympiacosfcapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import solipsismal.olympiacosfcapp.model.Olympiacos;

public interface OlympiacosRepository extends JpaRepository<Olympiacos, String>, JpaSpecificationExecutor<Olympiacos> {
}