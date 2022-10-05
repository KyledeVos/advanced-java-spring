package platform.codingnomads.co.corespring.examples.springbeanlifecycle;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class PrintFunkyMessage implements BeanNameAware {

    @Override
    public void setBeanName(String name) {
        System.out.println("Sometimes when I close my eyes... I can't see. Joke from Bean: " + name);
    }
}
