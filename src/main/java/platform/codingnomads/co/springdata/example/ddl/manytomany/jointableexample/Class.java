package platform.codingnomads.co.springdata.example.ddl.manytomany.jointableexample;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="classes")
@Getter
@Setter
@NoArgsConstructor
public class Class {

    @Id
    private Long id;

    @Column(nullable = false)
    private String courseName;

    @Column(nullable = false)
    private int maxCredits;
}
