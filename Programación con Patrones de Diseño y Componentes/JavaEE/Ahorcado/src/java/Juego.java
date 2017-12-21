/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pankecho
 */
@WebServlet(urlPatterns = {"/Juego"})
public class Juego extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    public static final String[] PALABRAS = {"ABCD","PRUEBA","OAXACA"};
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession();
        int maxint = 5;
        String palabra = (String) sesion.getAttribute("palabra"); 
        String aciertos;
        String errados;
        System.out.println(palabra);
        if(palabra == null){ 
            Random oran= new Random();
            palabra = PALABRAS[oran.nextInt(PALABRAS.length)]; 
            aciertos = "";
            errados = "";
            sesion.setAttribute("palabra",palabra); 
            sesion.setAttribute("aciertos",aciertos); 
            sesion.setAttribute("errados",errados);
        }else{
            aciertos = (String) sesion.getAttribute("aciertos"); 
            errados = (String) sesion.getAttribute("errados"); 
            String letra = request.getParameter("letra"); 
            if(palabra.indexOf(letra) >= 0)
                aciertos += letra; 
            else
                errados += letra; 
            
            sesion.setAttribute("aciertos", aciertos); 
            sesion.setAttribute("errados", errados);
        } 
        PrintWriter out = response.getWriter();
        try{ 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Juego Ahorcado </title>"); 
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>S Juego: " + request.getContextPath() + "</h2>"); 
            out.println("<h2>Probando suerte </h2>");
            boolean terminado = true;
            out.println("<h2>");
            for(int i = 0; i < palabra.length(); i++){
                String letra = palabra.substring(i, i + 1); 
                if(aciertos.indexOf(letra) >= 0)
                    out.println(""+letra); 
                else{ 
                    out.println(""+"_");
                    terminado = false;
                } 
            }
            
            out.println("</h2>"); 
            if(maxint > errados.length()){
                out.println("<br/><br/><br/>");
                for(char car = 'A'; car <= 'Z'; car++) {
                    if(aciertos.indexOf(car) == -1 && errados.indexOf(car) == -1) 
                        out.println("<a href=Juego?letra="+car+">"+car+"</a>");
                }
            }else{
                sesion.invalidate();
                out.println("<br /><h1> JUEGO TERMINADO </h1>"); 
                out.println("<br /><a href='index.jsp'>regresar</a>");
            }
            
            if(terminado){
                sesion.invalidate();
                out.println("<br/><h1>JUEGO COMPLETO</h1>");
                out.println("<br/> <a href='index.jsp'>regresar</a>");
            }
            out.println("</body>");
            out.println("</html>");   
        }
        finally{
            out.close();
        }
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
        processRequest(request, response);
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
