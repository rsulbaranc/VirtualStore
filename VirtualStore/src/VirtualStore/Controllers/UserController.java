package VirtualStore.Controllers;

import VirtualStore.Helpers.ConnectionDB;
import VirtualStore.Helpers.Hashing;

public class UserController {

	/*Profe aca podra ver un desastre y un pocoton de querys, perdone el desorden pero no pude
	configurar correctamente el Archivo de propiedades */
	
	//Metodo para Actualizar datos
	public static String Update(String userName, String passwordOld, String emailOld, String ageOld, String countryOld, String genderOld,
			String passwordNew, String emailNew, String ageNew, String countryNew, String genderNew) {
		
		String passHasheadaOld = Hashing.Encriptar(passwordOld);
		String passHasheadaNew = Hashing.Encriptar(passwordNew);
		
		String query1 = ("Update users set password = '" +passHasheadaNew+ "' where password = '" +passHasheadaOld
				+ "' and username = '"+userName+"'; ");
		
		String query2 = ("Update users set email = '" +emailNew+ "' where email = '" +emailOld
				+ "' and username = '"+userName+"'; ");
		
		String query3 = ("Update users set age = '" +ageNew+ "' where age = '" +ageOld
				+ "' and username = '"+userName+"'; ");
		
		String query4 = ("Update users set country = '" +countryNew+ "' where country = '" +countryOld
				+ "' and username = '"+userName+"'; ");
		
		String query5 = ("Update users set gender = '" +genderNew+ "' where gender = '" +genderOld
				+ "' and username = '"+userName+"'; ");
		
		String query = (query1 + query2 + query3 + query4 + query5);
				
		int respuesta = ConnectionDB.EjecutarSql(query);
		
		if (respuesta == 1) {
			return ("Tus datos han sido acutalizados correctamentos");
		}
		return ("Ocurrio un error al intentar actulizar sus datos");
	} 
	
	
	//Metodo para Borrar Usuarios 
	public static String Delete(String userName, String password) {
		
		String passHasheada = Hashing.Encriptar(password);
		System.out.println(passHasheada);
		
		String query = ("DELETE FROM users where username = '" +userName 
				+ "' and password = '" +passHasheada+ "';");
		
		int respuesta = ConnectionDB.EjecutarSql(query);
		
		if (respuesta == 1) {
			return ("Tus datos han sido Eliminados correctamentos");
		}
		return ("Verfique los datos ingresados!");
	} 
	
}
