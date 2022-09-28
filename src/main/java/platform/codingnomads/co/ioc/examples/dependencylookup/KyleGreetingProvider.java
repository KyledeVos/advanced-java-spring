package platform.codingnomads.co.ioc.examples.dependencylookup;

public class KyleGreetingProvider implements GreetingProvider{

    @Override
    public String getGreeting() {
        return "Hello from Kyle!";
    }
}
