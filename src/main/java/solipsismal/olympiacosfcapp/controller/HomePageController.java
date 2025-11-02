package solipsismal.olympiacosfcapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solipsismal.olympiacosfcapp.dto.CompetitionDTO;
import solipsismal.olympiacosfcapp.dto.MatchBasicDTO;
import solipsismal.olympiacosfcapp.dto.TeamStatsDTO;
import solipsismal.olympiacosfcapp.service.CompetitionService;
import solipsismal.olympiacosfcapp.service.MatchService;
import solipsismal.olympiacosfcapp.service.PlayerStatsService;
import solipsismal.olympiacosfcapp.service.TeamStatsService;

import java.util.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HomePageController {

    private final MatchService matchService;
    private final TeamStatsService teamStatsService;
    private final PlayerStatsService playerStatsService;
    private final CompetitionService competitionService;

    @GetMapping("/homepage")
    public Map<String, Object> getHomepageData() {
        Map<String, Object> homePageData = new HashMap<>();

        // Latest match
        Optional<MatchBasicDTO> previousMatch = matchService.getPreviousMatch();
        homePageData.put("previousMatch", previousMatch);

        // Next match
        Optional<MatchBasicDTO> nextMatch = matchService.getNextMatch();
        homePageData.put("nextMatch", nextMatch);

        // Team stats
        List<TeamStatsDTO> teamStats20252026 = teamStatsService.findById("TS20252026");
        homePageData.put("teamStats20252026", teamStats20252026);

        // Player stat leaders
        homePageData.put("topScorer", Objects.requireNonNull(playerStatsService.getTopScorer().orElse(null)));
        homePageData.put("assistLeader", Objects.requireNonNull(playerStatsService.getAssistsLeader().orElse(null)));
        homePageData.put("mostYellowCards", Objects.requireNonNull(playerStatsService.getPlayerWithMostYellowCards().orElse(null)));
        homePageData.put("mostRedCards", Objects.requireNonNull(playerStatsService.getPlayerWithMostRedCards().orElse(null)));
        homePageData.put("minutesPlayedLeader", Objects.requireNonNull(playerStatsService.getMinutesPlayedLeader().orElse(null)));
        homePageData.put("matchesPlayedLeader", Objects.requireNonNull(playerStatsService.getMatchesPlayedLeader().orElse(null)));
        homePageData.put("mostWins", Objects.requireNonNull(playerStatsService.getPlayerWithMostWins().orElse(null)));

        // Competition stats
        List<CompetitionDTO> competitionStatus = competitionService.findActive();
        homePageData.put("competitionsStatus", competitionStatus);

        return homePageData;
    }
}