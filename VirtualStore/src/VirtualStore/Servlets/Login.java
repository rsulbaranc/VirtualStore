package VirtualStore.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import VirtualStore.Controllers.LoginController;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
@MultipartConfig
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//HttpSession sesion = request.getSession();
		
				response.setContentType("text/html");	
				
				//Obtener parametros
				
				String usernameLogin = request.getParameter("usernameLogin");
				String passwordLogin = request.getParameter("passwordLogin");
				System.out.println(usernameLogin + passwordLogin);
				//Intanciar el metodo login y darle valor a sus parametros
				String Respuesta = LoginController.IniciarSesion(usernameLogin, passwordLogin);
				
				PrintWriter out=response.getWriter(); 
					
				//Generar Respuesta
				out.println("<html><body>");
				out.println(Respuesta);
				out.println("</body></html>");
				
	}

}
