package smartparking;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Reservation
 */
@WebServlet("/Reservation")
public class Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String lotID = request.getParameter("lotID");
		String userID = (String) request.getSession().getAttribute("userID");
		HttpSession session = request.getSession();
		RequestDispatcher rd = request.getRequestDispatcher("/reservation.jsp");
		AuthInfo authInfo=(AuthInfo) session.getAttribute("authInfo");
		if(authInfo == null){
			try {
				authInfo = DB.makeReservation(lotID, userID);
				session.setAttribute("authInfo",authInfo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("fail resv");
				e.printStackTrace();
			}
		}else{
			try {
				ParkingLot lot = DB.getLotLoc(authInfo.getAuthKey());
				session.setAttribute("lotLatitude", lot.getLatitude());
				session.setAttribute("lotLongitude", lot.getLongitude());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		authInfo.cal.add(Calendar.MINUTE, 30);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		sdf.setCalendar(authInfo.cal);
		session.setAttribute("expireTime", sdf.format(authInfo.cal.getTime()));
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
