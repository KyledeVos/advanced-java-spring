package platform.codingnomads.co.springdata.example.jpa.domain;

import javax.persistence.*;

@Entity
public class Scene {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="latitude")
    private double lat;
    private double lon;
    private String name;


}
