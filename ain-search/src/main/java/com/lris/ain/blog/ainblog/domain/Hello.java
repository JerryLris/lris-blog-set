package com.lris.ain.blog.ainblog.domain;

public class Hello {

	private long id; // 用户的唯一标识
 	private String welcome;
	private String title;

	public Hello() {
	}

	public Hello(String welcome, String title) {
		this.welcome = welcome;
		this.title = title;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWelcome() {
		return welcome;
	}

	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

}
