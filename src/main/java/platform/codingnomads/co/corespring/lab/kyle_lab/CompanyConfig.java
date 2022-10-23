package platform.codingnomads.co.corespring.lab.kyle_lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;

@Configuration
@ImportResource({"classpath*:xml-config/companyxml.xml"})
public class CompanyConfig {

    @Bean
    public Employee employee(){
        return new Employee();
    }

    @Bean
    public Manager manager(){
        return new Manager();
    }
}
