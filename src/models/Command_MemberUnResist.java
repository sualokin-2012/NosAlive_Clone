package models;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Command_MemberUnResist implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		HttpSession httpSession = request.getSession();
		
		String id = (String) httpSession.getAttribute("MEMBERID");
		String password = (String) httpSession.getAttribute("PASSWORD");
		
		System.out.println(id);
		System.out.println(password);
		
		MemberDAO dao = null;
		dao = new MemberDAO();
		boolean bUnRegist = false;
		bUnRegist = dao.deleteMemeber(id, password);
		
		if(bUnRegist){
			System.out.println("Unregist success");
			RequestDispatcher dispatcher = request.getRequestDispatcher("MemberUnregist_Success.jsp");
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
			System.out.println("Unregist falied");
		}
	}
}
