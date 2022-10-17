package platform.codingnomads.co.corespring.examples.primaryannotation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class WindowsMediaPlayer implements MediaPLayer{

    private String message;

    public WindowsMediaPlayer() {
        this.message = "Windows Media Player";
    }

    @Override
    public void printMessage() {
        System.out.println("I am the: " + message);
    }
}
