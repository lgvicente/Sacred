<%-- 
    Document   : Register
    Created on : 17/08/2009, 14:20:55
    Author     : luciano.vicente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        import="br.com.sacred.RegisterUser"
        import="br.com.sacred.UserBean"
        import="br.com.sacred.ComponentPopulator"
        import="java.util.*"
        import="java.sql.*"
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
    <%
    UserBean currentUser = (UserBean) session.getAttribute("currentSessionUser");
    if (currentUser != null){
        out.println("You are already registered.");
        response.sendRedirect("SacredElement.jsp");
        }
    %>

    <div id="divregister">
    <form id="formregister">
        <table cellpadding=4 cellspacing=2 border=0 align="center">
        <th colspan=2>
        <font color="white" size=3>Registrarion</font>
        <br><font size=1><sup></sup></font><hr>
        </th>
        <tr><td valign=top>
        <font color="white" size="2">First Name<sup>*</sup></font>
        <br><input type="text" name="firstname" value="" size=15 maxlength=20>
        </td>
        <td valign=top>
            <font color="white" size="2">Last Name<sup>*</sup></font>
        <br><input type="text" name="surname" value="" size=15 maxlength=20></td>
        </tr><tr>
        <td valign=top>
            <font color="white" size="2">E-Mail<sup>*</sup></font>
        <br><input type="text" name="email" value="" size=25
        maxlength=125><br></td>
        <td valign=top>
        <font color="white" size="2">Adress<sup>*</sup></font><br>
        <input type="text" name="address" value="" size=25 maxlength=25></td>
        </tr>

        <tr>
            <td valign=top>
        <font color="white" size="2">Country<sup>*</sup></font>
        <br><%
            ComponentPopulator countryname = new ComponentPopulator();
            List<String> lista = countryname.countrylist();

            out.println("<select name='country' class='input'>");
            Iterator it = lista.iterator();

            while(it.hasNext()){
            String dados = (String) it.next();
             out.println("<option>" + dados + "</option>");
            }
            %>
            </td>
            <td valign=top>
        <font color="white" size="2">City<sup>*</sup></font>
        <br><input type="text" name="city" size=25 value=""
        maxlength=25>
            </td>
        </tr>
        <tr><td valign=top colspan=2>
        <font color="white" size="2">User Login<sup>*</sup></font><br>
        <input type="text" name="userId" size=10 value="" maxlength=10>
        </td></tr>
        <tr>
        <td valign=top>
            <font color="white" size="2">Password<sup>*</sup></font>
        <br><input type="password" name="password" size=10 value=""
        maxlength=10></td><td valign=top>
        <font color="white" size="2">Confirm Password<sup>*</sup></font>
        <br><input type="password" name="cpassword" size=10 value=""
        maxlength=10></td><br>
        <br><br>
        <tr>
        <td align=center colspan=2><hr>
        <input type="submit" value="Enviar" onClick="ajaxFormRegister();"></td></tr></table>
        </form>
      </div>

</body>
</html>
