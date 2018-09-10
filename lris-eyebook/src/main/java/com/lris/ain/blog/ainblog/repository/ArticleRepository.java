package com.lris.ain.blog.ainblog.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lris.ain.blog.ainblog.domain.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>{

	public List<Article> findAllByCategoryId(long categoryId);
	
}
