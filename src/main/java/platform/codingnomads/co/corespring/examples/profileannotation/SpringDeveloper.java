package platform.codingnomads.co.corespring.examples.profileannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class SpringDeveloper {

    @Value("${springDeveloper.name}")
    private String name;

    @Value("${springDeveloper.age}")
    private String age;

    public SpringDeveloper() {

        System.out.println("SpringDeveloper is ready.");
    }

    @Override
    public String toString() {
        return "SpringDeveloper{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
