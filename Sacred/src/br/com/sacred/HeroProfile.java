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
public class HeroProfile {

    public static String[] getheroprofile(String login){

        Connection conn = null;
        String[] profile;
        profile = new String[21];
        Statement stmt = null;
        ResultSet rs = null;
        String HeroQuery=null;

        profile[0] = "heroname";
        profile[1] = "Head";
        profile[2] = "Neck";
        profile[3] = "Back";
        profile[4] = "Shoulder";
        profile[5] = "Chest";
        profile[6] = "Wrist";
        profile[7] = "Hand";
        profile[8] = "Waist";
        profile[9] = "Leg";
        profile[10] = "Feet";
        profile[11] = "Ring";
        profile[12] = "Ring";
        profile[13] = "Main Hand";
        profile[14] = "Off Hand";
        profile[15] = "herolevel";
        profile[16] = "herostr";
        profile[17] = "herosta";
        profile[18] = "heroagi";
        profile[19] = "heroint";
        profile[20] = "herospr";

        HeroQuery = "Select * from HeroProfile where userlogin = '"+login+"'";

        try
      {
         //connect to DB
         conn = ConectionDB.getConnection();
         stmt=conn.createStatement();
         rs = stmt.executeQuery(HeroQuery);
//         boolean more = rs.next();

         while (rs.next())
         {
            profile[0] = rs.getString("heroname");
            profile[15] = rs.getString("herolevel");
            profile[16] = rs.getString("herostr");
            profile[17] = rs.getString("herosta");
            profile[18] = rs.getString("heroagi");
            profile[19] = rs.getString("heroint");
            profile[20] = rs.getString("herospr");

            if(rs.getString("slotname").equals("Head")){
                    profile[1] = rs.getString("itemname");
            }
            if(rs.getString("slotname").equals("Neck")){
                    profile[2] = rs.getString("itemname");
            }
            if(rs.getString("slotname").equals("Back")){
                    profile[3] = rs.getString("itemname");
            }
            if(rs.getString("slotname").equals("Shoulder")){
                    profile[4] = rs.getString("itemname");
            }
            if(rs.getString("slotname").equals("Chest")){
                    profile[5] = rs.getString("itemname");
            }
            if(rs.getString("slotname").equals("Wrist")){
                    profile[6] = rs.getString("itemname");
            }
            if(rs.getString("slotname").equals("Hand")){
                    profile[7] = rs.getString("itemname");
            }
            if(rs.getString("slotname").equals("Waist")){
                    profile[8] = rs.getString("itemname");
            }
            if(rs.getString("slotname").equals("Leg")){
                    profile[9] = rs.getString("itemname");
            }
            if(rs.getString("slotname").equals("Feet")){
                    profile[10] = rs.getString("itemname");
            }
            if(rs.getString("slotname").equals("Right Ring")){
                    profile[11] = rs.getString("itemname");
            }
            if(rs.getString("slotname").equals("Left Ring")){
                    profile[12] = rs.getString("itemname");
            }
            if(rs.getString("slotname").equals("Main Hand")){
                    profile[13] = rs.getString("itemname");
            }
            if(rs.getString("slotname").equals("Off Hand")){
                    profile[14] = rs.getString("itemname");
            }
         }
      }

      catch (Exception ex)
      {
         System.out.println("Log In failed: An Exception has occurred! " + ex);
      }

        return profile;
    }

    public static String[] getheroinventory(String login, int pag){

        Connection conn = null;
        String[] inventory;
        inventory = new String[18];
        Statement stmt = null;
        ResultSet rs = null;
        String InventoryQuery=null;

        inventory[0] = " ";
        inventory[1] = " ";
        inventory[2] = " ";
        inventory[3] = " ";
        inventory[4] = " ";
        inventory[5] = " ";
        inventory[6] = " ";
        inventory[7] = " ";
        inventory[8] = " ";
        inventory[9] = " ";
        inventory[10] = " ";
        inventory[11] = " ";
        inventory[12] = " ";
        inventory[13] = " ";
        inventory[14] = " ";
        inventory[15] = " ";
        inventory[16] = " ";
        inventory[17] = " ";

        if (pag == 1){
        InventoryQuery = "select "+
                    "he.* ,"+
                    "i.itemname "+
                    "from "+
                    "HeroEquip he "+
                    "inner join item i on "+
                    "he.itemid = i.itemid "+
                    "where "+
                    "SlotID between 17 and 34 "+
                    "and he.heroid in (select heroid from heroprofile where userlogin = '"+login+"')";
        }
        if (pag == 2){
        InventoryQuery = "select "+
                    "he.* ,"+
                    "i.itemname "+
                    "from "+
                    "HeroEquip he "+
                    "inner join item i on "+
                    "he.itemid = i.itemid "+
                    "where "+
                    "SlotID between 35 and 52 "+
                    "and he.heroid in (select heroid from heroprofile where userlogin = '"+login+"')";
        }
        if (pag == 3){
        InventoryQuery = "select "+
                    "he.* ,"+
                    "i.itemname "+
                    "from "+
                    "HeroEquip he "+
                    "inner join item i on "+
                    "he.itemid = i.itemid "+
                    "where "+
                    "SlotID between 52 and 70 "+
                    "and he.heroid in (select heroid from heroprofile where userlogin = '"+login+"')";
        }

        try
      {
         //connect to DB
         conn = ConectionDB.getConnection();
         stmt=conn.createStatement();
         rs = stmt.executeQuery(InventoryQuery);
         int i = 0;
//         boolean more = rs.next();

         while (rs.next())
         {
            inventory[i] = rs.getString("itemname");
            i = i + 1;
         }
      }

      catch (Exception ex)
      {
         System.out.println("" + ex);
      }

        return inventory;
    }

}
