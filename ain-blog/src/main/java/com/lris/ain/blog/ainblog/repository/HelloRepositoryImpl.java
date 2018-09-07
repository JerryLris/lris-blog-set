package com.lris.ain.blog.ainblog.repository;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.lris.ain.blog.ainblog.domain.Hello;

@Repository
public class HelloRepositoryImpl implements HelloRepository{

	private static AtomicLong counter = new AtomicLong();
	
	private static ConcurrentMap<Long, Hello> helloMap = new ConcurrentHashMap<Long, Hello>();
	
	public HelloRepositoryImpl() {
		Hello hello = new Hello();
		hello.setTitle("welcome");
		hello.setWelcome("welcome welcome very very warm welcome!");
		this.saveOrUpateHello(hello);
	}
	
	@Override
	public Hello saveOrUpateHello(Hello hello) {
		Long id = hello.getId();
		if (id <= 0) {
			id = counter.incrementAndGet();
			hello.setId(id);
		}
		this.helloMap.put(id, hello);
		return hello;
	}

	@Override
	public void deleteHello(Long id) {
		
		this.helloMap.remove(id);
		
	}

	@Override
	public Hello getHelloById(Long id) {
		
		return this.helloMap.get(id);
	}

	@Override
	public List<Hello> listHello() {
		
		return new ArrayList<Hello>(this.helloMap.values());
	}

	
}
