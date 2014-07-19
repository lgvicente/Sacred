/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sacred;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author luciano.vicente
 */
public class RegisterEnemy extends HttpServlet{

public void init(ServletConfig config) throws ServletException{
super.init(config);
}
public void doPost(HttpServletRequest req, HttpServletResponse res)
throws ServletException, IOException{

        Connection conn = null;
        String monstername = req.getParameter("enemyname");
        String enemytype = req.getParameter("type");
        String enemylevel = req.getParameter("level");
        String exp = req.getParameter("exp");
        String mana = req.getParameter("mana");
        String hp = req.getParameter("hp");
        String dps = req.getParameter("dps");
        String armor = req.getParameter("armor");
        String str = req.getParameter("str");
        String sta = req.getParameter("sta");
        String agi = req.getParameter("agi");
        String inte = req.getParameter("inte");
        String spr = req.getParameter("spr");
        String heal = req.getParameter("heal");
        String spellpower = req.getParameter("sp");

        //monstername,enemytype,enemylevel,str,sta,agi,inte,spr,exp,mana,armor,dps,heal,spellpower,hp
        String newmonster="CALL proc_NewMonster(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

        try
      {
            conn = ConectionDB.getConnection();
            PreparedStatement pst = conn.prepareStatement(newmonster);
            pst.setString(1, monstername);
            pst.setString(2, enemytype);
            pst.setString(3, enemylevel);
            pst.setString(4, str);
            pst.setString(5, sta);
            pst.setString(6, agi);
            pst.setString(7, inte);
            pst.setString(8, spr);
            pst.setString(9, exp);
            pst.setString(10, mana);
            pst.setString(11, armor);
            pst.setString(12, dps);
            pst.setString(13, heal);
            pst.setString(14, spellpower);
            pst.setString(15, hp);
            pst.executeUpdate();
            pst.close();
            res.sendRedirect("Logged.jsp");
      }

        catch(SQLException e){
        System.out.println("SQLException caught: " + e.getMessage());
        }
        catch (Exception e){
        System.out.println(e);
        }
    }
}
