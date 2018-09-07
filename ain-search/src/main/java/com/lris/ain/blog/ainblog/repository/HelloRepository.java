package com.lris.ain.blog.ainblog.repository;


import java.util.List;

import com.lris.ain.blog.ainblog.domain.Hello;

public interface HelloRepository {

	/**
	 * 新增或者修改欢迎
	 * @param hello
	 * @return
	 */
	Hello saveOrUpateHello(Hello hello);
	
	/**
	 * 删除欢迎
	 * @param id
	 */
	void deleteHello(Long id);
	
	/**
	 * 根据欢迎id获取欢迎
	 * @param id
	 * @return
	 */
	Hello getHelloById(Long id);
	
	/**
	 * 获取所有欢迎的列表
	 * @return
	 */
	List<Hello> listHello();
}
