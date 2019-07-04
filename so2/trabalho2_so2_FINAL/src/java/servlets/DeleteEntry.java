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
import usables.Entry;
import usables.User;

/**
 *
 * @author danas
 */
public class DeleteEntry extends HttpServlet {

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
        
        //Servlet que remove apenas uma entrada da BD que foi selecionada para ser eliminada no mapa do perfil
        
        HttpSession session = request.getSession();

        //Apanha o ID da entry que vem do jsp
        int EntryId = parseInt(request.getParameter("Entry"));

        PropretiesGetter propriedades = new PropretiesGetter();
        String host = propriedades.getProperties("host");
        String bd = propriedades.getProperties("bd");
        String username = propriedades.getProperties("user");
        String password = propriedades.getProperties("pw");
        DataBaseManager db = new DataBaseManager(host, bd, username, password);

        User user = (User) session.getAttribute("login"); 

        db.deleteEntryByID(EntryId); //Delete na base de dados

        //Atualiza as entradas do user para o JSP
        ArrayList<Entry> entriesA = db.getEntryByUserID(user.getUserID());

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
