package com.co.choucair.stepdefinitions;

import com.co.choucair.tasks.OpenLoginPage;
import com.co.choucair.tasks.Login;
import com.co.choucair.utils.KillBrowser;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.webdriver.SerenityWebdriverManager;

import java.io.IOException;
import java.util.List;

import static com.co.choucair.utils.GlobalData.ACTOR;
import static com.co.choucair.utils.GlobalData.URL;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SerenityLoginStepDefinitions {

    @Before
    public void setup() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(ACTOR); // Se asegura que haya un actor inicializado
    }

    @Given("the user opens the login page")
    public void theUserOpensTheLoginPage() {
        theActorInTheSpotlight().attemptsTo(OpenLoginPage.at(URL));
    }

    @When("the user attempts to log in with credentials")
    public void theUserAttemptsToLogIn(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        String username = data.get(0).get(0);
        String password = data.get(0).get(1);

        theActorInTheSpotlight().attemptsTo(
                Login.withCredentials(username, password));
    }

    @After
    public static void CloseDriver() throws IOException, InterruptedException {
        if (SerenityWebdriverManager.inThisTestThread().getCurrentDriver() != null) {
            SerenityWebdriverManager.inThisTestThread().getCurrentDriver().quit();
            KillBrowser.processes(List.of((SerenityWebdriverManager.inThisTestThread().getCurrentDriverName()).split(":")).get(0));
        }
    }
}




