package com.mvc.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.mvc.bean.RegisterBean;
import com.mvc.dao.RegisterDao;
 
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;
	
     public RegisterServlet() {
     }
 
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Copying all the input parameters in to local variables
    	 String firstName = request.getParameter("firstname");
         String lastName = request.getParameter("lastname");
         String email = request.getParameter("email");
         String userName = request.getParameter("username");
         String password = request.getParameter("password");
         
         RegisterBean registerBean = new RegisterBean();
        //this is comment

         registerBean.setFirstName(firstName);
         registerBean.setLastName(lastName);
         registerBean.setEmail(email);
         registerBean.setUserName(userName);
         registerBean.setPassword(password); 
         
         RegisterDao registerDao = new RegisterDao();
         
        //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
         String userRegistered = registerDao.registerUser(registerBean);
         
         if(userRegistered.equals("Success")) {
            request.getRequestDispatcher("/Notification.jsp").forward(request, response);
         }
         else if (userRegistered.equals("Username already exist!")) {
             request.setAttribute("errMessage", "Username already existed!");
             request.getRequestDispatcher("/Register.jsp").forward(request, response);
         }
         else if (userRegistered.equals("Email already exist!")) {
             request.setAttribute("errMessage", "Email already exist!");
             request.getRequestDispatcher("/Register.jsp").forward(request, response);
         }
         else   //On Failure, display a meaningful message to the User.
         {
            request.setAttribute("errMessage", "Something went wrong!");
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
         }
     }
}