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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "competitions")
public class Competition {

    @Id
    @Column(length = 10, unique = true, nullable = false)
    private String id;

    @Column(name = "competition_name", length = 50, unique = true, nullable = false)
    private String competitionName;

    @Column(name = "competition_info", length = 1000)
    private String competitionInfo;
}
