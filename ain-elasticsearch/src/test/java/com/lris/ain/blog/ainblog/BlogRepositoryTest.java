package com.lris.ain.blog.ainblog;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.lris.ain.blog.ainblog.domain.Blog;
import com.lris.ain.blog.ainblog.repository.BlogRepository;


/**
 * BlogRepository 测试类.
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogRepositoryTest {
	
	@Autowired
    private BlogRepository blogRepository;
	
	@Test
	public void test() {
		blogRepository.deleteAll();
		blogRepository.save(new Blog("1","江城子·乙卯正月二十日夜记梦",
				"十年生死两茫茫，不思量，自难忘。千里孤坟，无处话凄凉。纵使相逢应不识，尘满面，鬓如霜。夜来幽梦忽还乡，小轩窗，正梳妆。相顾无言，惟有泪千行。料得年年肠断处，明月夜，短松冈"));
		blogRepository.save(new Blog("2","天净沙·秋思",
				"枯藤老树昏鸦，小桥流水人家，古道西风瘦马，夕阳西下，断肠人在天涯。"));
		blogRepository.save(new Blog("3","虞美人·春花秋月何时了",
				"春花秋月何时了，往事知多少。小楼昨夜又东风，故国不堪回首月明中。雕阑玉砌应犹在，只是朱颜改。问君能有几多愁，恰是一江春水向东流。"));
		blogRepository.save(new Blog("4","",
				"宿昔朱颜成暮齿，须臾白发变垂髫。一生几许伤心事，不向空门何处销。销，解脱。空门，佛门"));
		
		Pageable pageable = new PageRequest(0, 20);
		Page<Blog> page = blogRepository.findByTitleLikeOrContentLike("天", "小", pageable);
		//assertThat(page.getTotalElements()).isEqualTo(2);
		for(Blog blog:page.getContent()) {
			System.out.println(blog);
		}
	}
}
