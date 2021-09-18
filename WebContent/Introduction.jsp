<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
    <%@include file="style/Style.css" %>
    </style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script> 
var clickedButton;

function validate()
{ 
    var userId = document.form.userId.value;
    var aboutMe = document.form.aboutMe.value; 
    var hobby = document.form.hobby.value;

	if(clickedButton == "Save") {
	    if (aboutMe==null || aboutMe=="")
	    { 
	    alert("Field can't be blank"); 
	    return false; 
	    }
	    else if (hobby==null || hobby=="")
	    { 
	    alert("Field can't be blank"); 
	    return false; 
	    }
	}
    form.submit("IntroductionServerlet")
}
</script> 

</head>
<body>
	<div align="center">
		<h2>Please tell me more about yourself:</h2>
	</div>
	<br>
	<form name="form" method="post" action="IntroductionServerlet" onsubmit="validate();return false">
        <table align="center">
         <tr>
         <td style="padding-right: 1rem;">About me:</td>
         <td><textarea style="margin: 0px; width: 313px; height: 104px;" name="aboutMe"></textarea></td>
         </tr>
         <tr>
         <td style="padding-right: 1rem;">Hobby:</td>
         <td><textarea style="margin: 0px; width: 313px; height: 104px;" name="hobby"></textarea></td>
         </tr>
         <tr>
         <td><input type="hidden" name="userId" value="<%=request.getAttribute("userId")%>"></td>
         <td><%=(request.getAttribute("errMessage") == null) ? ""
         : request.getAttribute("errMessage")%></td>
         </tr>
        </table>
        <br>
         <input style="font-size: 1rem; font-weight: bold; width: 25%; height: 50px;"
          type="submit" onclick="clickedButton='Save'" value="Save"></input>
          
         <input  style="font-size: 1rem; font-weight: bold; width: 25%; height: 50px;"
          type="submit" onclick="clickedButton='Maybe later'" value="Maybe later"></input>
    </form>
</body>
</html>