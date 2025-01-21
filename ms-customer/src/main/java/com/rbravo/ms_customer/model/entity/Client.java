package com.rbravo.ms_customer.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
        name = "clients",
        schema = "management"
)
@Getter
@Setter
public class Client extends Person {

    /**
     * Password for the client account.
     */
    @Column(name = "password", nullable = false, length = 100)
    private String password;

    /**
     * Status of the client account (active/inactive).
     */
    @Column(name = "status", nullable = false)
    private boolean status;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
