package platform.codingnomads.co.corespring.examples.primaryannotation;

import org.springframework.stereotype.Component;

@Component
public class VLCMediaPlayer implements MediaPLayer {
    private String message;

    public VLCMediaPlayer() {
        this.message = "VLC Media Player";
    }

    @Override
    public void printMessage() {
        System.out.println("I am the: " + message);
    }
}
