/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sacred;

//import java.math.*;

/**
 *
 * @author luciano.vicente
 */
public class RandomEnemy {

    public static int getEnemyID(String local){
        long prob;
        int enemyid = 0;
        prob = Math.round(Math.random()*100);
        // Proteus - Training Village (1 - 10)
        if(local.equals("1")){
            if(prob >= 25)
                enemyid = 1;            
            if(prob < 25)
                enemyid = 2;
        }

        if(local.equals("2")){
            if(prob >= 50)
                enemyid = 3;
            if(prob < 50)
                enemyid = 4;
        }

        if(local.equals("3")){
            if(prob >= 40)
                enemyid = 5;
            if(prob < 40)
                enemyid = 6;
        }

        if(local.equals("4")){
            if(prob >= 50)
                enemyid = 7;
            if(prob < 50)
                enemyid = 8;
        }

        // Proteus - Shielded Forest (11 - 20)
        if(local.equals("5")){
            if(prob >= 25)
                enemyid = 9;
            if(prob < 25)
                enemyid = 10;
        }

        if(local.equals("6")){
            if(prob >= 50)
                enemyid = 11;
            if(prob < 50)
                enemyid = 12;
        }

        if(local.equals("7")){
            if(prob >= 40)
                enemyid = 10;
            if(prob < 40)
                enemyid = 13;
        }

        if(local.equals("8")){
            if(prob >= 10)
                enemyid = 14;
            if(prob < 10)
                enemyid = 15;
        }

        return enemyid;
    }
//dependendo do inimigo selecionado aqui, irá buscar os atributos
//em um tabela. Os valores serão fixos.
}
