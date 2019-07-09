/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5611.trabalho.bosque;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Ivo Guilherme
 */
public class CachorroVermelho extends Thread {

    int numeroPote = 0;
    public boolean verificando = true;
    
    // obriga a ser sempre a mesma Thread
    public static CachorroVermelho instancia;

    public static CachorroVermelho getInstance() {
        if (instancia == null) {
            instancia = new CachorroVermelho();
        }
        return instancia;
    }

    ScheduledExecutorService execService = Executors.newSingleThreadScheduledExecutor();//unica thread
    //A delayed result-bearing action that can be cancelled. Usually a scheduled future is the result of scheduling a task with a
    ScheduledFuture<?> future; // para agendar

    public synchronized void setVerificando() {
        this.verificando = true;
    }

    public void pararVerificacao() {
        this.verificando = false;
    }

    @Override
    public void run() {
        
    //        command - the task to execute
    //        initialDelay - the time to delay first execution
    //        period - the period between successive executions
    //        unit - the time unit of the initialDelay and period parameters
    //        a cada 2ut ele lança o cachorro vermelho
        future = execService.scheduleAtFixedRate(() -> {
            if (this.verificando) {
                Pote pote = Bosque.getInstance().getPoteNumero(numeroPote);

                System.out.println(("Cachorro " + Mapa.COR_NOME[0] + " verificando Pote " + (pote.getNumero()) + " Quantidade de moedas no pote: " + pote.getMoedas()).toUpperCase());
                if (pote.getMoedas() == 0) {
                    pote.adicionaUmaMoeda();
                    System.out.println("Cachorro " + Mapa.COR_NOME[0] + " Adicionou 1 moeda no pode " + pote.getNumero());
                }

                if (numeroPote == 19) {
                    numeroPote = 0;
                } else {
                    numeroPote++;
                }
            } else {
                future.cancel(false);
                execService.shutdown();

                try {
                    this.join();
                } catch (InterruptedException ex) {
                }
            }
        }, 0, Constantes.TEMPO.getNumero() * 2, TimeUnit.MILLISECONDS);
    }

}
