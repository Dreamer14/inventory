<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%><html>
<%@page import="com.Inventory.bean.purchaseRecord"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

   <div style="float:center; border:1px solid #000000; width:100%;  font-family:Arial, Helvetica, sans-serif; font-size:25px; background-image:url(images/InsideBanner_2.png); height:100PX; background-repeat:no-repeat; text-align:right;">
              <span style="display:block; margin:90px 15px 0 0; font-weight:bold; color:#FFFFFF;"></span>
	 </div>



<div align="right"><a href="userController?user=logout">logout</a></div>


<h2>welcome to purchase Record Section</h2>

  <table>
 
    <tr>
        <td><b>Product ID</b>&nbsp;</td>
        <td><b>Purchage_Date</b>&nbsp;</td>
        <td><b>Vendor_name</b>&nbsp;</td>

    </tr>


<%
     Iterator<purchaseRecord> itr;
     ArrayList<purchaseRecord> purlist=(ArrayList<purchaseRecord>)request.getAttribute("purchaseList");

     if(purlist!=null){
    	 for(itr=purlist.iterator();itr.hasNext();){

    		 purchaseRecord su=new purchaseRecord();	
    	              su=(purchaseRecord)itr.next();
  %>
 
      <tr>
         <td><%=su.getProductID()%></td>
         <td><%=su.getPurchaseDate()%></td> 
         <td><%=su.getVendorName()%>&nbsp;</td>
         <td><a href="userController?user=EditPurchaseRecord&productID=<%=su.getProductID()%>">Edit</a></td>
         <td><a href="userController?user=DeletePurchaseRecord&productID=<%=su.getProductID()%>">Delete</a></td>

      </tr>
    <tr>  

     </tr>
  
<%} 
    	 
  } %>
  </table>
         <div style="float:left; border:0px solid #000000; height:60px; width:1005px; padding:20px 0 0 0px; background-color:#b7995d; color:#FFFFFF; font-family:Arial, Helvetica, sans-serif; text-align:center; font-size:12px; color:#FFFFFF; margin: 180px 0 0 0;">




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