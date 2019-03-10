package models;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Command_GetMemberList implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		
		MemberDAO dao = null;
		dao = new MemberDAO();
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		
		list = dao.selectList();
		
		if(list != null){
			System.out.println("get memeber list success");
			request.setAttribute("MemberList", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("MemberList.jsp");
			
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
			System.out.println("get member list falied");
		}
	}
}
