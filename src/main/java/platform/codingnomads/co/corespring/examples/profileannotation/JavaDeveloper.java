package platform.codingnomads.co.corespring.examples.profileannotation;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("deploy")
public class JavaDeveloper {

    public JavaDeveloper(){

        System.out.println("Java Developer is ready.");
    }
}
