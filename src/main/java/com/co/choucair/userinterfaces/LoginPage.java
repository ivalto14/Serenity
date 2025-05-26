package com.co.choucair.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static final Target TXT_USER = Target.the("USER")
            .located(By.xpath("//*[@id='LoginPanel0_Username']\n"));
    public static final Target TXT_PASS = Target.the("PASS")
            .located(By.xpath("//*[@id='LoginPanel0_Password']\n"));
    public static final Target BTN_SUBMIT = Target.the("SUBMIT")
            .located(By.xpath("//*[@id='LoginPanel0_LoginButton']\n"));
    public static final Target ERROR_MESSAGE = Target.the("Invalid login error message")
            .locatedBy("//div[contains(@class, 'toast') and contains(@class, 'toast-error')]//div[@class='toast-message']");
}
