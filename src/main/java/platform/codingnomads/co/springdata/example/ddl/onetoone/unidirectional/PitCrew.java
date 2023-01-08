package platform.codingnomads.co.springdata.example.ddl.onetoone.unidirectional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="pit_crews")
@Getter
@Setter
@NoArgsConstructor
public class PitCrew {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="pit_crew_name", nullable = false)
    private String name;

    @OneToOne
    private Driver driver;

}
