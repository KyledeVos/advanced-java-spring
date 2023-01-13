package platform.codingnomads.co.springdata.example.dml.introducingrepositories.jparepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.*;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class JpaRepoDemo implements CommandLineRunner {

    @Autowired
    SoftDrinkRepo softDrinkRepo;

    public static void main(String[] args) {
        SpringApplication.run(JpaRepoDemo.class);
    }

    @Override
    public void run(String... args) throws Exception {
        SoftDrink fanta = SoftDrink.builder().name("Fanta").rating(10).build();
        SoftDrink coke = SoftDrink.builder().name("Coca-Cola").rating(4).build();
        SoftDrink drPepper = SoftDrink.builder().name("Dr. Pepper").rating(1).build();

        //***************************************************************************
        //Task - Add Entries
        SoftDrink sprite = SoftDrink.builder().name("Sprite").rating(4).build();
        SoftDrink pepsi = SoftDrink.builder().name("Pepsi").rating(6).build();
        SoftDrink mirinda = SoftDrink.builder().name("Mirinda").rating(10).build();
        //***************************************************************************

        //save single entity instance
        fanta = softDrinkRepo.save(fanta);

        //save multiple entity instances at a time
        List<SoftDrink> insertedSoftDrinks = softDrinkRepo.saveAll(List.of(coke, drPepper, pepsi, sprite, mirinda));

        //make sure all entities are actually saved to the database
        softDrinkRepo.flush();

        //***************************************************************************
        //TASK - Find
        System.out.println("***TASK - Find***");
        System.out.println("SoftDrink with id 3:");
        softDrinkRepo.findAll(
                Example.of(
                        SoftDrink.builder().id(3l).build(),
                        ExampleMatcher.matchingAny()
                )
        ).forEach(softdrink-> System.out.println(softdrink));

        //TASK - Update
        //update name of Pepsi to Pepsi Max

        for(SoftDrink softDrink: insertedSoftDrinks) {
            if (softDrink.getName().equalsIgnoreCase("pepsi")) {
                softDrink.setName("Pepsi Max");
                softDrinkRepo.save(softDrink);
            }
        }
        //***************************************************************************

        //update coke and drPepper to have rating 0 in the database
        for (SoftDrink sd : insertedSoftDrinks) {
            sd.setRating(0);
            softDrinkRepo.save(sd);
        }

        System.out.println("ALL SOFT DRINKS IN DESCENDING ORDER BASED ON ID");
        //get all soft drinks in ascending order and print toString() to the console
        softDrinkRepo.findAll(Sort.by(Sort.Direction.DESC, "id")).forEach(System.out::println);

        //find all using an example
        System.out.println("FINDING ALL USING EXAMPLE");
        softDrinkRepo.findAll(
                        Example.of(
                                //probe soft drink to match results with
                                SoftDrink.builder().rating(0).build(),
                                //ask that database entries that match any of the fields in the probe be returned
                                ExampleMatcher.matchingAny())
                )
                .forEach(System.out::println);

        //create page request to paginate through these 3 soft drinks. note that the first page is indicated using a 0
        PageRequest pageRequest = PageRequest.of(0, 2);

        System.out.println("FIRST PAGE");
        //get first page
        Page<SoftDrink> page = softDrinkRepo.findAll(pageRequest);
        page.getContent().forEach(System.out::println);

        System.out.println("SECOND PAGE");
        //get second page
        page = softDrinkRepo.findAll(pageRequest.next());
        page.getContent().forEach(System.out::println);

        //***************************************************************************
        //TASK - Delete
        softDrinkRepo.findAll().forEach(x->{
            if(x.getId()>3){
                softDrinkRepo.delete(x);
            }
        });

        //***************************************************************************

        //delete all 3 soft drinks in a batch
        softDrinkRepo.deleteAllInBatch();
    }
}