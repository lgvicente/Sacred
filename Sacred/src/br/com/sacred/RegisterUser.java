/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sacred;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class RegisterUser extends HttpServlet{
public void init(ServletConfig config) throws ServletException{
super.init(config);
}
public void doGet(HttpServletRequest req, HttpServletResponse res)
throws ServletException, IOException{

    ConectionDB conn = new ConectionDB();
    ResultSet rs = null;
    Statement stmt = null;

    Connection connection=null;
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
    String UserId = req.getParameter("userId");
    String fname = req.getParameter("firstname");
    String sname = req.getParameter("surname");
    String email = req.getParameter("email");
    String address = req.getParameter("address");
    String country = req.getParameter("country");
    String city = req.getParameter("city");
    String password = req.getParameter("password");
    Integer cont = 0;

    try {
    String sql = "Call userregister (?,?,?,?,?,?,?,?,?)";
    String sql_valid = "Select * from user where userlogin like '"+UserId+"'";
    connection = conn.getConnection();
    stmt=connection.createStatement();
    try{
        rs = stmt.executeQuery(sql_valid);
        rs.last();
        cont = rs.getRow();
    }
    catch(Exception e){
        out.println(e);
    }
    if(cont > 0)
        res.sendRedirect("herocreation.jsp?UserId="+UserId);
    else {
    PreparedStatement pst = connection.prepareStatement(sql);
    pst.setString(1, fname);
    pst.setString(2, sname);
    pst.setString(3, email);
    pst.setString(4, address);
    pst.setString(5, country);
    pst.setString(6, city);
    pst.setString(7, "0");
    pst.setString(8, UserId);
    pst.setString(9, password);
    int numRowsChanged = pst.executeUpdate();
    //implementar tratamento se o usuario já existe
    res.sendRedirect("herocreation.jsp?UserId="+UserId);
    pst.close();
      }
    }
    catch(SQLException e){
    out.println("SQLException caught: " + e.getMessage());
    }
    catch (Exception e){
    out.println(e);
    }
        finally {

            try {
            if (conn != null) connection.close();
                }
            catch (SQLException ignored){
            out.println(ignored);
            }
        }
    }

    public void delhero(String login){
        Connection conn = null;
        String delhero="CALL proc_delhero(?)";

        try
      {
            conn = ConectionDB.getConnection();
            PreparedStatement pst = conn.prepareStatement(delhero);
            pst.setString(1, login);
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