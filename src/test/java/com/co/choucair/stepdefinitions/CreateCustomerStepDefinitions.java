package com.co.choucair.stepdefinitions;

import com.co.choucair.questions.ValidateText;
import com.co.choucair.tasks.CreateCustomer;
import com.co.choucair.tasks.SearchCustomer;
import com.co.choucair.userinterfaces.CustomerPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.co.choucair.userinterfaces.CustomerPage.RESUL_CONT_NAME;
import static com.co.choucair.userinterfaces.DashboardPage.TXT_CLIENTS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.containsString;

public class CreateCustomerStepDefinitions {

    @And("the user creates a new customer with details")
    public void theUserCreatesANewCustomerWithDetails(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);

        String company = data.get(0).get(0);
        String containerName = data.get(0).get(1);
        String containerTitle = data.get(0).get(2);
        String address = data.get(0).get(3);
        String region = data.get(0).get(4);
        String postal = data.get(0).get(5);
        String phone = data.get(0).get(6);
        String fax = data.get(0).get(7);
        String lastDate = data.get(0).get(8);
        String email = data.get(0).get(9);

        // Ejecutar la tarea para crear el cliente
        theActorInTheSpotlight().attemptsTo(CreateCustomer.withDetails(
                company, containerName, containerTitle, address, region,
                postal, phone, fax, lastDate, email));
    }

    @And("the customer should be created successfully")
    public void theCustomerShouldBeCreatedSuccessfully() {
        String idClient = theActorInTheSpotlight().recall("usuarioID");
        theActorInTheSpotlight().attemptsTo(
                SearchCustomer.inTheModule(idClient)
        );

        System.out.println("Cliente creado y guardado exitosamente.");
    }

    @Then("the customer's name should be correctly displayed")
    public void validateCustomerName() {
        String expectedName = "Jane Smith"; // Nombre esperado

        theActorInTheSpotlight().should(
                seeThat(ValidateText.in(CustomerPage.RESUL_CONT_NAME), containsString(expectedName))
        );
    }

}



