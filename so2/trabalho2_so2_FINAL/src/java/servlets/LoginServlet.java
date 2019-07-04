/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import usables.User;

/**
 *
 * @author danas
 */
public class LoginServlet extends HttpServlet {

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
        
        //Login
        
        String urlbase = "/trabalho2_so2_FINAL";
        
        //Apanha username e password inseridas no jsp
        String username = request.getParameter("uname");
        String psw = request.getParameter("psw");
        
        
        try {
            //Encripta a password com md5
            //USE OF DIGEST MD5
            //Creating the MessageDigest object  
            MessageDigest md = MessageDigest.getInstance("MD5");

            //Passing data to the created MessageDigest Object
            md.update(psw.getBytes());

            //Compute the message digest
            byte[] digest = md.digest();

            //Converting the byte array in to HexString format
            StringBuilder hexString = new StringBuilder();

            for (int i = 0; i < digest.length; i++) {
                hexString.append(Integer.toHexString(0xFF & digest[i]));
            }
            
            psw = hexString.toString(); //Resultado da encriptação

        } catch (NoSuchAlgorithmException ex) {
            System.out.println("NO MD5");
        }
        
        PropretiesGetter propriedades = new PropretiesGetter();
        String host = propriedades.getProperties("host");
        String bd = propriedades.getProperties("bd");
        String usernameBD = propriedades.getProperties("user");
        String password = propriedades.getProperties("pw");
        DataBaseManager db = new DataBaseManager(host, bd, usernameBD, password);
        
        //Verifica se é possivel fazer logiin com os dados inseridos
        User login = db.checkUser(username, psw);    
        

        HttpSession session = request.getSession();
        
        //Login == null significa que nao foi possivel fazer login logo irá receber um alert no jsp
        if(login==null){
            session.setAttribute("loginInvalid", true);
        }else{
            session.setAttribute("loginInvalid", false);
        }
        
        session.setAttribute("login", login);
        
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
