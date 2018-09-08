package com.lris.ain.blog.ainblog;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lris.ain.blog.ainblog.repository.ArticleRepository;
import com.lris.ain.blog.ainblog.utils.FileUtils;

/**
 * Hello World 控制器测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReadTextToDbTest {

	@Autowired
    private ArticleRepository articleRepository;
	
    @Test
    public void testHello() throws Exception {
    	
    	String filepath = "F:\\lris-test\\";
		 File f = new File(filepath);
		 //FileUtils.readFileFilter(f, ".txt");
		 System.out.println(f.getName());
		 if(f.isDirectory()) {
			 for(File file:FileUtils.readFileFilter(f, ".txt")) {
				 if(!file.isDirectory()) {
					 System.out.println("-----------");
					 System.out.println(file.getName());
					 System.out.println(FileUtils.readFileToString(file));
					 System.out.println("-----------");
				 }else {
					 
				 }
			 }
		 }
    	
    }
}
