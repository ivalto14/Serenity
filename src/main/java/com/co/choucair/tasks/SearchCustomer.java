package com.co.choucair.tasks;

import com.co.choucair.interactions.PressEnterKey;
import com.co.choucair.userinterfaces.CustomerPage;
import com.co.choucair.userinterfaces.DashboardPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.co.choucair.userinterfaces.DashboardPage.SEARCH_CUSTOMER;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchCustomer implements Task {

    private final String id;

    public SearchCustomer(String id) {

        this.id = id;
    }

    public static SearchCustomer inTheModule(String id){
        return instrumented(SearchCustomer.class,id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                WaitUntil.the(DashboardPage.TXT_CLIENTS, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds(),
                Enter.theValue(id).into(SEARCH_CUSTOMER),
                PressEnterKey.pressEnter(),
                Click.on(CustomerPage.CUSTOMER_LINK.of(id))
        );
    }
}
