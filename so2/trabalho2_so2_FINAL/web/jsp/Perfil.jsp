<%-- 
    Document   : Perfil
    Created on : Jun 17, 2019, 6:53:17 PM
    Author     : danas
--%>

<%@page import="servlets.PropretiesGetter"%>
<%@page import="usables.Entry"%>
<%@page import="usables.Allergy"%>
<%@page import="java.util.ArrayList"%>
<%@page import="usables.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Profile</title>
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.5.1/dist/leaflet.css"
              integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ=="
              crossorigin=""/>

        <script src="https://unpkg.com/leaflet@1.5.1/dist/leaflet.js"
                integrity="sha512-GffPMF3RvMeYyc1LWMHtK8EbPv0iNZ8/oTtHPx9/cc2ILxQ+u905qIwdpULaqDkyBKgOaB57QTMg7ztg8Jm2Og=="
                crossorigin="">

        </script>

        <style>

            #mapid { height: 600px; }
            #mapid { width: 600px; }


        </style>
    </head>
    <body>

        <jsp:include page="TopMenuPerfil.jsp" flush="true"/>
        <%@page import="database.DataBaseManager"%>
        <%
            PropretiesGetter propriedades = new PropretiesGetter();
            String host = propriedades.getProperties("host");
            String bd = propriedades.getProperties("bd");
            String username = propriedades.getProperties("user");
            String password = propriedades.getProperties("pw");
            DataBaseManager db = new DataBaseManager(host, bd, username, password);
            ArrayList<Allergy> allergies = db.getAllAllergy();
            User login = (User) session.getAttribute("login");
            ArrayList<Entry> entries = db.getEntryByUserID(login.getUserID());

        %>

        <div style="display:flex">
            <form style="margin-right: 5%" id="showAllergies" >
                <b>Your Allergies</b><br/>
                <%                ArrayList<Allergy> allergiesUser = login.getAllergies();
                    for (int i = 0; i < allergiesUser.size(); i++) {

                %>
                <label for="uname"><b><%=allergiesUser.get(i).getAllergyType()%></b></label></br>
                        <%}%>
            </form>

            <form >
                <input style="display:block" id="editAller" type="button"  name="perfil" value="Edit allergies" onclick="ShowEdit();"/>
            </form>

            <form id="registEdit" style="display:none;" action="../RegistEdit">
                <%
                    for (int i = 0; i < allergies.size(); i++) {
                %>
                <input id="allergyRegist" type="checkbox" name="Allergy<%=i%>" value="<%=allergies.get(i).getAllergyType()%>"> <%out.println(allergies.get(i).getAllergyType());%><br>

                <%}
                %>
                <input id="submit" type="submit" value="Regist" onclick="return HideEdit();"/>

            </form>
        </div>

        <div id="mapid" style="margin-top: 10px; margin-bottom: 10px; width:100%;"></div>

        <script>
            function ShowEdit() {
                document.getElementById('editAller').style.display = 'none';
                document.getElementById('registEdit').style.display = 'block';
            }

            function HideEdit() {
                document.getElementById('editAller').style.display = 'block';
                document.getElementById('registEdit').style.display = 'none';
            }

        </script>


        <script>

            var yellowIcon = new L.Icon({
                iconUrl: '../images/marker-icon-yellow.png',
                shadowUrl: '../images/marker-shadow.png',
                iconSize: [25, 41],
                iconAnchor: [12, 41],
                popupAnchor: [1, -34],
                shadowSize: [41, 41]
            });
            var blueIcon = new L.Icon({
                iconUrl: '../images/marker-icon-blue.png',
                shadowUrl: '../images/marker-shadow.png',
                iconSize: [25, 41],
                iconAnchor: [12, 41],
                popupAnchor: [1, -34],
                shadowSize: [41, 41]
            });
            var redIcon = new L.Icon({
                iconUrl: '../images/marker-icon-red.png',
                shadowUrl: '../images/marker-shadow.png',
                iconSize: [25, 41],
                iconAnchor: [12, 41],
                popupAnchor: [1, -34],
                shadowSize: [41, 41]
            });
            var greenIcon = new L.Icon({
                iconUrl: '../images/marker-icon-green.png',
                shadowUrl: '../images/marker-shadow.png',
                iconSize: [25, 41],
                iconAnchor: [12, 41],
                popupAnchor: [1, -34],
                shadowSize: [41, 41]
            });
            var violetIcon = new L.Icon({
                iconUrl: '../images/marker-icon-violet.png',
                shadowUrl: '../images/marker-shadow.png',
                iconSize: [25, 41],
                iconAnchor: [12, 41],
                popupAnchor: [1, -34],
                shadowSize: [41, 41]
            });

            var mymap = L.map('mapid').setView([38.573130, -7.905779], 15);
            L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token={accessToken}', {
                attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
                maxZoom: 18,
                id: 'mapbox.streets',
                accessToken: 'pk.eyJ1IjoiZGFuaWVsc2VycmFubyIsImEiOiJjanBiMGN3YXgwbGExM3BwMnB3cDh4Mmd0In0.59et0oF8fcigGQWouxalDw'
            }).addTo(mymap);

            <%
                if (entries != null) {
                    for (int i = 0; i < entries.size(); i++) {
                        String allergyType = db.getAllergyType(entries.get(i).getAllergyID());
                        if (i == entries.size() - 1) {

            %>
            mymap.setView([<%=entries.get(i).getLatitude()%>,<%=entries.get(i).getLongitude()%>], 15);

            <%
                }

                if (allergyType.equals("Platano")) {
            %>
            //String aux = "<%=allergyType%> \n Point ID: <%=entries.get(i).getEntryID()%>";
            var marker = L.marker([<%=entries.get(i).getLatitude()%>, <%=entries.get(i).getLongitude()%>], {icon: greenIcon}).addTo(mymap);
            marker.bindPopup("<center><%=allergyType%> <br> Point ID: <%=entries.get(i).getEntryID()%> <form id='DeleteEntryOnMap' action='../DeleteEntry'> <input id='tlong' type='hidden' name='Entry' value='<%=entries.get(i).getEntryID()%>'/> <input type='submit' name='EntryToDelete' value='Delete'><br> </form></center>").openPopup();
            <%} else if (allergyType.equals("Gramineas")) {

            %>
            var marker = L.marker([<%=entries.get(i).getLatitude()%>, <%=entries.get(i).getLongitude()%>], {icon: redIcon}).addTo(mymap);
            marker.bindPopup("<center><%=allergyType%> <br> Point ID: <%=entries.get(i).getEntryID()%> <form id='DeleteEntryOnMap' action='../DeleteEntry'> <input id='tlong' type='hidden' name='Entry' value='<%=entries.get(i).getEntryID()%>'/> <input type='submit' name='EntryToDelete' value='Delete'><br> </form></center>").openPopup();
            <%} else if (allergyType.equals("Oliveira")) {

            %>
            var marker = L.marker([<%=entries.get(i).getLatitude()%>, <%=entries.get(i).getLongitude()%>], {icon: blueIcon}).addTo(mymap);
            marker.bindPopup("<center><%=allergyType%> <br> Point ID: <%=entries.get(i).getEntryID()%> <form id='DeleteEntryOnMap' action='../DeleteEntry'> <input id='tlong' type='hidden' name='Entry' value='<%=entries.get(i).getEntryID()%>'/> <input type='submit' name='EntryToDelete' value='Delete'><br> </form></center>").openPopup();
            <%} else if (allergyType.equals("Azinheiro")) {

            %>
            var marker = L.marker([<%=entries.get(i).getLatitude()%>, <%=entries.get(i).getLongitude()%>], {icon: yellowIcon}).addTo(mymap);
            marker.bindPopup("<center><%=allergyType%> <br> Point ID: <%=entries.get(i).getEntryID()%> <form id='DeleteEntryOnMap' action='../DeleteEntry'> <input id='tlong' type='hidden' name='Entry' value='<%=entries.get(i).getEntryID()%>'/> <input type='submit' name='EntryToDelete' value='Delete'><br> </form></center>").openPopup();
            <%}

                    }

                }%>
            var popup = L.popup();

        </script>

        <form action="../DeleteEntries" id="deleteEntries" >
            <b>Your Entries</b><br/>
            <%
                if (session.getAttribute("userEntries") != null) {
                    for (int i = 0; i < entries.size(); i++) {
                        String AllergyType = db.getAllergyType(entries.get(i).getAllergyID());


            %>
            <input class="toCheck" type="checkbox" name="Entry<%=i%>" value="<%=entries.get(i).getEntryID()%>"><span style="color:blue">Id:</span> <%=entries.get(i).getEntryID()%><span style="color:blue">-> Latitude:</span> <%=entries.get(i).getLatitude()%> <span style="color:blue">Longitude: </span><%=entries.get(i).getLongitude()%> <span style="color:blue">Allergy Type:</span> <%=AllergyType%> <span style="color:blue">Date:</span> <%=entries.get(i).getEntrydate()%> <span style="color:blue">Code:</span> <%=entries.get(i).getUniqueCode()%><br> 
            <%}
                }%>
            <input type="checkbox" onClick="toggle(this)" /> Select All<br/>
            <input id="suobmit" type="submit" value="Delete Entries"/>
        </form>

        <script language="JavaScript">
            //funcao para selecionar todas as checkboxes
            function toggle(source) {
                checkboxes = document.getElementsByClassName('toCheck');
                for (var i = 0, n = checkboxes.length; i < n; i++) {
                    checkboxes[i].checked = source.checked;
                }
            }
        </script>



    </body>
</html>
