package platform.codingnomads.co.springdata.example.dml.lifecyclecallback;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrintEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="userName")
    private String userName;

    @Transient
    private String userPassword;

    @Column(name="status")
    private String status;

    // write your methods here

   @PrePersist
    public void printBeforeSavingToDatabaseMessage(){
       System.out.println("\n******************** @PREPERSIST *****************");
       System.out.println("Entity is going to being saved to database\n");
   }

   @PreUpdate
    public void printBeforeUpdatingAnEntity(){
        System.out.println("\n******************** @PREUPDATE *****************");
        System.out.println("Entity is going to be updated\n");
    }

    @PreRemove
    public void printBeforeDeletingUser(){
        System.out.println("\n******************** @PREREMOVE *****************");
        System.out.println("Entity is going to be deleted\n");

    }

    @PostPersist
    public void printAfterUserIsAddedToDataBase(){
        System.out.println("\n******************** @POSTPERSIST *****************");
        System.out.println("Entity has been added to database\n");

    }

    @PostLoad
    public void printAfterUserHasBeenRetrievedFromDataBase(){
        System.out.println("\n******************** @POSTLOAD *****************");
        System.out.println("Entity has been retrieved from database\n");
    }

    @PostUpdate
    public void printAfterUserHasBeenUpdated(){
        System.out.println("\n******************** @POSTUPDATE *****************");
        System.out.println("Entity has been updated\n");
    }

    @PostRemove
    public void printAfterUserHasBeenDeletedFromDataBase(){
        System.out.println("\n******************** @POSTREMOVE *****************");
        System.out.println("Entity has been deleted from database\n");
    }




}
