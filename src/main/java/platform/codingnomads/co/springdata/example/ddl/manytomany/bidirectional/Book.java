package platform.codingnomads.co.springdata.example.ddl.manytomany.bidirectional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="book_title", nullable = false)
    private String title;

    @Column(name="author", nullable = false)
    private String author;

    @ManyToMany(mappedBy = "books")
    private Set<Reader> readerList;
}
