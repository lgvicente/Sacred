/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sacred;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class SendMessage extends HttpServlet{
public void init(ServletConfig config) throws ServletException{
super.init(config);
}
public void doPost(HttpServletRequest req, HttpServletResponse res)
throws ServletException, IOException{

    ConectionDB conn = new ConectionDB();

    Connection connection=null;
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
    String MailTo = req.getParameter("txtMailto");
    String MailFrom = req.getParameter("txtMailFrom");
    String MailBody = req.getParameter("txaMessage");
    String MailSub = req.getParameter("txtMailsub");

    try {
    String newmessage = "Call proc_NewMessage (?,?,?,?)";
    connection = conn.getConnection();
    PreparedStatement pst = connection.prepareStatement(newmessage);
    pst.setString(1, MailFrom);
    pst.setString(2, MailTo);
    pst.setString(3, MailSub);
    pst.setString(4, MailBody);
    pst.executeUpdate();
    //implementar tratamento se o usuario já existe
    res.sendRedirect("mail.jsp");
    pst.close();
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
}
