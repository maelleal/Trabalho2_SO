/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5611.trabalho.cacadores;

import br.UFSC.INE5611.trabalho.bosque.Bosque;
import br.UFSC.INE5611.trabalho.bosque.Constantes;
import br.UFSC.INE5611.trabalho.bosque.Pote;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Ivo Guilherme
 */
public class CachorroVermelho extends Thread {

    int pote_n = 0;
    public boolean verificando = true;
    public static CachorroVermelho instancia;

    public static CachorroVermelho getInstance() {

        if (instancia == null) {
            CachorroVermelho gu = new CachorroVermelho();
            gu.setDaemon(true);
            instancia = gu;
        }

        return instancia;
    }

    ScheduledExecutorService execService = Executors.newSingleThreadScheduledExecutor();
    ScheduledFuture<?> future;

    public synchronized void set_verificando() {
        this.verificando = true;
    }

    public void parar_verificacao() {
        this.verificando = false;
    }

    @Override
    public void run() {
        future = execService.scheduleAtFixedRate(() -> {
            if (this.verificando) {
                Pote pote = Bosque.getInstance().get_pote_n(pote_n);

                System.out.println(("Cachorro " + Bosque.COR_NOME[0] + " verificando Pote " + (pote.getNumero()) + " Quantidade de moedas no pote: " + pote.getMoedas()).toUpperCase());
                if (pote.getMoedas() == 0) {
                    pote.add_1_moeda();
                    System.out.println("Cachorro " + Bosque.COR_NOME[0] + " Adicionou 1 moeda no pode " + pote.getNumero());
                }

                if (pote_n == 19) {
                    pote_n = 0;
                } else {
                    pote_n++;
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

//    public void teste() {
//        if (this.verificando) {
//            Pote pote = Bosque.getInstance().get_pote_n(pote_n);
//
//            System.out.println(("Cachorro " + Bosque.COR_NOME[0] + " verificando Pote " + (pote.get_num()) + " || " + pote.getMoedas()).toUpperCase());
//            if (pote.getMoedas() == 0) {
//                pote.add_1_moeda();
//                System.out.println("Cachorro " + Bosque.COR_NOME[0] + "Adicionou 1 moéda no pode " + pote.get_num());
//            }
//
//            if (pote_n == 19) {
//                pote_n = 0;
//            } else {
//                pote_n++;
//            }
//        } else {
//            future.cancel(false);
//            execService.shutdown();
//
//            try {
//                this.join();
//            } catch (InterruptedException ex) {
//            }
//        }
//    }
}
