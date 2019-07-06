import java.sql.Connection;
import java.sql.DriverManager;

public class connectionace{
	
	public static Connection getConection(){
		     try {
                  Class.forName("com.mysql.jdbc.Driver");
             } 
		     catch (ClassNotFoundException e) {
                  System.out.println(e);
             }
		        Connection conn=null;
		     try{
		    	 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysys?useUnicode=true&characterEncoding=UTF-8", "root", "tangjing520");
		        
		        }
		     catch (Exception e) {
		                e.printStackTrace();
	             }
		         return conn;
		     }
	public static void close(Connection conn) {
        try {
            if (conn != null)
                 conn.close();
           } catch (Exception e) {
             e.printStackTrace();
           }
       }

}

