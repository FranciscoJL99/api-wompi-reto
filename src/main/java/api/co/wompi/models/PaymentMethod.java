package api.co.wompi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethod {

    @JsonProperty("type")
    private String type;

    @JsonProperty("phone_number")
    private String phoneNumber;
}
