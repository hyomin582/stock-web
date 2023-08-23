package com.naver.phone.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.naver.phone.dto.PhoneDto;

@Repository
public class PhoneDao {
	final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	public Connection open() { 
		Connection conn = null;
		 try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL,"ora_user","********");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 연결오류"); 
		}
		return conn;
	}
	
	
	// 회원가입 중 모든 아이디 조희 
	public List<PhoneDto> selectMember() throws Exception{
		Connection conn = open();
		ArrayList<PhoneDto> phoneDto = new ArrayList<>();
		
		// 모든 userid 가져오기
		String sql = "SELECT userid FROM USERTB";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		try (conn; pstmt; rs){
			while(rs.next()) {
				PhoneDto dbDto = new PhoneDto();
				dbDto.setUserid(rs.getString("userid"));
				phoneDto.add(dbDto);
			}
			return phoneDto;
		}
	} //selectMember end
	
	// 회원가입
	public void newMember(PhoneDto p) throws Exception{
		Connection conn = open();
		String sql = "INSERT INTO USERTB VALUES(?,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try(conn;pstmt){
		pstmt.setString(1, p.getUserid());
		pstmt.setString(2, p.getUserpw());
		pstmt.setString(3, p.getNickname());
		pstmt.executeUpdate();
		}
	}
	
	//	로그인하기
	public ArrayList<PhoneDto> getUser() throws Exception {
		Connection con = open();
		
		ArrayList<PhoneDto> userList = new ArrayList<>();
		String sql = "	SELECT userid, userpw FROM usertb	";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		try(con; pstmt; rs) {
			
			while(rs.next()) {
				PhoneDto u = new PhoneDto();
				u.setUserid(rs.getString("userid"));
				u.setUserpw(rs.getString("userpw"));
				userList.add(u);
			}
			return userList;
		}
	}
	
	// 로그인한 아이디의 등록된 전체목록 보기
	public List<PhoneDto> getAll(String userid) throws Exception {
		Connection conn = open();
		List<PhoneDto> phoneList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT b.MBNM, b.MBPH, b.MBAD, c.GROUPNAME	");
		sql.append("  FROM USERTB a								");
		sql.append("	 , MEMTB b								");
		sql.append("	 , GROUPTB c							");
		sql.append(" where a.USERID = ?							");
		sql.append("   AND B.MBGNO=C.MBGNO						");
		sql.append("   AND a.USERID = b.USERID					");
		sql.append(" ORDER BY b.mbnm							");
				
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, userid);
		ResultSet rs = pstmt.executeQuery();
		
		try(conn; pstmt; rs) {
			while(rs.next()) {
				System.out.println("ss");
				PhoneDto n = new PhoneDto();
				n.setMbnm(rs.getString("mbnm"));
				n.setMbph(rs.getString("mbph")); 
				n.setMbad(rs.getString("mbad"));
				n.setGroupname(rs.getString("groupname")); 
				
				phoneList.add(n);
			}
			return phoneList;			
		}
	}	

	//번호 추가하기
	public void addPhone(PhoneDto n) throws Exception {
		Connection conn = open();
			
		String sql = "INSERT INTO MEMTB(USERID, mbnm, mbph, mbad, mbgno) VALUES(?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql); 
			
		try(conn; pstmt) {
			pstmt.setString(1, n.getUserid());
			pstmt.setString(2, n.getMbnm());
			pstmt.setString(3, n.getMbph());
			pstmt.setString(4, n.getMbad());
			pstmt.setString(5, n.getMbgno());
			pstmt.executeUpdate();
			}
	}
	
	//번호 수정하기
	public void update(PhoneDto p,String mbph) throws Exception{
		Connection conn = open();
		
		if(p.getGroupname().equals("가족")) {
			p.setMbgno("10");
		}else if(p.getGroupname().equals("친구")) {
			p.setMbgno("20");
		}else {
			p.setMbgno("30");
		}
		
		String sql = "UPDATE memtb SET mbnm = ?, mbph = ?, mbad = ?, mbgno = ? WHERE mbph =? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try(conn;pstmt){
		pstmt.setString(1, p.getMbnm());
		pstmt.setString(2, p.getMbph());
		pstmt.setString(3, p.getMbad());
		pstmt.setString(4, p.getMbgno());
		pstmt.setString(5, mbph);
		pstmt.executeUpdate();
		}
	}
	
	//번호 삭제하기 
	public void delMem(String mbph) throws Exception{
		Connection conn = open();
		
		String sql = "DELETE FROM MemTb WHERE MBPH = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try(conn; pstmt){
			pstmt.setString(1, mbph);
			if(pstmt.executeUpdate()==0) {
				throw new SQLException("DB 삭제에러");
			}
		}
	}
}
	
	