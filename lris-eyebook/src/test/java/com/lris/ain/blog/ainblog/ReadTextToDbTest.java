package com.lris.ain.blog.ainblog;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lris.ain.blog.ainblog.domain.Article;
import com.lris.ain.blog.ainblog.domain.Category;
import com.lris.ain.blog.ainblog.repository.ArticleRepository;
import com.lris.ain.blog.ainblog.repository.CategoryRepository;
import com.lris.ain.blog.ainblog.utils.FileUtils;

/**
 * Hello World 控制器测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReadTextToDbTest {

	@Autowired
    private ArticleRepository articleRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Test
	public void test1() throws Exception {
		System.out.println("##########################");
		System.out.println(articleRepository.findAllByCategoryId(1L));
		System.out.println("--------------------------");
	}
    @Test
    public void testHello() throws Exception {
    	
    	Category catgory = new Category();
    	//String filepath = "F:\\lris-test\\";
    	String filepath = "F:\\PowerWordDict\\popopopo\\b1\\b1\\宠物\\宠物";
		 File f = new File(filepath);
		 //FileUtils.readFileFilter(f, ".txt");
		 System.out.println(f.getName());
		 catgory.setCategoryName(f.getName());
		 catgory= categoryRepository.save(catgory);
		 if(f.isDirectory()) {
			 for(File file:FileUtils.readFileFilter(f, ".txt")) {
				 if(!file.isDirectory()) {
					 System.out.println("-----------");
					 System.out.println(file.getName());
					 System.out.println(FileUtils.readFileToString(file));
					 Article article = new Article();
					 article.setCategoryId(catgory.getId());
					 article.setContent(FileUtils.readFileToString(file));
					 article.setTitle(file.getName());
					 article.setWords(file.getTotalSpace()/1024+"");
					 articleRepository.save(article);
					 System.out.println("-----------");
				 }
			 }
		 }
    	
    }
}
