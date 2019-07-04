/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.DataBaseManager;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
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
public class DeleteEntries extends HttpServlet {

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

        //Servlet que Remove entries "checked" na checkbox de entries do perfil
        
        HttpSession session = request.getSession();
        
        
        PropretiesGetter propriedades = new PropretiesGetter();
        String host = propriedades.getProperties("host");
        String bd = propriedades.getProperties("bd");
        String username = propriedades.getProperties("user");
        String password = propriedades.getProperties("pw");       
        DataBaseManager db = new DataBaseManager(host, bd, username, password);

        User user = (User) session.getAttribute("login"); //Get user que está logado

        int size = db.getEntryByUserID(user.getUserID()).size(); //Numero de entradas feitas pelo user logado

        ArrayList<Integer> entries = new ArrayList();

        //ciclo "for" que apanha todas as entries "checked" ou seja, quand oestao diferente de null e as adiciona a uma array list "entries"
        for (int i = 0; i < size; i++) {
            if (request.getParameter("Entry" + i) != null) {
                int allTemp = parseInt(request.getParameter("Entry" + i));
                entries.add(allTemp);
            }

        }
        
        //Metodo que elimina as entries da BD
        db.deleteEntries(entries);
        
        ArrayList<Entry> entriesA = db.getEntryByUserID(user.getUserID());

        //Atualiza as entries do user para o JSP
        session.setAttribute("userEntries", entriesA);

        response.sendRedirect("/trabalho2_so2_FINAL/jsp/Perfil.jsp");
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
