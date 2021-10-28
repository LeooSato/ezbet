package com.sato.ezbet.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_apostas")
public class aposta implements Serializable{

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private int winner_guess_id;

    @ManyToOne
    @JsonIgnoreProperties("aposta")
    private Jogos Jogos;

    @ManyToOne
    @JsonIgnoreProperties("aposta")
    private Usuario Usuario;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWinner_guess_id() {
        return this.winner_guess_id;
    }

    public void setWinner_guess_id(int winner_guess_id) {
        this.winner_guess_id = winner_guess_id;
    }


    public Jogos getJogo() {
        return this.Jogos;
    }

    public void setJogo(Jogos jogo) {
        this.Jogos = jogo;
    }


    public Usuario getUsuario() {
        return this.Usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.Usuario = usuario;
    }


}
