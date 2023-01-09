package platform.codingnomads.co.springdata.example.ddl.manytoone.unidirectional.usingmanytoone;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="likes")
@Getter
@Setter
@NoArgsConstructor
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String username;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;
}
