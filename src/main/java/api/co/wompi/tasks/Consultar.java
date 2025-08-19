package api.co.wompi.tasks;

import api.co.wompi.interations.GuardarToken;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static api.co.wompi.utils.Constantes.KEY;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Consultar implements Task {


    public static Consultar token() {
        return instrumented(Consultar.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/merchants/" + KEY)
                        .with(request -> request.contentType(ContentType.JSON)),
                GuardarToken.deAceptacion()
        );


    }
}