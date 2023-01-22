package platform.codingnomads.co.springdata.example.dml.transactional.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import platform.codingnomads.co.springdata.example.dml.transactional.models.Point;
import platform.codingnomads.co.springdata.example.dml.transactional.repositories.PointRepo;

import java.io.IOException;
import java.util.List;

@Service
public class PointService{

    @Autowired
    PointRepo repo;

    //@Transactional I

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void doSomeWork() {
        Point p = new Point(1,1);
        repo.save(p);

        p = new Point(2,2);
        repo.save(p);

        /*
            In order to call the foo() method - we must have an existing transaction (MANDATORY)
         */
        foo();
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void foo() {
        repo.getOne(1L);
    }

    //@Transactional II

    @Transactional(timeout = 5)
    public void savePoint() {
        //create new point (1,1)
        Point p = new Point(1,1);

        //save new point
        repo.save(p);
    }

    @Transactional(timeout = 5)
    public void timeOutAfter5() {
        Point p = new Point(2,2);
        repo.save(p);
    }

    @Transactional(timeout = 1)
    public void triggerTimeout() throws InterruptedException {
        Thread.sleep(950);
        Point p = new Point(1,1);
        repo.save(p);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Point getPointById(Long id) {
        return repo.getOne(id);
    }

    @Transactional(readOnly = true)
    public void noExceptionExpected() {
        Point p = repo.getOne(1L);

        p.setX(5);

        repo.save(p);
    }

    @Transactional(rollbackFor = {IOException.class, ArithmeticException.class})
    public void rollbackFor() throws IOException, ArithmeticException {
        Point p = repo.getOne(1L);
        p.setX(100);
        p.setX(100);
        repo.save(p);
        throw new IOException();
        //no change to DB
    }

    @Transactional(noRollbackFor = InterruptedException.class)
    public void noRollbackFor() throws InterruptedException{
        Point p = repo.getOne(2L);
        p.setX(4);
        p.setX(20);
        repo.save(p);
        throw new InterruptedException();
        //changes still commit
    }

    //TASK
    @Transactional(propagation = Propagation.MANDATORY, readOnly = true)

    private boolean checkDuplicate(int x, int y) {
        List<Point> points = repo.findAll();

        for(Point p: points){
            if(p.getX()==x && p.getY()==y){
                return true;
            }
        }
        return false;
    }

    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.SERIALIZABLE)
    public void addNonDuplicate(int x, int y){
        if(!checkDuplicate(x, y)){
            repo.save(new Point(x,y));
            System.out.println("Added new Point");
        }
        else{
            System.out.println("Point with same co-ordinates already exists");
        }
    }

    //Allow two methods to access the same row.
    //Both will read the same row and attempt to double the value of a co-ordinate

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void doubleXCoordinate(){
        Point point = repo.findAll().get(0);
        int x = point.getX();
        point.setX(x*2);
        repo.save(point);
    }
}
