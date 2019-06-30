/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5611.trabalho.bosque;

import java.util.ArrayList;

/**
 *
 * @author Ivo Guilherme
 */
public class Pote extends Thread {

    int numeroPote;
    int numeroMoedas;

    ArrayList<Pote> caminhos;
    ArrayList<Cachorro> cachorrosDormindo;

    public Pote(int num) {
        this.numeroPote = num;
        this.numeroMoedas = Constantes.MOEDAS_INICIAIS.getNumero();
        this.caminhos = new ArrayList<>();
        this.cachorrosDormindo = new ArrayList<>();
    }

    public void adicionaCachorroDormindo(Cachorro cachorro) throws InterruptedException {
        cachorro.dormir();
        this.cachorrosDormindo.add(cachorro);
    }

    public void procurar(Cachorro cachorroProcurando) throws InterruptedException {
        //gasta 1ut para procurar
        cachorroProcurando.sleep(Constantes.SLEEP.getNumero());

        //pega o mínimo entre o que tem e 3
        int moedas = this.getAteTresMoedas();
        if (moedas == 0) {
            this.adicionaCachorroDormindo(cachorroProcurando);
        } else {
            cachorroPegaMoedas(cachorroProcurando, moedas);
        }
    }

    public Pote caminhoVolta() {
        Pote volta = null;
        int min = 20;
        //pega o menor getNumero() para ser o caminho
        for (Pote p : this.caminhos) {
            if (p.getNumero() <= min) {
                volta = p;
                min = volta.getNumero();
            }
        }
        System.out.println(" Do pote " +this.numeroPote + " ->  volta para pote " + volta.getNumero());
        return volta;
    }

    public int getAteTresMoedas() {
        return Math.min(this.getMoedas(), 3);
    }

    public int getNumero() {
        return numeroPote;
    }

    public int getMoedas() {
        return numeroMoedas;
    }

    public void adicionaUmaMoeda() {
        if (this.numeroMoedas == 0) {
            this.numeroMoedas = 1;
        }
    }

    public void removeMoedas(int moedas) {
        if ((this.numeroMoedas - moedas) <= 0) {
            this.numeroMoedas = 0;
        } else {
            this.numeroMoedas -= moedas;
        }

    }

    public ArrayList getCaminhos() {
        return caminhos;
    }

    public void setCaminhos(ArrayList caminhos) {
        this.caminhos = caminhos;
    }

    public ArrayList getCachorrosDormindo() {
        return cachorrosDormindo;
    }


    public void cachorroPegaMoedas(Cachorro cachorro, int moedas) {
        synchronized (this) {
            cachorro.cachorroPegaMoedas(moedas);
            this.removeMoedas(moedas);
            int caminhoProximoPote = Bosque.caminhoRandom(0, this.caminhos.size());
            System.out.println("O proximo pode será o "+this.caminhos.get(caminhoProximoPote)
                    +"\n----------------------------------------------------------------------");
            cachorro.setPoteAtual(this.caminhos.get(caminhoProximoPote));
        }
    }

}
