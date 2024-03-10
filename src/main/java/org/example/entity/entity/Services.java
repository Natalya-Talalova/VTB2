
package org.example.entity.entity;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "wheelchair",
    "blind",
    "nfcForBankCards",
    "qrRead",
    "supportsUsd",
    "supportsChargeRub",
    "supportsEur",
    "supportsRub"
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Services {

    public boolean isWheelchair;
    public boolean isBlind;
    public boolean isNfcForBankCards;
    public boolean isQrRead;
    public boolean isSupportsUsd;
    public boolean isSupportsChargeRub;
    public boolean isSupportsEur;
    public boolean isSupportsRub;

    @JsonProperty("wheelchair")
    public Wheelchair wheelchair;
    @JsonProperty("blind")
    public Blind blind;
    @JsonProperty("nfcForBankCards")
    public NfcForBankCards nfcForBankCards;
    @JsonProperty("qrRead")
    public QrRead qrRead;
    @JsonProperty("supportsUsd")
    public SupportsUsd supportsUsd;
    @JsonProperty("supportsChargeRub")
    public SupportsChargeRub supportsChargeRub;
    @JsonProperty("supportsEur")
    public SupportsEur supportsEur;
    @JsonProperty("supportsRub")
    public SupportsRub supportsRub;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
