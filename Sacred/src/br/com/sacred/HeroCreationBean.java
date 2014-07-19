/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sacred;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HeroCreationBean extends HttpServlet{
public void init(ServletConfig config) throws ServletException{
super.init(config);
}
public void doPost(HttpServletRequest req, HttpServletResponse res)
throws ServletException, IOException{

ConectionDB conn = new ConectionDB();
//HttpSession session = req.getSession(true);
//UserBean currentuser = (UserBean) session.getAttribute("currentSessionUser");
Connection connection=null;
res.setContentType("text/html");
PrintWriter out = res.getWriter();
String heroname = req.getParameter("heroname");
String login = null;
Statement stmt = null;

String classid = req.getParameter("class");

if (classid == null){
    res.sendRedirect("herocriationerropage.jsp");
}
try {
login = req.getParameter("user");
//currentuser.getUsername();
String sql = "Call userherocreation (?,?,?)";
String sql2 = "Call userheropart2 (?,?)";
String sql3 = "Call userheropart3 (?)";
String sql4 = "Call userheropart4 (?)";

connection = conn.getConnection();
PreparedStatement pst = connection.prepareStatement(sql);
pst.setString(1, classid);
pst.setString(2, heroname);
pst.setString(3, login);
PreparedStatement pst2 = connection.prepareStatement(sql2);
pst2.setString(1, heroname);
pst2.setString(2, login);
PreparedStatement pst3 = connection.prepareStatement(sql3);
pst3.setString(1, heroname);
PreparedStatement pst4 = connection.prepareStatement(sql4);
pst4.setString(1, heroname);

pst.executeUpdate();
pst2.executeUpdate();
pst3.executeUpdate();
pst4.executeUpdate();

//implementar tratamento se o usuario já existe
res.sendRedirect("SacredElement.jsp");
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