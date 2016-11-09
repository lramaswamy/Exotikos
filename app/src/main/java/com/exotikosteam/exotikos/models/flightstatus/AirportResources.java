
package com.exotikosteam.exotikos.models.flightstatus;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class AirportResources {

    @SerializedName("departureTerminal")
    @Expose
    private String departureTerminal;
    @SerializedName("departureGate")
    @Expose
    private String departureGate;
    @SerializedName("arrivalTerminal")
    @Expose
    private String arrivalTerminal;

    /**
     * 
     * @return
     *     The departureTerminal
     */
    public String getDepartureTerminal() {
        return departureTerminal;
    }

    /**
     * 
     * @param departureTerminal
     *     The departureTerminal
     */
    public void setDepartureTerminal(String departureTerminal) {
        this.departureTerminal = departureTerminal;
    }

    /**
     * 
     * @return
     *     The departureGate
     */
    public String getDepartureGate() {
        return departureGate;
    }

    /**
     * 
     * @param departureGate
     *     The departureGate
     */
    public void setDepartureGate(String departureGate) {
        this.departureGate = departureGate;
    }

    /**
     * 
     * @return
     *     The arrivalTerminal
     */
    public String getArrivalTerminal() {
        return arrivalTerminal;
    }

    /**
     * 
     * @param arrivalTerminal
     *     The arrivalTerminal
     */
    public void setArrivalTerminal(String arrivalTerminal) {
        this.arrivalTerminal = arrivalTerminal;
    }

}
