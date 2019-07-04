/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.DataBaseManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import usables.Entry;
import usables.User;

/**
 *
 * @author danas
 */
public class RegistEntry extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //regista uma nova entry
        
        String urlbase = "/trabalho2_so2_FINAL";

        HttpSession session = request.getSession();

        //apanhas as coordenadas selecionadas no mapa
        String coordsSent = request.getParameter("latlong");

        //apanha os valores dos butoes em que so um terá a string correspondente, os outros estarão a null
        String platano = request.getParameter("Platano");
        String gramineas = request.getParameter("Gramineas");
        String oliveira = request.getParameter("Oliveira");
        String azinheiro = request.getParameter("Azinheiro");

        String[] coords = coordsSent.split(",");//mete as coordenadas num array
        Entry entryToSetView = new Entry(Float.parseFloat(coords[0]), Float.parseFloat(coords[1])); //Entry para dar setview do mapa no jsp

        User user = (User) session.getAttribute("login");

        //Set da elergyId para ser adicionada na BD
        int allergyID = 0;
        if ("Platano".equals(platano)) {
            allergyID = 1;
        }
        if ("Gramineas".equals(gramineas)) {
            allergyID = 2;
        }
        if ("Oliveira".equals(oliveira)) {
            allergyID = 3;
        }
        if ("Azinheiro".equals(azinheiro)) {
            allergyID = 4;
        }

        //Data
        java.sql.Timestamp entryDate = new java.sql.Timestamp(new java.util.Date(System.currentTimeMillis()).getTime());
        //Adiciona entrada nova
        Entry ent = new Entry(Float.parseFloat(coords[0]), Float.parseFloat(coords[1]), entryDate, allergyID, user.getUserID());

        //Apanha os pontos que ja estavam no mapa
        ArrayList<Entry> entries = new ArrayList();
        if (session.getAttribute("markers") != null) {
            entries = (ArrayList<Entry>) session.getAttribute("markers");
        }

        entries.add(ent); //atualiza entris no mapa com esta noba
        entries.add(entryToSetView); // adiciona tbm esta entri para dar setview do mapa
        session.setAttribute("markers", entries);
        session.setAttribute("showMarker", true); //
        session.setAttribute("newEntryOnMap", true); //usado para mudar cor do marker para a cor de entry nova

        PropretiesGetter propriedades = new PropretiesGetter();
        String host = propriedades.getProperties("host");
        String bd = propriedades.getProperties("bd");
        String username = propriedades.getProperties("user");
        String password = propriedades.getProperties("pw");
        DataBaseManager db = new DataBaseManager(host, bd, username, password);

        db.addEntry(ent); //atualiza bd com nova entrada

        response.sendRedirect(urlbase);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
