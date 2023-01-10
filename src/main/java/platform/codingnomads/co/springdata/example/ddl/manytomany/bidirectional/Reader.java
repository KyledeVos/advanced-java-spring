package platform.codingnomads.co.springdata.example.ddl.manytomany.bidirectional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="client_name", nullable = false)
    private String name;

    @Column(name = "contact_details", nullable = false)
    private String contactDetails;

    @Column(name = "belongsToClub", nullable = false)
    private boolean belongsToClub;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Book> books;
}
