package api.co.wompi.tasks;

import api.co.wompi.models.TransactionRequest;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static api.co.wompi.utils.Constantes.TOKEN;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CrearTransaccion implements Task {

    private final TransactionRequest transactionRequest;

    public CrearTransaccion(TransactionRequest transactionRequest) {
        this.transactionRequest = transactionRequest;
    }

    public static CrearTransaccion conDatos(TransactionRequest transactionRequest) {
        return instrumented(CrearTransaccion.class, transactionRequest);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/transactions")
                        .with(request -> request
                                .header("Authorization", TOKEN)
                                .contentType(ContentType.JSON)
                                .body(transactionRequest)
                        )
        );
    }
}
