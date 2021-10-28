package com.sato.ezbet.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "times")
public class Times {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @NotNull
    @Column
    private String nomeorg;

    public String getNomeorg() {
        return this.nomeorg;
    }

    public void setNomeorg(String nomeorg) {
        this.nomeorg = nomeorg;
    }

    @NotNull
    @Column
    private String LinkEscudo;
    @NotNull
    @Column
    private String player1;
    @NotNull
    @Column
    private String player2;
    @NotNull
    @Column
    private String player3;
    @NotNull
    @Column
    private String player4;
    @NotNull
    @Column
    private String player5;
    @Column
    private String playercomplete;
    @NotNull
    @Column
    private String coach;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="Times_Jogos",joinColumns= {@JoinColumn(name="Time_Id")},
            inverseJoinColumns= {@JoinColumn(name="Jogos_Id")})
    private List<Jogos> Jogos = new ArrayList<Jogos>();




    public List<Jogos> getJogos() {
        return Jogos;
    }

    public void setJogos(List<Jogos> jogos) {
        Jogos = jogos;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


    

    public String getLinkEscudo() {
        return LinkEscudo;
    }

    public void setLinkEscudo(String linkEscudo) {
        LinkEscudo = linkEscudo;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getPlayer3() {
        return player3;
    }

    public void setPlayer3(String player3) {
        this.player3 = player3;
    }

    public String getPlayer4() {
        return player4;
    }

    public void setPlayer4(String player4) {
        this.player4 = player4;
    }

    public String getPlayer5() {
        return player5;
    }

    public void setPlayer5(String player5) {
        this.player5 = player5;
    }

    public String getPlayercomplete() {
        return playercomplete;
    }

    public void setPlayercomplete(String playercomplete) {
        this.playercomplete = playercomplete;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public Object map(Object object) {
        return null;
    }

}