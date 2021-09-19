<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
    <%@include file="style/Style.css" %>
    </style>
<title>PR300 Phase1 Project</title>

<script> 
function validate()
{ 
     var username = document.form.username.value; 
     var password = document.form.password.value;
     
     if (username==null || username=="")
     { 
     alert("Username can't be blank"); 
     return false; 
     }
     else if (password==null || password=="")
     { 
     alert("Password can't be blank"); 
     return false; 
     } 
 } 
 

</script> 

</head>
<body>
<br>
	<h1>PR300 - Practical Project FSD | Phase1</h1>
	
	    <form name="form" action="LoginServerlet" method="post" onsubmit="return validate()">
        <table align="center">
         <tr>
         <td style="padding-right: 1rem;">Username</td>
         <td><input type="text" name="username" /></td>
         </tr>
         <tr>
         <td style="padding-right: 1rem;">Password</td>
         <td><input type="password" name="password" /></td>
         </tr>
         <tr>
         <td></td>
         <td style="padding-top: 1rem; color: red"><%=(request.getAttribute("errMessage") == null) ? ""
         : request.getAttribute("errMessage")%></td>
         </tr>
        </table>
        <br>
        
        <!-- 
        	customized button for Submit and Reset (see Style.css) 
        	Previous button style was commented.
        	
        	Reset button has 2 options noted for reference: 
        	Option 1 - resets the page
        	Option 2 - resets the form (commented)
        -->
        
        
        <!-- <input type="submit" value="Sign In"></input> -->
        <button type="submit">Sign In</button>
        
        <!-- Option 1  -->
        <!-- <input type="button" onclick="window.location='index.jsp'" value="Reset"> -->
        <button type="button" onclick="window.location='index.jsp'">Reset</button>
        
        <!-- Option 2  -->
        <!--  <input type="reset" value="Reset"></input>-->
        
    </form>
<section><br>
	<div align="center">New user? Click	<a href="Register.jsp">here</a> to register.
	</div>
</section>
</body>
</html>