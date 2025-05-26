package com.co.choucair.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;
import com.co.choucair.userinterfaces.CustomerPage;

public class ValidateCustomerErrorMessage implements Question<Boolean> {
    private final String expectedMessage;

    public ValidateCustomerErrorMessage(String expectedMessage) {
        this.expectedMessage = expectedMessage;
    }

    public static ValidateCustomerErrorMessage isVisibleWithText(String expectedMessage) {
        return new ValidateCustomerErrorMessage(expectedMessage);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean isVisible = Visibility.of(CustomerPage.ERROR_MESSAGE).answeredBy(actor).booleanValue();
        String actualMessage = Text.of(CustomerPage.ERROR_MESSAGE).answeredBy(actor).toString();
        return isVisible && actualMessage.contains(expectedMessage);
    }
}
