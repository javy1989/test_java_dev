package com.rbravo.ms_customer.model.dto;

public class ClientEvent {

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
