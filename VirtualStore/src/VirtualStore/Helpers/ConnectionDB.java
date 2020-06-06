package VirtualStore.Helpers;

import java.sql.*;

public class ConnectionDB {
	
public Connection ConenectDB;
	
	public static int EjecutarSql (String sql) {
		int Resultado = 0;
	
	try {	
		
		//I created connection to DataBase
		 Connection ConnectDB = DriverManager.getConnection("jdbc:postgresql://localhost:5432/WatchingDB", "postgres", "superpass");
		 
		//Crear Statement
		Statement st = ConnectDB.createStatement();
			
		
		//rellenar base de datos
		st.executeUpdate(sql);
		 ResultSet rs= st.executeQuery("select * from user");
		 
		if (rs.next()) {
			Resultado = 1;
		}
			
		sql = null;
		st.close();
		st = null;
		
		
		
		System.out.println("Query ejecutado");
		return Resultado;
	} 
	
	catch (SQLException e) {
		
		System.out.println("error en el query: " +e);
		return Resultado;
	}
	//return null;
	}

	public static int LoginSql (String sql) {
		int Resultado = 0;
	
	try {	
		
		//I created connection to DataBase
		 Connection ConnectDB = DriverManager.getConnection("jdbc:postgresql://localhost:5432/WatchingDB", "postgres", "superpass");
		 
		//Crear Statement
		Statement st = ConnectDB.createStatement();
			
		
		//rellenar base de datos
		 ResultSet rs= st.executeQuery(sql);
		 
		if (rs.next()) {
			Resultado = 1;
		}
			
		sql = null;
		st.close();
		st = null;
		
		
		
		System.out.println("Query ejecutado");
		return Resultado;
	} 
	
	catch (SQLException e) {
		System.out.println("error en el query: " +e);
		return Resultado;
	}
	
}

}
