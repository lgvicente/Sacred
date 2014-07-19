/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sacred;

import java.sql.*;

/**
 *
 * @author luciano.vicente
 */
public class Enemyloot {

    public static ResultSet getEnemyLoot(int enemyid){

        Connection conn = null;
        ResultSet rs = null;
        String LootProc=null;
        Statement stmt = null;

        try
        {
            LootProc = "Call EnemyLoot("+enemyid+")";
            conn = ConectionDB.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(LootProc);

        }
        catch (Exception e){
            System.out.println(e);
        }
        return rs;
    }

        public static int[] oldloot()
        {

        int enemyid = 1;
        long prob;
        int food = 0;
        int gold = 0;
        int item = 0;
        int[] loot;
        loot = new int[3];
//
        prob = Math.round(Math.random()*100);

        if(enemyid == 1){
            if(prob > 2){
                gold = Math.round(prob/25);
                if(prob > 35){
                    food = 1;
                    if(prob > 83){
                        item = 1;
                    }
                }
            }
        }
        loot[0] = gold;
        loot[1] = food;
        loot[2] = item;

        return loot;
    }

}
