package platform.codingnomads.co.springdata.example.ddl.joincolumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="studyclasses")
@Getter
@Setter
@NoArgsConstructor
public class StudyClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String name;

    @Column
    private int credits;

    @OneToMany
    @JoinColumn(name="user_id", nullable = false)
    private Set<User> user;
}
