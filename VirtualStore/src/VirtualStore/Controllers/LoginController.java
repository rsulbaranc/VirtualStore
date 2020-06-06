package VirtualStore.Controllers;

import VirtualStore.Helpers.Authentication;
import VirtualStore.Helpers.Hashing;

public class LoginController {

public static String  IniciarSesion(String UNameLog, String PassLog) {
		
		
		String passHasheada = Hashing.Encriptar(PassLog);
		System.out.println(PassLog);
		int respuestaLogin = Authentication.Auth(UNameLog, passHasheada);
		
		if (respuestaLogin == 1)
			return "Sesion Iniciada Correctamente";
		else 
			return "Ocurrio un error al intentar iniciar la sesion"
					+ "por favor verifique sus credenciales!";
	}
	
}
