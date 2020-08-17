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
		mv.printTitle("��ü ȸ�� ��ȸ");
		List<Member> list=ms.selectAllMember();
		mv.printMembers(list);
		mv.printMessage("��ü ȸ�� ��ȸ", list!=null&&list.size()!=0);
		return list;
	}
	
	public void searchById() {
		mv.printTitle("ȸ�� ���̵�� ��ȸ");
		String id = mv.inputText("�˻��� ���̵� �Է�");
		List<Member> list=ms.searchById(id);
		mv.printMembers(list);
		mv.printMessage("ȸ�� ���̵� "+id+"�� �˻�", list!=null&&list.size()!=0);
	}
	
	public void searchByName() {
		mv.printTitle("ȸ�� �̸����� ��ȸ");
		String name = mv.inputText("�˻��� �̸� �Է�");
		List<Member> list=ms.searchByName(name);
		mv.printMembers(list);
		mv.printMessage("ȸ�� �̸� "+name+"�� �˻�", list!=null&&list.size()!=0);
	}
	
	public void enrollMember() {
		mv.printTitle("ȸ�� ����");
		Member m = mv.inputMemberInfo();
		mv.printMessage("ȸ�� ����", ms.enrollMember(m));
	}
	
	public void updateMember() {
		mv.printTitle("ȸ����������");
		
		boolean result =false;
		List<Member> list = selectAllMembers();
		String id = mv.inputText("������ ������ ȸ���� ���̵� �Է�");
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
		if(m==null) mv.printMessage(id+"�� �ش��ϴ� ȸ���� �����ϴ�.");
		else mv.printMessage("ȸ�� ���� ����", result);
	}
	
	public void deleteMember() {
		mv.printTitle("ȸ�� Ż��");
		
		boolean result =false;
		List<Member> list = selectAllMembers();
		String id = mv.inputText("Ż���� ȸ���� ���̵� �Է�");
		Member m =null;
		for(Member v : list) {
			if(v.getMemberId().equals(id)) {
				m = v;
				list.clear();
				list.add(m);
				mv.printMembers(list);
				Loop:
					while(true) {
						char yn = mv.inputText(m.getMemberName()+"���� ������ �����մϱ�?(y/n)").charAt(0);
						switch (yn){
						case 'y': case 'Y': result=ms.deleteMember(m); break Loop;
						case 'n': case 'N': break;
						default: continue Loop;
						}
					}
				break;
			}
		}
		if(m==null) mv.printMessage(id+"�� �ش��ϴ� ȸ���� �����ϴ�.");
		else mv.printMessage("ȸ��"+m.getMemberName()+"�� Ż��", result);
	}
}
