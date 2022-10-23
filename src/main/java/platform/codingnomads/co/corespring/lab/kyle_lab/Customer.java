package platform.codingnomads.co.corespring.lab.kyle_lab;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Customer {

    private String name;
    private String orderDescription;

    public Customer(){
        System.out.println("Customer Created");
    }

}
