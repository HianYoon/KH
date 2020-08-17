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
	////////���θ޴�//////////////////////////////
	//////////////////////////////////////////////
	public void mainMenu() {
		while (true) {
			System.out.println("===== ���� �޴� =====");
			System.out.println("1. ȸ������");
			System.out.println("2. �Խ��ǰ���");
			System.out.println("3. ���α׷� ����");
			System.out.print("�޴� ��ȣ : ");
			int choice=0;
			String temp = sc.nextLine();
			if(temp.matches("^[0-9]*$")) choice=Integer.parseInt(temp);
			else choice=-1;
			switch(choice) {
			case 1: mc.memberMenu(); break;
			case 2:	mc.boardMenu(); break;
			case 3: System.out.println("���α׷��� �����մϴ�."); return;
				default: System.out.println("�߸��� �����Դϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
	
	public void memberMenu() {
		while (true) {
			System.out.println("===== ȸ������ ���� �޴� =====");
			System.out.println("1. ��üȸ����ȸ");
			System.out.println("2. ȸ�� ���̵�� ��ȸ");
			System.out.println("3. ȸ�� �̸����� ��ȸ");
			System.out.println("4. ȸ������");
			System.out.println("5. ȸ����������(�ּ�, ��ȭ��ȣ, �̸���)");
			System.out.println("6. ȸ��Ż��");
			System.out.println("7. ���θ޴���");
			System.out.print("�޴� ��ȣ : ");
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
			case 7: System.out.println("���� �޴��� ���ư��ϴ�."); return;
				default: System.out.println("�߸��� �����Դϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
	
	public void boardMenu() {
		while (true) {
			System.out.println("===== �Խ��� ���� �޴� =====");
			System.out.println("1. �Խ��� ��ü �˻�");
			System.out.println("2. �Խù� ���");
			System.out.println("3. �ۼ��ڷ� ��ȸ");
			System.out.println("4. �������� �˻�");
			System.out.println("5. �Խù� ����(����, ����)");
			System.out.println("6. �Խù� ����");
			System.out.println("7. ���θ޴���");
			System.out.print("�޴� ��ȣ : ");
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
			case 7: System.out.println("���� �޴��� ���ư��ϴ�."); return;
				default: System.out.println("�߸��� �����Դϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
	
	//////////////////////////////////////////////
	////////����//////////////////////////////////
	//////////////////////////////////////////////
	public void printTitle(String title) {
		System.out.println("===== "+title+" =====");
	}
	
	public void printMessage(String msg, boolean flag) {
		if (flag) System.out.println("!"+msg+" ����");
		else System.out.println("!"+msg+" ����");
	}
	
	public void printMessage(String msg) {
		System.out.println("!"+msg);
	}
	
	public String inputText(String title) {
		System.out.println("===== "+title+" =====");
		return sc.nextLine();
	}
	//////////////////////////////////////////////
	////////ȸ���޴�//////////////////////////////
	//////////////////////////////////////////////
	
	public void printMembers(List<Member> list) {
		System.out.println(list);
	}
	
	
	public Member inputMemberInfo() {
		printTitle("ȸ�� ����");
		String memberId="", memberPwd="", memberName="";
		while(memberId.length()==0 && memberPwd.length()==0 && memberName.length()==0) {
			memberId = inputText("ȸ�� ���̵� �Է�");
			memberPwd = inputText("��й�ȣ �Է�");
			memberName = inputText("ȸ�� �̸� �Է�");
			if(memberId.length()==0) System.out.println("ȸ�� ���̵� �Էµ��� �ʾҽ��ϴ�.");
			if(memberPwd.length()==0) System.out.println("��й�ȣ�� �Էµ��� �ʾҽ��ϴ�.");
			if(memberName.length()==0) System.out.println("ȸ�� �̸��� �Էµ��� �ʾҽ��ϴ�.");
		}
		String email = inputText("ȸ�� �̸��� �Է�");
		String address = inputText("ȸ�� �ּ� �Է�");
		String phone = inputText("ȸ�� ��ȭ��ȣ �Է�");
		
		return new Member(memberId, memberPwd, memberName, email, 
					address, phone);
	}
	
	public Member updateMember(Member m) {
		m.setEmail(inputText("ȸ�� �̸��� �Է�"));
		m.setAddress(inputText("ȸ�� �ּ� �Է�"));
		m.setPhone(inputText("ȸ�� ��ȭ��ȣ �Է�"));
		return m;
	}
	
	//////////////////////////////////////////////
	////////�Խ��Ǹ޴�////////////////////////////
	//////////////////////////////////////////////
	
	public void printArticle(List<Board> list) {
		System.out.println(list);
	}
}
