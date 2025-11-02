package solipsismal.olympiacosfcapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import solipsismal.olympiacosfcapp.model.DetailedBio;

import java.util.Optional;

public interface DetailedBioRepository extends JpaRepository<DetailedBio, String>, JpaSpecificationExecutor<DetailedBio> {
    boolean existsByIdAndSecondNationality(String playerId, String nationality);
}
