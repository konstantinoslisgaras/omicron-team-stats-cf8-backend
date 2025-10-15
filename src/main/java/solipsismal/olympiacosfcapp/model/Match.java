package solipsismal.olympiacosfcapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import solipsismal.olympiacosfcapp.core.enums.Day;
import solipsismal.olympiacosfcapp.core.enums.Ground;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "matches")
public class Match {

    @Id
    @Column(length = 10, unique = true, nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "olympiacos_id", nullable = false)
    private Olympiacos olympiacos;

    @ManyToOne
    @JoinColumn(name = "opponent_id", nullable = false)
    private Opponent opponent;

    @Column(name = "olympiacos_goals", length = 2, nullable = false)
    private Integer olympiacosGoals;

    @Column(name = "opponent_goals", length = 2, nullable = false)
    private Integer opponentGoals;

    @Column(length = 10)
    private String date;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Day day;

    @ManyToOne
    @JoinColumn(name = "competition_id", nullable = false)
    private Competition competition;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private Ground ground;

    @Column(name = "match_number", length = 2, nullable = false)
    private Integer matchNumber;

    @Column(length = 100)
    private String description;

    @ManyToOne
    @JoinColumn(name = "coach_id", nullable = false)
    private Coach coach;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_stats_id", nullable = false)
    private TeamStats teamStats;

    @ManyToOne
    @JoinColumn(name = "season_id", nullable = false)
    private Season season;

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PlayerMatch> playersMatches = new HashSet<>();

    public Match(String id, Olympiacos olympiacos, Opponent opponent, Integer olympiacosGoals, Integer opponentGoals,
                 String date, Day day, Competition competition, Ground ground, Integer matchNumber, String description,
                 Coach coach, Season season, TeamStats teamStats) {
        this.id = id;
        this.olympiacos = olympiacos;
        this.opponent = opponent;
        this.olympiacosGoals = olympiacosGoals;
        this.opponentGoals = opponentGoals;
        this.date = date;
        this.day = day;
        this.competition = competition;
        this.ground = ground;
        this.matchNumber = matchNumber;
        this.description = description;
        this.coach = coach;
        this.season = season;
        this.teamStats = teamStats;
        this.playersMatches = new HashSet<>();
    }
}