package board.boarddao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import board.boarddto.Boarddto;
import member.memberdao.MemberDAO;

public class Boarddao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static DataSource ds;
	
	private static Boarddao instance;
	
	static {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/board");
		}catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	private Boarddao() {
		
	}
	
	public static Boarddao getInstance() {
		if(instance == null) {
			instance = new Boarddao();
		}
		
		return instance;
	}
	
	public boolean insert(Boarddto dto) {
		boolean check = false;
		String sql = "insert post values(bnum,?,default,?,?,?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBwriter());
			pstmt.setString(2, dto.getBsubject());
			pstmt.setString(3, dto.getBcontent());
			pstmt.setString(4, dto.getBid());
			pstmt.executeUpdate();
			check = true;
		}catch(Exception e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}
	
	public List<Boarddto> AllBoard(){
		String sql = "select * from post";
		List<Boarddto> list = new ArrayList<>();
		
		try {
			conn = ds.getConnection();
			pstmt  = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Boarddto dto = new Boarddto();
				dto.setBnum(rs.getInt(1));
				dto.setBwriter(rs.getString(2));
				dto.setBdate(rs.getDate(3));
				dto.setBsubject(rs.getString(4));
				dto.setBcontent(rs.getString(5));
				dto.setBid(rs.getString(6));
				list.add(dto);
			}
			System.out.println(list);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
