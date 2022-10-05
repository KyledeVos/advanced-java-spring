package platform.codingnomads.co.corespring.examples.annotations.whatandwhy;

import java.lang.reflect.Method;

public class AnnotationParsingDemo {
    public static void main(String[] args) {
        try {
            Class<AnnotationDemoService> annotationDemoService = AnnotationDemoService.class;
            for (Method method : annotationDemoService.getMethods()) {
                if (method.isAnnotationPresent(ModernInfo.class)) {
                    ModernInfo modernInfo = method.getAnnotation(ModernInfo.class);
                    System.out.println("Info Received: " + modernInfo.info());
                }
                if(method.isAnnotationPresent(ModernString.class)){
                    ModernString modernString = method.getAnnotation(ModernString.class);
                    System.out.println("Info Received: " + modernString.data());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
