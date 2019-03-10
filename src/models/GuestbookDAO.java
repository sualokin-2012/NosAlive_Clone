package models;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletException;

public class GuestbookDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// 생성자 DB 연결
	public GuestbookDAO() {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException ex){
			try{
				throw new ServletException("Class Connection failed");
			}catch(ServletException e){
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
	
	// 전체 글 리스트
	public ArrayList<GuestbookDTO> selectList() {
		ArrayList<GuestbookDTO> list = new ArrayList<GuestbookDTO>();
		
		pstmt = null;
		String query = "select number, name, content, password from guestbook order by number desc";
		
		try{
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				GuestbookDTO dto = new GuestbookDTO();
				dto.setNumber(rs.getInt(1));
				dto.setGuestBookName(rs.getString(2));
				dto.setGuestBookContent(rs.getString(3));
				dto.setGuestBookPassword(rs.getString(4));
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
