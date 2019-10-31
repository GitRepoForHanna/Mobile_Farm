package pages;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.android_driver.DriverUtils;
import utils.wait.Wait;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TextNotePage extends NotePage {

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/edit_note")
    private WebElement bodyInput;

    public TextNotePage() {
        PageFactory.initElements(DriverUtils.getAppiumDriver(), this);
    }

    public void setBody(String body) {
        Wait.waitUntilParticularState(bodyInput::isDisplayed);
        DriverUtils.getActions().sendKeys(bodyInput, body).perform();
//        bodyInput.sendKeys(body);
        Logger.getLogger(TextNotePage.class).info(String.format("Set Body '%s'", body));
    }

    public void pressKey(Keys key) {
//        DriverUtils.getActions().sendKeys(bodyInput, key).perform();
    }

    public List<String> getBody() {
        Wait.waitUntilParticularState(bodyInput::isDisplayed);
        String bodyContent = bodyInput.getText();
        return StringUtils.isNotBlank(bodyContent) ? Arrays.asList(bodyContent) : Collections.EMPTY_LIST;
    }
}
