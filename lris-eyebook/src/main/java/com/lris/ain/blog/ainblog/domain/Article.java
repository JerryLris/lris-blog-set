package com.lris.ain.blog.ainblog.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 文章
 * @author lris
 *
 */
@Entity
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;//
	
	@Column(nullable = false) // 映射为字段，值不能为空
	private long  categoryId;//
	
	@Column() 
	private String title;//
	
	@Column(columnDefinition="TEXT")
	private String content;//
	
	@Column() 
	private String words;//

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", categoryId=" + categoryId + ", title=" + title + ", content=" + content
				+ ", words=" + words + "]";
	}
	
	
	
}
