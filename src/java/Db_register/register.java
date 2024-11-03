/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Db_register;

import DatabaseConnectivity.Dbconn;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author java3
 */

public class register extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) 
throws IOException{ 
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       Connection con = null;
    Statement st = null;
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String pass = request.getParameter("pass");
    String repass = request.getParameter("repass");
    String dob = request.getParameter("dob");
    String gender = request.getParameter("gender");
    String contact = request.getParameter("con");
    String loc = request.getParameter("location");
   
   
    try {
    Random s = new Random();
    int a = s.nextInt(10000 - 5000) +25000 ;
    System.out.print(a);
   
        con = Dbconn.getConnection();
        st = con.createStatement();
        int i = st.executeUpdate("insert into register (name, email, pass, repass, dob, gender, contact, loc, ukey) values ('" + name + "','" + email + "','" + pass + "','" + repass + "','" + dob + "','" + gender + "','" + contact + "','"+loc+"', '"+a+"')");
        if (i != 0) {
           
            response.sendRedirect("index.html?msg=success");
        } else {
            response.sendRedirect("register.jsp?msgg=failed");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    }}