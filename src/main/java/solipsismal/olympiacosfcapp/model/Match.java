package solipsismal.olympiacosfcapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import solipsismal.olympiacosfcapp.core.enums.Day;
import solipsismal.olympiacosfcapp.core.enums.Ground;
import solipsismal.olympiacosfcapp.core.enums.Result;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
    @JoinColumn(name = "opponent_id")
    private Opponent opponent;

    @Column(name = "olympiacos_goals", length = 2)
    private Integer olympiacosGoals;

    @Column(name = "opponent_goals", length = 2)
    private Integer opponentGoals;

    @Column(name = "result", length = 5, nullable = true)
    private String result;

    @Column(length = 10, nullable = false)
    private LocalDate date;

    @Column(length = 5)
    private LocalTime time;

    @Transient
    public LocalDateTime getDateTime() {
        if (date != null && time !=null) {
            return LocalDateTime.of(date, time);
        }
        return null;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Day day;

    @ManyToOne
    @JoinColumn(name = "competition_id", nullable = false)
    private Competition competition;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Ground ground;

    @Column(name = "match_number", nullable = false)
    private Integer matchNumber;

    @Column(length = 100, nullable = false)
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
                 String date, String time, Day day, Competition competition, Ground ground, Integer matchNumber, String description,
                 Coach coach, Season season, TeamStats teamStats) {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        this.id = id;
        this.olympiacos = olympiacos;
        this.opponent = opponent;
        this.olympiacosGoals = olympiacosGoals;
        this.opponentGoals = opponentGoals;
        result();
        this.date = LocalDate.parse(date, dateFormatter);
        this.time = LocalTime.parse(time, timeFormatter);
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

    // Constructor for short-term matches.
    public Match(String id, Olympiacos olympiacos, Opponent opponent, String date, String time, Day day, Competition competition,
                 Ground ground, Integer matchNumber, String description, Coach coach, Season season, TeamStats teamStats) {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        this.id = id;
        this.olympiacos = olympiacos;
        this.opponent = opponent;
        this.date = LocalDate.parse(date, dateFormatter);
        this.time = LocalTime.parse(time, timeFormatter);
        this.day = day;
        this.competition = competition;
        this.ground = ground;
        this.matchNumber = matchNumber;
        this.description = description;
        this.coach = coach;
        this.season = season;
        this.teamStats = teamStats;
    }

    // Constructor for long-term matches.
    public Match(String id, Olympiacos olympiacos, String date, Competition competition, Integer matchNumber, String description, Season season) {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        this.id = id;
        this.olympiacos = olympiacos;
        this.date = LocalDate.parse(date, dateFormatter);
        this.competition = competition;
        this.matchNumber = matchNumber;
        this.description = description;
        this.season = season;
    }

    public String getFormattedDate() {
        return date != null ? date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : null;
    }

    public String getFormattedTime() {
        return time != null ? time.format(DateTimeFormatter.ofPattern("HH:mm")) : null;
    }

    private void result() {
        if (this.olympiacosGoals > this.opponentGoals) {
            this.result = Result.WIN.toString();
        } else if (this.olympiacosGoals.equals(this.opponentGoals)) {
            this.result = Result.DRAW.toString();
        } else {
            this.result = Result.LOSS.toString();
        }
    }
}