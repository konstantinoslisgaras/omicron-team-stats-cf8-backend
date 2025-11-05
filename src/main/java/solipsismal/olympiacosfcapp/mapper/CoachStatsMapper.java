package solipsismal.olympiacosfcapp.mapper;

import solipsismal.olympiacosfcapp.dto.CoachStatsDTO;
import solipsismal.olympiacosfcapp.model.Coach;
import solipsismal.olympiacosfcapp.model.CoachStats;

public class CoachStatsMapper {

    public static CoachStatsDTO toDTO(Coach coach) {
        if (coach == null || coach.getCoachStats() == null) return null;

        var coachStats = coach.getCoachStats();

        return new CoachStatsDTO(
                coach.getId(),
                coach.getLastname(),
                coach.getFirstname(),
                coachStats.getGoals(),
                coachStats.getGoalsConceded(),
                coachStats.getMatchesManaged(),
                coachStats.getWins(),
                coachStats.getDraws(),
                coachStats.getLosses()
        );
    }
}