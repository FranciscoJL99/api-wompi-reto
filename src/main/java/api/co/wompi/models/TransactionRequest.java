package api.co.wompi.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static api.co.wompi.utils.Constantes.CURRENCY;
import static api.co.wompi.utils.Constantes.METODO;
import static api.co.wompi.utils.GenerateData.correoAleatorio;
import static api.co.wompi.utils.SignatureUtil.generarFirma;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionRequest {

    @JsonProperty("amount_in_cents")
    private Integer amountInCents;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("customer_email")
    private String customerEmail;

    @JsonProperty("payment_method")
    private PaymentMethod paymentMethod;

    @JsonProperty("reference")
    private String reference;

    @JsonProperty("acceptance_token")
    private String acceptanceToken;

    @JsonProperty("signature")
    private String signature;

    public static TransactionRequest crearJson(String telefono, int monto, String referencia, String acceptanceToken) {
        return new TransactionRequest(
                monto,
                CURRENCY,
                correoAleatorio(),
                new PaymentMethod(METODO, telefono),
                referencia,
                acceptanceToken,
                generarFirma(referencia, monto, CURRENCY, "stagtest_integrity_nAIBuqayW70XpUqJS4qf4STYiISd89Fp")
        );
    }

}
