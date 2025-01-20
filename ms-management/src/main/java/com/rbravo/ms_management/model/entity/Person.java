package com.rbravo.ms_management.model.entity;

import com.rbravo.ms_management.model.enums.GenderTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(
        name = "persons",
        schema = "management",
        indexes = {
                @Index(name = "person_name_idx", columnList = "name")
        },
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "identification")
        }
)
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {

    /**
     * The person id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The person identification
     */
    @Column(nullable = false, length = 15)
    private String identification;

    /**
     * Full name of the person.
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Gender of the person. Allowed values: M (Male), F (Female), O (Other).
     */
    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private GenderTypeEnum gender;

    /**
     * Birthdate of the person.
     */
    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    /**
     * Address of the person.
     */
    @Column(name = "address")
    private String address;

    /**
     * Phone number of the person.
     */
    @Column(name = "phone")
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GenderTypeEnum getGender() {
        return gender;
    }

    public void setGender(GenderTypeEnum gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return name;
    }
}
