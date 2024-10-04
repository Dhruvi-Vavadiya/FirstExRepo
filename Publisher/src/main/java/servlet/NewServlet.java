/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import ejb.PublishBeanLocal;
import entity.Customer;
import entity.Address;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Planet
 */
@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

    @EJB
    PublishBeanLocal pbl;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>");

            //CUSTOMER
//            pbl.addCust("jirva", "Vavadiya");
//            pbl.updateCust(6, "dhruvi", "Patel");
//            pbl.deleCust(5);

            Collection<Customer> cust = pbl.getAllCustomer();
            out.println("<h1 align='center'>Cutomer details<h1/><table border='1'>"); // Start the table and add a border
            out.println("<thead>"); // Table header
            out.println("<tr>");
            out.println("<th>Customer Id</th>"); // Header for Customer ID
            out.println("<th>First Name</th>"); // Header for First Name
            out.println("<th>Last Name</th>"); // Header for Last Name
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>"); // Table body
            for (Customer c : cust) {
                out.println("<tr><td>" + c.getCustomerID()
                        + "</td><td>" + c.getFirstName()
                        + "</td><td>" + c.getLastName() + "</td></tr>");
            }
            out.println("</tbody>");
            out.println("</table><hr/>"); // End the table

//            Collection<Customer> custfnm = pbl.getAllCustomerByFirstname("dhruvi");
//            for (Customer c : custfnm) {
//                out.println("<br/> CId ::" + c.getCustomerID()
//                        + "<br/>FName ::" + c.getFirstName()
//                        + "<br/>LName ::" + c.getLastName() + "<hr/>");
//            }
//            
//            Collection<Customer> custlnm=pbl.getAllCustomerByLastname("Patel");
//            for(Customer c : custlnm){
//                out.println("<br/> CID ::"+ c.getCustomerID()+"<br/> Lname :: "+c.getLastName()+"<hr/>");
//            }
//            pbl.getCustomerById(2); //pending..........

            //ADDRESS
//            pbl.addAddressToCustomer("D-5900", "suart", "gujrat", "395004", 6);
//            pbl.addAddressToCustomer("E-1", "Vadodara", "Gujarat", "380001", 8);
//            pbl.updateAddressToCustomer(2, "R-5900", "rajkot", "jamnager", "395857",3);
//            pbl.removeAddressToCustomer(3,2);
            
//            out.println("<h1 align='center'>get address of cutomer<h1/><table border='1'>"); // Start the table and add a border
//            out.println("<thead>"); // Table header
//            out.println("<tr>");
//            out.println("<th>Address Id</th>"); // Header for Customer ID
//            out.println("<th>Street</th>"); // Header for First Name
//            out.println("<th>state</th>"); // Header for Last Name
//            out.println("<th>city</th>"); // Header for Last Name
//            out.println("<th>zip</th>"); // Header for Last Name
//            out.println("<th>customer id</th>"); // Header for Last Name
//            out.println("<th>customer fname</th>"); // Header for Last Name
//            out.println("<th>customer lname</th>"); // Header for Last Name
//            out.println("</tr>");
//            out.println("</thead>");
//            out.println("<tbody>"); // Table body
//            Collection<Customer> custtt = pbl.getAllCustomer();
//            for(Customer c : custtt){
//                Collection<Address> add = pbl.getAddressOfCustomer(c.getCustomerID());
//                 for (Address a : add) {
//                out.println("<tr><td>" + a.getAddressId()
//                        + "</td><td>" + a.getStreet()
//                         + "</td><td>" + a.getState()
//                         + "</td><td>" + a.getCity()
//                         + "</td><td>" + a.getZip()
//                         + "</td><td>" + c.getCustomerID()
//                         + "</td><td>" + c.getFirstName()
//                        + "</td><td>" + c.getLastName()+ "</td></tr>");
//            }
//                
//            }

        //Pending.........
//             out.println("</tbody>");
//            out.println("</table>"); // End the table

//            out.println("<h1 align='center'>get customer from address<h1/><table border='1'>"); // Start the table and add a border
//            out.println("<thead>"); // Table header
//            out.println("<tr>");
//            out.println("<th>Address Id</th>"); // Header for Customer ID
//            out.println("<th>Street</th>"); // Header for First Name
//            out.println("<th>state</th>"); // Header for Last Name
//            out.println("<th>city</th>"); // Header for Last Name
//            out.println("<th>zip</th>"); // Header for Last Name
//            out.println("<th>customer id</th>"); // Header for Last Name
//            out.println("<th>customer fname</th>"); // Header for Last Name
//            out.println("<th>customer lname</th>"); // Header for Last Name
//            out.println("</tr>");
//            out.println("</thead>");
//            out.println("<tbody>"); // Table body
//            Collection<Address> addlist = pbl.getAllAddress();
//            for(Address a : addlist){
//              Customer c = pbl.getCustomerFromAddress(a.getAddressId());
//                if(c != null) {
//                out.println("<tr><td>" + a.getAddressId()
//                        + "</td><td>" + a.getStreet()
//                         + "</td><td>" + a.getState()
//                         + "</td><td>" + a.getCity()
//                         + "</td><td>" + a.getZip()
//                         + "</td><td>" + c.getCustomerID()
//                         + "</td><td>" + c.getFirstName()
//                        + "</td><td>" + c.getLastName()+ "</td></tr>");
//            }
//                
//            }
//             out.println("</tbody>");
//            out.println("</table>"); // End the table

            out.println("<h1>Donee...</h1>");
            out.println("</h3>");
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
