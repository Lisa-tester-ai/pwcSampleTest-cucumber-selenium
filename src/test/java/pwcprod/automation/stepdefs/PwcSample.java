package pwcprod.automation.stepdefs;

import pwcprod.automation.SharedContext;
import pwcprod.automation.pages.PwcContactUsPage;
import pwcprod.automation.pages.PwcHomePage;
import pwcprod.automation.pages.PwcSearchResultPage;
import cucumber.api.Scenario;
import cucumber.api.java8.En;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class PwcSample implements En {
    private WebDriver driver;
    private PwcHomePage homePage;
    private PwcSearchResultPage searchResultPage;
    private PwcContactUsPage contactUsPage;

    private SharedContext sharedContext;

    // Warning: Make sure the timeouts for hooks using a web driver are zero
    public PwcSample(SharedContext sharedContext) {
        this.sharedContext = sharedContext;

        Before(new String[]{"@web"}, 0, 1, (Scenario scenario) -> {
            this.sharedContext.setUp();
        });
        Before(new String[]{"@web", "@chrome"}, 0, 1, (Scenario scenario) -> {
            driver = this.sharedContext.getDriver("chrome");
        });
        Before(new String[]{"@web", "@firefox"}, 0, 1, (Scenario scenario) -> {
            driver = this.sharedContext.getDriver("firefox");
        });
        Before(new String[]{"@pwc"}, 0, 10, (Scenario scenario) -> {
            homePage = new PwcHomePage(driver);
            searchResultPage = new PwcSearchResultPage(driver);
            contactUsPage = new PwcContactUsPage(driver);
        });   
        Given("^a web browser is on the PWC Digital Pulse page$", () -> {
            homePage.navigateToHomePage();
        });
        When("^the search phrase \"([^\"]*)\" is entered$", (String phrase) -> {
            homePage.enterSearchPhrase(phrase);
        });
        When("^I click on top icon to perform a search$", () -> {
            homePage.clickOnIconToSearch();
        });
        When("^I click on nav bar$", () -> {
            homePage.clickOnNavBar();
        });    
        When("^I select \"([^\"]*)\" from nav bar menu$", (String phrase) -> {
            homePage.selectFromNavBarMenu(phrase);
        }); 
        When("^I click the next button on the carousel$", () -> {
            homePage.clickOnCarouselNextButton();
        });   
        When("^I click the Previous button on the carousel$", () -> {
            homePage.clickOnCarouselPreButton();
        });  
        Then("^results for \"([^\"]*)\" are shown$", (String phrase) -> {
            assertThat(searchResultPage.pageTitleContains(phrase)).isTrue();
        });
        Then("^I am taken to the Contact Us page$", () -> {
            assertThat(contactUsPage.isContactUsPage()).isTrue();
        });
        Then("^all contacts details are displayed$", () -> {
            assertThat(contactUsPage.checkListOfContact()).isTrue();
        });
        Then("^carousel will load (\\d+) featured articles$", (String num) -> {
            homePage.checkItemNumOfCarousel(Integer.parseInt(num));
        });
        Then("^\"([^\"]*)\" is displayed in the first (\\d+) results$", (String phrase, String num) -> {
            assertThat(searchResultPage.isInResults(phrase, Integer.parseInt(num))).isTrue();
        });
        After(new String[]{"@web"}, (Scenario scenario) -> {
            this.sharedContext.tearDown();
        });
    }
}
