package com.co.choucair.stepdefinitions;

import com.co.choucair.questions.ValidateCustomerErrorMessage;
import com.co.choucair.questions.ValidateText;
import com.co.choucair.tasks.OpenLoginPage;
import com.co.choucair.tasks.Login;
import com.co.choucair.tasks.CreateCustomer;
import com.co.choucair.tasks.SearchCustomer;
import com.co.choucair.userinterfaces.CustomerPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

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
        String representative = data.get(0).get(3);
        String address = data.get(0).get(4);
        String country = data.get(0).get(5);
        String city = data.get(0).get(6);
        String region = data.get(0).get(7);
        String postal = data.get(0).get(8);
        String phone = data.get(0).get(9);
        String fax = data.get(0).get(10);
        String lastDate = data.get(0).get(11);
        String last = data.get(0).get(12);
        String email = data.get(0).get(13);

        theActorInTheSpotlight().attemptsTo(CreateCustomer.withDetails(
                company, containerName, containerTitle, representative, address, country, city, region,
                postal, phone, fax, lastDate, last, email));
    }

    @And("the customer should be created successfully")
    public void theCustomerShouldBeCreatedSuccessfully() {
        String idClient = theActorInTheSpotlight().recall("usuarioID");
        theActorInTheSpotlight().attemptsTo(SearchCustomer.inTheModule(idClient));
        System.out.println("Cliente creado y guardado exitosamente.");
    }

    @Then("the customer's name should be correctly displayed")
    public void validateCustomerName(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        String expectedName = data.get(0).get(0);
        theActorInTheSpotlight().should(seeThat(ValidateText.in(CustomerPage.RESUL_CONT_NAME),
                containsString(expectedName)));
    }

    @And("the user attempts to create a new customer with invalid details")
    public void theUserAttemptsToCreateANewCustomerWithInvalidDetails(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);

        String company = data.get(0).get(0);
        String containerName = data.get(0).get(1);
        String containerTitle = data.get(0).get(2);
        String representative = data.get(0).get(3);
        String address = data.get(0).get(4);
        String country = data.get(0).get(5);
        String city = data.get(0).get(6);
        String region = data.get(0).get(7);
        String postal = data.get(0).get(8);
        String phone = data.get(0).get(9);
        String fax = data.get(0).get(10);
        String lastDate = data.get(0).get(11);
        String last = data.get(0).get(12);
        String email = data.get(0).get(13);

        theActorInTheSpotlight().attemptsTo(CreateCustomer.withDetails(
                company, containerName, containerTitle, representative, address, country, city, region,
                postal, phone, fax, lastDate, last, email));
    }

    @Then("the system should display a customer creation error message")
    public void theSystemShouldDisplayACustomerCreationErrorMessage() {
        String expectedErrorMessage = "Please validate empty or invalid inputs (marked with red) before submitting the form.";

        theActorInTheSpotlight().should(
                seeThat(ValidateCustomerErrorMessage.isVisibleWithText(expectedErrorMessage))
        );
    }
}

