package com.mvc.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.LoginBean;
import com.mvc.bean.UserDetails;
import com.mvc.dao.LoginDao;
 
@WebServlet("/LoginServerlet")
public class LoginServerlet  extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
    public LoginServerlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //Copying all the input parameters in to local variables
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        
        LoginBean loginBean = new LoginBean();
       //Using Java Beans - An easiest way to play with group of related data
        loginBean.setUserName(userName);
        loginBean.setPassword(password); 
        
        LoginDao loginDao = new LoginDao();
        
       //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
        UserDetails userDetails = loginDao.loginUser(loginBean);
        
        if(userDetails != null && (userDetails.Hobby != null && userDetails.AboutMe != null))   //On success, you can display a message to user on Home page
        {
        	request.setAttribute("userId", userDetails.UserId);
        	request.setAttribute("userName", userDetails.UserName);
        	request.setAttribute("firstName", userDetails.FirstName);
        	request.setAttribute("lastName", userDetails.LastName);
        	request.setAttribute("email", userDetails.Email);
        	request.setAttribute("aboutMe", userDetails.AboutMe);
        	request.setAttribute("hobby", userDetails.Hobby);
            request.getRequestDispatcher("/UserDetails.jsp").forward(request, response);
        }
        else if (userDetails != null && (userDetails.Hobby == null || userDetails.AboutMe == null)) {
        	request.setAttribute("userId", userDetails.UserId);
        	request.setAttribute("userName", userDetails.UserName);
        	request.setAttribute("firstName", userDetails.FirstName);
        	request.setAttribute("lastName", userDetails.LastName);
        	request.setAttribute("email", userDetails.Email);
            request.getRequestDispatcher("/Introduction.jsp").forward(request, response);
        }
        else   //On Failure, display a meaningful message to the User.
        {
           request.setAttribute("errMessage", "No Record Found!");
           request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
