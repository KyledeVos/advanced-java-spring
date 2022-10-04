package platform.codingnomads.co.corespring.examples.springbeans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class SpringDeveloper {

    private Address address;
    private Car car;

    public SpringDeveloper(Address address, Car car) {

        this.address = address;
        this.car = car;
    }
}
