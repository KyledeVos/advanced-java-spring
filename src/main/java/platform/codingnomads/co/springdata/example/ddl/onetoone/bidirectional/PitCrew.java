package platform.codingnomads.co.springdata.example.ddl.onetoone.bidirectional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="pitcrews")
@Getter
@Setter
@NoArgsConstructor
public class PitCrew {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String teamName;

    @OneToOne(mappedBy = "pitCrew")
    private Car car;
}
