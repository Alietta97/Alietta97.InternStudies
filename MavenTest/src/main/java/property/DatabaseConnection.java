package property;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 

public class DatabaseConnection {
	
	static final String JDBC_DRIVER = "org.h2.Driver";   
    static final String DB_URL = "jdbc:h2:tcp://localhost/~/test";  
	
    static final String USER = "sa"; 
	static final String PASS = "";
	public static Connection conn;
	
	public static Connection connect() {
		
		
	      try{
	         
	         Class.forName(JDBC_DRIVER);  
	        	         
	         try {
	    	   
	        	 conn = (Connection)DriverManager.getConnection(DB_URL, USER, PASS);
	    	   
		         System.out.println("Connected database successfully...\n"); 
		         
	         	 }	catch(SQLException ex){
	         		 
	         		 	System.out.println("Failed to create the database connection.");
	         		 		
	       			}
	         
	      	 } 	catch(ClassNotFoundException ex) { 
	    	  
	      		 	// Handle errors for JDBC 
	      		 	ex.printStackTrace(); 
	         
	      	 	}
	      
	      System.out.println("\t\t\tWellcome!!!\n"); 
	     
	      return conn;
	}
	
	public static void disconnect() {
		
		try {
        	 if (conn != null)
                 conn.close();
			System.out.println("Closing database ...\n"); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
       
		System.out.print("\t\t\tGoodbye!!!\n");
        
	}
	


}
