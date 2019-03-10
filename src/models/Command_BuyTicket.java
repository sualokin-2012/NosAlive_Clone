package models;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Command_BuyTicket implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		HttpSession httpSession = request.getSession();
		String id = (String)httpSession.getAttribute("MEMBERID");
		System.out.println("id from session = " + id);

		String ticketID = request.getParameter("ticket");
		System.out.println("ticket type = " + ticketID);
		MemberDAO dao = new MemberDAO();
		int ticketCount = dao.getCurrentTicketCount(ticketID);
		
		boolean bBuyTicket = false;
		MemberDAO ticketDao = new MemberDAO();
		bBuyTicket = ticketDao.buyTicket(id, ticketID, ticketCount);
		
		if(bBuyTicket){
			System.out.println("buyticket success");
			RequestDispatcher dispatcher = request.getRequestDispatcher("BuyTicket_Success.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println("buyticket failed");
		}
	}
}
