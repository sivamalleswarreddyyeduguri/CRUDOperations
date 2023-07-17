package repository;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOClass {
     public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jdbc";
			String user="root";
			String pass="root";
			Connection con=DriverManager.getConnection(url,user,pass);
			System.out.println("write the query");
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			Statement statement=con.createStatement();
			boolean res=statement.execute(reader.readLine());
			if(res) {
				ResultSet set=statement.getResultSet();
				ResultSetMetaData data=set.getMetaData();
				int count = data.getColumnCount();
				while(set.next()) {
					for(int i=1;i<=count;i++) {
						System.out.println(data.getColumnName(i)+" of the employe is"+set.getObject(i));
					}
					
					System.out.println("------------------------------------------");
					
				}
			}
			con.close();
			
		}
		catch(ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}
}
