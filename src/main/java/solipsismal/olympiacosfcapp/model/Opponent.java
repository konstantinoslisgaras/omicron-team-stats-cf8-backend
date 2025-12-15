package solipsismal.olympiacosfcapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "opponents")
public class Opponent {

    @Id
    @Column(length = 10, unique = true, nullable = false)
    private String id;

    @Column(name = "opponent_name", length = 50, unique = true, nullable = false)
    private String opponentName;

    @Column(length = 50, unique = false, nullable = false)
    private String country;
}