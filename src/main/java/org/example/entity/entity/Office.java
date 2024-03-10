package org.example.entity.entity;

import java.util.LinkedHashMap;
import java.util.List;
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
        "salePointName",
        "address",
        "status",
        "openHours",
        "rko",
        "openHoursIndividual",
        "officeType",
        "salePointFormat",
        "suoAvailability",
        "hasRamp",
        "latitude",
        "longitude",
        "metroStation",
        "distance",
        "kep",
        "myBranch"
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Office {
    @JsonProperty("salePointName")
    public String salePointName;
    @JsonProperty("address")
    public String address;
    @JsonProperty("status")
    public String status;
    @JsonProperty("openHours")
    public List<OpenHour> openHours;
    @JsonProperty("rko")
    public String rko;
    @JsonProperty("openHoursIndividual")
    public List<OpenHoursIndividual> openHoursIndividual;
    @JsonProperty("officeType")
    public String officeType;
    @JsonProperty("salePointFormat")
    public String salePointFormat;
    @JsonProperty("suoAvailability")
    public String suoAvailability;
    @JsonProperty("hasRamp")
    public String hasRamp;
    @JsonProperty("latitude")
    public double latitude;
    @JsonProperty("longitude")
    public double longitude;
    @JsonProperty("metroStation")
    public Object metroStation;
    @JsonProperty("distance")
    public int distance;
    @JsonProperty("kep")
    public boolean kep;
    @JsonProperty("myBranch")
    public boolean myBranch;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
