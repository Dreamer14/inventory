<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.Inventory.bean.addProduct"%>


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
		$( "#purchagedate" ).datepicker();
		//$( "#returnDate" ).datepicker();
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
        


	  
            var nameofInventory=document.getElementById("productName").value;
            var purchagedate=document.getElementById("productDesc").value;
            var openBalace=document.getElementById("productType").value;

           
  if(nameofInventory==""){

          alert("please fill the name of Inventory.")
           return false;
  
         }
  if(purchagedate=="")
        {
      
         alert("please fill the date of purchase.");
          return false;
     }
  if(openBalace==""){
                alert("open balace filed can't be empty.");
                return false;
     }
  else if(!digits.test(openBalace)){
	  
        alert("Please enter the numeric value in the open balace field.");
        return false;
     } 
    return true;
  }
</script>

</head>
<body>
 <div style="float:center; border:1px solid #000000; width:100%;  font-family:Arial, Helvetica, sans-serif; font-size:25px; background-image:url(images/InsideBanner_2.png); height:100PX; background-repeat:no-repeat; text-align:right;">
              <span style="display:block; margin:90px 15px 0 0; font-weight:bold; color:#FFFFFF;"></span>
	 </div>

<!--Header-->
<h2>Add Purchase Record In System</h2><br>



<form action="userController?user=updateProduct" method="post">    

  <table cellpadding="0" cellspacing="0" border="0" align="center">


 
<%
     Iterator<addProduct> itr;
     ArrayList<addProduct> purlist=(ArrayList<addProduct>)request.getAttribute("viewProductList");

     if(purlist!=null){
    	 for(itr=purlist.iterator();itr.hasNext();){

    		 addProduct su=new addProduct();	
    	                 su=(addProduct)itr.next();
  %>


          <input type="hidden" name="hiddenProductID" value="<%=su.getProductID()%>"/>


      <tr>
             <td><b>Name of Product:</b></td>
             <td><input type="text" id="productName" name="productName" value="<%=su.getProductName()%>"/></td></tr>
      <tr>
             <td colspan="2" height="18"></td>
  
      </tr>
      <tr>
            <td><b>Product Description:</b></td><td><input type="text" id="productDesc" name="productDesc" value="<%=su.getProductDecription()%>"/></td>
      </tr>
      <tr>
             <td colspan="2" height="18"></td></tr>

      <tr>
             <td><b>Opening Balance:</b></td><td><input type="text" id="productType" name="productType" value="<%=su.getNetAmount()%>"></td>
      </tr>
       <tr>
             <td colspan="2" height="18"></td>
       
      </tr>


      <tr>
             <td colspan="2" height="18"></td>

      </tr>

    <%}
    	 } %>   

     
      <tr>
             <td>         </td>
             <td align="right"><input type="submit" value="update" onclick="return validate();"/></td>
      </tr>

     </table>
   </form>


<!--footer-->
  <div style="float:left; border:0px solid #000000; height:60px; width:1005px; padding:20px 0 0 0px; background-color:#b7995d; color:#FFFFFF; font-family:Arial, Helvetica, sans-serif; text-align:center; font-size:12px; color:#FFFFFF; margin: 280px 0 0 0;">




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
 



</body>
</html>