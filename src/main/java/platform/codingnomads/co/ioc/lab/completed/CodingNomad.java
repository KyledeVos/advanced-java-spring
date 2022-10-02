package platform.codingnomads.co.ioc.lab.completed;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
@RequiredArgsConstructor
public class CodingNomad {
    // automatically injected due to being private final
    private final JDK jdk;
    // automatically injected due to being private final
    private final IDE ide;
    // automatically injected due to being private final
    private final Framework framework;

    //Lab - Field Injection

    private final Whiteboard whiteboard;

    private Joplin joplin;

    //Lab - Setter Injection
    @Autowired
    public void setJoplin(Joplin joplin){
        this.joplin = joplin;
    }

    public String createAwesomeSoftware() {
        return MessageFormat
                .format("This coding nomad is creating awesome software using, " +
                                "IDE: ({0}:{1}), JDK: ({2}:{3}), Framework: ({4}:{5}), Whiteboard Size: ({6})" +
                                " that is clean: ({7}), using ({8}:{9}) in Notebook: ({10}) ",
                        ide.getName(),
                        ide.getVersion(),
                        jdk.getName(),
                        jdk.getVersion(),
                        framework.getName(),
                        framework.getVersion(),
                        whiteboard.getSize(),
                        whiteboard.isClean(),
                        joplin.getName(),
                        joplin.getVersion(),
                        joplin.getNotebook()
                );
    }
}
