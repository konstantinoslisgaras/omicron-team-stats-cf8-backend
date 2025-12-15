package solipsismal.olympiacosfcapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import solipsismal.olympiacosfcapp.model.Opponent;

import java.util.Optional;

public interface OpponentRepository extends JpaRepository<Opponent, String>, JpaSpecificationExecutor<Opponent> {
    Optional<Opponent> findByOpponentName(String opponentName);
}