package solipsismal.olympiacosfcapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Olympiacos {

    @Id
    @Column(length = 10, unique = true, nullable = false)
    private String id;

    @Column(length = 20, unique = true, nullable = false)
    private String name;

    @Column(length = 1_000, nullable = false)
    private String trophies;

    @Column(length = 10_000, nullable = false)
    private String history;
}