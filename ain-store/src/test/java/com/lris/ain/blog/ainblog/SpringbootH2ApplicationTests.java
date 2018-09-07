package com.lris.ain.blog.ainblog;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lris.ain.blog.ainblog.domain.Hello;
import com.lris.ain.blog.ainblog.repository.HelloRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootH2ApplicationTests {
 
	@Autowired 
	private HelloRepository helloRepository;
	
	@Test
	public void test(){
		Optional<Hello> hellos = helloRepository.findById(new Long(1));
		System.out.println(hellos.get());
	}
}
