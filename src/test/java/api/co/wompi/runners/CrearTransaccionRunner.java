package api.co.wompi.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/crear_transaccion.feature",
        glue = {"api.co.wompi.stepdefinitions"},
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class CrearTransaccionRunner {
}
