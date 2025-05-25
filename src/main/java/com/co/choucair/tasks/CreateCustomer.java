package com.co.choucair.tasks;

import com.co.choucair.interactions.PressArrowDownKey;
import com.co.choucair.interactions.PressEnterKey;
import com.co.choucair.userinterfaces.CustomerPage;
import com.co.choucair.userinterfaces.DashboardPage;
import com.co.choucair.utils.IdGenerator;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

import static com.co.choucair.userinterfaces.CustomerPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateCustomer implements Task {

    private String id;
    private String company;
    private String containerName;
    private String containerTitle;
    private String representative;
    private String address;
    private String country;
    private String city;
    private String region;
    private String postal;
    private String phone;
    private String fax;
    private String lastDate;
    private String last;
    private String email;

    public CreateCustomer(String company, String containerName, String containerTitle, String representative,
                          String address,String country, String city, String region, String postal, String phone,
                          String fax, String lastDate,String last, String email) {
        this.id = "";
        this.company = company;
        this.containerName = containerName;
        this.containerTitle = containerTitle;
        this.representative = representative;
        this.address = address;
        this.country = country;
        this.city = city;
        this.region = region;
        this.postal = postal;
        this.phone = phone;
        this.fax = fax;
        this.lastDate = lastDate;
        this.last = last;
        this.email = email;
    }

    public static CreateCustomer withDetails(String company, String containerName, String containerTitle, String representative,
                                             String address, String country, String city, String region, String postal, String phone,
                                             String fax, String lastDate,String last, String email) {
        return instrumented(CreateCustomer.class, company, containerName, containerTitle, representative, address, country, city, region,
                postal, phone, fax, lastDate,last, email);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        id = IdGenerator.generateId();
        actor.remember("usuarioID", id);
        String idRecuperado = actor.recall("usuarioID");
        System.out.println("---> id" + idRecuperado);
        actor.attemptsTo(

                WaitUntil.the(DashboardPage.HOME, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(DashboardPage.HOME),
                Click.on(DashboardPage.BTN_NORTHWIND),
                WaitUntil.the(DashboardPage.BTN_CLIENTS, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(DashboardPage.BTN_CLIENTS),
                WaitUntil.the(DashboardPage.TXT_CLIENTS, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(CustomerPage.BTN_CREATE),
                WaitUntil.the(CustomerPage.TXT_ID, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                PressEnterKey.pressEnter(),
                Enter.theValue(id).into(CustomerPage.TXT_ID),
                Enter.theValue(company).into(TXT_COMPANY),
                Enter.theValue(containerName).into(TXT_CONT_NAME),
                Enter.theValue(containerTitle).into(TXT_CONT_TITLE),
                Enter.theValue(representative).into(LABEL_REPRESENTATIVES),
                PressEnterKey.pressEnter(),
                Enter.theValue(address).into(CustomerPage.TXT_ADDRESS),
                Enter.theValue(country).into(LABEL_COUNTRY),
                PressArrowDownKey.pressArrowDown(),
                PressEnterKey.pressEnter(),
                Enter.theValue(city).into(LABEL_CITY),
                PressArrowDownKey.pressArrowDown(),
                PressEnterKey.pressEnter(),
                Enter.theValue(region).into(CustomerPage.TXT_REGION),
                Enter.theValue(postal).into(CustomerPage.TXT_POSTAL),
                Enter.theValue(phone).into(CustomerPage.TXT_PHONE),
                Enter.theValue(fax).into(CustomerPage.TXT_FAX),
                Enter.theValue(lastDate).into(CustomerPage.TXT_LAST_DATE),
                Enter.theValue(last).into(LABEL_LAST),
                PressEnterKey.pressEnter(),
                Enter.theValue(email).into(CustomerPage.TXT_EMAIL),
                Click.on(CustomerPage.BTN_SAVE)
        );
    }
}