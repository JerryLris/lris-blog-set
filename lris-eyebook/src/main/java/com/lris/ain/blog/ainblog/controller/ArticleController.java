package com.lris.ain.blog.ainblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lris.ain.blog.ainblog.repository.ArticleRepository;
import com.lris.ain.blog.ainblog.repository.CategoryRepository;

/**
 * Hello World 控制器
 * @author lris
 *
 */
@Controller
@RequestMapping("/")
public class ArticleController {

	@Autowired
    private ArticleRepository articleRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@RequestMapping("/")
	public String index() {
		return "redirect:/list";
	}
	
	@RequestMapping("/list")
	public String getArticleList(Model model,
			@RequestParam(value="categoryId",required=false,defaultValue="1") long categoryId) {
		
		model.addAttribute("nowCategory",categoryRepository.findById(categoryId).get().getCategoryName());
		model.addAttribute("categoryList", categoryRepository.findAll());
		model.addAttribute("articleList", articleRepository.findAllByCategoryId(categoryId));
		return "index";
	}
	@RequestMapping("/article")
	public String getArticle(Model model,
			@RequestParam(value="articleId",required=false,defaultValue="1") long articleId) {
		
		model.addAttribute("article", articleRepository.findById(articleId).get());
		return "article";
	}


	
}
