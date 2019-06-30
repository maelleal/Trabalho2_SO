/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5611.trabalho.bosque;


/**
 *
 * @author Ivo Guilherme
 */
public class Cachorro extends Thread {

    boolean cachorroRico; //com o máximo de moedas possível
    int moedas;
    Pote poteAtual;
    int cor;
    boolean rodando = false;

    public Cachorro(int cor) {
        this.moedas = 0;
        this.cor = cor;
        this.cachorroRico = false;
        poteAtual = null;
    }

    @Override
    public void run() {
        try {
            if (Bosque.getInstance().isJogoRodando() && !this.cachorroRico) {
                        //imprime que o cachorro está procurando no pote
                        System.out.println("Cachorro " + Mapa.COR_NOME[this.getCor()] 
                            + " está procurando moedas no pote " + (poteAtual.getNumero()));
                
                poteAtual.procurar(this);
                this.run();
                this.rodando = true;
                
            } else if (Bosque.getInstance().isJogoRodando() && this.cachorroRico) {
                Pote poteDeVolta = poteAtual.caminhoVolta();
                
                        //imprime que o cachorro está rico e fazendo o cominho de volta
                        System.out.println("Cachorro " + Mapa.COR_NOME[this.getCor()] 
                            + " voltando a partir do pote" + (poteAtual.getNumero()) 
                            + " para o pote " + poteDeVolta.getNumero() );

                if (poteDeVolta.getNumero() == 1) {
                } else {
                    this.setPoteAtual(poteDeVolta);
                    this.run();
                    this.rodando = true;
                }
            }
            Cachorro.sleep(Constantes.TEMPO.getNumero());
        } catch (Exception ex) {
            System.out.println("Ops, deu crash com a Thread / cachorro cor "+this.cor);
            ex.printStackTrace();
        }
    }

    public boolean isRodando() {
        return rodando;
    }

    public void setRodando(boolean rodando) {
        this.rodando = rodando;
    }

    public void cachorroPegaMoedas(int moedas) {
        this.moedas += moedas;
        if (this.moedas >= Constantes.MOEDAS_PARA_VOLTAR.getNumero()) {
            System.out.println("Voltar para o cacador");
            this.cachorroRico = true;
        }
    }

    public void dormir() throws InterruptedException {
        System.out.println("Botando o cachorro para dormir");
        // native void sleep(long l)
        // Thread dorme pelo tempo passado (1)
        // cede o processador para outra Thread
        Cachorro.sleep(Constantes.TEMPO.getNumero() * Constantes.TEMPO.getNumero());
    }

    public int getMoedas() {
        return moedas;
    }

    public void setMoedas(int moedas) {
        this.moedas = moedas;
    }

    public Pote getPoteAtual() {
        return poteAtual;
    }

    public void setPoteAtual(Pote poteAtual) {
        this.poteAtual = poteAtual;
    }

    public int getCor() {
        return cor;
    }

}
