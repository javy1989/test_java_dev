package com.rbravo.ms_management.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;

/**
 * Represent update DTO to client
 *
 * @author rbravo
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientUpdateDTO extends PersonDTO {

    @NotNull(message = "Status is mandatory")
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
