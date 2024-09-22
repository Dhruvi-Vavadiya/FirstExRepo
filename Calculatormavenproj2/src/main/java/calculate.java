/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.logging.*;

/**
 *
 * @author Planet
 */
@WebServlet(urlPatterns = {"/cal"})
public class calculate extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet calculate</title>");
            out.println(" <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\" integrity=\"sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N\" crossorigin=\"anonymous\">\n" +
" ");
            out.println("<style>\n" +
"            .b {\n" +
"                animation: blinker 1.5s linear infinite;\n" +
"                color: red;\n" +
"            }\n" +
"            @keyframes blinker {\n" +
"                50% {\n" +
"                    opacity: 0;\n" +
"                }\n" +
"            }\n" +
"        </style>");
            
            out.println("</head>");
           
            out.println("<body class='text-center'>");
//            out.println("<h1>Servlet calculate at " + request.getContextPath() + "</h1>");
//            out.println("<h1>Hello world<h1>");
            int n1 = Integer.parseInt(request.getParameter("n1"));
            int n2 = Integer.parseInt(request.getParameter("n2"));
            String name = request.getParameter("a1");
            double result = 0;
//            out.println("<h1>"+name+"</h1>");

            if ("Addition".equals(name)) {
                result = n1 + n2;
                out.println("<h1 class='b mt-2 text-primary text-center'>Addition is :: "+result+"</h1>");
            }else if("Subtraction".equals(name)){
                result = n1 - n2;
                out.println("<h1 class='b mt-2 text-primary text-center'>Subtraction is :: "+result+"</h1>");
//               
            }else if("Multiplication".equals(name)){
                result = n1 * n2;
                out.println("<h1 class='b mt-2 text-primary text-center'>Multiplication is :: "+result+"</h1>");
                
            }else if("Division".equals(name)){
               if(n2 != 0){
                    result = n1 / n2;
                     out.println("<h1 class='b mt-2 text-primary text-center'>Division is :: "+result+"</h1>");
               }else{
                    out.println(" <script>alert('(\"Error:Division by zero\")')</script>");
                    RequestDispatcher rd = request.getRequestDispatcher("/Calculatormavenproj2/index.html");
                rd.include(request, response);
               }
            }else {
                out.println("<h1 class=' mt-2 text-danger text-center'>Error</h1>");
               response.sendRedirect("/Calculatormavenproj2/index.html");
            }
             
            out.println("</body>");
            out.println("</html>");
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
