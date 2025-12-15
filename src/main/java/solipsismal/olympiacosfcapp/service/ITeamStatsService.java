package solipsismal.olympiacosfcapp.service;

import solipsismal.olympiacosfcapp.dto.TeamStatsDTO;

import java.util.List;

public interface ITeamStatsService {
    List<TeamStatsDTO> findById(String id);
}