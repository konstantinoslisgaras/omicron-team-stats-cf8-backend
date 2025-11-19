package solipsismal.olympiacosfcapp.service;

import solipsismal.olympiacosfcapp.dto.PlayerStatsDTO;

import java.util.List;
import java.util.Optional;

public interface IPlayerStatsService {
    Optional<PlayerStatsDTO> getTopScorer();
    List<PlayerStatsDTO> getTop5Scorers();
    Optional<PlayerStatsDTO> getAssistsLeader();
    List<PlayerStatsDTO> getTop5AssistsLeaders();
    Optional<PlayerStatsDTO> getPlayerWithMostYellowCards();
    List<PlayerStatsDTO> getTop5PlayersWithMostYellowCards();
    Optional<PlayerStatsDTO> getPlayerWithMostRedCards();
    List<PlayerStatsDTO> findTop5ByRedCardsGreaterThanOrderByRedCardsDesc();
    Optional<PlayerStatsDTO> getMinutesPlayedLeader();
    List<PlayerStatsDTO> getTop5MinutesPlayedLeaders();
    Optional<PlayerStatsDTO> getMatchesPlayedLeader();
    List<PlayerStatsDTO> getTop5MatchesPlayedLeaders();
    Optional<PlayerStatsDTO> getPlayerWithMostWins();
    List<PlayerStatsDTO> getTop5PlayersWithMostWins();
}
