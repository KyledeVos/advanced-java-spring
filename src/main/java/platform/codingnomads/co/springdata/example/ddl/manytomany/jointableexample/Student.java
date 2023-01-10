package platform.codingnomads.co.springdata.example.ddl.manytomany.jointableexample;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="students")
@Getter
@Setter
@NoArgsConstructor
public class Student {

    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int yearOfStudy;

    @Column(name="student_credits", nullable = false)
    private int credits;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_courses_join_table",
            joinColumns = {@JoinColumn(name="student_credits_reference", referencedColumnName = "student_credits"),
            @JoinColumn(name="student_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {@JoinColumn(name="course_max_credit_reference", referencedColumnName = "maxCredits"),
            @JoinColumn(name = "course_id", referencedColumnName = "id")
            }
    )
    private Set<Class> classSet;
}
