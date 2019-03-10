package models;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Command_UpdateMemberInfo implements Command{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
	
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String intro = request.getParameter("intro");
		String hobby = request.getParameter("hobby");
		String hint = request.getParameter("hint");
		
		MemberDTO dto = new MemberDTO();
		
		dto.setId(id);
		dto.setPassword(password);
		dto.setName(null);
		dto.setNickname(nickname);
		dto.setPhone1(phone1);
		dto.setPhone2(phone2);
		dto.setPhone3(phone3);
		dto.setIntro(intro);
		dto.setHobby(hobby);
		dto.setGrade(0);
		dto.setHint(hint);
		dto.setBirth(null);
		dto.setGender(null);
		
		MemberDAO dao = new MemberDAO();
		boolean bUpdate = false;
		bUpdate = dao.updateMemberInfo(dto);
		
		if(bUpdate){
			System.out.println("update success");
			RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateMemberInfo_Success.jsp");
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
			System.out.println("update failed");
		}
	}
}
