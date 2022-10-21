package platform.codingnomads.co.corespring.examples.profileannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("deploy")
public class JavaDeveloper {

    @Value("${javaDeveloper.name}")
    private String name;

    @Value(("${javaDeveloper.age}"))
    private String age;

    public JavaDeveloper(){

        System.out.println("Java Developer is ready.");
    }

    @Override
    public String toString() {
        return "JavaDeveloper{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
