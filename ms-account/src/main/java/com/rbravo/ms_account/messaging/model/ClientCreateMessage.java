package com.rbravo.ms_account.messaging.model;

/**
 * Represents the information of the created client message
 *
 * @author rbravo
 */
public class ClientCreateMessage {

    private Long clientId;
    private String identification;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }
}
