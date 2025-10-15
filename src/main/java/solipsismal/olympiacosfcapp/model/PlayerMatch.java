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
@Table(name = "players_matches")
public class PlayerMatch {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "match_id", nullable = false)
    private Match match;

    @Column(length = 2, nullable = false)
    private Integer goals;

    @Column(length = 2, nullable = false)
    private Integer assists;

    @Column(length = 2, nullable = false)
    private Integer yellowCards;

    @Column(length = 2, nullable = false)
    private Integer redCards;

    @Column(length = 2, nullable = false)
    private Integer goalsConceded;

    @Column(length = 1, nullable = false)
    private Integer appearances;

    @Column(length = 3, nullable = false)
    private Integer minutesPlayed;
}
