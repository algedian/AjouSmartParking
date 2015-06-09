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
 * Servlet implementation class Join
 */
@WebServlet("/Join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Join() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userID = request.getParameter("userID");
		String name = request.getParameter("name");
		User res = null;
		try {
			res = DB.addUser(name, userID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("can't add user name("+name +") userID("+userID+")");
			e.printStackTrace();
		}
		if(res == null){
			request.setAttribute("phoneNum", userID);
			RequestDispatcher rd = request.getRequestDispatcher("join.jsp");
			rd.forward(request, response);
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("user", res);
		}
	}

}
