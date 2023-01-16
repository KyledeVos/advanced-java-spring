package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import groovyjarjarpicocli.CommandLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.repositories.PlantRepo;

import java.util.List;

@SpringBootApplication
public class PlayerDemo implements CommandLineRunner {

    @Autowired
    PlayerRepo playerRepo;



    public static void main(String[] args){
        SpringApplication.run(PlayerDemo.class);
    }

    @Override
    public void run(String... args) throws Exception {

        //Create Players

        playerRepo.saveAll(List.of(
                Player.builder().name("Lexy").credits(3400).level(5).onlineGamer(true).build(),
                Player.builder().name("MadMax3000").credits(7000).level(9).onlineGamer(true).build(),
                Player.builder().name("SandyUltra").credits(2000).level(3).onlineGamer(false).build(),
                Player.builder().name("AncientCurxe").credits(6900).level(5).onlineGamer(true).build(),
                Player.builder().name("RunAlone").credits(13000).level(15).onlineGamer(true).build(),
                Player.builder().name("IWindowsRXR").credits(9700).level(8).onlineGamer(false).build(),
                Player.builder().name("Brian").credits(800).level(1).onlineGamer(false).build(),
                Player.builder().name("Original").credits(18900).level(20).onlineGamer(true).build(),
                Player.builder().name("August").credits(1000).level(1).onlineGamer(true).build()
        ));

        System.out.println("******************************");
        System.out.println("Find all Players that Play Online");
        playerRepo.findByOnlineGamerIsTrue().forEach(System.out::println);

        System.out.println("******************************");
        System.out.println("Find Players with credits higher than 5000");
        playerRepo.findByCreditsGreaterThan(5000).
                forEach(player -> System.out.println(player.toString()));


        System.out.println("******************************");
        System.out.println("Find Top 2 players with level higher than 4");
        playerRepo.getTop2ByLevelGreaterThan(Sort.by(Sort.Order.desc("level")), 4)
                .forEach(System.out::println);

        System.out.println("******************************");
        System.out.println("Find players with level of 5 and credits higher than 5000");
        playerRepo.getByLevelAndCreditsGreaterThan(5, 5000).forEach(System.out::println);

        System.out.println("******************************");
        System.out.println("Find players with level less than 7 and credits higher than 1000");
        playerRepo.getByLevelLessThanAndCreditsGreaterThan(7, 1000).forEach(System.out::println);

        System.out.println("******************************");
        System.out.println("Find Highest ranked Player by level");
        //Note if multiple players exist with the same level it would
        //return the first in the db
        System.out.println(playerRepo.findTopByLevelGreaterThan(1, Sort.by(Sort.Order.desc("level"))));

        System.out.println("******************************");
        System.out.println("Find players with letters 'an' contained in their name");
        playerRepo.findByNameContaining("an").forEach(System.out::println);

        System.out.println("******************************");
        System.out.println("Find player(s) with a specific name and print out their online status");
        String name = "Brian";
        List<Player> playersCalled = playerRepo.findByNameIs(name);
        if(playersCalled.isEmpty()){
            System.out.println("No Playes called: " + name);
        }else{
            playersCalled.forEach(player -> System.out.println(player.isOnlineGamer()));
        }

        System.out.println("******************************");
        System.out.println("Find players with credits greater than or equal to 1000 " +
                "Or are online gamers");
        playerRepo.getByCreditsGreaterThanEqualOrOnlineGamerIs(1000, true)
                .forEach(System.out::println);

        System.out.println("******************************");
        System.out.println("Determine the number of players that do not play online");
        int notOnlineGamerCount = playerRepo.countByOnlineGamerIsNot(true);
        System.out.println(notOnlineGamerCount);
        
    }
}
