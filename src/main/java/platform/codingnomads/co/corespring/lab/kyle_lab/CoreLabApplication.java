package platform.codingnomads.co.corespring.lab.kyle_lab;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class CoreLabApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(CompanyConfig.class);

//        Employee employee = ctx.getBean(Employee.class);
//        Manager manager = ctx.getBean(Manager.class);
//        Customer customer = ctx.getBean(Customer.class);

       // Company company = new Company(employee, manager, customer);
        Company company = ctx.getBean(Company.class);
        System.out.println(company.getCustomer().getName());
        company.getEmployee().setName("Nick");
        company.getEmployee().setEmployeeNumber(1);
        company.getEmployee().setDepartment("sales");

        company.getManager().setName("Angela");
        company.getManager().setManagerNumber(3);
        company.getManager().setControlDepartment("HR");

        System.out.println(company.toString());


    }

}
