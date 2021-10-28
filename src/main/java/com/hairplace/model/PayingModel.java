/*
package com.hairplace.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "estabelecimento")
public class UserModel implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "nome", unique = false, nullable = false)
    private String name;

    @Column(name = "cnpj", unique = false, nullable = false)
    private String cnpj;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "endereco", unique = false, nullable = false)
    private String address;

    @Column(name = "telefone", unique = false, nullable = false)
    private String numberphone;

}