package platform.codingnomads.co.corespring.examples.autowiredannotation;

import lombok.ToString;
import org.springframework.stereotype.Component;

@Component("samsung")
@ToString
public class Samsung implements Monitor {
}
