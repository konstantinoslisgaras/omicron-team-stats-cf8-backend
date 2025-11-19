package solipsismal.olympiacosfcapp.dto;

import lombok.Getter;
import lombok.Setter;
import solipsismal.olympiacosfcapp.model.TeamStats;

@Getter
@Setter
public class TeamStatsDTO {
    private String id;
    private Integer goals;
    private Integer assists;
    private Integer goalsConceded;
    private Integer yellowCards;
    private Integer redCards;
    private Integer wins;
    private Integer draws;
    private Integer losses;
    private Integer totalMatches;
    private String season;

    public TeamStatsDTO(TeamStats teamStatsDTO) {
        this.id = teamStatsDTO.getId();
        this.goals = teamStatsDTO.getGoals();
        this.assists = teamStatsDTO.getAssists();
        this.goalsConceded = teamStatsDTO.getGoalsConceded();
        this.yellowCards = teamStatsDTO.getYellowCards();
        this.redCards = teamStatsDTO.getRedCards();
        this.wins = teamStatsDTO.getWins();
        this.draws = teamStatsDTO.getDraws();
        this.losses = teamStatsDTO.getLosses();
        this.totalMatches = teamStatsDTO.getTotalMatches();
        this.season = seasonNameGenerator(teamStatsDTO.getId());
    }

    private String seasonNameGenerator(String id) {
        String start = id.substring(4, 6);
        String end = id.substring(8);
        return start + "-" + end;
    }
}