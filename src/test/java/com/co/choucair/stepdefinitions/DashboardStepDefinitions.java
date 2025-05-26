package com.co.choucair.stepdefinitions;

import com.co.choucair.questions.ValidateDashboardNavigation;
import com.co.choucair.tasks.Dashboard;
import com.co.choucair.utils.KillBrowser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.webdriver.SerenityWebdriverManager;

import java.io.IOException;
import java.util.List;

import static com.co.choucair.utils.GlobalData.ACTOR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DashboardStepDefinitions {

    @Before
    public void setup() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(ACTOR);
    }

    @When("the user navigates through the dashboard")
    public void theUserNavigatesThroughTheDashboard() {
        theActorInTheSpotlight().attemptsTo(Dashboard.navigate());
    }

    @Then("the user should see all the dashboard sections")
    public void theUserShouldSeeAllTheDashboardSections() {
        theActorInTheSpotlight().should(
                seeThat(ValidateDashboardNavigation.isSuccessful())
        );
    }

    @After
    public static void closeDriver() throws IOException, InterruptedException {
        if (SerenityWebdriverManager.inThisTestThread().getCurrentDriver() != null) {
            SerenityWebdriverManager.inThisTestThread().getCurrentDriver().quit();
            KillBrowser.processes(List.of((SerenityWebdriverManager.inThisTestThread().getCurrentDriverName()).split(":")).get(0));
        }
    }
}

