package VirtualStore.Controllers;

import VirtualStore.Helpers.ConnectionDB;
import VirtualStore.Helpers.Hashing;

public class RegisterController {

	public static String  RegistrarDB(String UNameCon, String PassCon,
			String EmailCon, String AgeCon , String CounCon, String GenCon) {
		
		String PassHash = Hashing.Encriptar(PassCon);
		System.out.println(GenCon);
		String query = ("insert into users values ('" +UNameCon 
				+ "', '" +PassHash+ "', '"  +EmailCon+ "', " + AgeCon 
				+ ", '" +CounCon+ "', '" +GenCon+ "')");
		
		int respuestaRegistro = ConnectionDB.EjecutarSql(query);
		if (respuestaRegistro == 1) {
			System.out.println("Registro Exitoso");
			return "Felicidades! tu registro se ha realizado exitosamente";
		}
		else
			System.out.println("error en el registro");
			return "Ocurrio un error al momento de intentar Registrarte";
	}
	
}
