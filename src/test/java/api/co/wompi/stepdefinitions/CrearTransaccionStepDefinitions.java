package api.co.wompi.stepdefinitions;

import api.co.wompi.models.TransactionRequest;
import api.co.wompi.questions.EstadoTransaccion;
import api.co.wompi.questions.ValidarError;
import api.co.wompi.tasks.Consultar;
import api.co.wompi.tasks.CrearTransaccion;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.model.environment.ConfiguredEnvironment;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static api.co.wompi.utils.Constantes.MONTO_INVALIDO;
import static api.co.wompi.utils.Constantes.TELEFONO;
import static api.co.wompi.utils.GenerateData.referenciaAleatoria;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CrearTransaccionStepDefinitions {


    @Dado("que el comercio tiene un token de autenticación válido")
    public void queElComercioTieneUnTokenDeAutenticaciónVálido() {
        theActorInTheSpotlight().attemptsTo(
                Consultar.token()
        );
    }

    @Cuando("solicita la creación de una transacción con Nequi de {} y referencia {string}")
    public void solicitaLaCreacionDeUnaTransaccionConNequiDeYReferencia(Integer monto, String referencia) {
        TransactionRequest request = TransactionRequest.crearJson(
                TELEFONO,
                monto,
                referencia,
                theActorInTheSpotlight().recall("ACCEPTANCE_TOKEN")
        );

        theActorInTheSpotlight().attemptsTo(
                CrearTransaccion.conDatos(request)
        );
    }

    @Entonces("la respuesta debe contener un estado {string} o {string}")
    public void laRespuestaDebeContenerUnEstadoO(String estadoUno, String estadodos) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(EstadoTransaccion.es(estadoUno, estadodos))
        );
    }

    @Cuando("solicita la creación de una transacción con un monto inválido")
    public void solicitaLaCreaciónDeUnaTransacciónConUnMontoInválido() {
        TransactionRequest request = TransactionRequest.crearJson(
                TELEFONO,
                MONTO_INVALIDO,
                referenciaAleatoria(),
                theActorInTheSpotlight().recall("ACCEPTANCE_TOKEN")
        );

        theActorInTheSpotlight().attemptsTo(
                CrearTransaccion.conDatos(request)
        );
    }
    @Entonces("la respuesta debe contener un error de validación")
    public void laRespuestaDebeContenerUnErrorDeValidación() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidarError.montos())
        );
    }

}
