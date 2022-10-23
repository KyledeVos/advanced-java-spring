package platform.codingnomads.co.corespring.lab.kyle_lab;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
public class Company {

    private Employee employee;
    private Manager manager;
    private Customer customer;

    @Autowired
    public Company(Employee employee, Manager manager, Customer customer){
        this.employee = employee;
        this.manager = manager;
        this.customer = customer;
    }


}
