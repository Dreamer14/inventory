package com.Inventory.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Inventory.bean.addProduct;
import com.Inventory.bean.department;
import com.Inventory.bean.issueRecord;
import com.Inventory.bean.measureMent;
import com.Inventory.bean.purchaseRecord;
import com.Inventory.bean.userBean;
import com.Inventory.bean.userCreditional;


/**
 * Servlet implementation class userController
 */
public class userController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	com.Inventory.util.userControllerUtil controllerUtil=null; 
	userBean  beanObj=new userBean();
	
	userCreditional userLogin= new userCreditional();
	
	
	
	public userCreditional getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(userCreditional userLogin) {
		this.userLogin = userLogin;
	}


	purchaseRecord purRecord=new purchaseRecord();
	issueRecord isseRecord=new issueRecord();
	addProduct addProduct=new addProduct();
	
 ArrayList<addProduct> addproductlist=null;	
 ArrayList<department> departmentList=null;
 ArrayList<measureMent> measureMentList=null;
 
 
 
	
	
	
public ArrayList<measureMent> getMeasureMentList() {
	return measureMentList;
}

public void setMeasureMentList(ArrayList<measureMent> measureMentList) {
	this.measureMentList = measureMentList;
}

public ArrayList<department> getDepartmentList() {
	return departmentList;
}

public void setDepartmentList(ArrayList<department> departmentList) {
	this.departmentList = departmentList;
}

public ArrayList<addProduct> getAddproductlist() {
	return addproductlist;
}

public void setAddproductlist(ArrayList<addProduct> addproductlist) {
	this.addproductlist = addproductlist;
}

public addProduct getAddProduct() {
		return addProduct;
	}

	public void setAddProduct(addProduct addProduct) {
		this.addProduct = addProduct;
	}


ArrayList<purchaseRecord> purlist=null;	
   
   ArrayList<issueRecord> issuelist=null;
	
       
    public ArrayList<issueRecord> getIssuelist() {
	return issuelist;
  }

public void setIssuelist(ArrayList<issueRecord> issuelist) {
	this.issuelist = issuelist;
  }

	public ArrayList<purchaseRecord> getPurlist() {
	return purlist;
}

