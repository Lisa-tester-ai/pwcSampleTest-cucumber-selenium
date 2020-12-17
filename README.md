Automation with BDD Testing  
===========================  

 _BDD Automation Tests using Cucumber, Selenium, Java_         
 
# Test Chanllenge Of PWC  

## Setup your DEV env      

1. Make sure you have installed [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/index-jsp-138363.html) _version 8_, [Maven](https://maven.apache.org/index.html) _version 3.3.1 or higher_.      

2. Clone this repo and verify compile  

    ```
    mvn clean compile  
    ```

3. Run all tests

    ```
    mvn clean test -DisLocal=true -DisHeadless=false
    ```  
    to see test results are generated, just open this `pwcProd-cucumber-selenium/target/cucumber/index.html` in your browser  
      
    _optional params:_    
    - when running inside Jenkins environment, you must append `-DGITHUB_TOKEN=...public_access_token...`  
    - if you want to forcefully use custom webdrivers (e.g. specific versions), then just append:     
    `-Dwebdriver.gecko.driver=wdm_local/geckodriver -Dwebdriver.chrome.driver=wdm_local/chromedriver`  

4. Run inside Intellij IDEA    
    Import as standard Maven project.    
    Then, set 'Cucumber java' defaults of this project as:    
    - Main class: `cucumber.api.cli.Main`       
    - Glue: `pwcProd.automation.stepdefs`      
    - feature folder path: _point to folder where feature files are_  
    - VM options: (copy the same ones from mvn example )   

5. Framework Architecture

    Project-Name
	|_src/test/java/pwcprod/automation
	|	|_pages
	|	|	|_AbstractPage.java
	|	|	|_PwcContactUsPage.java
	|	|	|_PwcHomePage.java
	|	|	|_PwcSearchResultPage.java
	|	|_stepdefs
	|	|	|_PwcSample.java
	|_src/test/resources/pwcprod/automation
	|	|_PwcSampleTest.feature
	|_wdm_local
	|	|_chromedriver_linux
	|	|_chromedriver_mac
	|	|_chromedriver-v240_linux64.zip
 	|	|_chromedriver-v240_mac64.zip
    |	|_chromedriver-v240_win32.zip
	|	|_chromedriver.exe
 	|	|_geckodriver_linux
    |	|_geckodriver_mac
	|	|_geckodriver-v0.20.1_linux64.zip
 	|	|_chromedriver-v0.20.1_macos.tar.gz
    |	|_chromedriver-v0.20.1_win64.zip
    |	|_chromedriver.exe
    

  
  
