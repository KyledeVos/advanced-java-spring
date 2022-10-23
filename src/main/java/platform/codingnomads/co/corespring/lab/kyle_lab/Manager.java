package platform.codingnomads.co.corespring.lab.kyle_lab;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Manager {

    private String name;
    private String ControlDepartment;
    private int managerNumber;

    public Manager(){
        System.out.println("Manager Created");
    }
}
