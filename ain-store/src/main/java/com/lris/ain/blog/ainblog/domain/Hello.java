package com.lris.ain.blog.ainblog.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hello implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id; // 用户的唯一标识
	@Column(nullable = false) // 映射为字段，值不能为空
 	private String welcome;
	@Column(nullable = false)
	private String title;

	protected Hello() {// JPA 的规范要求无参构造函数；设为 protected 防止直接使用 
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
