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
public class showChoosenLocal extends HttpServlet {

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
        
        // para mostrar o circulo vermelho

        HttpSession session = request.getSession();

        //Apanha as coordenadas, cria um array com elas e crias uma entry auxiliar para depois dar set na map view
        String coordsSent = request.getParameter("latlong1");
        String[] coords = coordsSent.split(",");
        Entry entryToSetView = new Entry(Float.parseFloat(coords[0]), Float.parseFloat(coords[1]));

        session.setAttribute("choosenPlace", coords);
        User user = (User) session.getAttribute("login");

        PropretiesGetter propriedades = new PropretiesGetter();
        String host = propriedades.getProperties("host");
        String bd = propriedades.getProperties("bd");
        String username = propriedades.getProperties("user");
        String password = propriedades.getProperties("pw");
        DataBaseManager db = new DataBaseManager(host, bd, username, password);

        
        ArrayList<Entry> entriesToSend = new ArrayList();
        ArrayList<Integer> userAllergies = db.getUserAllergies(user.getUserID()); //Apanhas as allergias do user
        
        ArrayList<Entry> entriesByAllergy = new ArrayList();

        //Adiciona ao arraylist "entriesByALlergy" todas as entries pertencentes as allergias que o user sofre
        for (int i = 0; i < userAllergies.size(); i++) {
            ArrayList<Entry> aux = db.getEntryByAllergyID(userAllergies.get(i));
            for (int j = 0; j < aux.size(); j++) {
                entriesByAllergy.add(aux.get(j));
            }
        }
        
        
        //Ciclo for que percorre o array de entries pertencentes as alergias que o user sofre
        //e que com a formula de haversine retirada da internet compara a distancia dessa entrie ao
        //centro do circulo e verifica se esse valor é menor que 0,1
        //caso seja adiciona as ao arraylist "entriesToSend"
        for (int i = 0; i < entriesByAllergy.size(); i++) {
            double R = 6372.8; // In kilometers  
            double dLat = Math.toRadians(entriesByAllergy.get(i).getLatitude() - Float.parseFloat(coords[0]));
            double dLon = Math.toRadians(entriesByAllergy.get(i).getLongitude() - Float.parseFloat(coords[1]));
            double lat1 = Math.toRadians(Float.parseFloat(coords[0]));
            double lat2 = Math.toRadians(entriesByAllergy.get(i).getLatitude());

            double a = Math.pow(Math.sin(dLat / 2), 2) + Math.pow(Math.sin(dLon / 2), 2) * Math.cos(lat1) * Math.cos(lat2);
            double c = 2 * Math.asin(Math.sqrt(a));

            if ((R * c <= 0.1)) {
                entriesToSend.add(entriesByAllergy.get(i));
            }
        }

        //adiciona a entry ao final para dar set view no mapa
        //E atualiza os markeres para o jsp
        entriesToSend.add(entryToSetView);
        session.setAttribute("markers", entriesToSend);

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
