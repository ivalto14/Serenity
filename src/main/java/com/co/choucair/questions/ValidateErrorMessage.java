package com.co.choucair.questions;

import com.co.choucair.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;


public class ValidateErrorMessage implements Question<Boolean> {
    private final String expectedMessage;

    public ValidateErrorMessage(String expectedMessage) {
        this.expectedMessage = expectedMessage;
    }

    public static ValidateErrorMessage isVisibleWithText(String expectedMessage) {
        return new ValidateErrorMessage(expectedMessage);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean isVisible = Visibility.of(LoginPage.ERROR_MESSAGE).answeredBy(actor).booleanValue();
        String actualMessage = Text.of(LoginPage.ERROR_MESSAGE).answeredBy(actor).toString();

        return isVisible && actualMessage.contains(expectedMessage);
    }
}

