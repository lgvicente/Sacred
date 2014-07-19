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
public class FightAttributes {

    public static String[] getheroattributes(String login){

        Connection conn = null;
        String[] hattributes;
        hattributes = new String[11];
        Statement stmt = null;
        ResultSet rs = null;
        String HeroQuery=null;

        hattributes[0] = "HP";
        hattributes[1] = "Mana";
        hattributes[2] = "Level";
        hattributes[3] = "Strength";
        hattributes[4] = "Stamina";
        hattributes[5] = "Agility";
        hattributes[6] = "Intelligence";
        hattributes[7] = "Spirit";
        hattributes[8] = "Damage";
        hattributes[9] = "Armor";
        hattributes[10] = "HeroName";

        HeroQuery = "Select * from HeroAttribute where userlogin = '"+login+"'";

        try
      {
         //connect to DB
         conn = ConectionDB.getConnection();
         stmt=conn.createStatement();
         rs = stmt.executeQuery(HeroQuery);
//         boolean more = rs.next();

         while (rs.next())
         {
            hattributes[0] = rs.getString("HP");
            hattributes[1] = rs.getString("Mana");
            hattributes[2] = rs.getString("herolevel");
            hattributes[3] = rs.getString("Str");
            hattributes[4] = rs.getString("Sta");
            hattributes[5] = rs.getString("Agi");
            hattributes[6] = rs.getString("Inte");
            hattributes[7] = rs.getString("Spr");
            hattributes[8] = rs.getString("Dps");
            hattributes[9] = rs.getString("Armor");
            hattributes[10] = rs.getString("heroname");
         }
      }

      catch (Exception ex)
      {
         System.out.println("Log In failed: An Exception has occurred! " + ex);
      }

        return hattributes;
    }
        public static String[] getenemyattributes(int enemyid){

        Connection conn = null;
        String[] eattributes;
        eattributes = new String[12];
        Statement stmt = null;
        ResultSet rs = null;
        String HeroQuery=null;

        eattributes[0] = "HP";
        eattributes[1] = "Mana";
        eattributes[2] = "Level";
        eattributes[3] = "Strength";
        eattributes[4] = "Stamina";
        eattributes[5] = "Agility";
        eattributes[6] = "Intelligence";
        eattributes[7] = "Spirit";
        eattributes[8] = "Damage";
        eattributes[9] = "Armor";
        eattributes[10] = "Enemy Name";
        eattributes[11] = "Exp";

        HeroQuery = "Select * from enemy where enemyid = "+enemyid;

        try
      {
         //connect to DB
         conn = ConectionDB.getConnection();
         stmt=conn.createStatement();
         rs = stmt.executeQuery(HeroQuery);
//         boolean more = rs.next();

         while (rs.next())
         {
            eattributes[0] = rs.getString("enemyhp");
            eattributes[1] = rs.getString("enemymana");
            eattributes[2] = rs.getString("enemylevel");
            eattributes[3] = rs.getString("enemystr");
            eattributes[4] = rs.getString("enemysta");
            eattributes[5] = rs.getString("enemyagi");
            eattributes[6] = rs.getString("enemyint");
            eattributes[7] = rs.getString("enemyspr");
            eattributes[8] = rs.getString("enemydps");
            eattributes[9] = rs.getString("enemyarmor");
            eattributes[10] = rs.getString("Enemyname");
            eattributes[11] = rs.getString("enemyexp");
         }
      }

      catch (Exception ex)
      {
         System.out.println("Log In failed: An Exception has occurred! " + ex);
      }

        return eattributes;
    }

        public static boolean getStatus(String login){

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String UserStatus=null;
        boolean rsval = false;

        UserStatus = "Select * from currentcombat where user = '"+login+"'";

        try
      {
         conn = ConectionDB.getConnection();
         stmt=conn.createStatement();
         rs = stmt.executeQuery(UserStatus);

         rsval = rs.first();

         rs.close();
         stmt.close();
      }

      catch (Exception ex)
      {
         System.out.println(ex);
      }

        return rsval;
    }

        public static String[] getCurrentFight(String login){

        Connection conn = null;
        Statement stmt = null;
        ResultSet rscf = null;
        String currentfight=null;
        String[] fightdata;
        fightdata = new String[3];

        currentfight = "select * from view_currentcombat where user = '"+login+"'";

        try
      {
         conn = ConectionDB.getConnection();
         stmt=conn.createStatement();
         rscf = stmt.executeQuery(currentfight);
         rscf.first();

         System.out.println(rscf.getFloat("enemyid"));

         fightdata[0] = rscf.getString("enemyid");
         fightdata[1] = rscf.getString("dmgtaken");
         fightdata[2] = rscf.getString("currenttime");

         rscf.close();
         stmt.close();
      }

      catch(SQLException e){
        System.out.println("SQLException caught: " + e.getMessage());
        }
        catch (Exception e){
        System.out.println(e);
        }

        return fightdata;
    }
        public void startmission(String dmgtaken, String login, String time, String enemyid){

        Connection conn = null;
        String createcombat="Call proc_currentcombat(?,?,?,?)";

        try
      {
            conn = ConectionDB.getConnection();
            PreparedStatement pst = conn.prepareStatement(createcombat);
            pst.setString(1, login);
            pst.setString(2, enemyid);
            pst.setString(3, dmgtaken);
            pst.setString(4, time);
            pst.executeUpdate();
            pst.close();
      }

        catch(SQLException e){
        System.out.println("SQLException caught: " + e.getMessage());
        }
        catch (Exception e){
        System.out.println(e);
        }
    }
        public void endmission(String login){

        Connection conn = null;
        String endmission="delete from currentcombat where user = '"+login+"'";

        try
      {
            conn = ConectionDB.getConnection();
            PreparedStatement pst = conn.prepareStatement(endmission);
            pst.executeUpdate();
            pst.close();
      }

        catch(SQLException e){
        System.out.println("SQLException caught: " + e.getMessage());
        }
        catch (Exception e){
        System.out.println(e);
        }
    }

}
