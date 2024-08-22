package com.oriontek_test.oriontek_test.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.BatchSize;

@Entity
@Table(name = "Address")
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 255)
    private String street;

    @NotNull
    @Size(max = 100)
    private String city;

    @Null
    @Size(max = 100)
    private String state;

    @NotNull
    @Size(max = 20)
    private String zipCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientes_id")
    private ClientModel client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull @Size(max = 255) String getStreet() {
        return street;
    }

    public void setStreet(@NotNull @Size(max = 255) String street) {
        this.street = street;
    }

    public @NotNull @Size(max = 100) String getCity() {
        return city;
    }

    public void setCity(@NotNull @Size(max = 100) String city) {
        this.city = city;
    }

    public @NotNull @Size(max = 100) String getState() {
        return state;
    }

    public void setState(@NotNull @Size(max = 100) String state) {
        this.state = state;
    }

    public @NotNull @Size(max = 20) String getZipCode() {
        return zipCode;
    }

    public void setZipCode(@NotNull @Size(max = 20) String zipCode) {
        this.zipCode = zipCode;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }
}
