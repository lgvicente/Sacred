/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sacred;

   import java.sql.*;

   public class HeroDAO
   {
      static Connection currentCon = null;
      static ResultSet rs = null;



      public static HeroBean hero(HeroBean bean, String username) {

         //preparing some objects for connection
         Statement stmt = null;

         String searchQuery =
                "select * from "+
                "user u "+
                "inner join userhero uh on "+
                "uh.userid = u.userid "+
                "inner join hero h on "+
                "h.heroid = uh.heroid "+
                "inner join HeroAttribute ha on "+
                "h.heroid = ha.heroid "+
                "inner join class cl on "+
                "cl.classId = h.classid "+
                "where "+
                "u.userlogin='"+ username+"'";

      // "System.out.println" prints in the console; Normally used to trace the process
      try
      {
         //connect to DB
         currentCon = ConectionDB.getConnection();
         stmt=currentCon.createStatement();
         rs = stmt.executeQuery(searchQuery);
         boolean more = rs.next();

         // if user does not exist set the isValid variable to false
         if (!more)
         {
            System.out.println("Sorry, you are not a registered user! Please sign up first");
            bean.setValid(false);
         }

         //if user exists set the isValid variable to true
         else if (more)
         {
            String heroname = rs.getString("heroname");
            String herohp = rs.getString("herohp");
            String heromana = rs.getString("heromana");
            String heroclass = rs.getString("ClassName");
            String herostr = rs.getString("herostr");
            String herosta = rs.getString("herosta");
            String heroagi = rs.getString("heroagi");
            String heroint = rs.getString("heroint");
            String herospr = rs.getString("herospr");
            String herolevel = rs.getString("herolevel");
            String heroexp = rs.getString("heroexp");
            String heromaxhp = rs.getString("heromaxhp");
            String heromaxmana = rs.getString("heromaxmana");
            String damage = rs.getString("herodps");
            String armor = rs.getString("heroarmor");
            String heal = rs.getString("heroheal");
            String spellpower = rs.getString("herosp");

            bean.setHeroName(heroname);
            bean.setHerohp(herohp);
            bean.setHeromana(heromana);
            bean.setHeroClass(heroclass);
            bean.setHeroStr(herostr);
            bean.setHeroSta(herosta);
            bean.setHeroAgi(heroagi);
            bean.setHeroInt(heroint);
            bean.setHeroSpr(herospr);
            bean.setHeroLevel(herolevel);
            bean.setHeroExp(heroexp);
            bean.setHeroMaxHP(heromaxhp);
            bean.setHeroMaxMana(heromaxmana);
            bean.setHeroDPS(damage);
            bean.setHeroArmor(armor);
            bean.setHeroHeal(heal);
            bean.setHeroSP(spellpower);
            bean.setValid(true);
         }
      }

      catch (Exception ex)
      {
         System.out.println("Log In failed: An Exception has occurred! " + ex);
      }

      //some exception handling
      finally
      {
         if (rs != null)	{
            try {
               rs.close();
            } catch (Exception e) {}
               rs = null;
            }

         if (stmt != null) {
            try {
               stmt.close();
            } catch (Exception e) {}
               stmt = null;
            }

         if (currentCon != null) {
            try {
               currentCon.close();
            } catch (Exception e) {
            }

            currentCon = null;
         }
      }

return bean;

      }
   }
