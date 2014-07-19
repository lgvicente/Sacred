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
public class RegisterItem extends HttpServlet{

public void init(ServletConfig config) throws ServletException{
super.init(config);
}
public void doPost(HttpServletRequest req, HttpServletResponse res)
throws ServletException, IOException{

        Connection conn = null;
        String itemname = req.getParameter("itemname");
        String itemvalue = req.getParameter("value");
        String itemdesc = req.getParameter("description");
        String itemlevel = req.getParameter("level");
        String itemtype = req.getParameter("type");
        String classname = req.getParameter("class");
        String itemrarity = req.getParameter("rarity");
        String dps = req.getParameter("dps");
        String armor = req.getParameter("armor");
        String str = req.getParameter("str");
        String sta = req.getParameter("sta");
        String agi = req.getParameter("agi");
        String inte = req.getParameter("inte");
        String spr = req.getParameter("spr");
        String heal = req.getParameter("heal");
        String spellpower = req.getParameter("sp");

        //itemname,itemvalue,itemdesc,itemlevel,itemtype,class,itemrarity,str,sta,agi,inte,spr,dps,armor,heal,spellpower
        String newitem="CALL proc_NewItem(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        String newattribute="CALL proc_NewAttribute(?,?,?,?,?,?,?,?,?);";
        String attributeval = "Select * from itemattribute where "+
                "dps = "+dps+" "+
                "and armor = "+armor+" "+
                "and heal = "+heal+" "+
                "and spellpower = "+spellpower+" "+
                "and str = "+str+" "+
                "and sta = "+sta+" "+
                "and agi = "+agi+" "+
                "and inte = "+inte+" "+
                "and spr = "+spr;

        try
      {
            conn = ConectionDB.getConnection();
            PreparedStatement pst = conn.prepareStatement(newitem);
            PreparedStatement pst2 = conn.prepareStatement(newattribute);
            Statement stmt = null;
            ResultSet rs = null;
            stmt=conn.createStatement();
            rs = stmt.executeQuery(attributeval);

            // verifica se o atributo já existe, senão cria um novo
            boolean first = false;
            first = rs.first();

            if (first == false){

            pst2.setString(1, dps);
            pst2.setString(2, armor);
            pst2.setString(3, str);
            pst2.setString(4, sta);
            pst2.setString(5, agi);
            pst2.setString(6, inte);
            pst2.setString(7, spr);
            pst2.setString(8, heal);
            pst2.setString(9, spellpower);
            pst2.executeUpdate();
            pst2.close();

            }

            pst.setString(1, itemname);
            pst.setString(2, itemvalue);
            pst.setString(3, itemdesc);
            pst.setString(4, itemlevel);
            pst.setString(5, itemtype);
            pst.setString(6, classname);
            pst.setString(7, itemrarity);
            pst.setString(8, str);
            pst.setString(9, sta);
            pst.setString(10, agi);
            pst.setString(11, inte);
            pst.setString(12, spr);
            pst.setString(13, dps);
            pst.setString(14, armor);
            pst.setString(15, heal);
            pst.setString(16, spellpower);
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
