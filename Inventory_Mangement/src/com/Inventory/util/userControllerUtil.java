package com.Inventory.util;

import java.util.ArrayList;

import javax.servlet.http.HttpServlet;

import com.Inventory.bean.addProduct;
import com.Inventory.bean.department;
import com.Inventory.bean.issueRecord;
import com.Inventory.bean.measureMent;
import com.Inventory.bean.purchaseRecord;
import com.Inventory.model.DBUtil;

public class userControllerUtil extends HttpServlet {
	
	
	static ArrayList<purchaseRecord> purlist=null;
	
	static ArrayList<issueRecord>  issuelist=null;
	
	static ArrayList<addProduct>  addProductList=null;
	
	static ArrayList<department> departmentList=null;
	
	static ArrayList<measureMent> measureMentList=null;
	
	
	
	public static ArrayList<measureMent> getMeasureMentList() {
		return measureMentList;
	}

	public static void setMeasureMentList(ArrayList<measureMent> measureMentList) {
		userControllerUtil.measureMentList = measureMentList;
	}

	public static ArrayList<department> getDepartmentList() {
		return departmentList;
	}

	public static void setDepartmentList(ArrayList<department> departmentList) {
		userControllerUtil.departmentList = departmentList;
	}

	public static ArrayList<addProduct> getAddProductList() {
		return addProductList;
	}

	public static void setAddProductList(ArrayList<addProduct> addProductList) {
		userControllerUtil.addProductList = addProductList;
	}

	public static ArrayList<issueRecord> getIssuelist() {
		return issuelist;
	}

	public static void setIssuelist(ArrayList<issueRecord> issuelist) {
		userControllerUtil.issuelist = issuelist;
	}

	public ArrayList<purchaseRecord> getPurlist() {
		return purlist;
	}

	public void setPurlist(ArrayList<purchaseRecord> purlist) {
		this.purlist = purlist;
	}

	public userControllerUtil(String userName,String password,String emailID){
  	   
            DBUtil.addUser(userName,password,emailID);

      }
	 
	public static boolean checkUser(String email,String password){
		
		  boolean flag=DBUtil.checkUserLogin(email,password);
		return flag; 
	   }
	public static boolean addIssueRecord(String nameInventory,String issueDate,String issueDepartmentName){
		 
		 boolean flag=DBUtil.addIssueRecord(nameInventory,issueDate,issueDepartmentName);
		 
		 return flag;
	 }
	public static boolean addPurchaseRecord(String nameInventory,String purchaseDate,String amountofInventory,String vendorName)  {
		
		 boolean flag=DBUtil.addPurchaseRecord(nameInventory,purchaseDate,amountofInventory,vendorName);
		
       return flag;		
	 }
	
	
	public static boolean addProduct(String nameOfProduct,String descriptionofProduct,String netAmount,String unitMearueMent)  {
		
		 boolean flag=DBUtil.addProduct(nameOfProduct,descriptionofProduct,netAmount,unitMearueMent);
		
      return flag;		
	 }
	
	
	
    public static ArrayList<purchaseRecord> getAllPurchaseRecord(){
    	
    
    	    purlist=DBUtil.getAllPurchaseRecord();
    	
    	 
    	    return purlist;
    	
      }
    
    
    public static ArrayList<addProduct> getAllAddProduct(){
    
    	      addProductList=DBUtil.getAllAddProduct();
	    
    	return addProductList;
	
     }
    
    public static ArrayList<issueRecord>  getAllIssueRecord(){
    	
    	
    	   issuelist=DBUtil.getAllIssueRecord();
    	
    	return issuelist;
    }
    
    public static ArrayList<addProduct>  getNameOfProduct(){
    	
    	
    	addProductList=DBUtil.getProductNameList();
 	
 	     return addProductList;
    }
 public static ArrayList<measureMent>  getMeasureName(){
    	
    	
	            measureMentList=DBUtil.getMeasureMentList();
 	
 	     return measureMentList;
   }
    
    
  public static ArrayList<department>  getDepartmentName(){
    	
    	
	             departmentList=DBUtil.getDepartmentName();
 	
 	     return departmentList;
   }
    
    
    
    public static ArrayList<purchaseRecord>  editPurchaseRecord(int ids){
    	
    	
    	 purlist=DBUtil.editPurchaseRecord(ids);
    	
          return purlist;  	
      }
    
    public static ArrayList<addProduct>  editAddProduct(int ids){
    	
    
         	addProductList=DBUtil.editAddProduct(ids);
   	
         return addProductList;  	
     }
    
    
    
    public static ArrayList<issueRecord>  editIssueRecord(int ids){
    	
    	     issuelist=DBUtil.editIssueRecord(ids);
   	
         return issuelist;  	
     }
   public static boolean updatePurchaseRecord(String nameInventory,String purchaseDate,String amountofInventory,String vendorName,int productID)  {
		
		 boolean flag=DBUtil.updatePurchaseRecord(nameInventory,purchaseDate,amountofInventory,vendorName,productID);
		
      return flag;		
	 }
   
   public static boolean updateProduct(String nameProduct,String productDesc,String productType,int productID)  {
		
		 boolean flag=DBUtil.updateProduct(nameProduct,productDesc,productType,productID);
		
    return flag;		
	 }
   
   public static boolean deleteProductID(int productID){
	   
    
	    boolean flag=DBUtil.deletePoductID(productID);
	   
          return flag;  
       }
   
   public static boolean deleteIssueRecord(int productID){
	   
	    
	    boolean flag=DBUtil.deleteIssueRecord(productID);
	   
         return flag;  
      }
   
   public static boolean deletePurchaseRecord(int productID){
	   
	    
	    boolean flag=DBUtil.deletePurchaseRecord(productID);
	   
        return flag;  
     }
   
   
    }











