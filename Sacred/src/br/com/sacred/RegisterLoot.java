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
public class RegisterLoot extends HttpServlet{

public void init(ServletConfig config) throws ServletException{
super.init(config);
}
public void doPost(HttpServletRequest req, HttpServletResponse res)
throws ServletException, IOException{

        Connection conn = null;
        String enemy = req.getParameter("enemy");
        String item = req.getParameter("item");
        String qtd = req.getParameter("qtd");
        String prob = req.getParameter("prob");

        //enemy,item,Qtd,Prob
        String newloot="CALL proc_NewLoot(?,?,?,?);";

        try
      {
            conn = ConectionDB.getConnection();
            PreparedStatement pst = conn.prepareStatement(newloot);
            pst.setString(1, enemy);
            pst.setString(2, item);
            pst.setString(3, qtd);
            pst.setString(4, prob);
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
