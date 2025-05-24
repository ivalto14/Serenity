package com.co.choucair.tasks;

import com.co.choucair.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {

    private final String username;
    private final String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Login withCredentials(String username, String password) {
        return instrumented(Login.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // 1. Validar que el campo de usuario sea visible antes de interactuar con él
        actor.attemptsTo(
                WaitUntil.the(LoginPage.TXT_USER, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(LoginPage.TXT_USER),
                Enter.theValue(username).into(LoginPage.TXT_USER),
                Click.on(LoginPage.TXT_PASS),
                Enter.theValue(password).into(LoginPage.TXT_PASS),
                Click.on(LoginPage.BTN_SUBMIT)
        );
    }
}


