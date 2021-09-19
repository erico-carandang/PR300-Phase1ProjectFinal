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
		<h2>Welcome,  <td><%=request.getAttribute("firstName")%></td>!</h2>
		<h3>User Details:</h3>
	</div>
	   <form name="form" method="post">
	     <table align="center" style="text-align: start;">
	     <tr>
         <td><input type="hidden" name="userId" value="<%=request.getAttribute("userId")%>"></td>
         </tr>
         <tr>
         <td style="text-align: right;">First Name:</td>
         <td style="padding-left: 1.5rem"><%=request.getAttribute("firstName")%></td>
         </tr>
          <tr>
         <td style="text-align: right;">Last Name:</td>
         <td style="padding-left: 1.5rem"><%=request.getAttribute("lastName")%></td>
         </tr>
         <tr>
         <td style="text-align: right;">Email:</td>
         <td style="padding-left: 1.5rem"><%=request.getAttribute("email")%></td>
         </tr>
         <tr>
         <td style="text-align: right;">Username: </td>
         <td style="padding-left: 1.5rem"><%=request.getAttribute("userName")%></td>
         </tr>
         <tr>
         <td style="text-align: right;">About me:</td>
         <td style="padding-left: 1.5rem"><%=(request.getAttribute("aboutMe") == null) ? "(Not specified)" : request.getAttribute("aboutMe")%></td>
         </tr>
		 <tr>
         <td style="text-align: right;">Hobby:</td>
         <td style="padding-left: 1.5rem"><%=(request.getAttribute("hobby") == null) ? "(Not specified)" : request.getAttribute("hobby")%></td>
         </tr>
        </table>
        <br>
        <br>
        <button type="button" onclick="window.location='index.jsp'">Logout</button>
      </form>
</body>
</html>