package platform.codingnomads.co.springdata.example.dml.usingqueryannotation.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.models.SoilType;

import java.util.LinkedList;
import java.util.List;

@Repository
public interface SoilTypeRepo extends JpaRepository<SoilType, Long> {

    @Query("SELECT st from SoilType st")
    List<SoilType> findAndPrintAllSoilTypes();

    @Query("SELECT st from SoilType st WHERE ph > 7.5")
    List<SoilType> findSoilTypeWithPhHigherThan7_5();

    @Query("SELECT st from SoilType st WHERE name = ?1")
    List<SoilType> findSoilByName(String name);

    @Query("SELECT st from SoilType st")
    List<SoilType> sortSoilTypesByPh(Sort sort);

    @Query("SELECT st from SoilType st WHERE dry = true")
    List<SoilType> findDrySoilType(Sort sort);
}
