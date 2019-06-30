/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5611.trabalho.bosque;

import java.util.ArrayList;

/**
 *
 * @author Ismael
 */
public class Mapa {

    public static Mapa instancia;
    ArrayList<Pote> potes;

    //bosque é sempre o mesmo
    public static Mapa getInstance() {
        if (instancia == null) {
            instancia = new Mapa();
        }
        return instancia;
    }

    private Mapa(){
        this.criaMapa();
    }
    public void criaMapa() {
        Pote pote1 = new Pote(1);
        Pote pote2 = new Pote(2);
        Pote pote3 = new Pote(3);
        Pote pote4 = new Pote(4);
        Pote pote5 = new Pote(5);
        Pote pote6 = new Pote(6);
        Pote pote7 = new Pote(7);
        Pote pote8 = new Pote(8);
        Pote pote9 = new Pote(9);
        Pote pote10 = new Pote(10);
        Pote pote11 = new Pote(11);
        Pote pote12 = new Pote(12);
        Pote pote13 = new Pote(13);
        Pote pote14 = new Pote(14);
        Pote pote15 = new Pote(15);
        Pote pote16 = new Pote(16);
        Pote pote17 = new Pote(17);
        Pote pote18 = new Pote(18);
        Pote pote19 = new Pote(19);
        Pote pote20 = new Pote(20);

        this.potes = new ArrayList<>();
        this.potes.add(pote1);
        this.potes.add(pote2);
        this.potes.add(pote3);
        this.potes.add(pote4);
        this.potes.add(pote5);
        this.potes.add(pote6);
        this.potes.add(pote7);
        this.potes.add(pote8);
        this.potes.add(pote9);
        this.potes.add(pote10);
        this.potes.add(pote11);
        this.potes.add(pote12);
        this.potes.add(pote13);
        this.potes.add(pote14);
        this.potes.add(pote15);
        this.potes.add(pote16);
        this.potes.add(pote17);
        this.potes.add(pote18);
        this.potes.add(pote19);
        this.potes.add(pote20);

        //adiciona os caminhos possiveis
        // 1
        ArrayList<Pote> pote_disponiveis1 = new ArrayList<>();
        pote_disponiveis1.add(pote2);
        pote_disponiveis1.add(pote15);
        pote1.setCaminhos(pote_disponiveis1);

        // 2
        ArrayList<Pote> pote_disponiveis2 = new ArrayList<>();
        pote_disponiveis2.add(pote1);
        pote_disponiveis2.add(pote3);
        pote_disponiveis2.add(pote5);
        pote2.setCaminhos(pote_disponiveis2);

        // 3
        ArrayList<Pote> pote_disponiveis3 = new ArrayList<>();
        pote_disponiveis3.add(pote2);
        pote_disponiveis3.add(pote9);
        pote3.setCaminhos(pote_disponiveis3);

        // 4
        ArrayList<Pote> pote_disponiveis4 = new ArrayList<>();
        pote_disponiveis4.add(pote2);
        pote_disponiveis4.add(pote9);
        pote_disponiveis4.add(pote10);
        pote4.setCaminhos(pote_disponiveis4);

        // 5
        ArrayList<Pote> pote_disponiveis5 = new ArrayList<>();
        pote_disponiveis5.add(pote2);
        pote_disponiveis5.add(pote6);
        pote5.setCaminhos(pote_disponiveis5);

        // 6
        ArrayList<Pote> pote_disponiveis6 = new ArrayList<>();
        pote_disponiveis6.add(pote5);
        pote_disponiveis6.add(pote7);
        pote_disponiveis6.add(pote8);
        pote6.setCaminhos(pote_disponiveis6);

        // 7
        ArrayList<Pote> pote_disponiveis7 = new ArrayList<>();
        pote_disponiveis7.add(pote6);
        pote7.setCaminhos(pote_disponiveis7);

        // 8
        ArrayList<Pote> pote_disponiveis8 = new ArrayList<>();
        pote_disponiveis8.add(pote6);
        pote8.setCaminhos(pote_disponiveis8);

        // 9
        ArrayList<Pote> pote_disponiveis9 = new ArrayList<>();
        pote_disponiveis9.add(pote3);
        pote_disponiveis9.add(pote4);
        pote_disponiveis9.add(pote15);
        pote_disponiveis9.add(pote18);
        pote9.setCaminhos(pote_disponiveis9);

        // 10
        ArrayList<Pote> pote_disponiveis10 = new ArrayList<>();
        pote_disponiveis10.add(pote4);
        pote_disponiveis10.add(pote12);
        pote10.setCaminhos(pote_disponiveis10);

        // 11
        ArrayList<Pote> pote_disponiveis11 = new ArrayList<>();
        pote_disponiveis11.add(pote17);
        pote_disponiveis11.add(pote15);
        pote_disponiveis11.add(pote12);
        pote11.setCaminhos(pote_disponiveis11);

        // 12
        ArrayList<Pote> pote_disponiveis12 = new ArrayList<>();
        pote_disponiveis12.add(pote11);
        pote_disponiveis12.add(pote10);
        pote_disponiveis12.add(pote13);
        pote12.setCaminhos(pote_disponiveis12);

        // 13
        ArrayList<Pote> pote_disponiveis13 = new ArrayList<>();
        pote_disponiveis13.add(pote12);
        pote13.setCaminhos(pote_disponiveis13);

        // 14
        ArrayList<Pote> pote_disponiveis14 = new ArrayList<>();
        pote_disponiveis14.add(pote11);
        pote_disponiveis14.add(pote16);
        pote14.setCaminhos(pote_disponiveis14);

        // 15
        ArrayList<Pote> pote_disponiveis15 = new ArrayList<>();
        pote_disponiveis15.add(pote1);
        pote_disponiveis15.add(pote9);
        pote15.setCaminhos(pote_disponiveis15);

        // 16
        ArrayList<Pote> pote_disponiveis16 = new ArrayList<>();
        pote_disponiveis16.add(pote18);
        pote_disponiveis16.add(pote14);
        pote_disponiveis16.add(pote20);
        pote16.setCaminhos(pote_disponiveis16);

        // 17
        ArrayList<Pote> pote_disponiveis17 = new ArrayList<>();
        pote_disponiveis17.add(pote16);
        pote_disponiveis17.add(pote11);
        pote17.setCaminhos(pote_disponiveis17);

        // 18
        ArrayList<Pote> pote_disponiveis18 = new ArrayList<>();
        pote_disponiveis18.add(pote9);
        pote_disponiveis18.add(pote19);
        pote18.setCaminhos(pote_disponiveis18);

        // 19
        ArrayList<Pote> pote_disponiveis19 = new ArrayList<>();
        pote_disponiveis19.add(pote18);
        pote_disponiveis19.add(pote20);
        pote19.setCaminhos(pote_disponiveis19);

        // 20
        ArrayList<Pote> pote_disponiveis20 = new ArrayList<>();
        pote_disponiveis20.add(pote19);
        pote_disponiveis20.add(pote19);
        pote20.setCaminhos(pote_disponiveis20);

       // Bosque.instancia.setInicio(pote1);
    }

    public Pote getPoteNumero(int n) {
        return this.potes.get(n);
    }

    public static final String[] COR_NOME = {"Vermelho", "Amarelo", "Verde", "Azul"};
}
