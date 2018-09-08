package com.lris.ain.blog.ainblog.repository;


import org.springframework.data.repository.CrudRepository;

import com.lris.ain.blog.ainblog.domain.Article;

public interface ArticleRepository extends CrudRepository<Article, Long>{

	
}
