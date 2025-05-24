package com.co.choucair.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.interactions.Actions;

public class PressEnterKey implements Interaction {
    @Override
    @Step("{0} press enter key")
    public <T extends Actor> void performAs(T actor) {
        Actions actions = new Actions(BrowseTheWeb.as(actor).getDriver());
        actions.sendKeys(org.openqa.selenium.Keys.ENTER).perform();
    }    public static PressEnterKey pressEnter() {
        return new PressEnterKey();
    }
}