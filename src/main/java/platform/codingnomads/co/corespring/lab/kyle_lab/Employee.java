package platform.codingnomads.co.corespring.lab.kyle_lab;

import lombok.*;

@Getter
@Setter
@ToString
public class Employee {

    private String name;
    private int employeeNumber;
    private String department;

    public Employee(){
        System.out.println("Employee Created");
    }
}
