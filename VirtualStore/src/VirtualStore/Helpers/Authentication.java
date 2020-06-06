package VirtualStore.Helpers;

import VirtualStore.Helpers.ConnectionDB;

public class Authentication {
	
	public static int Auth(String userLogin, String passLogin) {
		int verificado = 0;
		String query = ("SELECT *FROM users where username = '" +userLogin 
				+ "' and password = '" +passLogin+ "';");
		
		int respuestaAuthentication = ConnectionDB.LoginSql(query);
		
		if (respuestaAuthentication == 1) {
			verificado = 1;
			System.out.println("Autenticado");
			return verificado;}
		else
			System.out.println("error al autenticar");
		return verificado;
	} 

}
