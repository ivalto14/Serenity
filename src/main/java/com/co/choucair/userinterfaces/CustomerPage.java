package com.co.choucair.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CustomerPage {
    public static final Target BTN_CREATE = Target.the("New Customer button")
            .located(By.xpath("//div[contains(@class, 'tool-button') and contains(@class, 'add-button') and contains(@class, 'icon-tool-button') and @data-action='add']"));
    public static final Target TXT_ID = Target.the("Customer ID input field")
            .located(By.xpath("//input[@id='Serenity_Demo_Northwind_CustomerDialog9_CustomerID']"));
    public static final Target TXT_COMPANY = Target.the("Company name input field")
            .located(By.xpath("//input[@id='Serenity_Demo_Northwind_CustomerDialog9_CompanyName']"));
    public static final Target TXT_CONT_NAME = Target.the("Contact name input field")
            .located(By.xpath("//input[@id='Serenity_Demo_Northwind_CustomerDialog9_ContactName']"));
    public static final Target TXT_CONT_TITLE = Target.the("Contact title input field")
            .located(By.xpath("//input[@id='Serenity_Demo_Northwind_CustomerDialog9_ContactTitle']"));
    public static final Target LABEL_REPRESENTATIVES = Target.the("Representative selection option")
            .located(By.xpath("//input[@id='s2id_autogen10']"));
    public static final Target TXT_ADDRESS = Target.the("Address input field")
            .located(By.xpath("//input[@id='Serenity_Demo_Northwind_CustomerDialog9_Address']"));
    public static final Target LABEL_COUNTRY = Target.the("Country dropdown")
            .located(By.xpath("//input[@id='s2id_autogen11']"));
    public static final Target LABEL_CITY = Target.the("City dropdown")
            .located(By.xpath("//input[@id='s2id_autogen12']"));
    public static final Target TXT_REGION = Target.the("Region input field")
            .located(By.xpath("//input[@id='Serenity_Demo_Northwind_CustomerDialog9_Region']"));
    public static final Target TXT_POSTAL = Target.the("Postal Code input field")
            .located(By.xpath("//input[@id='Serenity_Demo_Northwind_CustomerDialog9_PostalCode']"));
    public static final Target TXT_PHONE = Target.the("Phone input field")
            .located(By.xpath("//input[@id='Serenity_Demo_Northwind_CustomerDialog9_Phone']"));
    public static final Target TXT_FAX = Target.the("Fax input field")
            .located(By.xpath("//input[@id='Serenity_Demo_Northwind_CustomerDialog9_Fax']"));
    public static final Target TXT_LAST_DATE = Target.the("Last Contact Date input field")
            .located(By.xpath("//input[@id='Serenity_Demo_Northwind_CustomerDialog9_LastContactDate']"));
    public static final Target LABEL_LAST = Target.the("Last selection dropdown")
            .located(By.xpath("//input[@id='s2id_autogen13']"));
    public static final Target TXT_EMAIL = Target.the("Email input field")
            .located(By.xpath("//input[@id='Serenity_Demo_Northwind_CustomerDialog9_Email']"));
    public static final Target BTN_SAVE = Target.the("Save button")
            .located(By.xpath("//div[@data-action='save-and-close']"));
    public static final Target CUSTOMER_NAME_LABEL = Target.the("Customer search input")
            .locatedBy("//input[@id='Serenity_Demo_Norhtwind_CustomerGrid0_QuickSearchInput']");
    public static final Target CUSTOMER_LINK = Target.the("Customer link")
            .locatedBy("//div[@class='slick-cell l0 r0']/a[@data-item-id='{0}']");
    public static final Target RESUL_CONT_NAME = Target.the("Resulting customer name field")
            .locatedBy("//input[contains(@id, 'Serenity_Demo_Northwind_CustomerDialog') and @name='ContactName']");
    public static final Target TOOLTIP_MESSAGE = Target.the("Tooltip message field")
            .locatedBy("//div[contains(@class, 'tooltip') and contains(@class, 'show')]//div[@class='tooltip-inner']");
}

