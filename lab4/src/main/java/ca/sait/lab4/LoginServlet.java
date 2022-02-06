/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ca.sait.lab4;

import ca.sait.lab4.models.User;
import ca.sait.lab4.services.AccountService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author peony
 */
public class LoginServlet extends HttpServlet {



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
        HttpSession session =request.getSession();
        
        if(session.getAttribute("username") !=null){
            response.sendRedirect("home");
        }
        String query = request.getQueryString();
        
        if(query != null && query.contains("logout")){
            
        }
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
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
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
       
        
        if(username == null || username.isEmpty()||password == null || password.isEmpty()){
            
            request.setAttribute("message", "Username or Password is empty");
        }
        else{
            AccountService account = new AccountService();
            
            User user = account.login(username, password);
            
            if(user!=null){
                request.getSession().setAttribute("username",username);
                response.sendRedirect("home");
                return;
            }
            else{
                request.setAttribute("username", username);
                request.setAttribute("message", "Invalid Username or Password.");
            }
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }


}
