<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@page import="com.Inventory.bean.measureMent" %>


<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<link rel="shortcut icon" href="images/arun.jpg" />
<link type="text/css" href="css/menu.css" rel="stylesheet"/>
<link  rel="stylesheet" href="css/style.css"/>
<link rel="stylesheet" href="css/jquery.ui.datepicker.css">
<link rel="stylesheet" href="css/jquery.ui.theme.css">
<link rel="stylesheet" href="css/jquery.ui.core.css">
<script type="text/javascript" src="js/menu.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script src="js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="js/jquery.ui.core.js" type="text/javascript"></script>
<script src="js/jquery.ui.widget.js" type="text/javascript"></script>
<script src="js/jquery.ui.datepicker.js" type="text/javascript"></script>


<script type="text/javascript">
	$(function() {
		$( "#dateofIssue" ).datepicker();
		$( "#returnDate" ).datepicker();
	});
</script>


<script type="text/javascript">

  function validate(){
            
	    var regEmail = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
		var alphaNum = /[a-zA-Z0-9]$/;
		var alphabet = /^[a-zA-Z ]+$/;
		var alphabetWithHyphen = /^[a-zA-Z0-9\- ]+$/;
		var digits = /^([0-9])+$/;
		var tomatch= /www:\/\/[A-Za-z0-9\.-]{3,}\.[A-Za-z]{3}/;

		
		
		    var nameofInventory=document.myForm.nameofInventory.value;
            var dateofIssue=document.myForm.decrProduct.value;
            var openBalace=document.myForm.netAmount.value;

   if(openBalace==""){
               
            alert("please fill the opening balace filed.");
		    return false;
          }     
   else if(!digits.test(openBalace)){
                    alert("Please enter the numberic value.");
                    return false;
           }
            
  if(nameofInventory==""){

          alert("please fill the name of the product ID.")
           return false;
  
         }
  if(dateofIssue=="")
        {
      
         alert("please fill the decription of product.");
          return false;
     }
   return true;
    }
 </script>
</head>

<body>

     <div style="margin:auto; border:0px solid  #0000CC; width:1000px; font-family: Arial, Helvetica, sans-serif;">
 <div style="float:left; border:0px solid  #0000CC; width:1000px;">


   <div style="float:left; border:0px solid red; width:1000px;  font-family:Arial, Helvetica, sans-serif; background-image:url(images/InsideBanner_234.png); height:150px; background-repeat:no-repeat; text-align:right;">
              <span style="display:block; margin:112px 15px 0 0; font-weight:bold; color:#FFFFFF; font-size:25px; text-align:center">
			  Fixed Assets Inventory Management System</span>
	 </div>
	 
	 
	 
<!--Header-->
        <div style="width:1000px; border:0px solid green; float:left; height:351px; width:1000px; background-color:#f9efda;">

            <div style="float:left; border:0px solid #FF0000; width:518px; margin:14px 0 0 0;"><img src="images/ti9d3u24.png"></div>

               <div style="float:left; border:0px solid #000000; width:3px; height:350px;">
               <img src="images/Untitled-1.png" height="350px" width="2px">
      </div>



<div style="float:left; border:0px solid #000000; margin:1px 0 0 0px; width:479px; height:350px; background-color:#f9efda;">

<div style="float:left; border:0px solid #000000; width:479px; text-align:center;">
<h2>Add Product into Database</h2></div>



<div style="float:left; border:0px solid #000000; margin:30px 0 0 70px;">
<form action="userController?user=addProductDatabase" name="myForm" method="post">    

  <table cellpadding="0" cellspacing="0" border="0" align="center">

      <tr>
             <td><b>Product ID:</b></td>
             <td><input type="text" id="nameofInventory" name="nameofInventory"/></td></tr>
      <tr>
             <td colspan="2" height="18"></td>
  
      </tr>
      <tr>
            <td><b>Description of Product:</b></td><td><input type="text" id="decrProduct" name="decrProduct"/></td>
      </tr>
      <tr>
             <td colspan="2" height="18"></td></tr>

      <tr>
             <td><b>Opening Balance:</b></td><td><input type="text" id="netAmount" name="netAmount"></td>
      </tr>
       <tr>
             <td colspan="2" height="18"></td>
       
      </tr>
     
<tr>
       <td><b>Measurement of Inventory:</b></td>
  <%
   
       Iterator<measureMent> itr; 
       ArrayList<measureMent> data=(ArrayList<measureMent>)request.getAttribute("productMeasureMentList"); 
    
  if(data!=null){
 
 %>
<td>
   <select style="width:175px;" name="measureMentName">
  
        <option>Select---</option>
  <%
    for(itr=data.iterator();itr.hasNext();){

    	measureMent su=new measureMent();	
              su=(measureMent)itr.next();
   %>
 <option>
   <%=su.getMeasureName()%>

  <%}
	 
  %>   
 </option>    
    </select>
</td>
    
 <%}%>

   </tr>

       <tr>
             <td colspan="2" height="18"></td>
       
      </tr>
     


      <tr>
             <td>         </td>
             <td align="right"><input type="submit" value="add" onClick="return validate();"/></td>
      </tr>

     </table>
   </form>
      </div>
</div>
</div>
<!--footer-->
 <div style="float:left; border:0px solid #000000; height:60px; width:1000px; padding:20px 0 0 0px; background-color:#b7995d; color:#FFFFFF; font-family:Arial, Helvetica, sans-serif; text-align:center; font-size:12px; color:#FFFFFF; margin:0px 0 0 0;">




          <div style="margin:0 0 0 50px; color:#FFFFFF; ">



               <a  href="#">Home</a>
               |	
              <a href="#">About Us</a>
               |
              <a  href="#">Support</a>
               |
               <a href="#">Development</a>
               |
              <a href="#">Contact Us</a>
</div>
                  <div id="" style="margin:0 0 0 50px;">&copy; Copyright Information Goes Here. All Rights Reserved.</div>


</div>





</div>
</div>
</body>
</html> 
