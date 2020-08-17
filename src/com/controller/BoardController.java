package com.controller;

import com.view.MenuView;

public class BoardController {
	
	private MenuView mv = null;
	
	public BoardController() {
		// TODO Auto-generated constructor stub
	}
	public BoardController(MenuView mv) {
		// TODO Auto-generated constructor stub
		this.mv = mv;
	}
	
	public void boardMenu() {
		mv.boardMenu();
	}
	
	public void selectAllBoard() {
		mv.printTitle("게시판 전체 검색");
		
	}
}
