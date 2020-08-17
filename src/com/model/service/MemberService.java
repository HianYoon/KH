package com.model.service;

import static com.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.model.dao.MemberDao;
import com.model.vo.Member;

public class MemberService {
	
	private MemberDao md = new MemberDao();
	
	public List<Member> selectAllMember(){
		Connection conn = getConnection();
		List<Member> list =md.loadMembers(conn,"selectMemberAll",null);
		close(conn);
		return list;
	}
	
	public List<Member> searchById(String id){
		Connection conn = getConnection();
		List<Member> list = md.loadMembers(conn,"searchById",id);
		close(conn);
		return list;
	}
	
	public List<Member> searchByName(String name){
		Connection conn = getConnection();
		List<Member> list = md.loadMembers(conn,"searchByName",name);
		close(conn);
		return list;
	}
	
	public boolean enrollMember(Member m) {
		Connection conn =getConnection();
		boolean result = md.enrollMember(conn,m);
		close(conn);
		return result;
	}
	
	public boolean updateMember(Member m) {
		Connection conn = getConnection();
		boolean result = md.updateMember(conn, m);
		close(conn);
		return result;
	}
	
	public boolean deleteMember(Member m) {
		Connection conn = getConnection();
		boolean result = md.deleteMember(conn, m);
		close(conn);
		return result;
	}
}
