package com.Inventory.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.Inventory.base.userBase;
import com.Inventory.bean.addProduct;
import com.Inventory.bean.department;
import com.Inventory.bean.issueRecord;
import com.Inventory.bean.measureMent;
import com.Inventory.bean.purchaseRecord;

public class DBUtil extends userBase {
	
	
	public static boolean addUser(String userName,String password, String emailID){
		
	    System.out.println("Insert into adduser mehtod>>>>Fixed Assist Inventory System>>>>>>>>>>>>>>>>>>"+userName);
	
		boolean flag = false;
		PreparedStatement pstmt = null;
		
		String query ="insert into admin_info(userName,password,email_ID,status) values (?,?,?,0)";
		
		try {
			
			Connection conn = com.Inventory.connection.Connection.getConnection();
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			pstmt.setString(3, emailID);
			
			
			if(pstmt.executeUpdate() == 1)	{
				flag = true;				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
 public static boolean checkUserLogin(String emailID,String password){
		
	    System.out.println("Insert into checkUSer mehtod>>>>Fixed Assist Inventory System>>>>>>>>>>>>>>>>>>"+emailID);
	
		boolean flag = false;
		PreparedStatement pstmt = null;
		ResultSet result=null;
		
		
		String query ="select * from admin_info where email_ID=? and password=?";
		   
	
		try {
			
			Connection conn = com.Inventory.connection.Connection.getConnection();
			pstmt = conn.prepareStatement(query);
			
		System.out.println("query of user is"+query);
		
		
			pstmt.setString(1, emailID);
			pstmt.setString(2, password);
			
			result=pstmt.executeQuery();
			
	System.out.println("hhhhhhhhhhhhhhhhhhhhhhhh"+result);		
			
	  if(result.next())	{
		  
		    System.out.println("enter into result set====================");
				flag = true;				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}	

 public static boolean addIssueRecord(String nameInventory,String issueDate,String issueDepartmentName){
	 
	 boolean flag=false;
	 
	 PreparedStatement pstmt = null;
		
		String query ="insert into issue_record(nameofInventory,issue_date,issue_to_department_id) values (?,?,?)";
		
		try {
			
			Connection conn = com.Inventory.connection.Connection.getConnection();
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, nameInventory);
			pstmt.setString(2, issueDate);
			
			//pstmt.setString(3, issueNoDay);
			//pstmt.setString(4, returnDate);
			//pstmt.setString(5, versionInventory);
			
			pstmt.setString(3, issueDepartmentName);
			
			
		if(pstmt.executeUpdate() == 1)	{
				flag = true;				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	return flag; 
   }
 public static boolean addPurchaseRecord(String nameInventory,String purchaseDate,String amountofInventory,String vendorName){
	 
	 boolean flag=false;
	 
	 PreparedStatement pstmt = null;
		
		String query ="insert into purchase_record(nameofInventory,purchage_date,amountofInventory,vendor_name) values (?,?,?,?)";
		
		try {
			
			Connection conn = com.Inventory.connection.Connection.getConnection();
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, nameInventory);
			pstmt.setString(2, purchaseDate);
			
			//pstmt.setString(3, versionInventory);
			
			pstmt.setString(3, amountofInventory);
			pstmt.setString(4, vendorName);
			
			//pstmt.setString(6, quality);
			
			
		if(pstmt.executeUpdate() == 1)	{
				flag = true;				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
   return flag;
    }
 
public static boolean addProduct(String nameOfProduct,String descriptionProduct,String netAmount,String unitMearueMent){
	 
	 boolean flag=false;
	 
	 PreparedStatement pstmt = null;
		
		String query ="insert into fixedAsset_info(product_name,description_Product,netAmount,unit_measurement) values (?,?,?,?)";
		
		try {
			
			Connection conn = com.Inventory.connection.Connection.getConnection();
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, nameOfProduct);
			pstmt.setString(2, descriptionProduct);
			pstmt.setString(3, netAmount);
			pstmt.setString(4, unitMearueMent);
			
			
			
		if(pstmt.executeUpdate() == 1)	{
				flag = true;				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
   return flag;
    }

 
 
 
 public static ArrayList<purchaseRecord> getAllPurchaseRecord(){
	
	   System.out.println("Enter into getAll purchase record method");
	   

		boolean flag = false;
		PreparedStatement pstmt = null;
		ResultSet result=null;
	   
	   purchaseRecord purchaseReco=null;
	 
	   ArrayList<purchaseRecord> listPur=new ArrayList<purchaseRecord>();
	 
	 
	   try {
		      String query ="select * from purchase_record";

				Connection conn = com.Inventory.connection.Connection.getConnection();
				pstmt = conn.prepareStatement(query);
				result=pstmt.executeQuery();
				
		while(result.next())	{
			  
			    System.out.println("enter into result set====================");
			    
			    purchaseReco=new purchaseRecord();
			    
			    purchaseReco.setProductID(result.getInt("product_ID"));
			    purchaseReco.setNameOfInventory(result.getString("nameofInventory"));
			    purchaseReco.setPurchaseDate(result.getString("purchage_date"));
			    //purchaseReco.setVersionOfInventory(result.getString("versionInventory"));
			    purchaseReco.setAmountOfInventory(result.getString("amountofInventory"));
			    purchaseReco.setVendorName(result.getString("vendor_name"));
			   // purchaseReco.setQuality(result.getString("qty"));
			 
			    listPur.add(purchaseReco);
			    
			    }
	         } 
	    catch (Exception e) {
			 e.printStackTrace();
		 }
	    return listPur;
	   }
 
 
 public static ArrayList<issueRecord> getAllIssueRecord(){
		
	   System.out.println("Enter into getAll issue record method");
	   
		boolean flag = false;
		PreparedStatement pstmt = null;
		ResultSet result=null;
	   
		issueRecord issueReco=null;
	 
	   ArrayList<issueRecord> listPur=new ArrayList<issueRecord>();
	 
	 
	   try {
		      String query ="select * from issue_record";

				Connection conn = com.Inventory.connection.Connection.getConnection();
				pstmt = conn.prepareStatement(query);
				result=pstmt.executeQuery();
				
		while(result.next())	{
			  
			    System.out.println("enter into result set====================");
			    
			    issueReco=new issueRecord();
			    
			    issueReco.setProductID(result.getInt("product_ID"));
			    issueReco.setNameInventory(result.getString("nameofInventory"));
			    issueReco.setIssueDate(result.getString("issue_date"));
			    
			       //issueReco.setIssueNoDay(result.getString("issueNoDay"));
			      //issueReco.setReturnDate(result.getString("returnDate"));
			     //issueReco.setVersionOfInventory(result.getString("versionInventory"));
			    
			    issueReco.setIssueToDepartment(result.getString("issue_to_department_id"));
			 
			    listPur.add(issueReco);
			    
			    }
	         } 
	    catch (Exception e) {
			 e.printStackTrace();
		 }
	    return listPur;
	   }


 
 public static ArrayList<purchaseRecord> editPurchaseRecord(int ids){
		
	   System.out.println("Enter into getAll purchase record method");
	   

		boolean flag = false;
		PreparedStatement pstmt = null;
		ResultSet result=null;
	   
	   purchaseRecord purchaseReco=null;
	 
	   ArrayList<purchaseRecord> listPur=new ArrayList<purchaseRecord>();
	 
	 
	   try {
		      String query ="select * from purchase_record where product_ID=?";

				Connection conn = com.Inventory.connection.Connection.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, ids);
				
				result=pstmt.executeQuery();
				
		while(result.next())	{
			  
			    System.out.println("enter into result set====================");
			    
			    purchaseReco=new purchaseRecord();
			    
			    purchaseReco.setProductID(result.getInt("product_ID"));
			    purchaseReco.setNameOfInventory(result.getString("nameofInventory"));
			    purchaseReco.setPurchaseDate(result.getString("purchage_date"));
			    //purchaseReco.setVersionOfInventory(result.getString("versionInventory"));
			    purchaseReco.setAmountOfInventory(result.getString("amountofInventory"));
			    purchaseReco.setVendorName(result.getString("vendor_name"));
			   // purchaseReco.setQuality(result.getString("qty"));
			 
			    listPur.add(purchaseReco);
			    
			    }
	         } 
	    catch (Exception e) {
			 e.printStackTrace();
		 }
	    return listPur;
	   }
 
 public static ArrayList<addProduct> editAddProduct(int ids){
		
	   System.out.println("Enter into getAll purchase record method");


		boolean flag = false;
		PreparedStatement pstmt = null;
		ResultSet result=null;
	   
		addProduct purchaseReco=null;
	 
	   ArrayList<addProduct> listPur=new ArrayList<addProduct>();
	 
	 
	   try {
		      String query ="select * from fixedAsset_info where product_ID=?";

				Connection conn = com.Inventory.connection.Connection.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, ids);
				
				result=pstmt.executeQuery();
				
		while(result.next())	{
			  
			    System.out.println("enter into result set====================");
			    
			    purchaseReco=new addProduct();
			    
			    purchaseReco.setProductID(result.getInt("product_ID"));
			    purchaseReco.setProductName(result.getString("product_name"));
			    purchaseReco.setProductDecription(result.getString("description_Product"));
			    purchaseReco.setNetAmount(result.getString("netAmount"));
			    //purchaseReco.setProductType(result.getString("product_type"));
			    
			    
			    listPur.add(purchaseReco);
			    
			    }
	         } 
	    catch (Exception e) {
			 e.printStackTrace();
		 }
	    return listPur;
	   }

 
 public static ArrayList<issueRecord> editIssueRecord(int ids){
		
	   System.out.println("Enter into getAll purchase record method");
	   

		boolean flag = false;
		PreparedStatement pstmt = null;
		ResultSet result=null;
	   
		issueRecord issueReco=null;
	 
	   ArrayList<issueRecord> issuelist=new ArrayList<issueRecord>();
	 
	 
	   try {
		      String query ="select * from issue_record where product_ID=?";

				Connection conn = com.Inventory.connection.Connection.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, ids);
				
				result=pstmt.executeQuery();
				
		while(result.next())	{
			  
			    System.out.println("enter into result set====================");
			    
			    issueReco=new issueRecord();
			    
			    issueReco.setProductID(result.getInt("product_ID"));
			    issueReco.setNameInventory(result.getString("nameofInventory"));
			    issueReco.setIssueDate(result.getString("issue_date"));
			    
			      //issueReco.setIssueNoDay(result.getString("issueNoDay"));
			     //issueReco.setReturnDate(result.getString("returnDate"));
			    //issueReco.setVersionOfInventory(result.getString("versionInventory"));
			    
			    issueReco.setIssueToDepartment(result.getString("issue_to_department_id"));
			 
			    issuelist.add(issueReco);
			    
			    }
	         } 
	    catch (Exception e) {
			 e.printStackTrace();
		 }
	    return issuelist;
	   }
 
 
 
public static boolean updatePurchaseRecord(String nameInventory,String purchaseDate,String amountofInventory,String vendorName,int productID){
 
 boolean flag=false;
 
 PreparedStatement pstmt = null;
	
	String query ="update purchase_record SET nameofInventory=?,purchage_date=?,amountofInventory=?,vendor_name=? where product_ID=?";
	
	try {
		
		Connection conn = com.Inventory.connection.Connection.getConnection();
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, nameInventory);
		pstmt.setString(2, purchaseDate);
		//pstmt.setString(3, versionInventory);
		pstmt.setString(3, amountofInventory);
		pstmt.setString(4, vendorName);
		//pstmt.setString(6, quality);
		pstmt.setInt(5, productID);
		
		
	if(pstmt.executeUpdate() == 1)	{
			flag = true;				
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
return flag;
 
    }

public static boolean updateProduct(String nameProduct,String productDesc,String productType,int productID){
	 
	 boolean flag=false;
	 
	 PreparedStatement pstmt = null;
		
		String query ="update fixedAsset_info SET product_name=?,description_Product=?,netAmount=? where product_ID=?";
		
		try {
			
			Connection conn = com.Inventory.connection.Connection.getConnection();
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, nameProduct);
			pstmt.setString(2, productDesc);
			pstmt.setString(3, productType);
			pstmt.setInt(4, productID);
			
	   if(pstmt.executeUpdate() == 1)	{
	 		flag = true;				
		 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	return flag;
	 
	    }


public static boolean deletePoductID(int productID){
	 
	 boolean flag=false;
	 
	 PreparedStatement pstmt = null;
		
		String query ="delete  from fixedAsset_info where product_ID=?";
		
		try {
			
			Connection conn = com.Inventory.connection.Connection.getConnection();
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, productID);
			
			
	   if(pstmt.executeUpdate() == 1)	{
	 		flag = true;				
		 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	return flag;
	 
	    }

public static boolean deleteIssueRecord(int productID){
	 
	 boolean flag=false;
	 
	 PreparedStatement pstmt = null;
		
		String query ="delete  from issue_record where product_ID=?";
		
		try {
			
			Connection conn = com.Inventory.connection.Connection.getConnection();
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, productID);
			
			
	   if(pstmt.executeUpdate() == 1)	{
	 		flag = true;				
		 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	return flag;
	 
	    }


public static boolean deletePurchaseRecord(int productID){
	 
	 boolean flag=false;
	 
	 PreparedStatement pstmt = null;
		
		String query ="delete  from purchase_record where product_ID=?";
		
		try {
			
			Connection conn = com.Inventory.connection.Connection.getConnection();
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, productID);
			
			
	   if(pstmt.executeUpdate() == 1)	{
	 		flag = true;				
		 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	return flag;
	 
	    }


public static ArrayList<addProduct> getProductNameList(){
		
	   System.out.println("Enter into getAll issue record method");
	   
		boolean flag = false;
		PreparedStatement pstmt = null;
		ResultSet result=null;
	   
		addProduct productNameList=null;
	 
	   ArrayList<addProduct> listPur=new ArrayList<addProduct>();
	 
	 
	   try {
		      String query ="select * from fixedAsset_info";

				Connection conn = com.Inventory.connection.Connection.getConnection();
				pstmt = conn.prepareStatement(query);
				result=pstmt.executeQuery();
				
		while(result.next())	{
			  
			    System.out.println("enter into result set====================");
			    
			    productNameList=new addProduct();
			    
			    productNameList.setProductID(result.getInt("product_ID"));
			    productNameList.setProductName(result.getString("product_name"));
			    productNameList.setProductDecription(result.getString("description_Product"));
			    productNameList.setNetAmount(result.getString("netAmount"));
			   // productNameList.setProductType(result.getString("product_type"));
			    
			    listPur.add(productNameList);
			    
			    }
	         } 
	    catch (Exception e) {
			 e.printStackTrace();
		 }
	    return listPur;
	   }
public static ArrayList<measureMent> getMeasureMentList(){
	
	   System.out.println("Enter into getAll MeasureMent record method");
	   
		boolean flag = false;
		PreparedStatement pstmt = null;
		ResultSet result=null;
	   
		measureMent productNameList=null;
	 
	   ArrayList<measureMent> listPur=new ArrayList<measureMent>();
	 
	 
	   try {
		      String query ="select * from unit_measurement";

				Connection conn = com.Inventory.connection.Connection.getConnection();
				pstmt = conn.prepareStatement(query);
				result=pstmt.executeQuery();
				
		while(result.next())	{
			  
			    System.out.println("enter into result set====================");
			    
			    productNameList=new measureMent();
			    
			    productNameList.setMeasureID(result.getInt("measureID"));
			    productNameList.setMeasureName(result.getString("unit_measurement"));
			    
			    
			    
			    
			    listPur.add(productNameList);
			    
			    }
	         } 
	    catch (Exception e) {
			 e.printStackTrace();
		 }
	    return listPur;
	   }




public static ArrayList<department> getDepartmentName(){
	
	   System.out.println("Enter into getAll issue record method");
	   
		boolean flag = false;
		PreparedStatement pstmt = null;
		ResultSet result=null;
	   
		department productNameList=null;
	 
	   ArrayList<department> listPur=new ArrayList<department>();
	 
	 
	   try {
		      String query ="select * from departments";

				Connection conn = com.Inventory.connection.Connection.getConnection();
				pstmt = conn.prepareStatement(query);
				result=pstmt.executeQuery();
				
		while(result.next())	{
			  
			    System.out.println("enter into result set====================");
			    
			    productNameList=new department();
			    
			    productNameList.setDepartmentID(result.getInt("department_id"));
			    productNameList.setDepartmentName(result.getString("department_name"));
			    
			    listPur.add(productNameList);
			    
			    }
	         } 
	    catch (Exception e) {
			 e.printStackTrace();
		 }
	    return listPur;
	   }
public static ArrayList<addProduct> getAllAddProduct(){
	
	   System.out.println("Enter into getAll purchase record method");
	   

		boolean flag = false;
		PreparedStatement pstmt = null;
		ResultSet result=null;
	   
		addProduct purchaseReco=null;
	 
	   ArrayList<addProduct> listPur=new ArrayList<addProduct>();
	 
	 
	   try {
		      String query ="select * from fixedAsset_info";

				Connection conn = com.Inventory.connection.Connection.getConnection();
				pstmt = conn.prepareStatement(query);
				result=pstmt.executeQuery();
				
		while(result.next())	{
			  
			    System.out.println("enter into result set====================");
			    
			    purchaseReco=new addProduct();
			    
			    purchaseReco.setProductID(result.getInt("product_ID"));
			    purchaseReco.setProductName(result.getString("product_name"));
			    purchaseReco.setProductDecription(result.getString("description_Product"));
			    purchaseReco.setNetAmount(result.getString("netAmount"));
			    //purchaseReco.setProductType(result.getString("product_type"));
			    
			    
			    listPur.add(purchaseReco);
			    
			    }
	         } 
	    catch (Exception e) {
			 e.printStackTrace();
		 }
	    return listPur;
	   }
   }
