package solipsismal.olympiacosfcapp.service;

import solipsismal.olympiacosfcapp.dto.PlayerStatsDTO;

import java.util.List;
import java.util.Optional;

public interface IPlayerStatsService {
    Optional<PlayerStatsDTO> getTopScorer();
    List<PlayerStatsDTO> getTop5Scorers();
    Optional<PlayerStatsDTO> getAssistsLeader();
    List<PlayerStatsDTO> getTopAssistsLeaders();
    Optional<PlayerStatsDTO> getPlayerWithMostYellowCards();
    List<PlayerStatsDTO> getPlayersWithMostYellowCards();
    Optional<PlayerStatsDTO> getPlayerWithMostRedCards();
    List<PlayerStatsDTO> getPlayersWithMostRedCards();
    Optional<PlayerStatsDTO> getMinutesPlayedLeader();
    List<PlayerStatsDTO> getTopMinutesPlayedLeaders();
    Optional<PlayerStatsDTO> getMatchesPlayedLeader();
    List<PlayerStatsDTO> getTopMatchesPlayedLeaders();
    Optional<PlayerStatsDTO> getPlayerWithMostWins();
}
