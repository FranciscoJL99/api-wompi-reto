package api.co.wompi.interations;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GuardarToken implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        String acceptanceToken = SerenityRest.lastResponse()
                .jsonPath()
                .getString("data.presigned_acceptance.acceptance_token");

        actor.remember("ACCEPTANCE_TOKEN", acceptanceToken);
    }

    public static GuardarToken deAceptacion() {
        return instrumented(GuardarToken.class);
    }
}