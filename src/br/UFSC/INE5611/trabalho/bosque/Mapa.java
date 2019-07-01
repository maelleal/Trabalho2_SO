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
       
    }

    public static final String[] COR_NOME = {"Vermelho", "Amarelo", "Verde", "Azul"};
}
