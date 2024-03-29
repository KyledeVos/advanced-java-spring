package platform.codingnomads.co.springdata.example.dml.usingqueryannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QueryApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(QueryApplication.class);
    }

    @Autowired
    PlantService plantService;

    @Autowired
    SoilTypeService soilTypeService;

    @Override
    public void run(String... args) throws Exception {

        plantService.saveStuff();

        plantService.getStuff();

        soilTypeService.saveSoilTypes();

        soilTypeService.getStuff();

    }
}
