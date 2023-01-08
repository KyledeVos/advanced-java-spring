package platform.codingnomads.co.corespring.lab.kyle_lab;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
@ImportResource({"classpath*:xml-config/companyxml.xml"})
public class CompanyConfig {

    @Bean("employee")
    public Employee employee(){
        return new Employee();
    }

    @Bean("manager")
    public Manager manager(){
        return new Manager();
    }
}
