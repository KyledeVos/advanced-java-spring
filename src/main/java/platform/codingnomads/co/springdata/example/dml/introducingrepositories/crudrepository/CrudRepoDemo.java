package platform.codingnomads.co.springdata.example.dml.introducingrepositories.crudrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class CrudRepoDemo implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(CrudRepoDemo.class);
    }

    //autowire the UserRepo into the class to gain access to the CRUD methods
    @Autowired
    UserRepo userRepo;

    @Override
    public void run(String... args) throws Exception {
        //create new user
        User user = User.builder().firstName("Bobby").lastName("Bobbert").age(56).build();
        User user2 = User.builder().firstName("Joanne").lastName("Joanna").age(36).build();

        //task
        User user3 = User.builder().firstName("Harry").lastName("Miles").age(38).build();
        User user4 = User.builder().firstName("Sarah").lastName("Clair").age(29).build();
        User user5 = User.builder().firstName("Nelly").lastName("Jackson").age(45).build();
        User user6 = User.builder().firstName("Amanda").lastName("Hudge").age(78).build();

        //save user and assign what is returned to the user variable.
//        user = userRepo.save(user);
//        user2 = userRepo.save(user2);

        //task
        Iterable<User> users = userRepo.saveAll(List.of(user, user2, user3, user4, user5, user6));

        //findAll users from database
        users = userRepo.findAll();

        for(User u : users){
            System.out.println(u.toString());
        }

        //delete the user using the id of the inserted user object
//        userRepo.deleteById(user.getId());
//        userRepo.deleteById(user2.getId());

        //delete all users at once from database
        userRepo.deleteAll(users);
    }
}
