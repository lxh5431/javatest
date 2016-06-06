package testDB;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class TestDB {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try{
			runTest();
			
		}catch(SQLException ex){
			for(Throwable t:ex)
				t.printStackTrace();
		
		}

	}
	public static void runTest() throws SQLException,IOException{
		try(Connection conn=getConnection()){
        Statement stat=conn.createStatement();
        stat.executeUpdate("CREATE TABLE Greetings(Message CHAR(20))");
        stat.executeLargeUpdate("INSERT INTO Greetings VALUES('Hello, World!')");
        try(ResultSet result=stat.executeQuery("SELECT * FROM Greetings")){
        	if(result.next())
        		System.out.println(result.getString(1));
        }
        stat.executeUpdate("DROP TABLE Greetings");
		}
	}
	public static Connection getConnection() throws SQLException,IOException{
		Properties props=new Properties();
		try(InputStream in=Files.newInputStream(Paths.get("database.properties"))){
			props.load(in);
			
			
		}
		String drivers=props.getProperty("jdbc.drivers");
		if(drivers!=null)System.setProperty("jdbc.drivers",drivers);
    String url=props.getProperty("jdbc.url");
    String username=props.getProperty("jdbc.username");
    String password=props.getProperty("jdbc.password");
	
	return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/scutcs","root","123456");
		}

}
