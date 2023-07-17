package com.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@Entity
@Table(name = "clientes")
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data_nasc")
    private LocalDate date_of_birth;
    @Column(name = "nome")
    private String name;
    @Column(name = "telefone")
    private Long phone;
    @Column(name = "email")
    private String email;

}
