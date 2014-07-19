/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sacred;

import java.sql.*;

public class ResultLogic{

    public void lifemana(String dmgtaken, String login, String exp){

        Connection conn = null;
        String lifemana="Call proc_updatehero(?,?,?)";

        try
      {
            conn = ConectionDB.getConnection();
            PreparedStatement pst = conn.prepareStatement(lifemana);
            pst.setString(1, dmgtaken);
            pst.setString(2, login);
            pst.setString(3, exp);
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

    public void upitens(String Qtd, String userLogin){

        Connection conn = null;
        String upitem="Call proc_upBattleItens(?,?)";

        try
      {
            conn = ConectionDB.getConnection();
            PreparedStatement pst = conn.prepareStatement(upitem);
            pst.setString(1, Qtd);
            pst.setString(2, userLogin);
            pst.executeUpdate();
            pst.close();
      }

        catch(SQLException e){
        System.out.println(e.getMessage());
        }
        catch (Exception e){
        System.out.println(e);
        }
    }

    public void initens(String Qtd, String Item, String userlogin){

        Connection conn = null;
        String initem="Call proc_inBattleItens(?,?,?)";

        try
      {
            conn = ConectionDB.getConnection();
            PreparedStatement pst = conn.prepareStatement(initem);
            pst.setString(1, Qtd);
            pst.setString(2, Item);
            pst.setString(3, userlogin);
            pst.executeUpdate();
            pst.close();
      }

        catch(SQLException e){
        System.out.println(e.getMessage());
        }
        catch (Exception e){
        System.out.println(e);
        }
    }

    public void uplost(String userlogin){

        Connection conn = null;
        String uplost="Call proc_upLost(?)";

        try
      {
            conn = ConectionDB.getConnection();
            PreparedStatement pst = conn.prepareStatement(uplost);
            pst.setString(1, userlogin);
            pst.executeUpdate();
            pst.close();
      }

        catch(SQLException e){
        System.out.println(e.getMessage());
        }
        catch (Exception e){
        System.out.println(e);
        }
    }

    public void levelup(String login, String heroname, String classid){

        Connection conn = null;
        String levelup="Call proc_levelup(?,?)";
        ResultSet rs = null;
        Statement stmt = null;
        String compQuery = "select "+
                           "max(level) as nlevel, "+
                           "(select herolevel from hero where heroname = '"+heroname+"') as alevel "+
                           "from "+
                           "levelup "+
                           "where "+
                           "expneeded <= (select heroexp from hero where heroname = '"+heroname+"')";

        try
        {
            conn = ConectionDB.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(compQuery);
            rs.beforeFirst();

            while (rs.next()){
                int nlevel = Integer.parseInt(rs.getString("nlevel"));
                int alevel = Integer.parseInt(rs.getString("alevel"));
                if (nlevel > alevel){
                    PreparedStatement pst = conn.prepareStatement(levelup);
                    pst.setString(1, login);
                    pst.setString(2, classid);
                    pst.executeUpdate();
                    pst.close();
                }
            }
            rs.close();
        }
        catch(SQLException e){
        System.out.println(e.getMessage());
        }
        catch (Exception e){
        System.out.println(e);
        }
    }

       public void churchok(String heroname){

        Connection conn = null;
        String churchok="Call proc_church(?)";

        try
      {
            conn = ConectionDB.getConnection();
            PreparedStatement pst = conn.prepareStatement(churchok);
            pst.setString(1, heroname);
            pst.executeUpdate();
            pst.close();
      }

        catch(SQLException e){
        System.out.println(e.getMessage());
        }
        catch (Exception e){
        System.out.println(e);
        }
    }
}
