package com.co.choucair.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/serenityLogin.feature",
glue = "com.co.choucair.stepdefinitions",
snippets = CucumberOptions.SnippetType.CAMELCASE)

public class OpenLoginRunner {

}
