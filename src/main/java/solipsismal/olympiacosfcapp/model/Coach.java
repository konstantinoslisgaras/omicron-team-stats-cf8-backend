package solipsismal.olympiacosfcapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "coaches")
public class Coach {

    @Id
    @Column(length = 10, unique = true, nullable = false)
    private String id;

    @Column(name = "lastname", length = 30, unique = false, nullable = false)
    private String lastname;

    @Column(name = "firstname", length = 30, unique = false, nullable = true)
    private String firstname;

    @Column(name = "birth_year", length = 4, nullable = false)
    private Integer birthYear;

    @Column(name = "nationality", length = 30, nullable = false)
    private String nationality;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "detailed_bio_id")
    private DetailedBio detailedBio;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "coach_stats_id")
    private CoachStats coachStats;

    @Column(name = "plays_for_olympiacos", nullable = false)
    private Boolean playsForOlympiacos;
}
