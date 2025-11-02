package solipsismal.olympiacosfcapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import solipsismal.olympiacosfcapp.model.Competition;

import java.util.List;
import java.util.Optional;

public interface CompetitionRepository extends JpaRepository<Competition, String>, JpaSpecificationExecutor<Competition> {
    Optional<Competition> findByCompetitionName(String competitionName);
    List<Competition> findAllByOrderByIdAsc();
    List<Competition> findByIsParticipatingTrueOrderByIdAsc();
}
