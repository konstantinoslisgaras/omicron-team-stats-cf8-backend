package solipsismal.olympiacosfcapp.service;

import org.springframework.stereotype.Service;
import solipsismal.olympiacosfcapp.dto.PlayerStatsDTO;
import solipsismal.olympiacosfcapp.mapper.PlayerStatsMapper;
import solipsismal.olympiacosfcapp.repository.PlayerStatsRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerStatsService implements IPlayerStatsService {

    private final PlayerStatsRepository playerStatsRepository;

    public PlayerStatsService(PlayerStatsRepository playerStatsRepository) {
        this.playerStatsRepository = playerStatsRepository;
    }

    @Override
    public Optional<PlayerStatsDTO> getTopScorer() {
        return playerStatsRepository.findFirstByOrderByGoalsDesc()
                .map(PlayerStatsMapper::toDTO);
    }

    @Override
    public List<PlayerStatsDTO> getTop5Scorers() {
        return playerStatsRepository.findTop5ByOrderByGoalsDesc()
                .stream()
                .map(PlayerStatsMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PlayerStatsDTO> getAssistsLeader() {
        return playerStatsRepository.findFirstByOrderByAssistsDesc()
                .map(PlayerStatsMapper::toDTO);
    }

    @Override
    public List<PlayerStatsDTO> getTop5AssistsLeaders() {
        return playerStatsRepository.findTop5ByOrderByAssistsDesc()
                .stream()
                .map(PlayerStatsMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PlayerStatsDTO> getPlayerWithMostYellowCards() {
        return playerStatsRepository.findFirstByOrderByYellowCardsDesc()
                .map(PlayerStatsMapper::toDTO);
    }

    @Override
    public List<PlayerStatsDTO> getTop5PlayersWithMostYellowCards() {
        return playerStatsRepository.findTop5ByOrderByYellowCardsDesc()
                .stream()
                .map(PlayerStatsMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PlayerStatsDTO> getPlayerWithMostRedCards() {
        return playerStatsRepository.findFirstByOrderByRedCardsDesc()
                .map(PlayerStatsMapper::toDTO);
    }

    @Override
    public List<PlayerStatsDTO> findTop5ByRedCardsGreaterThanOrderByRedCardsDesc() {
        return playerStatsRepository.findTop5ByRedCardsGreaterThanOrderByRedCardsDesc(0)
                .stream()
                .map(PlayerStatsMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PlayerStatsDTO> getMinutesPlayedLeader() {
        return playerStatsRepository.findFirstByOrderByMinutesPlayedDesc()
                .map(PlayerStatsMapper::toDTO);
    }

    @Override
    public List<PlayerStatsDTO> getTop5MinutesPlayedLeaders() {
        return playerStatsRepository.findTop5ByOrderByMinutesPlayedDesc()
                .stream()
                .map(PlayerStatsMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PlayerStatsDTO> getMatchesPlayedLeader() {
        return playerStatsRepository.findFirstByOrderByMatchesPlayedDesc()
                .map(PlayerStatsMapper::toDTO);
    }

    @Override
    public List<PlayerStatsDTO> getTop5MatchesPlayedLeaders() {
        return playerStatsRepository.findTop5ByOrderByMatchesPlayedDesc()
                .stream()
                .map(PlayerStatsMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PlayerStatsDTO> getPlayerWithMostWins() {
        return playerStatsRepository.findFirstByOrderByWinsDesc()
                .map(PlayerStatsMapper::toDTO);
    }

    @Override
    public List<PlayerStatsDTO> getTop5PlayersWithMostWins() {
        return playerStatsRepository.findTop5ByOrderByWinsDesc()
                .stream()
                .map(PlayerStatsMapper::toDTO)
                .collect(Collectors.toList());
    }
}