public void setPurlist(ArrayList<purchaseRecord> purlist) {
	this.purlist = purlist;
}

	public issueRecord getIsseRecord() {
		return isseRecord;
	}

	public void setIsseRecord(issueRecord isseRecord) {
		this.isseRecord = isseRecord;
	}

	public purchaseRecord getPurRecord() {
		return purRecord;
	}

	public void setPurRecord(purchaseRecord purRecord) {
		this.purRecord = purRecord;
	}

	public userBean getBeanObj() {
		return beanObj;
	}

	public void setBeanObj(userBean beanObj) {
		this.beanObj = beanObj;
	}

	public com.Inventory.util.userControllerUtil getControllerUtil() {
		return controllerUtil;
	}

	public void setControllerUtil(
			com.Inventory.util.userControllerUtil controllerUtil) {
		this.controllerUtil = controllerUtil;
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public userController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	
	
private void processRequest(HttpServletRequest request,HttpServletResponse response){
		 
        System.out.println("Enter into Process Request method");
         
         String userInfo=request.getParameter("user");
         
     System.out.println("value of userInfo is"+userInfo);    
         

if(userInfo.equalsIgnoreCase("registerUser")){
	  
	      try {
	    	  
		
		    response.sendRedirect("register.jsp");
		  
	           } 
	            catch (Exception e) {
		           e.printStackTrace();
	        }
         }





if(userInfo.equalsIgnoreCase("registerUserSucc")){
	  
	       System.out.println("enter into registerUserSucc method");
	     
	       
	       //String userName=beanObj.getUserName();
	       //String password=beanObj.getPassword();
	       //String emailID=beanObj.getEmail();
	       
	       
	       String userName=request.getParameter("userName");
	       String password=request.getParameter("password");
	       String emailID=request.getParameter("emailID");
	       
	       System.out.println("us11111er Name of>>>>"+userName+">>>password of>>"+password+">>>>email id of"+emailID);
	    
	       beanObj.setUserName(userName);
	       beanObj.setUserName(password);
	       beanObj.setUserName(emailID);
	       
	     System.out.println("value from object"+beanObj.getUserName());  
	       
	       
	       System.out.println("user Name of>>>>"+userName+">>>password of>>"+password+">>>>email id of"+emailID);
	       
     try {
	    	   
	    	   com.Inventory.util.userControllerUtil  user=new com.Inventory.util.userControllerUtil(userName,password,emailID);
	        	
	    	   
	    	  RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/index.jsp"); 
	    	  dispatcher.forward(request, response);
	    	   
	    	   
	    	   //response.sendRedirect("index.jsp");	
		
	        } 
     catch (Exception e) {
   		       e.printStackTrace();
	         }
	      }

if(userInfo.equalsIgnoreCase("loginUser")){
	 
	     System.out.println("Enter into login user method");
	     
	     HttpSession sessoin=request.getSession(true);
	  
	   boolean flag=false;     
	   String emailID=request.getParameter("email");
  	   String password=request.getParameter("password");
  	   
  	   
  	 userLogin.setUserName(emailID);
  	 userLogin.setPassword(password);
  	 
  	           sessoin.setAttribute("userEmail", userLogin);
  	   
  	   System.out.println("email ID of user is"+emailID+"password is>>"+password);  
  	   
  	   
  	try {
		
  		    flag=controllerUtil.checkUser(emailID,password);
  		 
  		if(flag==true){
  			 
  			   System.out.println("Enter into if part when login"+flag);	
  			   
  			
  	          RequestDispatcher dipatcher=getServletContext().getRequestDispatcher("/success.jsp");
  	          dipatcher.forward(request, response);
  			 
  		   }
  		else{
  			  System.out.println("Enter into else part when else part");
  			  
  			 
 			   String dataD="UserName and password not match with database."; 
			   
			   request.setAttribute("wrongUserName", dataD);
  			  
  			 
  			  RequestDispatcher dipatcher=getServletContext().getRequestDispatcher("/index.jsp");
	          dipatcher.forward(request,response);
  			
  		    }
  	    } 
  	   catch (Exception e) {
	 	    e.printStackTrace();
      	}
  	  }


if(userInfo.equalsIgnoreCase("purchaseRecord")){
	
	   System.out.println("enter into purchase record jsp for list the record>>>>>>>>>>>");    
	   
	   HttpSession sessoin=request.getSession(true);
	   
	
  try {
	      purlist=controllerUtil.getAllPurchaseRecord();
	      
	     System.out.println("size of list is"+purlist.size());  
	    
	    request.setAttribute("purchaseList", purlist);
	      
	   RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/purchaseRecord.jsp");
	   dispatcher.forward(request, response);   
	   
		// response.sendRedirect("purchaseRecord.jsp");
	   } 
	 catch (Exception e) {
		
    	}
	}

if(userInfo.equalsIgnoreCase("purchaseRecordReport")){
	
	   System.out.println("enter into purchase record jsp for list the record>>>>>>>>>>>");    
	   
	   HttpSession sessoin=request.getSession(true);
	   
	
try {
	      purlist=controllerUtil.getAllPurchaseRecord();
	      
	     System.out.println("size of list is"+purlist.size());  
	    
	    request.setAttribute("purchaseList", purlist);
	      
	   RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/purchaseRecordReport.jsp");
	   dispatcher.forward(request, response);   
	   
		// response.sendRedirect("purchaseRecord.jsp");
	   } 
	 catch (Exception e) {
		
 	}
	}


if(userInfo.equalsIgnoreCase("IssueRecord")){

	   System.out.println("enter into IssueRecord jsp for list the record>>>>>>>>>>>");    
	   
	   HttpSession sessoin=request.getSession(true);
	   
	
   try {
	      issuelist=controllerUtil.getAllIssueRecord();
	      
	      System.out.println("size of list is"+issuelist.size());  
	    
	    request.setAttribute("IssueList", issuelist);
	      
	   RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/issueRecord.jsp");
	   dispatcher.forward(request, response);   
	   
		// response.sendRedirect("purchaseRecord.jsp");
	   } 
	
	 catch (Exception e) {
	    }
      }

if(userInfo.equalsIgnoreCase("IssueRecordReport")){

	   System.out.println("enter into IssueRecord jsp for list the record>>>>>>>>>>>");    
	   
	   HttpSession sessoin=request.getSession(true);
	   
	
try {
	      issuelist=controllerUtil.getAllIssueRecord();
	      
	      System.out.println("size of list is"+issuelist.size());  
	    
	    request.setAttribute("IssueList", issuelist);
	      
	   RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/issueRecorReport.jsp");
	   dispatcher.forward(request, response);   
	   
		// response.sendRedirect("purchaseRecord.jsp");
	   } 
	
	 catch (Exception e) {
	    }
   }
if(userInfo.equalsIgnoreCase("logout")){
	
	 try {
		
	      response.sendRedirect("index.jsp");
		 
		 
	     } 
	 catch (Exception e) {
		   e.printStackTrace();
	    }
	   }
if(userInfo.equalsIgnoreCase("AddIssueRecord")){
	
	    System.out.println("Enter into the addIssueRecord method>>>>>>>>>>>");
	  
	try {
		 
		
		  addproductlist=controllerUtil.getNameOfProduct();
		  departmentList=controllerUtil.getDepartmentName();
		
		  
		  
		 System.out.println("size of list is"+addproductlist.size());
		  
		   request.setAttribute("addProductList", addproductlist);
		   request.setAttribute("departmentList", departmentList);
		     
		   RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/addIssueRecord.jsp");
		   dispatcher.forward(request, response);   
		  
		      //response.sendRedirect("addIssueRecord.jsp");
	      } catch (Exception e) {
		          e.printStackTrace();
	      }
	
      }

if(userInfo.equalsIgnoreCase("addIssueRecordSucc")){
	
	   System.out.println("Enter into add Issue record method");
	    
	   boolean flag=false;
	   
	   String nameInventory=request.getParameter("nameofInventory");
	   
	System.out.println("name of product is****************************"+nameInventory);   
	   String issueDate=request.getParameter("dateofIssue");
	   
	    //String issueNoDay=request.getParameter("issueNoDay"); 
	   //String returnDate=request.getParameter("returnDate");
	  //String versionInventory=request.getParameter("versioInventory");
	   
	   String issueDepartmentName=request.getParameter("issueToDepartment");
	   
	   
  	   
	   try {
		   
		   
		   flag=controllerUtil.addIssueRecord(nameInventory,issueDate,issueDepartmentName);
		   
		   if(flag==true){
			   
			   response.sendRedirect("success.jsp");
			   
		       }
		   else {
			   response.sendRedirect("success.jsp");
		         }
		     } 
	    catch (Exception e) {
		         e.printStackTrace();
	    }
 	 }

if(userInfo.equalsIgnoreCase("AddPurchaseRecord")){
	
	            System.out.println("Enter into the addIssueRecord method>>>>>>>>>>>");
	 	
	  try {
		  
		  addproductlist=controllerUtil.getNameOfProduct();
		  
		 System.out.println("size of list is"+addproductlist.size());
		  
		  request.setAttribute("addProductList", addproductlist);
		  
		     
		   RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/addPurchaseRecord.jsp");
		   dispatcher.forward(request, response);   
		  
		      //response.sendRedirect("addIssueRecord.jsp");
	      } catch (Exception e) {
		          e.printStackTrace();
	      }
	    
	   }
if(userInfo.equalsIgnoreCase("addpurchaseRecordSucc")){
	
	 System.out.println("Enter into add Issue record method");
	    
	   boolean flag=false;
	   
	   String nameInventory=request.getParameter("nameofInventory");
	   String purchaseDate=request.getParameter("purchagedate");
	   
	      //String versionInventory=request.getParameter("versionofInventory"); 
	   
	   String amountofInventory=request.getParameter("amountofInventory");
	   String vendorName=request.getParameter("vendorName");
	   
	     //String quality=request.getParameter("quality");
	   
	   
	   
	   try {
		   
		   
		   flag=controllerUtil.addPurchaseRecord(nameInventory,purchaseDate,amountofInventory,vendorName);
		   
		   if(flag==true){
			   
			   response.sendRedirect("success.jsp");
			   
		       }
		   else {
			   response.sendRedirect("success.jsp");
		         }
		     } 
	    catch (Exception e) {
		         e.printStackTrace();
	      }
       }
if(userInfo.equalsIgnoreCase("EditPurchaseRecord")){
	
	    String ID=request.getParameter("productID").toString();
	    
	    int ids=Integer.parseInt(ID);
	     
  try {
	   purlist=controllerUtil.editPurchaseRecord(ids);
	   request.setAttribute("viewPurchaseList", purlist);
		
	   
	   
	   RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/editPurchaseRecord.jsp");
	   dispatcher.forward(request, response);
	   
	   
	  
	    } 
	catch (Exception e) {
		 e.printStackTrace();
        	} 
        }

if(userInfo.equalsIgnoreCase("EditAddProduct")){
	
    String ID=request.getParameter("productID").toString();
    
    int ids=Integer.parseInt(ID);
     
try {
	 
	    addproductlist=controllerUtil.editAddProduct(ids);
        request.setAttribute("viewProductList", addproductlist);
	
   
   
   RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/editProductData.jsp");
   dispatcher.forward(request, response);
   
   
  
    } 
catch (Exception e) {
	 e.printStackTrace();
    	} 
    }





if(userInfo.equalsIgnoreCase("EditIssueRecord")){
	
    String ID=request.getParameter("productID").toString();
    
    int ids=Integer.parseInt(ID);
    
     
 try {
	
	 issuelist=controllerUtil.editIssueRecord(ids);
	 
     request.setAttribute("viewIssueList", issuelist);
	
   
   
   RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/editIssueRecord.jsp");
   dispatcher.forward(request, response);
   
   
  
    } 
catch (Exception e) {
	 e.printStackTrace();
    	} 
    }


if(userInfo.equalsIgnoreCase("updatePurchaseRecordSucc")){
	
	  boolean flag=false;
	
	   String nameInventory=request.getParameter("nameofInventory");
	   String purchaseDate=request.getParameter("purchagedate");
	   //String versionInventory=request.getParameter("versionofInventory"); 
	   String amountofInventory=request.getParameter("amountofInventory");
	   String vendorName=request.getParameter("vendorName");
	   //String quality=request.getParameter("quality");
	   
	   int productID=Integer.parseInt(request.getParameter("hiddenProductID"));
	   
	
	
	 try{
		
		 flag=controllerUtil.updatePurchaseRecord(nameInventory,purchaseDate,amountofInventory,vendorName,productID);
		   
		   if(flag==true){
			   
			   response.sendRedirect("success.jsp");
			   
		       }
		   else {
			   response.sendRedirect("success.jsp");
		         }
		  } 
	  catch (Exception e) {
		 e.printStackTrace();
	}
	
	
        }


if(userInfo.equalsIgnoreCase("updateProduct")){
	
	  boolean flag=false;
	  
	  HttpSession session=request.getSession(true);
	
	   String nameProduct=request.getParameter("productName");
	   String productDesc=request.getParameter("productDesc");
	   String productType=request.getParameter("productType"); 
	  
	   int productID=Integer.parseInt(request.getParameter("hiddenProductID"));
	   
	
	
	 try{
		
		 session.setAttribute("userEmail", userLogin);
		 
		 flag=controllerUtil.updateProduct(nameProduct,productDesc,productType,productID);
		   
		   if(flag==true){
			   
			   response.sendRedirect("success.jsp");
			   
		       }
		   else {
			   response.sendRedirect("success.jsp");
		         }
		  } 
	  catch (Exception e) {
		 e.printStackTrace();
	}
	
	
      }




if(userInfo.equalsIgnoreCase("AddProduct")){
	
	 System.out.println("Enter into add product method");
	
	   try {
		 
		   
		    measureMentList=controllerUtil.getMeasureName();
			  
			System.out.println("size of list is"+measureMentList.size());
			  
		    request.setAttribute("productMeasureMentList", measureMentList);
			  
			     
			RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/addProduct.jsp");
			dispatcher.forward(request, response);   
			
		   //response.sendRedirect("addProduct.jsp");
		   
	       } 
	  catch (Exception e) {
		     e.printStackTrace();
         }
       }
if(userInfo.equalsIgnoreCase("addProductDatabase")){
	
	 System.out.println("Enter into add product into database");
	 
	  boolean flag=false;
	   String nameProduct=request.getParameter("nameofInventory");
	   String descOfProduct=request.getParameter("decrProduct");
	   String netAmountProduct=request.getParameter("netAmount");
	   String unitMearueMent=request.getParameter("measureMentName");
	   
 try {
		   
		   
		   flag=controllerUtil.addProduct(nameProduct,descOfProduct,netAmountProduct,unitMearueMent);
		   
		   if(flag==true){
			   
			   response.sendRedirect("success.jsp");
			   
		       }
		   else {
			   response.sendRedirect("success.jsp");
		         }
		     } 
	    catch (Exception e) {
		         e.printStackTrace();
	      }

	    }

if(userInfo.equalsIgnoreCase("editProduct")){
	System.out.println("enter into edit product for list the record>>>>>>>>>>>");    
	   
	   HttpSession sessoin=request.getSession(true);
	   
	
try {
	    addproductlist=controllerUtil.getAllAddProduct();
	      
	     System.out.println("size of list is"+addproductlist.size());  
	    
	    request.setAttribute("productList", addproductlist);
	      
	   RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/addViewProduct.jsp");
	   dispatcher.forward(request, response);   
	   
		// response.sendRedirect("purchaseRecord.jsp");
	   } 
	 catch (Exception e) {
		        e.printStackTrace();
        	}
         }

if(userInfo.equalsIgnoreCase("editProductReport")){
	System.out.println("enter into edit product for list the record>>>>>>>>>>>");    
	   
	   HttpSession sessoin=request.getSession(true);
	   
	
try {
	    addproductlist=controllerUtil.getAllAddProduct();
	      
	     System.out.println("size of list is"+addproductlist.size());  
	    
	    request.setAttribute("productList", addproductlist);
	      
	   RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/productReport.jsp");
	   dispatcher.forward(request, response);   
	   
		// response.sendRedirect("purchaseRecord.jsp");
	   } 
	 catch (Exception e) {
		        e.printStackTrace();
        	}
         }




if(userInfo.equalsIgnoreCase("deleteProduct")){
	
	      String productID=request.getParameter("productID").toString();
	      
	      int productIDs=Integer.parseInt(productID);
	
	      boolean flag=false;
       try {
    	   
    	   addproductlist=controllerUtil.getAllAddProduct();
    	   
    	   flag=controllerUtil.deleteProductID(productIDs); 
 	      
  	       System.out.println("size of list is"+addproductlist.size()+"flag is>>>>>>>"+flag);  
  	    
  	       request.setAttribute("productList", addproductlist);
    	    
    	    
    	   if(flag==true){
    		   
    		   RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/addViewProduct.jsp");
    		   dispatcher.forward(request, response); 
    		   
    		     
    	          }
    	   else {
    		   
    		   RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/addViewProduct.jsp");
    		   dispatcher.forward(request, response); 
			
		        } 
    	   } 
       catch (Exception e) {
		     e.printStackTrace();
    	   }	
        }

if(userInfo.equalsIgnoreCase("deleteIssueRecord")){
	
     String productID=request.getParameter("productID").toString();
    
     int productIDs=Integer.parseInt(productID);

    boolean flag=false;
    
 try {
	   
	 
	 flag=controllerUtil.deleteIssueRecord(productIDs); 
	 issuelist=controllerUtil.getAllIssueRecord();
	 
       request.setAttribute("IssueList", issuelist);
	  // request.setAttribute("productList", addproductlist);
	    
	    
	   if(flag==true){
		   
		   RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/issueRecord.jsp");
		   dispatcher.forward(request, response); 
		   
		     
	          }
	   else {
		   
		   RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/issueRecord.jsp");
		   dispatcher.forward(request, response); 
		
	        } 
	   } 
 catch (Exception e) {
	     e.printStackTrace();
	   }	
  }
 
 if(userInfo.equalsIgnoreCase("DeletePurchaseRecord")){
	
      String productID=request.getParameter("productID").toString();
   
    int productIDs=Integer.parseInt(productID);

   boolean flag=false;
   
try {
	   
	 flag=controllerUtil.deletePurchaseRecord(productIDs); 
	 purlist=controllerUtil.getAllPurchaseRecord();
	 
	 
        request.setAttribute("purchaseList", purlist);
	    
	  // request.setAttribute("productList", addproductlist);
	    
	    
	   if(flag==true){
		   
		   RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/purchaseRecord.jsp");
		   dispatcher.forward(request, response); 
		   
		     
	          }
	   else {
		   
		   RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/purchaseRecord.jsp");
		   dispatcher.forward(request, response); 
		
	        } 
	   } 
catch (Exception e) {
	     e.printStackTrace();
	   }	
 }


     }	
  }
