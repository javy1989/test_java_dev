package com.rbravo.ms_customer.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * DTO representing a Person.
 *
 * @author rbravo
 */
public class ClientUpdateDTO {

    @NotBlank(message = "Identifier is mandatory")
    @Size(max = 15, min = 10, message = "Identification cannot exceed 15 characters or min 10 characters")
    private String identification;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "Gender is mandatory")
    @Pattern(regexp = "^(M|F|O)$", message = "Gender must be M, F, or O")
    private String gender;

    @NotNull(message = "Birthdate is mandatory")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate birthdate;

    @Size(max = 255, message = "Address cannot exceed 255 characters")
    private String address;

    @Pattern(regexp = "^\\+?[0-9]{7,15}$", message = "Phone must be a valid format")
    private String phone;

    @NotNull(message = "Status is mandatory")
    private boolean status;





}
