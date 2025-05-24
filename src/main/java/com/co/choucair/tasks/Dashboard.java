package com.co.choucair.tasks;

import com.co.choucair.userinterfaces.DashboardPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Dashboard implements Task {

    public static Dashboard navigate() {
        return instrumented(Dashboard.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                WaitUntil.the(DashboardPage.HOME, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(DashboardPage.HOME),
                Click.on(DashboardPage.BTN_BOARD),
                WaitUntil.the(DashboardPage.CARD_ORDERS, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(DashboardPage.HOME),
                Click.on(DashboardPage.BTN_NORTHWIND),
                WaitUntil.the(DashboardPage.BTN_CLIENTS, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(DashboardPage.BTN_CLIENTS),
                WaitUntil.the(DashboardPage.TXT_CLIENTS, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(DashboardPage.ADMINISTRATION),
                WaitUntil.the(DashboardPage.TXT_ADMINISTRATION, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds()
        );
    }
}
