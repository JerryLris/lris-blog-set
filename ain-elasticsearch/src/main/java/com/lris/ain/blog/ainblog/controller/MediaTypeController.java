package com.lris.ain.blog.ainblog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lris.ain.blog.ainblog.vo.UserVO;

/**
 * Media Type 控制器.
 */
@RestController
public class MediaTypeController {

	/**
	 * 根据客户端请求的 Content-Type，响应相应的 UserVO 类型.
	 * 
	 * @return
	 */
	@RequestMapping("/user")
	public UserVO getUser() {
		return new UserVO("waylau", 30);
	}

	@RequestMapping("/users")
	public List<UserVO> getUsers() {
		List<UserVO> list = new ArrayList<>();
		list.add(new UserVO("waylau", 30));
		list.add(new UserVO("老卫", 30));
		return list;
	}
}
