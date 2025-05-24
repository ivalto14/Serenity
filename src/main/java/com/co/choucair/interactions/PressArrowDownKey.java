package com.co.choucair.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.interactions.Actions;

public class PressArrowDownKey implements Interaction {
    @Override
    @Step("{0} press the arrow down key")
    public <T extends Actor> void performAs(T actor) {
        Actions actions = new Actions(BrowseTheWeb.as(actor).getDriver());
        actions.sendKeys(org.openqa.selenium.Keys.ARROW_DOWN).perform();
    }
    public static PressArrowDownKey pressArrowDown() {
        return new PressArrowDownKey();
    }
}
