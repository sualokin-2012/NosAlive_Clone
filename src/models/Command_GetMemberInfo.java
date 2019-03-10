package models;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Command_GetMemberInfo implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		HttpSession httpSession = request.getSession();
		
		String id = (String) httpSession.getAttribute("MEMBERID");
		
		MemberDAO dao = null;
		dao = new MemberDAO();
		MemberDTO member = new MemberDTO();
		
		member = dao.getMemberInfo(id);
		
		if(member != null){
			System.out.println("member info inquire success");
			request.setAttribute("Member", member);
			RequestDispatcher dispatcher = request.getRequestDispatcher("MemberInfo.jsp");
		
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
			System.out.println("member info inqiure failed");
		}
	}
}
