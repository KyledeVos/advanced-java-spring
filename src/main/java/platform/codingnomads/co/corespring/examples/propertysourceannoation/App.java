package platform.codingnomads.co.corespring.examples.propertysourceannoation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class App {
    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @Value("${app.releaseDate}")
    private String appReleaseDate;

    public String getAppName() {
        return appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public String getAppReleaseDate() {
        return appReleaseDate;
    }
}
