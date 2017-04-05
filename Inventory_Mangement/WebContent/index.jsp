<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.Inventory.bean.userBean"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fixed Assist Inventory Management System</title>

<style type="text/css">
fieldset
{ border:0px solid #b7995d;
}

legend
{
color:#FF0000;
}
</style>
<script type="text/javascript">


function validate(){

    var userName=document.getElementById("name").value;
    var password=document.getElementById("password").value;
    
    if(userName==""){

         alert("please enter the username.");
         return false;
    
     }
    if(password=="")
    {
        
         alert("please enter the password.");
         return false;
     }
    return true;
}


</script>
</head>
<body>
   <div style="margin:auto; border:0px solid  #0000CC; width:1000px; font-family:Arial, Helvetica, sans-serif;">
 <div style="float:left; border:0px solid  #0000CC; width:1000px;">

     <div style="float:left; border:0px solid red; width:1000px;  font-family:Arial, Helvetica, sans-serif; background-image:url(images/InsideBanner_234.png); height:150px; background-repeat:no-repeat; text-align:right;">
              <span style="display:block; margin:112px 15px 0 0; font-weight:bold; color:#FFFFFF; font-size:25px; text-align:center">
			  Fixed Assets Inventory Management System</span>
	 </div>


<div style="width:1000px; border:0px solid green; float:left; height:328px;">

<div style="float:left; border:0px solid #FF0000; width:518px;">
<img src="images/images1.png">
</div>

<div style="float:left; border:0px solid #000000; width:3px;">
<img src="images/Untitled-1.png">
</div>

<div style="float:left; border:0px solid #000000; margin:1px 0 0 0px; width:478px; height:325px; background-color:#dbd6d3;">
<table width="100%" border="0" bgcolor="dbd6d3">
    <tr>

   <td colspan="2" height="50"><h2></h2></td>


 <%
        if(request.getAttribute("wrongUserName")!=null){
 
        String data=request.getAttribute("wrongUserName").toString();
        
        
        %>
   
   <td align="center" style="color: red;"><center><%=data%></center></td>
   

   <%} %>

</tr>

</table>


<form action="userController?user=loginUser" method="post">
  <fieldset>
  <legend>
</legend>
     <table border="0"  cellpadding="0" cellspacing="0" align="center" width="400" bgcolor="dbd6d3">


<tr><td colspan="2" height="50"></td>


</tr>
	
  <tr>
   <td style="font-size:18px;">Email-id:</td> <td><input type="text" id="name" name="email"/></td></tr>

<tr><td colspan="2" height="10"></td></tr>

<tr>             <td style="font-size:18px;">Password:</td>  <td><input type="password" id="password" name="password"/></td></tr>

<tr><td colspan="2" height="15"></td></tr>

  <tr><td></td>      <td align="center"><input type="submit" value="Login" onClick="return validate();"> </td>

  <td><input type="hidden" name="user" value="loginUser"></td>
</tr>

       
      </table>
	  
   </fieldset>
   </form>
              </div>
</div>

<div style="float:left; border:0px solid #000000; height:60px; width:1000px; padding:20px 0 0 0px; background-color:#b7995d; color:#FFFFFF; font-family:Arial, Helvetica, sans-serif; text-align:center; font-size:12px; color:#FFFFFF;">

  


          <div style="margin:0 0 0 50px; color:#FFFFFF; ">



               <a  href="#">Home</a>
               |	
              <a href="#">About Us</a>
               |
              <a  href="#">Support</a>
               |
               <a href="#">Development</a>
               |
              <a href="#">Conact Us</a>
 </div>
                  <div id="" style="margin:0 0 0 50px;">&copy; Copyright Information Goes Here. All Rights Reserved.</div>

        </div>
      </div>
   </div>
 </body>
</html>

