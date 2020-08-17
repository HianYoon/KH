package com.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.model.vo.Member;

public class MemberDao {
	
	Properties prop =new Properties();
	
	public MemberDao() {
		// TODO Auto-generated constructor stub
		try {
			prop.load(new FileReader("resources/sql/sql.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Member> loadMembers(Connection conn, String propQuery, String search) {
		
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<Member>();
		String sql=null;
		if(search!=null) sql = prop.getProperty(propQuery) + "'"+search+"'";
		else sql = prop.getProperty(propQuery);
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Member m = new Member(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4), rs.getString(5), 
						rs.getString(6), rs.getString(7), rs.getDate(8));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public boolean enrollMember(Connection conn, Member m) {
		
		PreparedStatement pstmt = null;
		int result =0;
		String sql = prop.getProperty("enrollMember");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getAddress());
			pstmt.setString(6, m.getPhone());
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result!=0;
	}

	public boolean updateMember(Connection conn, Member m) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMember");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, m.getEmail());
			pstmt.setString(2, m.getAddress());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getMemberId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result!=0;
	}
	
	public boolean deleteMember(Connection conn, Member m) {
		int result =0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMember");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemberId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result!=0;
	}
	
}
