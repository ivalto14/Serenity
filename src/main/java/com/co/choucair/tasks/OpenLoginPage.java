package com.co.choucair.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class OpenLoginPage implements Task {

    private final String url;

    public OpenLoginPage(String url) {
        this.url = url;
    }

    public static OpenLoginPage at(String url) {
        return instrumented(OpenLoginPage.class, url);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }
}