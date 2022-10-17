package platform.codingnomads.co.corespring.examples.scopeannotaion;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ScopeAnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ScopeAnnotationDemoConfig.class);
        ctx.refresh();
        SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);

        System.out.println("-----Hashcode of SingletonBean-----");
        System.out.println(singletonBean1.hashCode());
        System.out.println(singletonBean2.hashCode());

        final PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
        final PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);

        System.out.println("-----Hashcode of PrototypeBean-----");
        System.out.println(prototypeBean1.hashCode());
        System.out.println(prototypeBean2.hashCode());
        System.out.println();

        SingletonJoke singletonJoke1 = ctx.getBean(SingletonJoke.class);
        SingletonJoke singletonJoke2 = ctx.getBean(SingletonJoke.class);

        System.out.println("\nTask");
        System.out.println("-----Hashcode of SingletonJokes-----");
        System.out.println(singletonJoke1.hashCode());
        System.out.println(singletonJoke2.hashCode());


        PrototypeJoke prototypeJoke1 = ctx.getBean(PrototypeJoke.class);
        PrototypeJoke prototypeJoke2 = ctx.getBean(PrototypeJoke.class);

        System.out.println("-----Hashcode of Prototype Jokes-----");
        System.out.println(prototypeJoke1.hashCode());
        System.out.println(prototypeJoke2.hashCode());

        ctx.close();
    }
}
