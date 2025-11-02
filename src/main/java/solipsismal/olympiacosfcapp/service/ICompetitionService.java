package solipsismal.olympiacosfcapp.service;

import solipsismal.olympiacosfcapp.dto.CompetitionDTO;

import java.util.List;

public interface ICompetitionService {
    List<CompetitionDTO> findAll();
    List<CompetitionDTO> findActive();
}
