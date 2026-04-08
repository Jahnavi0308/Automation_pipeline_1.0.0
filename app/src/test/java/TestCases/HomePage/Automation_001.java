package TestCases.HomePage;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

import PageObjects.Homepage;
import TestCases.BaseTest;
import Utilities.ThreadLocalManager;
import Utilities.readini;
import Utilities.Config;

@Test(groups = {"Regression", "HomePage"} ,testName = "User Registration Test")
public class Automation_001 extends BaseTest {
    Homepage homepage;
    Map<String, Object> configMap;
    readini config = new readini();

    @Description("Test Case 1: User Registration")
    @Test
    public void parseIniFile() {
        String iniPath = System.getProperty("user.dir") + "/src/test/resources/Automation_001.ini";
        configMap = config.readini(iniPath);
        homepage = new Homepage(ThreadLocalManager.getDriver());
    }

    @Test(dependsOnMethods = "parseIniFile")
    public void LoginPageNavigation() {
        Allure.step("Click on Login link");
        homepage.clickLoginLink();
    }

    @Test(dependsOnMethods = "LoginPageNavigation")
    public void UserSignUp() {
         Allure.step("Sign up page navigation and user details entry");
        homepage.enterName((String)Config.resolveVars("#name", configMap));
        System.out.println("Name: " + (String)Config.resolveVars("#name", configMap));
        homepage.enterEmail((String) Config.resolveVars("#email", configMap));
        homepage.clickSignupButton();
    }

    @Test(dependsOnMethods = "UserSignUp")
    public void AccountInformation() {

        Allure.step("Entering account information");
        
        String gender = (String) Config.resolveVars("#gender", configMap);
        if(gender.equalsIgnoreCase("Mr")) {
            homepage.selectGenderMale();
        }
        if(gender.equalsIgnoreCase("Mrs")){
            homepage.selectGenderFemale();
        }

        homepage.enterUserPassword((String) Config.resolveVars("#password",configMap));
        
        String days = (String) Config.resolveVars("#days", configMap);
        String months = (String) Config.resolveVars("#months", configMap);
        String years = (String) Config.resolveVars("#years", configMap);
        homepage.enterDateOfBirth(days, months, years);

        homepage.enterFirstName((String) Config.resolveVars("#firstname", configMap));
        homepage.enterLastName((String) Config.resolveVars("#lastname", configMap));
        homepage.enterCompany((String) Config.resolveVars("#company", configMap));
        homepage.enterAddress1((String) Config.resolveVars("#address1", configMap));
        homepage.enterAddress2((String) Config.resolveVars("#address2", configMap));
        homepage.enterCountry((String) Config.resolveVars("#country", configMap));
        homepage.enterCity((String) Config.resolveVars("#city", configMap));
        homepage.enterState((String) Config.resolveVars("#state", configMap));
        homepage.enterZipcode((String) Config.resolveVars("#zipcode", configMap));
        homepage.enterMobilePhone((String) Config.resolveVars("#mobilephone", configMap));

        homepage.clickCreateAccountButton();

        Assert.assertTrue(
                ThreadLocalManager.getDriver().getPageSource().contains("Account Created!"),
                "Account creation failed"
);

    }
}

