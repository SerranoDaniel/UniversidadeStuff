<%-- 
    Document   : topMenu
    Created on : Jun 15, 2019, 7:02:41 PM
    Author     : danas
--%>

<%@page import="servlets.PropretiesGetter"%>
<%@page import="usables.Allergy"%>
<%@page import="java.util.ArrayList"%>
<%@page import="usables.User"%>
<%@page language="java" contentType="text/html"%>
<!DOCTYPE html>

<%@page import="database.DataBaseManager"%>
<%PropretiesGetter propriedades = new PropretiesGetter();
        String host = propriedades.getProperties("host");
        String bd = propriedades.getProperties("bd");
        String username = propriedades.getProperties("user");
        String password = propriedades.getProperties("pw");
        DataBaseManager db = new DataBaseManager(host, bd, username, password);
    ArrayList<Allergy> allergies = db.getAllAllergy();

%>

<div style="margin-left: 30%">
    <form id="loginform" style="display: block;" action="LoginServlet" >
        <label for="uname"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="uname" required>

        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" required>
        <input id="submit" type="submit" value="Login"/>

        <input id="firstRegist" type="submit" value="Regist" onclick="return showRegist();" />
    </form>

    <br>


    <form id="registform" style="display: none;" action="RegistServlet" >
        <label for="uname"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="unameR" required>

        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="pswR" required>

        <br>

        <script>
            function showRegist() {
                document.getElementById('registform').style.display = 'block';

                document.getElementById('firstRegist').style.display = 'none';
            }

        </script>
        <%                for (int i = 0; i < allergies.size(); i++) {
        %>
        <input style="margin-left: 21%" id="allergyRegist" type="checkbox" name="Allergy<%=i%>" value="<%=allergies.get(i).getAllergyType()%>"> <%out.println(allergies.get(i).getAllergyType());%><br>
        <%}
        %>
        <input style="margin-left: 23%" id="submit" type="submit" value="Regist" />
    </form>
    <br>

</div>
