package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="players")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private double credits;

    @Column
    private int level;

    @Column
    private boolean onlineGamer;

}