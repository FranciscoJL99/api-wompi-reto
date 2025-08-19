package api.co.wompi.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class EstadoTransaccion implements Question<Boolean> {

    private final String[] expected;

    public EstadoTransaccion(String... expected) {
        this.expected = expected;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String actualStatus = SerenityRest.lastResponse()
                .jsonPath()
                .getString("data.status");

        if (actualStatus == null) return false;

        for (String value : expected) {
            if (actualStatus.equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }

    public static EstadoTransaccion es(String... expected) {
        return new EstadoTransaccion(expected);
    }
}