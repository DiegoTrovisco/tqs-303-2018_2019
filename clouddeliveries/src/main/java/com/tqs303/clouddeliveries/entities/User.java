/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tqs303.clouddeliveries.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.beans.factory.annotation.Autowired;


import javax.persistence.*;

/**
 * @author Diego
 */
@Entity
public class User {

    @Autowired
    @Transient
    private PasswordEncoder passwordEncoder;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUser;

    @Column(name = "nome")
    private String nome;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "telemovel")
    private int telemovel;

    @Column(name = "nif")
    private int nif;

    public User(){

    }
    public User(String nome, String password, String endereco, int telemovel, int nif) {
        this.nome = nome;
        this.password = passwordEncoder.passwordEncoder().encode(password);
        this.endereco = endereco;
        this.telemovel = telemovel;
        this.nif = nif;
    }

    public String getNome() {
        return nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(int telemovel) {
        this.telemovel = telemovel;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }


}
