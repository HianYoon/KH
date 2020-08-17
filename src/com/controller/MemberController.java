package com.controller;

import java.util.List;

import com.model.service.MemberService;
import com.model.vo.Member;
import com.view.MenuView;

public class MemberController {
	
	private MenuView mv = null;
	private MemberService ms = new MemberService();
	
	public MemberController() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberController(MenuView mv) {
		super();
		this.mv = mv;
	}
	
	public void memberMenu() {
		mv.memberMenu();
	}
	
	public List<Member> selectAllMembers() {
		mv.printTitle("전체 회원 조회");
		List<Member> list=ms.selectAllMember();
		mv.printMembers(list);
		mv.printMessage("전체 회원 조회", list!=null&&list.size()!=0);
		return list;
	}
	
	public void searchById() {
		mv.printTitle("회원 아이디로 조회");
		String id = mv.inputText("검색할 아이디 입력");
		List<Member> list=ms.searchById(id);
		mv.printMembers(list);
		mv.printMessage("회원 아이디 "+id+"로 검색", list!=null&&list.size()!=0);
	}
	
	public void searchByName() {
		mv.printTitle("회원 이름으로 조회");
		String name = mv.inputText("검색할 이름 입력");
		List<Member> list=ms.searchByName(name);
		mv.printMembers(list);
		mv.printMessage("회원 이름 "+name+"로 검색", list!=null&&list.size()!=0);
	}
	
	public void enrollMember() {
		mv.printTitle("회원 가입");
		Member m = mv.inputMemberInfo();
		mv.printMessage("회원 가입", ms.enrollMember(m));
	}
	
	public void updateMember() {
		mv.printTitle("회원정보수정");
		
		boolean result =false;
		List<Member> list = selectAllMembers();
		String id = mv.inputText("정보를 수정할 회원의 아이디 입력");
		Member m =null;
		
		for(Member v : list) {
			if(v.getMemberId().equals(id)) {
				m = v;
				list.clear();
				list.add(m);
				mv.printMembers(list);
				m=mv.updateMember(m);
				result=ms.updateMember(m);
				break;
			}
		}
		if(m==null) mv.printMessage(id+"에 해당하는 회원이 없습니다.");
		else mv.printMessage("회원 정보 수정", result);
	}
	
	public void deleteMember() {
		mv.printTitle("회원 탈퇴");
		
		boolean result =false;
		List<Member> list = selectAllMembers();
		String id = mv.inputText("탈퇴할 회원의 아이디 입력");
		Member m =null;
		for(Member v : list) {
			if(v.getMemberId().equals(id)) {
				m = v;
				list.clear();
				list.add(m);
				mv.printMembers(list);
				Loop:
					while(true) {
						char yn = mv.inputText(m.getMemberName()+"님의 정보를 삭제합니까?(y/n)").charAt(0);
						switch (yn){
						case 'y': case 'Y': result=ms.deleteMember(m); break Loop;
						case 'n': case 'N': break;
						default: continue Loop;
						}
					}
				break;
			}
		}
		if(m==null) mv.printMessage(id+"에 해당하는 회원이 없습니다.");
		else mv.printMessage("회원"+m.getMemberName()+"님 탈퇴", result);
	}
}
