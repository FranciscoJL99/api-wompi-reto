package api.co.wompi.stepdefinitions;


import io.cucumber.java.Before;
import net.serenitybdd.model.environment.ConfiguredEnvironment;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class Hooks {
    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        SerenityRest.enableLoggingOfRequestAndResponseIfValidationFails();
        SerenityRest.useRelaxedHTTPSValidation();

        String baseUrl = ConfiguredEnvironment
                .getEnvironmentVariables()
                .getProperty("serenity.rest.base.url");

        OnStage.theActorCalled("QA")
                .can(
                        CallAnApi.at(
                                baseUrl
                        )
                );
    }
}
