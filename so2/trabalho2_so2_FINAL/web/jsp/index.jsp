<%-- 
    Document   : index
    Created on : Jun 16, 2019, 6:14:15 PM
    Author     : danas
--%>

<%@page import="servlets.PropretiesGetter"%>
<%@page import="usables.Entry"%>
<%@page import="java.util.ArrayList"%>
<%@page import="usables.Allergy"%>
<%@page import="usables.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Urban Jogging And Allergies</title>

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
    <body>

        <%@page import="database.DataBaseManager"%>
        <%
            PropretiesGetter propriedades = new PropretiesGetter();
            String host = propriedades.getProperties("host");
            String bd = propriedades.getProperties("bd");
            String username = propriedades.getProperties("user");
            String password = propriedades.getProperties("pw");
            DataBaseManager db = new DataBaseManager(host, bd, username, password);
            ArrayList<Allergy> allergies = db.getAllAllergy();
            ArrayList<Entry> entries = (ArrayList<Entry>) session.getAttribute("markers");

            //Manda alert caso a sessao usercheck seja falsa pois significa que o registo com o username ja esta em uso
            if (session.getAttribute("userCheck") != null) {
                boolean check = (boolean) session.getAttribute("userCheck");
                if (check == false) {
        %>

        <script>
            alert("Username already in use");
        </script>

        <%
                    session.setAttribute("userCheck", true);
                }
            }

            //Envia alert caso a sessao login invalid esteja a true pois significa que os dados inseridos estao incorretos
            if (session.getAttribute("loginInvalid") != null) {
                boolean check2 = (boolean) session.getAttribute("loginInvalid");
                if (check2) {
        %>

        <script>
            alert("Username or password invalid");
        </script>

        <%
                    session.setAttribute("loginInvalid", false);
                }
            }

            //Virifica se a sessao login é diferente de null, caso seja significa que ha user logado, logo,
            //Serao mostradas as opcoes que um user tem de acordo com o pedido no enunciado pelo prof
            User login = (User) session.getAttribute("login");
            if (login != null) {

        %>
        <!-- user esta logado logo ira mostrar a pagina "loggedinMenu" que contem o butao de ir para o perfil e de logout
            E ira mostrar tbm as opcoes de escolher um local para ir "form id chooselocal", de escolher os markers a serem mostrados no mapa
            E e a opcao de registar uma nova entry "form id allergy regist" -->
        <jsp:include page="LoggedInMenu.jsp" flush="true"/>
        <div id="loggedInOptions" style="display: flex;">
            <form id="registEntry" action="RegistEntry" >
                <b>Click on the map and select an allergy to regist your entry!</b><br/>
                <input id="latlong" type="hidden" name="latlong" value=""/>
                <%                for (int i = 0; i < allergies.size(); i++) {


                %>
                <input type="submit" name="<%=allergies.get(i).getAllergyType()%>" value="<%=allergies.get(i).getAllergyType()%>"><br>
                <%}
                %>

            </form>

            <form id="chooseLocal"  style="margin-right:20%; margin-left: 18%" action="showChoosenLocal" >
                <b>Click on the map to choose ur destination!</b><br/>
                <input id="latlong1" type="hidden" name="latlong1" value=""/>

                <input type="submit" name="placeToGo" value="Go!"><br>
            </form> 

            <form id="markerscheck" action="showMarkersFromCheckbox">
                <b>Select the allergy type to show on map:</b><br/>
                <%
                    for (int i = 0;
                            i < allergies.size();
                            i++) {
                %>
                <input id="allergyRegist" type="checkbox" name="Allergy<%=i%>" value="<%=allergies.get(i).getAllergyType()%>"> <%out.println(allergies.get(i).getAllergyType());%><br>
                <%}
                %>
                <input type="submit" value="Show" name="submit">
            </form>
        </div>

        <%} else {%>
        <!-- else, logo nao ha user logged in por isso aparece a pagina de "notloggedinmenu" e apenas a opcao de mostrar no mapa os markers pedidos na checkbox -->
        <jsp:include page="NotLoggedInMenu.jsp" flush="true"/>

        <div>
            <form id="markerscheck2" style="display:block; margin-left : 40%" action="showMarkersFromCheckbox">
                <b>Select the allergy type to show on map:</b><br/>
                <%
                    for (int i = 0;
                            i < allergies.size();
                            i++) {
                %>
                <input style="margin-left: 8%" id="allergyRegist" type="checkbox" name="Allergy<%=i%>" value="<%=allergies.get(i).getAllergyType()%>"> <%out.println(allergies.get(i).getAllergyType());%><br>
                <%}
                %>
                <input style="margin-left: 10%" type="submit" value="Show" name="submit">
            </form>
        </div>

        <%}%>

        <%
            // aqui define o int last que vai servir para ir buscar ao arraylist de entries o code certo a mostrar
            //depois de ter sido registada uma entry nova
            if (session.getAttribute("showMarker") != null) {
                boolean showmarker = (boolean) session.getAttribute("showMarker");
                if (showmarker) {
                    int last = entries.size() - 1;
                    session.setAttribute("showMarker", false);
        %>


        <h1>
            Your entry was registed with the code: <%out.println(entries.get(last - 1).getUniqueCode());%>
        </h1>
        <%
                }
            }%>

        <div id="mapid" style="margin-top: 10px; margin-bottom: 10px; width:100%;"></div>



        <script>
            //Definicao das vars para ir buscar os icones certos as imagens
            var yellowIcon = new L.Icon({
                iconUrl: 'images/marker-icon-yellow.png',
                shadowUrl: 'images/marker-shadow.png',
                iconSize: [25, 41],
                iconAnchor: [12, 41],
                popupAnchor: [1, -34],
                shadowSize: [41, 41]
            });
            var blueIcon = new L.Icon({
                iconUrl: 'images/marker-icon-blue.png',
                shadowUrl: 'images/marker-shadow.png',
                iconSize: [25, 41],
                iconAnchor: [12, 41],
                popupAnchor: [1, -34],
                shadowSize: [41, 41]
            });
            var redIcon = new L.Icon({
                iconUrl: 'images/marker-icon-red.png',
                shadowUrl: 'images/marker-shadow.png',
                iconSize: [25, 41],
                iconAnchor: [12, 41],
                popupAnchor: [1, -34],
                shadowSize: [41, 41]
            });
            var greenIcon = new L.Icon({
                iconUrl: 'images/marker-icon-green.png',
                shadowUrl: 'images/marker-shadow.png',
                iconSize: [25, 41],
                iconAnchor: [12, 41],
                popupAnchor: [1, -34],
                shadowSize: [41, 41]
            });
            var violetIcon = new L.Icon({
                iconUrl: 'images/marker-icon-violet.png',
                shadowUrl: 'images/marker-shadow.png',
                iconSize: [25, 41],
                iconAnchor: [12, 41],
                popupAnchor: [1, -34],
                shadowSize: [41, 41]
            });

            //Set viewp especifico para evora, num caso real iria buscar a localizacao do user
            var mymap = L.map('mapid').setView([38.573130, -7.905779], 15);
            L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token={accessToken}', {
                attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
                maxZoom: 18,
                id: 'mapbox.streets',
                accessToken: 'pk.eyJ1IjoiZGFuaWVsc2VycmFubyIsImEiOiJjanBiMGN3YXgwbGExM3BwMnB3cDh4Mmd0In0.59et0oF8fcigGQWouxalDw'
            }).addTo(mymap);
            <%
                //Aqui so entra caso tenha sido escolhido um local para passear
                //E por isso ira definir as coordenadas do circulo
                String[] coordsChoosen = (String[]) session.getAttribute("choosenPlace");
                if (coordsChoosen != null) {
                    float lat = Float.parseFloat(coordsChoosen[0]);
                    float longi = Float.parseFloat(coordsChoosen[1]);
            %>
                //Definicao do circulo
            var circle = L.circle([<%=lat%>, <%=longi%>], {
                color: 'red',
                fillColor: '#f03',
                fillOpacity: 0.2,
                radius: 100
            }).addTo(mymap);
            <%}%>

            <%
                //set de auxiliares
                boolean aux = false;
                boolean auxEntry = false;
                if (session.getAttribute("checkChecks") != null) {
                    aux = (boolean) session.getAttribute("checkChecks");
                }
                if (session.getAttribute("newEntryOnMap") != null) {
                    auxEntry = (boolean) session.getAttribute("newEntryOnMap");
                }

                if (entries != null) {
                    for (int i = 0; i < entries.size() - 1; i++) {
                        String allergyType = db.getAllergyType(entries.get(i).getAllergyID());
                        if (i == entries.size() - 1 && aux == false) {

            %>
                //set map view para coordenadas vindas tanto de um registo de entry nova, como de uma local escolhido para passear
            mymap.setView([<%=entries.get(i).getLatitude()%>,<%=entries.get(i).getLongitude()%>], 15);

            <%
                }
                
                   //Conjuto de ifs para definir as cores dos markers a aparecer no mapa
                if (allergyType.equals("Platano")) {
            %>
            var marker = L.marker([<%=entries.get(i).getLatitude()%>, <%=entries.get(i).getLongitude()%>], {icon: greenIcon}).addTo(mymap);
            marker.bindPopup("<%=allergyType%>").openPopup();
            <%} else if (allergyType.equals("Gramineas")) {

            %>
            var marker = L.marker([<%=entries.get(i).getLatitude()%>, <%=entries.get(i).getLongitude()%>], {icon: redIcon}).addTo(mymap);
            marker.bindPopup("<%=allergyType%>").openPopup();
            <%} else if (allergyType.equals("Oliveira")) {

            %>
            var marker = L.marker([<%=entries.get(i).getLatitude()%>, <%=entries.get(i).getLongitude()%>], {icon: blueIcon}).addTo(mymap);
            marker.bindPopup("<%=allergyType%>").openPopup();
            <%} else if (allergyType.equals("Azinheiro")) {

            %>
            var marker = L.marker([<%=entries.get(i).getLatitude()%>, <%=entries.get(i).getLongitude()%>], {icon: yellowIcon}).addTo(mymap);
            marker.bindPopup("<%=allergyType%>").openPopup();
            <%}
                if (auxEntry && aux == false && i == entries.size() - 2) {
            %>
            var marker = L.marker([<%=entries.get(i).getLatitude()%>, <%=entries.get(i).getLongitude()%>], {icon: violetIcon}).addTo(mymap);
            marker.bindPopup("<%=allergyType%>").openPopup();
            <%
                            session.setAttribute("checkChecks", false);
                            session.setAttribute("newEntryOnMap", false);
                            break;
                        }

                    }
                    session.setAttribute("checkChecks", false);
                }%>
                    
            //FIM dos ifs a difinir as cores dos markers
            
            var popup = L.popup();

               //Funcao que apanhas as coordendas selecionadas no mapa e as cologa nos tanto nos forms latlong ou latlong1 que irao ser usadas
               //Quando ocorrer a sua chamada num servlet
            function onMapClick(e) {
                popup
                        .setLatLng(e.latlng)
                        .setContent("You clicked the map at " + e.latlng)
                        .openOn(mymap);
                document.getElementById("latlong").value = "" + e.latlng.lat + ',' + e.latlng.lng + "";
                document.getElementById("latlong1").value = "" + e.latlng.lat + ',' + e.latlng.lng + "";
            }

            mymap.on('click', onMapClick);
        </script>
    </body>
</html>