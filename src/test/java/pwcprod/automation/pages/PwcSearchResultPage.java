package pwcprod.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.IntStream;

public class PwcSearchResultPage extends AbstractPage {

    private static final String RESULTS_TITLE_SELECTOR = "h2 a";

    @FindBy(css = RESULTS_TITLE_SELECTOR)
    private List<WebElement> results;

    public PwcSearchResultPage(WebDriver driver) {
        super(driver);
    }
    
    public boolean pageTitleContains(String phrase) {
        try {
            return driverWait(5).until(ExpectedConditions.titleContains(phrase));
        } catch (TimeoutException ex) {
            return false;
        }
    }

    boolean isInResults(String expectedTitle, int nbOfResultsToSearch) {
        wait.forPresenceOfElements(5, By.cssSelector(RESULTS_TITLE_SELECTOR), "Result title");
        return IntStream.range(0, Math.min(this.results.size(), nbOfResultsToSearch))
                .anyMatch(index -> this.results.get(index).getText().contains(expectedTitle));
    }

}
