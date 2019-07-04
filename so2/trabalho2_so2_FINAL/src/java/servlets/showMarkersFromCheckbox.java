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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import usables.Allergy;
import usables.Entry;
import usables.User;

/**
 *
 * @author danas
 */
public class showMarkersFromCheckbox extends HttpServlet {

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
        String urlbase = "/trabalho2_so2_FINAL";
        
        //Vai mostrar no mapa todas as alergias que tenham sido "checked" no jsp

        PropretiesGetter propriedades = new PropretiesGetter();
        String host = propriedades.getProperties("host");
        String bd = propriedades.getProperties("bd");
        String username = propriedades.getProperties("user");
        String password = propriedades.getProperties("pw");
        DataBaseManager db = new DataBaseManager(host, bd, username, password);
        
        
        int size = db.getAllAllergy().size(); //numero de allergias que a web app permite

        ArrayList<Entry> entries = new ArrayList();

        //apanha as alergias checked no jsp e vai buscar a bd todas as entradas com essa alergyID e adiciona ao arraylist entries
        for (int i = 0; i < size; i++) {
            if (request.getParameter("Allergy" + i) != null) {
                String allergies = (String) request.getParameter("Allergy" + i);
                int allergyID = db.getAllergyId(allergies);
                ArrayList<Entry> entriesAux = db.getEntryByAllergyID(allergyID);
                for (int j = 0; j < entriesAux.size(); j++) {
                    entries.add(entriesAux.get(j));
                }
            }
        }
       
        HttpSession session = request.getSession();

        //update dos markers
        session.setAttribute("markers", entries);
        session.setAttribute("checkChecks", true);

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
