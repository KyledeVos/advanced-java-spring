package platform.codingnomads.co.corespring.examples.dependsonannotation;

import org.springframework.beans.factory.annotation.Autowired;

public class SpellCheck {

    @Autowired
    private JDK jdk;

    public SpellCheck(){
        System.out.println("Spell Checker is ready.");
    }


}
