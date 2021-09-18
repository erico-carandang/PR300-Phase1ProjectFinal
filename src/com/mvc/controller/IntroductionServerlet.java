package com.mvc.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.IntroductionBean;
import com.mvc.bean.LoginBean;
import com.mvc.bean.UserDetails;
import com.mvc.dao.IntroductionDao;
import com.mvc.dao.LoginDao;
 
@WebServlet("/IntroductionServerlet")
public class IntroductionServerlet  extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
    public IntroductionServerlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //Copying all the input parameters in to local variables
        String aboutMe = request.getParameter("aboutMe");
        String hobby = request.getParameter("hobby");
        String userId = request.getParameter("userId");
        
        IntroductionBean introductionBean = new IntroductionBean();
       //Using Java Beans - An easiest way to play with group of related data
        introductionBean.setAboutMe(aboutMe);
        introductionBean.setHobby(hobby); 
        introductionBean.setUserId(userId);
        
        IntroductionDao introductionDao = new IntroductionDao();
        
       //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
        UserDetails ud = introductionDao.AddIntroduction(introductionBean);
        
        if(ud != null)   //On success, you can display a message to user on Home page
        {
        	request.setAttribute("userId", ud.UserId);
        	request.setAttribute("userName", ud.UserName);
        	request.setAttribute("firstName", ud.FirstName);
        	request.setAttribute("lastName", ud.LastName);
        	request.setAttribute("email", ud.Email);
        	request.setAttribute("aboutMe", ud.AboutMe);
        	request.setAttribute("hobby", ud.Hobby);
           request.getRequestDispatcher("/UserDetails.jsp").forward(request, response);
        }
        else   //On Failure, display a meaningful message to the User.
        {
           request.setAttribute("errMessage", "Something Went Wrong!");
           request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
