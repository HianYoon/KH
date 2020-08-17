package com.view;

import java.util.List;
import java.util.Scanner;

import com.controller.MainController;
import com.model.vo.Board;
import com.model.vo.Member;

public class MenuView {
	private Scanner sc = new Scanner(System.in);
	private MainController mc = null;
	
	public MenuView() {
		// TODO Auto-generated constructor stub
	}
	public MenuView(MainController mc) {
		this.mc=mc;
	}
	//////////////////////////////////////////////
	////////메인메뉴//////////////////////////////
	//////////////////////////////////////////////
	public void mainMenu() {
		while (true) {
			System.out.println("===== 메인 메뉴 =====");
			System.out.println("1. 회원관리");
			System.out.println("2. 게시판관리");
			System.out.println("3. 프로그램 종료");
			System.out.print("메뉴 번호 : ");
			int choice=0;
			String temp = sc.nextLine();
			if(temp.matches("^[0-9]*$")) choice=Integer.parseInt(temp);
			else choice=-1;
			switch(choice) {
			case 1: mc.memberMenu(); break;
			case 2:	mc.boardMenu(); break;
			case 3: System.out.println("프로그램을 종료합니다."); return;
				default: System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void memberMenu() {
		while (true) {
			System.out.println("===== 회원관리 서브 메뉴 =====");
			System.out.println("1. 전체회원조회");
			System.out.println("2. 회원 아이디로 조회");
			System.out.println("3. 회원 이름으로 조회");
			System.out.println("4. 회원가입");
			System.out.println("5. 회원정보수정(주소, 전화번호, 이메일)");
			System.out.println("6. 회원탈퇴");
			System.out.println("7. 메인메뉴로");
			System.out.print("메뉴 번호 : ");
			int choice=0;
			String temp = sc.nextLine();
			if(temp.matches("^[0-9]*$")) choice=Integer.parseInt(temp);
			else choice=-1;
			switch(choice) {
			case 1: mc.selectAllMembers(); break;
			case 2:	mc.searchById(); break;
			case 3: mc.searchByName(); break;
			case 4:	mc.enrollMember(); break;
			case 5:	mc.updateMember(); break;
			case 6:	mc.deleteMember(); break;
			case 7: System.out.println("이전 메뉴로 돌아갑니다."); return;
				default: System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void boardMenu() {
		while (true) {
			System.out.println("===== 게시판 서브 메뉴 =====");
			System.out.println("1. 게시판 전체 검색");
			System.out.println("2. 게시물 등록");
			System.out.println("3. 작성자로 조회");
			System.out.println("4. 제목으로 검색");
			System.out.println("5. 게시물 수정(제목, 내용)");
			System.out.println("6. 게시물 삭제");
			System.out.println("7. 메인메뉴로");
			System.out.print("메뉴 번호 : ");
			int choice=0;
			String temp = sc.nextLine();
			if(temp.matches("^[0-9]*$")) choice=Integer.parseInt(temp);
			else choice=-1;
			switch(choice) {
			case 1:  mc.selectAllBoard(); break;
			case 2:	 break;
			case 3:  break;
			case 4:	 break;
			case 5:	 break;
			case 6:	 break;
			case 7: System.out.println("이전 메뉴로 돌아갑니다."); return;
				default: System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
			}
		}
	}
	
	//////////////////////////////////////////////
	////////공용//////////////////////////////////
	//////////////////////////////////////////////
	public void printTitle(String title) {
		System.out.println("===== "+title+" =====");
	}
	
	public void printMessage(String msg, boolean flag) {
		if (flag) System.out.println("!"+msg+" 성공");
		else System.out.println("!"+msg+" 실패");
	}
	
	public void printMessage(String msg) {
		System.out.println("!"+msg);
	}
	
	public String inputText(String title) {
		System.out.println("===== "+title+" =====");
		return sc.nextLine();
	}
	//////////////////////////////////////////////
	////////회원메뉴//////////////////////////////
	//////////////////////////////////////////////
	
	public void printMembers(List<Member> list) {
		System.out.println(list);
	}
	
	
	public Member inputMemberInfo() {
		printTitle("회원 가입");
		String memberId="", memberPwd="", memberName="";
		while(memberId.length()==0 && memberPwd.length()==0 && memberName.length()==0) {
			memberId = inputText("회원 아이디 입력");
			memberPwd = inputText("비밀번호 입력");
			memberName = inputText("회원 이름 입력");
			if(memberId.length()==0) System.out.println("회원 아이디가 입력되지 않았습니다.");
			if(memberPwd.length()==0) System.out.println("비밀번호가 입력되지 않았습니다.");
			if(memberName.length()==0) System.out.println("회원 이름이 입력되지 않았습니다.");
		}
		String email = inputText("회원 이메일 입력");
		String address = inputText("회원 주소 입력");
		String phone = inputText("회원 전화번호 입력");
		
		return new Member(memberId, memberPwd, memberName, email, 
					address, phone);
	}
	
	public Member updateMember(Member m) {
		m.setEmail(inputText("회원 이메일 입력"));
		m.setAddress(inputText("회원 주소 입력"));
		m.setPhone(inputText("회원 전화번호 입력"));
		return m;
	}
	
	//////////////////////////////////////////////
	////////게시판메뉴////////////////////////////
	//////////////////////////////////////////////
	
	public void printArticle(List<Board> list) {
		System.out.println(list);
	}
}
