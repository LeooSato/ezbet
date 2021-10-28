package com.sato.ezbet.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="jogos")
public class Jogos implements Serializable{

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate DataJogo;

    private String Winner_id;

    private int Rounds_loser;
    private int Rounds_winner;

    public int getRounds_loser() {
        return this.Rounds_loser;
    }

    public void setRounds_loser(int Rounds_loser) {
        this.Rounds_loser = Rounds_loser;
    }

    public int getRounds_winner() {
        return this.Rounds_winner;
    }

    public void setRounds_winner(int Rounds_winner) {
        this.Rounds_winner = Rounds_winner;
    }


    @ManyToMany(mappedBy="Jogos",cascade=CascadeType.ALL)
    private List<Times> Times = new ArrayList<Times>();



    public List<Times> getTimes() {
        return Times;
    }

    public void setTimes(List<Times> times) {
        Times = times;
    }

    public String getWinner_id() {
        return Winner_id;
    }

    public void setWinner_id(String Winner_id) {
        this.Winner_id =Winner_id;
    }



    public LocalDate getDataJogo() {
        return DataJogo;
    }

    public void setDataJogo(LocalDate dataJogo) {
        DataJogo = dataJogo;
    }

    @OneToMany(mappedBy="Jogos",cascade=CascadeType.ALL)
    @JsonIgnoreProperties("Jogos")
    private List<aposta> aposta;

    public List<aposta> getAposta() {
        return this.aposta;
    }

    public void setAposta(List<aposta> aposta) {
        this.aposta = aposta;
    }



}