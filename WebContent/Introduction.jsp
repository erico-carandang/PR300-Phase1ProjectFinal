<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
    <%@include file="style/Style.css" %>
    </style>
<meta charset="ISO-8859-1">
<title>User Introduction</title>

<script> 
var clickedButton = null;

function validate()
{ 
    var userId = document.form.userId.value;

	if(clickedButton == "Save") 
	{
	    var aboutMe = document.form.aboutMe.value; 
	    var hobby = document.form.hobby.value;
		if (aboutMe==null || aboutMe=="")
	    { 
	    alert("About me cannot be blank"); 
	    return false; 
	    }
		
	    else if (hobby==null || hobby=="")
	    { 
	    alert("Hobby cannot be blank"); 
	    return false; 
	    }
	}
	else
	{
		document.form.hobby.value = null;
		document.form.aboutMe.value = null;
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
        
        
        <button type="submit" onclick="clickedButton='Save'">Save</button>
        <button type="submit" onclick="clickedButton='AskMeLater'">Ask Me Later</button>
        
    </form>
</body>
</html>