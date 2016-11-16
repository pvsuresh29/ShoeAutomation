package common;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

/**
 * Created by Suresh Venkata on 11/10/16.
 */
public class ScenarioData {

    private String sessionId;

    public ScenarioData() {
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(WebDriver driver) {
        Cookie cookie  = driver.manage().getCookieNamed(Constants.SESSION_COOKIE_NAME);
        this.sessionId = cookie.getValue();
    }
}