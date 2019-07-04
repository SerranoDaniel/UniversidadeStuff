/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.DataBaseManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import usables.Allergy;
import usables.User;

/**
 *
 * @author danas
 */
public class RegistServlet extends HttpServlet {

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
        //Regista novo user
        
        String urlbase = "/trabalho2_so2_FINAL";

        PropretiesGetter propriedades = new PropretiesGetter();
        String host = propriedades.getProperties("host");
        String bd = propriedades.getProperties("bd");
        String usernameDB = propriedades.getProperties("user");
        String password = propriedades.getProperties("pw");
        DataBaseManager db = new DataBaseManager(host, bd, usernameDB, password);
        
        int size = db.getAllAllergy().size(); //numero de allergias que a web app permite

        ArrayList<Allergy> allergies = new ArrayList();

        //apanha dados
        String username = request.getParameter("unameR");
        String psw = request.getParameter("pswR");

        try {
            //Encriptacao da password
            //USE OF DIGEST MD5
            //Creating the MessageDigest object  
            MessageDigest md = MessageDigest.getInstance("MD5");

            //Passing data to the created MessageDigest Object
            md.update(psw.getBytes());

            //Compute the message digest
            byte[] digest = md.digest();
            System.out.println(digest);

            //Converting the byte array in to HexString format
            StringBuilder hexString = new StringBuilder();

            for (int i = 0; i < digest.length; i++) {
                hexString.append(Integer.toHexString(0xFF & digest[i]));
            }

            psw = hexString.toString();

        } catch (NoSuchAlgorithmException ex) {
            System.out.println("NO MD5");
        }

        HttpSession session = request.getSession();

        //Verifica que username ja existe para saber se pode criar ou nao (== null -> pode criar)
        User userCheck = db.checkUserName(username);
        if (userCheck != null) {
            session.setAttribute("userCheck", false);
            response.sendRedirect(urlbase);
        } else {
            //Apanha as allergias escolhidas pelo user
            session.setAttribute("userCheck", true);
            for (int i = 0; i < size; i++) {
                if (request.getParameter("Allergy" + i) != null) {
                    Allergy allTemp = new Allergy(request.getParameter("Allergy" + i));
                    allergies.add(allTemp);
                }

            }

            //Adiciona a base de dados 
            User userToRegist = new User(username, psw);
            User registed = db.addUser(userToRegist, allergies);

            session.setAttribute("login", registed);

            response.sendRedirect(urlbase);
        }
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
