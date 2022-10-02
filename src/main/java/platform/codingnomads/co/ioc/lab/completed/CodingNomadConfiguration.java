package platform.codingnomads.co.ioc.lab.completed;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("platform.codingnomads.co.ioc.lab.completed")
public class CodingNomadConfiguration {

    @Bean
    public Framework framework() {
        return Framework.builder().name("Spring Boot").version("2.5").build();
    }

    @Bean
    public IDE ide() {
        return IDE.builder().name("IntelliJ IDEA").version("2021.1").build();
    }

    @Bean
    public JDK jdk() {
        return JDK.builder().name("OpenJDK").version("11").build();
    }

    @Bean
    public Whiteboard whiteboard(){
        return Whiteboard.builder().size("large").clean(true).build();
    }

    @Bean
    public Joplin joplin(){
        return Joplin.builder().name("Joplin Note-taking App").version("2.8.8").notebook("IoC").build();
    }

}
