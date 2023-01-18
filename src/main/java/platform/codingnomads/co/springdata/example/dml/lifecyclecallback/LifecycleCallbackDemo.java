package platform.codingnomads.co.springdata.example.dml.lifecyclecallback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LifecycleCallbackDemo {

    @Autowired
    PrintEntityRepository printEntityRepository;

    public static void main(String[] args) {
        SpringApplication.run(LifecycleCallbackDemo.class);
    }

    @Bean
    public CommandLineRunner runStuff(PrintEntityRepository printEntityRepository) {
        return (args) -> {
            // put your logic here

            //add user to database
            printEntityRepository.save(PrintEntity.builder()
                    .userName("kyle").userPassword("1234").status("My Status")
                    .build());

            //update user in database
            PrintEntity user = printEntityRepository.findById(1L).get();
            user.setUserName("Mark");
            printEntityRepository.save(user);

            //delete user
            printEntityRepository.deleteById(1L);



        };
    }
}
