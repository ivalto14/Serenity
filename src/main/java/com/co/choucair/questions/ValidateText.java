package com.co.choucair.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Value;
import net.serenitybdd.screenplay.targets.Target;

public class ValidateText implements Question<String> {
    private final Target target;

    public ValidateText(Target target) {
        this.target = target;
    }

    public static ValidateText in(Target target) {
        return new ValidateText(target);
    }

    @Subject("the text displayed in {target}")
    @Override
    public String answeredBy(Actor actor) {
        return Value.of(target).answeredBy(actor);
    }
}

