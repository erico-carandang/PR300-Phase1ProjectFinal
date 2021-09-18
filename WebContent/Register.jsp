<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>

<style type="text/css">
    <%@include file="style/Style.css" %>
</style>

<script> 
function validate()
{ 
     var firstname = document.form.fullname.value;
     var lastname = document.form.fullname.value;
     var email = document.form.email.value;
     var username = document.form.username.value; 
     var password = document.form.password.value;
     var conpassword= document.form.conpassword.value;
     
     if (firstname==null || firstname=="")
     { 
     alert("First Name can't be blank"); 
     return false; 
     }
     if (lastname==null || lastname=="")
     { 
     alert("Last Name can't be blank"); 
     return false; 
     }
     else if (email==null || email=="")
     { 
     alert("Email can't be blank"); 
     return false; 
     }
     else if (username==null || username=="")
     { 
     alert("Username can't be blank"); 
     return false; 
     }
     else if(password.length<6)
     { 
     alert("Password must be at least 6 characters long."); 
     return false; 
     } 
     else if (password!=conpassword)
     { 
     alert("Confirm Password should match with the Password"); 
     return false; 
     } 
 } 
</script> 
</head>
<body>
<h2>Enter Details </h2>
    <form name="form" action="RegisterServlet" method="post" onsubmit="return validate()">
        <table align="center">
         <tr>
         <td style="padding-right: 1rem;">First Name:</td>
         <td><input type="text" name="firstname" /></td>
         </tr>
         <tr>
         <td style="padding-right: 1rem;">Last Name:</td>
         <td><input type="text" name="lastname" /></td>
         </tr>
         <tr>
         <td style="padding-right: 1rem;">Email:</td>
         <td><input type="email" placeholder="email@example.com" name="email" /></td>
         </tr>
         <tr>
         <td style="padding-right: 1rem;">Username:</td>
         <td><input type="text" name="username" /></td>
         </tr>
         <tr>
         <td style="padding-right: 1rem;">Password:</td>
         <td><input type="password" name="password" /></td>
         </tr>
         <tr>
         <td style="padding-right: 1rem;">Confirm Password:</td>
         <td><input type="password" name="conpassword" /></td>
         </tr>
         <tr>
         <td></td>
         <td style="padding-top: 2rem; color: red"><%=(request.getAttribute("errMessage") == null) ? ""
         : request.getAttribute("errMessage")%></td>
        
         </tr>
        </table>
        <br>
		<input type="submit" value="Register"></input>
        <input type="button" onclick="window.location='Register.jsp'" value="Reset"></input>
        <br>
        <br>
        <div align="center">Already registered? Click 
		<a href="index.jsp">here</a> to login
	</div>
        
    </form>
</body>
</html>