package api.co.wompi.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidarError implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        String errorType = SerenityRest.lastResponse()
                .jsonPath()
                .getString("error.type");

        return errorType != null && errorType.equalsIgnoreCase("INPUT_VALIDATION_ERROR");
    }

    public static ValidarError montos() {
        return new ValidarError();
    }
}