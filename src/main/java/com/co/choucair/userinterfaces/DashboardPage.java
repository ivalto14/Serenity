package com.co.choucair.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DashboardPage {
    public static final Target HOME = Target.the("HOME")
            .located(By.xpath("//a[@class='s-sidebar-band-link' and @href='#s_sidebar_group1' and @title='StartSharp']"));
    public static final Target ADMINISTRATION = Target.the("ADMINISTRATION")
            .located(By.xpath("//a[@class='s-sidebar-band-link' and @href='#s_sidebar_group2' and @title='Administration']"));
    public static final Target BTN_BOARD = Target.the("Tablero button")
            .located(By.xpath("//span[text()='Dashboard']"));
    public static final Target BTN_NORTHWIND = Target.the("Northwind button")
            .located(By.xpath("//span[text()='Northwind']"));
    public static final Target TXT_ADMINISTRATION = Target.the("Administration section title")
            .located(By.xpath("//h5[@class='s-sidebar-group-title' and text()='Administration']"));
    public static final Target TXT_CLIENTS = Target.the("Clients section title")
            .located(By.xpath("//div[@class='title-text' and text()='Customers']"));
    public static final Target BTN_CLIENTS = Target.the("Clients button")
            .located(By.xpath("//span[@class='s-sidebar-link-text' and text()='Customers']"));
    public static final Target CARD_ORDERS = Target.the("Orders card title")
            .located(By.xpath("//h3[@class='card-title' and text()='Orders']"));
    public static final Target SEARCH_CUSTOMER = Target.the("Customer search input")
            .locatedBy("//input[@id='Serenity_Demo_Norhtwind_CustomerGrid0_QuickSearchInput']");
    public static final Target LANGUAGE = Target.the("Language switcher")
            .located(By.xpath("//a[@class='s-sidebar-band-link s-language-selection-link' and @data-bs-toggle='dropdown']"));
    public static final Target SWITCH_THEME = Target.the("Theme switcher")
            .located(By.xpath("//a[@class='s-sidebar-band-link s-theme-selection-link' and @data-bs-toggle='dropdown']"));
    public static final Target ADMIN = Target.the("Admin profile dropdown")
            .located(By.xpath("//a[contains(@class, 's-sidebar-band-link') and contains(@class, 's-user-profile-link') and @data-bs-toggle='dropdown']"));
    public static final Target LANGUAGE_UNO = Target.the("English language selector")
            .located(By.xpath("//a[@class='dropdown-item' and @data-language='en']"));
    public static final Target COSMOS = Target.the("Cosmos dark theme selector")
            .located(By.xpath("//a[@class='dropdown-item' and @data-theme='cosmos-dark']"));
    public static final Target LOGOUT = Target.the("Logout button")
            .located(By.xpath("//a[@class='dropdown-item' and @href='/Account/Signout']"));

}
