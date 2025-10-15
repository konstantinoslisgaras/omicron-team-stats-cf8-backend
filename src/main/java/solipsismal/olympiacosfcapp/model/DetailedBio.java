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
@Table(name = "detailed_bio")
public class DetailedBio {

    @Id
    @Column(length = 10, unique = true, nullable = false)
    private String id;

    @Column(name = "fullname", length = 100, unique = true, nullable = false)
    private String fullname;

    @Column(name = "birthdate", length = 10, unique = false, nullable = false)
    private String birthdate;

    @Column(name = "city_of_birth", length = 50, unique = false, nullable = false)
    private String cityOfBirth;

    @Column(name = "second_nationality", length = 30, unique = false, nullable = true)
    private String secondNationality;

    @Column(name = "height", length = 4, unique = false, nullable = true)
    private Double height;

    @Column(name = "previous_team", length = 50, unique = false, nullable = true)
    private String previousTeam;

    @Column(name = "biography", length = 1_000, nullable = false)
    private String biography;
}