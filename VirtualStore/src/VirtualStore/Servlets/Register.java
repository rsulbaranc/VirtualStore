package VirtualStore.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VirtualStore.Controllers.RegisterController;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");	
		
		//Obtener parametros
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String age = request.getParameter("age");
		String country = request.getParameter("country");
		String gender = request.getParameter("gender");
		
		System.out.println(gender);
		
		//Intanciar el metodo Registrar y darle valor a sus parametros
		String respuesta = RegisterController.RegistrarDB(username, password, email, age, country, gender);
		
		PrintWriter out=response.getWriter(); 
			
		//Generar Respuesta
		out.println("<html><body>");
		out.println(respuesta);
		out.println("</body></html>");
		
	}

}
