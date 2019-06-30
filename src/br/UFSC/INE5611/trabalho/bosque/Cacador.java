/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5611.trabalho.bosque;

import br.UFSC.INE5611.trabalho.bosque.Bosque;

/**
 *
 * @author Ivo Guilherme
 */
public class Cacador {

    int cor;
    int moedas;
    private int cachorroNoBosque;
    Cachorro cachorro1;
    Cachorro cachorro2;

    public Cacador(int cor) {
        this.cor = cor;
        this.moedas = 0;
        this.cachorroNoBosque = 2;
        // mesma coisa que Thread cachorro1 = new Thread(Cachorro) se implementasse Runable
        // Cachorro é onde está o método run()
        // mas só começa a rodar com start()
        this.cachorro1 = new Cachorro(this.cor);
        this.cachorro2 = new Cachorro(this.cor);

    }

    public Cachorro getCachorro1() {
        return cachorro1;
    }

    public Cachorro getCachorro2() {
        return cachorro2;
    }

    public Cachorro getCachorroNoBosque() {
        if (cachorroNoBosque == 1) {
            return cachorro1;
        } else {
            return cachorro2;
        }
    }

    public void cachorroEntraNoBosque() {
        if (cachorroNoBosque == 1) {
            this.setCachorroNoBosque(2);
            System.out.println("Cachorro do caçador "+Mapa.COR_NOME[this.getCor()]+ " entrou no bosque");

            cachorro2.setPoteAtual(Mapa.getInstance().getPoteNumero(1));
            //starta a Thread synchronized
            cachorro2.start();
        } else {

            this.setCachorroNoBosque(1);
            System.out.println("Cachorro do caçador "+Mapa.COR_NOME[this.getCor()]+ " entrou no bosque");
            
            cachorro1.setPoteAtual(Mapa.getInstance().getPoteNumero(1));
            //starta a Thread synchronized
            cachorro1.start();
        }
    }

    public void setCachorroNoBosque(int i) {
        this.cachorroNoBosque = i;
    }

    //cacador recebe moedas do cachorro
    public void receberMoedasDoCachorro(Cachorro cachorro) {
        this.moedas += cachorro.getMoedas();
        cachorro.setMoedas(0);
        System.out.println("Caçador " + Mapa.COR_NOME[this.getCor()] + " possui " + (this.getMoedas()) + " moedas");
    }


    public int getMoedas() {
        return this.moedas;
    }

    public int getCor() {
        return cor;
    }

//    public void anuncia_qtd_moedas() {
//        System.out.println("Caçador " + Bosque.COR_NOME[this.getCor()] + " possui " + (this.getMoedas()) + " moedas");
//
//    }

}
