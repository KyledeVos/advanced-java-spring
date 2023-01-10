package platform.codingnomads.co.springdata.example.ddl.joincolumn;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="user_resources_loopUpTable",
    joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    inverseJoinColumns = {@JoinColumn(name = "resource_id", referencedColumnName = "name"),
                            @JoinColumn(name = "resource_name", referencedColumnName = "name", unique = true)})
    private Set<Resource> resourceSet;


}
