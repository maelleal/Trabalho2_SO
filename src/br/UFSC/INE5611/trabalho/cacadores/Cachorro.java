/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5611.trabalho.cacadores;

import br.UFSC.INE5611.trabalho.bosque.Bosque;
import br.UFSC.INE5611.trabalho.bosque.Pote;

/**
 *
 * @author Ivo Guilherme
 */
public class Cachorro extends Thread {

    boolean finalizar;
    int moedas;
    Pote pote_atual;
    int cor;
    
    boolean has_started = false;

    public Cachorro(int cor) {
        this.moedas = 0;
        this.cor = cor;
        this.finalizar = false;
        pote_atual = null;
    }

    @Override
    public void run() {
        try {
            if (Bosque.getInstance().is_disputa_acontecendo() && !this.finalizar) {
                this.anuncia_procura_pote(pote_atual.get_num());
                pote_atual.procurar(this);
                this.run();
                this.has_started = true;
            } else if (Bosque.getInstance().is_disputa_acontecendo() && this.finalizar) {
                Pote pote_volta = pote_atual.caminho_volta();
                this.anuncia_retorno_pote(pote_atual.get_num(), pote_volta.get_num());

                if (pote_volta.get_num() == 1) {
                } else {
                    this.setPote_atual(pote_volta);
                    this.run();
                    this.has_started = true;
                }
            }

            Cachorro.sleep(Bosque.UNIT_TEMPO);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean isHas_started() {
        return has_started;
    }

    public void setHas_started(boolean has_started) {
        this.has_started = has_started;
    }

    public void add_moedas(int moedas) {
        this.moedas += moedas;
        if (this.moedas >= Bosque.MOEDAS_PARA_VOLTAR) {
//            System.out.println("Voltar para o dono");
            this.finalizar = true;
        }
    }

    public void dormir() throws InterruptedException {
        System.out.println("Dormir");
        Cachorro.sleep(Bosque.UNIT_TEMPO * Bosque.TEMPO_DORMIR);
        
    }

    public void anuncia_procura_pote(int i) {
        System.out.println(Bosque.PRINT_PREFIX[this.getCor()] + "Cachorro " + Bosque.COR_NOME[this.getCor()] + " procurando moedas no pote " + (i) + Bosque.PRINT_SUFIX);

    }


    public void anuncia_retorno_pote(int i, int j) {
        System.out.println(Bosque.PRINT_PREFIX[this.getCor()] + "Cachorro " + Bosque.COR_NOME[this.getCor()] + " voltando a partir do pote" + (i) + " para o pote " + j + Bosque.PRINT_SUFIX);

    }

    public int getMoedas() {
        return moedas;
    }

    public void setMoedas(int moedas) {
        this.moedas = moedas;
    }

    public Pote getPote_atual() {
        return pote_atual;
    }

    public void setPote_atual(Pote pote_atual) {
        this.pote_atual = pote_atual;
    }

    public int getCor() {
        return cor;
    }

}
