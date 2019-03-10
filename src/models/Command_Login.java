package models;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Command_Login implements Command{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		MemberDAO dao = null;
		dao = new MemberDAO();
		boolean bLogin = false;
		bLogin = dao.loginMember(id, password);
		
		if(bLogin){
			System.out.println("login success");
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login_Success.jsp");
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
			System.out.println("login failed");
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login_Failed.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
