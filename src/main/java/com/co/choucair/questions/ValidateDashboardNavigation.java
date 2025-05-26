package com.co.choucair.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import com.co.choucair.userinterfaces.DashboardPage;

public class ValidateDashboardNavigation implements Question<Boolean> {

    public static ValidateDashboardNavigation isSuccessful() {
        return new ValidateDashboardNavigation();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean isHomeVisible = Visibility.of(DashboardPage.HOME).answeredBy(actor).booleanValue();
        boolean isAdminVisible = Visibility.of(DashboardPage.TXT_ADMINISTRATION).answeredBy(actor).booleanValue();
        boolean isLangVisible = Visibility.of(DashboardPage.LANGUAGE).answeredBy(actor).booleanValue();
        boolean isThemeVisible = Visibility.of(DashboardPage.SWITCH_THEME).answeredBy(actor).booleanValue();
        boolean isProfileVisible = Visibility.of(DashboardPage.ADMIN).answeredBy(actor).booleanValue();

        // Depuración: Imprimir mensajes si algún elemento no está visible
        if (!isHomeVisible) System.out.println("❌ HOME no está visible");
        if (!isAdminVisible) System.out.println("❌ ADMINISTRATION no está visible");
        if (!isLangVisible) System.out.println("❌ LANGUAGE no está visible");
        if (!isThemeVisible) System.out.println("❌ SWITCH_THEME no está visible");
        if (!isProfileVisible) System.out.println("❌ ADMIN no está visible");

        return isHomeVisible && isAdminVisible && isLangVisible && isThemeVisible && isProfileVisible;
    }
}
