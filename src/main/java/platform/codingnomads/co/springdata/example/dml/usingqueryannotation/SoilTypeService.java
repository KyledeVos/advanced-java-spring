package platform.codingnomads.co.springdata.example.dml.usingqueryannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.models.SoilType;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.repositories.SoilTypeRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SoilTypeService {

    @Autowired
    SoilTypeRepo soilTypeRepo;

    //Adding more SoilTypes for Task
    SoilType sandy = SoilType.builder().name("sandy").ph(6.2).dry(false).build();
    SoilType silt = SoilType.builder().name("silt").ph(6.5).dry(true).build();
    SoilType clay = SoilType.builder().name("clay").ph(8.5).dry(false).build();

    public void saveSoilTypes(){
        soilTypeRepo.saveAll(List.of(sandy, silt, clay));
    }


    @Transactional
    public void getStuff(){
        System.out.println("************************************");
        System.out.println("SOIL TYPE TASK\n");

        System.out.println("1) Print all Soil Types");
        soilTypeRepo.findAndPrintAllSoilTypes().forEach(System.out::println);

        System.out.println("\n************************************");
        System.out.println("2) Print all Soil Types with a ph higher than 7.5");
        soilTypeRepo.findSoilTypeWithPhHigherThan7_5().forEach(System.out::println);

        System.out.println("\n************************************");
        System.out.println("3) Search for soil by name");
        soilTypeRepo.findSoilByName("clay").forEach(System.out::println);

        System.out.println("\n************************************");
        System.out.println("4) Sort Soil Types by ph");
        soilTypeRepo.sortSoilTypesByPh(Sort.by(Sort.Order.desc("ph")))
                .forEach(System.out::println);

        System.out.println("\n************************************");
        System.out.println("5) Find Dry Soil Plant with the Highest pH");
        System.out.println(soilTypeRepo.findDrySoilType(Sort.by(Sort.Order.desc("ph"))).get(0).toString());


    }
}
