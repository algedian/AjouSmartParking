package smartparking;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/Login")
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
		HttpSession session = request.getSession();
		String phoneNum = request.getParameter("phoneNum");
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		User user = (User)session.getAttribute("user");
		if(user != null){
			if(latitude == null || longitude==null){
				response.sendRedirect("Welcome");
				return;
			}else{
				session.setAttribute("latitude", latitude);
				session.setAttribute("longitude", longitude);
				response.sendRedirect("Welcome");
				return;
			}
		}
		session.setAttribute("latitude", latitude);
		session.setAttribute("longitude", longitude);
		
		try {
			user = DB.getUser(phoneNum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("cant get user");
			e.printStackTrace();
		}
		if(user==null){
			request.setAttribute("phoneNum", phoneNum);
			RequestDispatcher rd = request.getRequestDispatcher("/join.jsp");
			rd.forward(request, response);
		}else{
			session.setAttribute("user", user);
			response.sendRedirect("Welcome");
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
