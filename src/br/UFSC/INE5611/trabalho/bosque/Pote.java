/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5611.trabalho.bosque;

import java.util.ArrayList;
import br.UFSC.INE5611.trabalho.cacadores.Cachorro;

/**
 *
 * @author Ivo Guilherme
 */
public class Pote extends Thread {

    int numeroPote;
    int numeroMoedas;

    ArrayList<Pote> caminhos;
    ArrayList<Cachorro> cachorros_dormindo;

    public Pote(int num) {
        this.numeroPote = num;
        this.numeroMoedas = Constantes.MOEDAS_INICIAIS.getNumero();
        this.caminhos = new ArrayList<>();
        this.cachorros_dormindo = new ArrayList<>();
    }

    public void addCachorroDormindo(Cachorro cachorro) throws InterruptedException {
        cachorro.dormir();
        this.cachorros_dormindo.add(cachorro);
    }

    public void procurar(Cachorro cachorroProcurando) throws InterruptedException {
        cachorroProcurando.sleep(Constantes.TEMPO.getNumero());

        int tres_moedas = this.getTresMoedas();
        if (tres_moedas == 0) {
            this.addCachorroDormindo(cachorroProcurando);
        } else {
            synchronized (this) {
                cachorroProcurando.add_moedas(tres_moedas);
                this.removeMoedas(tres_moedas);
                int n_caminho = Bosque.numero_entre(0, this.caminhos.size());
                cachorroProcurando.setPote_atual(
                        this.caminhos.get(n_caminho)
                );
            }
        }
    }

    public Pote caminhoVolta() {

        Pote volta = null;
        int min = 20;
        for (Pote p : this.caminhos) {
            if (p.getNumero() <= min) {
                volta = p;
                min = volta.getNumero();
            }
        }
        return volta;
    }

    public int getTresMoedas() {
        return Math.min(this.getMoedas(), 3);
    }

    public int getNumero() {
        return numeroPote;
    }

    public int getMoedas() {
        return numeroMoedas;
    }

    public void add_1_moeda() {
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

    public ArrayList get_caminhos() {
        return caminhos;
    }

    public void set_caminhos(ArrayList caminhos) {
        this.caminhos = caminhos;
    }

    public ArrayList get_cachorros_dormindo() {
        return cachorros_dormindo;
    }

    public void teste() {

        Pote volta = null;
        int min = 20;
        for (Pote p : this.caminhos) {
            if (p.getNumero() <= min) {
                volta = p;
            }
        }

        System.out.println(this.numeroPote + " = " + volta.getNumero());
    }

}
