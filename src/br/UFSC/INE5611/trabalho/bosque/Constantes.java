/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5611.trabalho.bosque;

/**
 *
 * @author Ismael
 */
public enum Constantes {
    //define as variáveis int
    VERMELHO(0),
    AMARELO(1),
    VERDE(2),
    AZUL(3),
   // TEMPO(500),
    MOEDAS_PARA_GANHAR(50),
    //as moedas do dono + moedas do cachorro podem somar os 50
    MOEDAS_PARA_VOLTAR(20),
    SLEEP(60 * 100),
    SHORTSLEEP(100),
    MOEDAS_INICIAIS(4);

    private final int numero;

    private Constantes(int num) {
        this.numero = num;
    }

    public int getNumero() {
        return this.numero;
    }
}
