package pwcprod.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class PwcContactUsPage extends AbstractPage {

    private static final String PAGE_ContactUs_URL = "https://www.digitalpulse.pwc.com.au/contact-us/";
    private static final By BY_CONTACT_CONTENT = By.cssSelector(".span_3 p")
    

    public PwcContactUsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isContactUsPage() {
        String URL = getDriver().getCurrentUrl();
        Assert.assertEquals(URL, PAGE_ContactUs_URL);
    }

    public boolean pageTitleContains(String phrase) {
        try {
            return driverWait(5).until(ExpectedConditions.titleContains(phrase));
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public boolean checkListOfContact() {
        String[] expected = {
            "Wherever you are in the world, find your local PwC Digital Services office.", 
            "Email us via the form below.", 
            "Learn more about working with us.", 
            "Get in touch with PwC."};

        List<WebElement> allContacts = select.findElements(BY_CONTACT_CONTENT);
        if (expected.length != allContacts.size()) {
           System.out.println("fail, wrong number of contacts found");
           return false;
        }

        // make sure that the value of every <p> element equals the expected text
        for (int i = 0; i < expected.length; i++) {
            String contentValue = allContacts.get(i).getText();
            if (contentValue.equals(expected[i])) {
                System.out.println("passed on: " + contentValue);
                return true;
            } else  {
                System.out.println("failed on: " + contentValue);
                return false;
            }
        }
    } 
}
