/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sacred;

import java.util.HashMap;

public class Cronometro implements Runnable {
    private static HashMap<String,Long> mapa;
    static {
        mapa = new HashMap<String,Long>();
    }
    public static void marcaTempo(String key) {
        mapa.put(key,Long.valueOf(System.currentTimeMillis()));
    }
    public static void mostraTempo(String key) {
        long tempoDecorrido = System.currentTimeMillis() - mapa.get(key);
        System.out.println(key+": "+tempoDecorrido+" milisegundos");
    }
    public static void main(String args[]) {
        Cronometro t = new Cronometro();
        t.run();
    }
    public void run() {
        Cronometro.marcaTempo("marcador");
        for(int i=0;i< 10;i++) {
            try {
                Thread.sleep(1000);
            } catch(Exception e) {
                System.out.println(e.toString());
            }
            Cronometro.mostraTempo("marcador");
        }
    }
}