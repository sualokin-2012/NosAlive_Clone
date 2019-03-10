package models;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Command_MemberRegist implements Command{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String nickname = request.getParameter("nickname");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String intro = request.getParameter("intro");
		String hobby = request.getParameter("hobby");
		int grade = 1;
		String hint = request.getParameter("hint");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		
		MemberDTO dto = new MemberDTO();
		
		dto.setId(id);
		dto.setPassword(password);
		dto.setName(name);
		dto.setNickname(nickname);
		dto.setPhone1(phone1);
		dto.setPhone2(phone2);
		dto.setPhone3(phone3);
		dto.setIntro(intro);
		dto.setHobby(hobby);
		dto.setGrade(grade);
		dto.setHint(hint);
		dto.setBirth(Date.valueOf(birth));
		dto.setGender(gender);
		
		MemberDAO dao = null;
		dao = new MemberDAO();
		boolean bRegist = false;
		bRegist = dao.registMember(dto);
		
		if(bRegist){
			System.out.println("regist success");
			RequestDispatcher dispatcher = request.getRequestDispatcher("MemberRegist_Success.jsp");
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
			System.out.println("regist failed");
		}
	}
}
