package platform.codingnomads.co.corespring.examples.importannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class TaskConfiguration {

    @Bean
    @Primary
    public SpringDeveloper mySpringDeveloper(){
        System.out.println("Bean Created in TaskConfiguration");
        return new SpringDeveloper();
    }

}
