package models;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.ServletException;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 생성자 DB 연결
	public MemberDAO() {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException ex){
			try {
				throw new ServletException("Class Connection failed");
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String url = "jdbc:mysql://localhost:3306/BulletinBoard?useUnicode=true&characterEncoding=utf8";
		String id = "root";
		String pw = "1111";
		
		try{
			conn = DriverManager.getConnection(url, id, pw);
		}catch(SQLException ex){
			try {
				throw new ServletException("DB Connection failed");
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// 회원 가입
	public boolean registMember(MemberDTO dto) {
		boolean bRet = false;
		
		pstmt = null;
		
		String query = "insert into member(id, password, name, nickname, phone1, phone2, phone3, introduce,hobby, grade, hint, birth, gender)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try{
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getNickname());
			pstmt.setString(5, dto.getPhone1());
			pstmt.setString(6, dto.getPhone2());
			pstmt.setString(7, dto.getPhone3());
			pstmt.setString(8, dto.getIntro());
			pstmt.setString(9, dto.getHobby());
			pstmt.setInt(10, dto.getGrade());
			pstmt.setString(11, dto.getHint());
			pstmt.setDate(12, (Date) dto.getBirth());
			pstmt.setString(13, dto.getGender());
			pstmt.executeUpdate();
			
			pstmt.close();
			
			bRet = true;
			
		}catch(Exception e){
			
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}finally{
			
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e2){
				e2.printStackTrace();
				System.out.println(e2.getMessage());
			}
		}
		
		return bRet;
	}
	
	// 회원 로그인
	public boolean loginMember(String id, String pw) {
		
		pstmt = null;
		rs = null;
		boolean bRet = false;
		String query = "select password from member where id = ?";
		
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			
			if(!rs.next()){
				bRet = false;
			}
				
			if(rs.getString(1).equals(pw)){
				bRet = true;
			}else{
				bRet = false;
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}finally{
			
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e2){
				e2.printStackTrace();
				System.out.println(e2.getMessage());
			}
		}
		
		return bRet;
	}
	
	// 회원 삭제(탈퇴)
	public boolean deleteMemeber(String id, String password) {
		
		//String query = "delete from member where id = ? and password = ?";
		boolean bRet = false;
		pstmt = null;
		rs = null;
		
		try{
			
			String query = "select password from member where id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			System.out.println(id);
			System.out.println(query);
			rs = pstmt.executeQuery();
			if(rs.next()){
				String dbPassword = rs.getString("password");
				System.out.println(dbPassword);
				if(dbPassword.equals(password)){
					String delQuery = "delete from member where id = ?";
					pstmt = conn.prepareStatement(delQuery);
					pstmt.setString(1, id);
					System.out.println(id);
					System.out.println(delQuery);
					pstmt.executeUpdate();
					bRet = true;
				}
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}finally{
			
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e2){
				e2.printStackTrace();
				System.out.println(e2.getMessage());
			}
		}
		
		return bRet;
	}
	
	// 현재 티켓의 전체량 리스트
	public ArrayList<Integer> getCurrentTicketCountList(){
		ArrayList<Integer> ticketList = new ArrayList<Integer>();
		
		pstmt = null;
		rs = null;
		String query = "select count from ticket order by type asc";
		
		try{
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				int resultCount = new Integer(rs.getInt(1));
				ticketList.add(resultCount);
				System.out.println(resultCount);
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e2){
				e2.printStackTrace();
				System.out.println(e2.getMessage());
			}
		}
		
		return ticketList;
	}
	
	// 해당 티켓 아이디에 대해 티켓이 몇장 남았는지 반환
	public int getCurrentTicketCount(String ticketID){
		
		int retVal = -1;
		pstmt = null;
		rs = null;
		String query = "select count from ticket where type = ?";
		
		try{	
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, ticketID);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				retVal = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e2){
				e2.printStackTrace();
				System.out.println(e2.getMessage());
			}
		}
		
		return retVal;
	}
	
	// 티켓 구매
	public boolean buyTicket(String userId, String ticketID, int ticketCount){
		boolean bRet = false;
		
		// 티켓갯수가 0보다 작거나 같으면 리턴한다
		if(ticketCount <= 0){
			return false;
		}else{
		// 티켓 한개를 구매 했으므로 티켓 DB에 카운트를 한개 차감하고 업데이트 한다
			ticketCount--;
		}
			
		pstmt = null;
		PreparedStatement memberPs = null;
		PreparedStatement buyTicketPs = null;
		rs = null;
		String query = "update ticket set count = ? where type = ?";
		String memberQuery = "update member set ticket = ? where id = ?";
		String buyTicketQuery = "insert into buyinfo(userid, tickettype, remaincount)"
				+ "values(?, ?, ?)";
		
		try{
			pstmt = conn.prepareStatement(query);
			conn.setAutoCommit(false);
			pstmt.setInt(1, ticketCount);
			pstmt.setString(2, ticketID);
			System.out.println(query);
			int rn = pstmt.executeUpdate();
			
			memberPs = conn.prepareStatement(memberQuery);
			memberPs.setString(1, ticketID);
			memberPs.setString(2, userId);
			memberPs.executeUpdate();
			
			buyTicketPs = conn.prepareStatement(buyTicketQuery);
			buyTicketPs.setString(1, userId);
			buyTicketPs.setString(2, ticketID);
			buyTicketPs.setInt(3, ticketCount);
			buyTicketPs.executeUpdate();
			
			bRet = true;
			conn.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
			if(conn != null){
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println(e1.getMessage());
				}
			}
		}finally{
			try{
				if(pstmt != null){
					pstmt.close();
					memberPs.close();
				}
				if(conn != null) conn.close();
			}catch(Exception e2){
				e2.printStackTrace();
				System.out.println(e2.getMessage());
			}
		}
		
		return bRet;
	}

	
	// 회원 정보 조회
	public MemberDTO getMemberInfo(String id) {
		MemberDTO retMember = null;
		retMember = new MemberDTO();
		
		pstmt = null;
		rs = null;
		String query = "select * from member where id = ?";
		
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(!rs.next()){
				return null;
			}
			
			retMember.setId(rs.getString(1));
			retMember.setPassword(rs.getString(2));
			retMember.setName(rs.getString(3));
			retMember.setNickname(rs.getString(4));
			retMember.setPhone1(rs.getString(5));
			retMember.setPhone2(rs.getString(6));
			retMember.setPhone3(rs.getString(7));
			retMember.setIntro(rs.getString(8));
			retMember.setHobby(rs.getString(9));
			retMember.setGrade(rs.getInt(10));
			retMember.setHint(rs.getString(11));
			retMember.setBirth(rs.getDate(12));
			retMember.setGender(rs.getString(13));
			
		}catch(Exception e){
			
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e2){
				e2.printStackTrace();
				System.out.println(e2.getMessage());
			}
		}
		
		return retMember;
	}
	
	// 회원 정보 업데이트
	public boolean updateMemberInfo(MemberDTO dto){
		boolean bRet = false;
		
		pstmt = null;
		rs = null;
		String query = "update member set password = ?, nickname = ?, phone1 = ?, phone2 = ?, phone3 = ?, introduce = ?, hint = ? where id = ?";
		
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getPassword());
			pstmt.setString(2, dto.getNickname());
			pstmt.setString(3, dto.getPhone1());
			pstmt.setString(4, dto.getPhone2());
			pstmt.setString(5, dto.getPhone3());
			pstmt.setString(6, dto.getIntro());
			pstmt.setString(7, dto.getHint());
			pstmt.setString(8, dto.getId());			
			int rn = pstmt.executeUpdate();
			bRet = true;			
		}catch(Exception e){
			
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e2){
				e2.printStackTrace();
				System.out.println(e2.getMessage());
			}
		}
		return bRet;
	}
	
	// 회원 정보 리스트 조회
	public ArrayList<MemberDTO> selectList() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		
		pstmt = null;
		String query = "select * from member";
		
		try{
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
			
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString(1));
				dto.setPassword(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setNickname(rs.getString(4));
				dto.setPhone1(rs.getString(5));
				dto.setPhone2(rs.getString(6));
				dto.setPhone3(rs.getString(7));
				dto.setIntro(rs.getString(8));
				dto.setHobby(rs.getString(9));
				dto.setGrade(rs.getInt(10));
				dto.setHint(rs.getString(11));
				dto.setBirth(rs.getDate(12));
				dto.setGender(rs.getString(13));
				list.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e2){
				e2.printStackTrace();
				System.out.println(e2.getMessage());
			}
		}
		
		return list;
	}
}
