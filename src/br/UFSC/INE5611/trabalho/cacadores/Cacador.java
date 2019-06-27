/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5611.trabalho.cacadores;

import br.UFSC.INE5611.trabalho.bosque.Bosque;

/**
 *
 * @author Ivo Guilherme
 */
public class Cacador {

    int cor;
    int moedas;
    private int cachorro_em_campo;
    Cachorro cachorro1;
    Cachorro cachorro2;

    public Cacador(int cor) {
        this.cor = cor;
        this.moedas = 0;
        this.cachorro_em_campo = 2;
        this.cachorro1 = new Cachorro(this.cor);
        this.cachorro2 = new Cachorro(this.cor);

    }

    public Cachorro getCachorro1() {
        return cachorro1;
    }

    public Cachorro getCachorro2() {
        return cachorro2;
    }

    public Cachorro get_cachorro_vez() {
        if (cachorro_em_campo == 1) {
            return cachorro1;
        } else {
            return cachorro2;

        }
    }

    public void lancar_cachorro() {


        if (cachorro_em_campo == 1) {

            this.set_cachorro_em_campo(2);
            anuncia_lancar_cachorro();

            cachorro2.setPote_atual(Bosque.getInstance().get_pote_n(1));

                cachorro2.start();

        } else {

            this.set_cachorro_em_campo(1);
            anuncia_lancar_cachorro();


            cachorro1.setPote_atual(Bosque.getInstance().get_pote_n(1));

                cachorro1.start();

        }

    }

    public void set_cachorro_em_campo(int i) {
        this.cachorro_em_campo = i;
    }

    public void receber_cachorro(Cachorro cachorro) {
        this.moedas += cachorro.getMoedas();
        cachorro.setMoedas(0);
        this.anuncia_qtd_moedas();
    }


    public int getMoedas() {
        return this.moedas;
    }

    public int getCor() {
        return cor;
    }

    public void anuncia_qtd_moedas() {
        System.out.println("Caçador " + Bosque.COR_NOME[this.getCor()] + " possui " + (this.getMoedas()) + " moedas");

    }

    public void anuncia_lancar_cachorro() {
        System.out.println("Caçador " + Bosque.COR_NOME[this.getCor()] + " lança cachorro " + cachorro_em_campo);
    }
}
