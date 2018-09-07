package com.lris.ain.blog.ainblog.controller.vo;

public class Item {

	private String title;
	private String name;
	private String detail;
	
	public Item() {
	}
	public Item(String title,String name,String detail) {
		this.title = title;
		this.name = name;
		this.detail = detail;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
}
