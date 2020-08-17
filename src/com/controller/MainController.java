package com.controller;

import com.view.MenuView;

public class MainController {
	
	private MenuView mv = new MenuView(this);
	private MemberController mc = new MemberController(mv);
	private BoardController bc = new BoardController(mv);
	
	public void mainMenu() {
		mv.mainMenu();
	}
	
	public void memberMenu() {
		mc.memberMenu();
	}
	
	public void boardMenu() {
		bc.boardMenu();
	}
	
	public void selectAllMembers() {
		mc.selectAllMembers();
	}
	
	public void searchById() {
		mc.searchById();
	}
	
	public void searchByName() {
		mc.searchByName();
	}
	
	public void enrollMember() {
		mc.enrollMember();
	}
	
	public void updateMember() {
		mc.updateMember();
	}
	
	public void deleteMember() {
		mc.deleteMember();
	}
	
	public void selectAllBoard() {
		bc.selectAllBoard();
	}
}
