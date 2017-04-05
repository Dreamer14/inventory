<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.Inventory.*"%>

<html>
<head>

<title>Insert title here</title>
<link rel="stylesheet" href="css/css.css" type="text/css" />

</head>
<body>


    <div style="margin:auto; border:0px solid  #0000CC; width:1000px; font-family:Arial, Helvetica, sans-serif;">
 <div style="float:left; border:0px solid  #0000CC; width:1000px;">

<div style="float:left; border:0px solid red; width:1000px;  font-family:Arial, Helvetica, sans-serif;  background-image:url(images/InsideBanner_234.png); height:150px; background-repeat:no-repeat; text-align:right;">
         <span style="display:block; margin:112px 15px 0 0; font-weight:bold; color:#FFFFFF; font-size:25px; text-align:center;">
			  Fixed Assets Inventory Management System</span>
 </div>


<div align="right"><a href="userController?user=logout">logout</a></div>

<jsp:useBean id="userEmail" class="com.Inventory.bean.userCreditional" scope="session"/>
<div style="float:left; height:30px; width:1000px; border:0px solid #000000; font-size:15px; color:#b7995d;">
<b>welcome</b> <jsp:getProperty name="userEmail" property="userName"/></div>


<div style="float:left; border:0px solid #000000; background-color:#e9e7e6; width:1000px; height:46px; color:#FFFFFF;">
                
				<ul>
				<li>
				
				
				<div class="dc wid"> 
<a href="#" class="dc">Manage Product</a>
<ul>
<li><a href="userController?user=AddProduct">Add product</a></li>
<li><a href="userController?user=editProduct">View/edit products</a></li>
</ul>
</div>
</li>



<li>
				<div class="dc">
<a href="#" class="dc">Manage issuance</a>
<ul>
<li><a href="userController?user=AddIssueRecord">Add Issue Record</a></li>
<li><a href="userController?user=IssueRecord">View/edit Issues Record</a></li>
</ul>
</div>
</li>

<li>
				
				
				<div class="dc">
<a href="#" class="dc">Manage Purchase</a>
<ul>
<li><a href="userController?user=AddPurchaseRecord">Add purchase Record</a></li>
<li><a href="userController?user=purchaseRecord">View/edit Purchace Record</a></li>
</ul>
</div>
</li>


<li>
				<div class="dc">
<a href="#" class="dc">Reports</a>
<ul>
<li><a href="userController?user=IssueRecordReport">Issue Record Report</a></li>
<li><a href="userController?user=editProductReport">Product Record Report</a></li>
<li><a href="userController?user=purchaseRecordReport">Purchase Record Report</a></li>
 </ul>
</div>
</li>


</ul>

    </div>

   <div style="float:left; border:1px solid #000000; height:60px; width:1000px; padding:20px 0 0 0px; background-color:#b7995d; color:#FFFFFF; font-family:Arial, Helvetica, sans-serif; text-align:center; font-size:12px; color:#FFFFFF; margin: 300px 0 0 0;">

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
