<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
    <%@include file="style/Style.css" %>
    </style>
<meta charset="ISO-8859-1">
<title>User Details</title>
</head>
<body>
	<div align="center">
		<h2>WELCOME <td><%=request.getAttribute("firstName")%></td></h2>
	</div>
	<br></br>
	   <form name="form" method="post">
	     <table align="center" style="text-align: start;">
	     <tr>
         <td><input type="hidden" name="userId" value="<%=request.getAttribute("userId")%>"></td>
         </tr>
         <tr>
         <td>First Name:</td>
         <td style="padding-left: 1.5rem"><%=request.getAttribute("firstName")%></td>
         </tr>
          <tr>
         <td>Last Name:</td>
         <td style="padding-left: 1.5rem"><%=request.getAttribute("lastName")%></td>
         </tr>
         <tr>
         <td>Email:</td>
         <td style="padding-left: 1.5rem"><%=request.getAttribute("email")%></td>
         </tr>
         <tr>
         <td>Username: </td>
         <td style="padding-left: 1.5rem"><%=request.getAttribute("userName")%></td>
         </tr>
         <tr>
         <td>About me:</td>
         <td style="padding-left: 1.5rem"><%=(request.getAttribute("aboutMe") == null) ? "(Not specified)" : request.getAttribute("aboutMe")%></td>
         </tr>
		 <tr>
         <td>Hobby:</td>
         <td style="padding-left: 1.5rem"><%=(request.getAttribute("hobby") == null) ? "(Not specified)" : request.getAttribute("hobby")%></td>
         </tr>
        </table>
        <br>
        <br>
        <input style="font-size: 1rem; font-weight: bold; width: 100px; height: 50px;"
         type='button' value='Logout' onclick="window.location='index.jsp'"/>
      </form>
</body>
</html>