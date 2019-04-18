/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tqs303.clouddeliveries.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private String nome;
    private String endereco;
    private int telemovel;
    private int nif;

    @JsonIgnore
    private String password;

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
