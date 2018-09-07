package com.lris.ain.blog.ainblog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.lris.ain.blog.ainblog.domain.Blog;

/**
 * Blog
 */
public interface BlogRepository extends ElasticsearchRepository<Blog, String> {
	/**
	 * 根据用标题+内容检索
	 * @param name
	 * @param pageable
	 * @return
	 */
	Page<Blog> findByTitleLikeOrContentLike(String title, String content, Pageable pageable);
}
