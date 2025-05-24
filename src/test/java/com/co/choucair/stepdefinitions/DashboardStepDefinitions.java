package com.co.choucair.stepdefinitions;

import com.co.choucair.tasks.Dashboard;
import com.co.choucair.utils.KillBrowser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.webdriver.SerenityWebdriverManager;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import com.co.choucair.userinterfaces.DashboardPage;

import java.io.IOException;
import java.util.List;

import static com.co.choucair.utils.GlobalData.ACTOR;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DashboardStepDefinitions {

    @When("the user navigates through the dashboard")
    public void theUserNavigatesThroughTheDashboard() {
        theActorInTheSpotlight().attemptsTo(Dashboard.navigate());
    }

    @Then("the user should see the Administration section")
    public void theUserShouldSeeTheAdministrationSection() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(DashboardPage.TXT_ADMINISTRATION, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds()
        );
    }
}

