package com.model.vo;

import java.sql.Date;

public class Board {
	private String div;
	private String title;
	private String comment;
	private String writer;
	private Date writeDate;
	
	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(String div, String title, String comment, String writer) {
		super();
		this.div = div;
		this.title = title;
		this.comment = comment;
		this.writer = writer;
	}

	public Board(String div, String title, String comment, String writer, Date writeDate) {
		super();
		this.div = div;
		this.title = title;
		this.comment = comment;
		this.writer = writer;
		this.writeDate = writeDate;
	}

	public String getDiv() {
		return div;
	}

	public void setDiv(String div) {
		this.div = div;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "\ndiv=" + div + ", title=" + title + ", comment=" + comment + ", writer=" + writer + ", writeDate="
				+ writeDate;
	}
	
}
