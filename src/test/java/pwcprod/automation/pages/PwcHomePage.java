package pwcprod.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PwcHomePage extends AbstractPage {

    private static final String PAGE_HOME_URL = "https://www.digitalpulse.pwc.com.au";
    private static final By BY_SEARCH_FIELD = By.id("search-input");
    private static final By BY_SEARCH_ICON = By.className("bt-search");
    private static final By BY_NAV_BAR = By.className("bt-bars");
    private static final By BY_CAROUSEL_CARD = By.className("card");
    private static final By BY_CAROUSEL_CARD_CONTENT = By.cssSelector("div.card div h2");
    private static final By BY_CAROUSEL_NEXT = By.className("flex-next");
    private static final By BY_CAROUSEL_PRE = By.className("flex-prev");
    

    public PwcHomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
        getDriver().navigate().to(PAGE_HOME_URL);
    }

    public void clickOnIconToSearch() {
        WebElement searchIcon = driverWait(10).until(ExpectedConditions.elementToBeClickable(BY_SEARCH_ICON));
        searchIcon.click();
    }

    public void clickOnNavBar() {
        WebElement navBar = driverWait(10).until(ExpectedConditions.elementToBeClickable(BY_NAV_BAR));
        navBar.click();
    }

    public void clickOnCarouselNextButton() {
        WebElement nextButton = driverWait(10).until(ExpectedConditions.elementToBeClickable(BY_CAROUSEL_NEXT));
        nextButton.click();
    }

    public void clickOnCarouselPreButton() {
        WebElement preButton = driverWait(10).until(ExpectedConditions.elementToBeClickable(BY_CAROUSEL_PRE));
        preButton.click();
    }

    public void selectFromNavBarMenu(String phrase){
        Select menu = new Select(driver.findElement(BY_NAV_BAR));
        menu.selectByVisibleText(phrase);
    }

    public void enterSearchPhrase(String phrase) {
        WebElement searchField = driverWait(10).until(ExpectedConditions.elementToBeClickable(BY_SEARCH_FIELD));
        searchField.sendKeys(phrase);
        searchField.submit();
    }

    public boolean pageTitleContains(String phrase) {
        try {
            return driverWait(5).until(ExpectedConditions.titleContains(phrase));
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public boolean checkItemNumOfCarousel(int expectedSize) { 
        List<WebElement> allItems = select.findElements(BY_CAROUSEL_CARD_CONTENT);
        if (expectedSize != allItems.size()) {
           System.out.println("fail, wrong number of items found");
           return false;
        }
        else{
            return true;
        }
    } 
}
