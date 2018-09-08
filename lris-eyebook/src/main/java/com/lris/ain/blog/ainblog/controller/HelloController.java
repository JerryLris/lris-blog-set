package com.lris.ain.blog.ainblog.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lris.ain.blog.ainblog.controller.vo.Item;
import com.lris.ain.blog.ainblog.domain.Hello;
import com.lris.ain.blog.ainblog.repository.HelloRepository;

/**
 * Hello World 控制器
 * @author lris
 *
 */
@Controller
@RequestMapping("/hello")
public class HelloController {


	@Autowired 
	private HelloRepository helloRepository;
	
	@ResponseBody
	@RequestMapping("/")
	public String hello() {
		return "Hello World! Welcome to visit lris-blog";
	}
	@RequestMapping("/index")
	public String helloIndex(Model model) {
		model.addAttribute("img", "/hello/index.png");
		return "hellos/index";
	}
	@RequestMapping("/index-jsp")
	public String  helloIndexJsp(Model model) {
		List<Item> list = new ArrayList<Item>();
		list.add(new Item("title","name","detail"));
		list.add(new Item("title2","name2","detail2"));
		model.addAttribute("list", list);
		return "hellos/index-thymeleaf";
	}
	
	/**
	 * 从 欢迎存储库 获取欢迎列表
	 * @return
	 */
	@GetMapping("/list")
	@ResponseBody
	private List<Hello> getHellolist() {
		List<Hello> hellos = new ArrayList<>();
		for (Hello hello : helloRepository.findAll()) {
			hellos.add(hello);
		}
 		return hellos;
	}

	/**
	 * 查询所用欢迎
	 * @return
	 */
/*	@GetMapping("/lists")
	public ModelAndView list(Model model) {
		model.addAttribute("helloList", getHellolist());
		model.addAttribute("title", "欢迎管理");
		return new ModelAndView("hellos/list", "helloModel", model);
	}*/
	@GetMapping("/lists")
	public String list(Model model) {
		model.addAttribute("helloList", getHellolist());
		model.addAttribute("title", "欢迎管理");
		System.out.println("---------------");
		return "hellos/list2";
	}
 
	/**
	 * 根据id查询欢迎
	 * @param message
	 * @return
	 */
	@GetMapping("/{id}")
	public ModelAndView view(@PathVariable("id") Long id, Model model) {
		Optional<Hello> hellos = helloRepository.findById(id);
		
		model.addAttribute("hello", hellos.isPresent()==true?hellos.get():null);
		model.addAttribute("title", "查看欢迎");
		return new ModelAndView("hellos/view", "helloModel", model);
	}

	/**
	 * 获取 form 表单页面
	 * @param hello
	 * @return
	 */
	@GetMapping("/form")
	public ModelAndView createForm(Model model) {
		model.addAttribute("hello", new Hello(null,null));
		model.addAttribute("title", "创建欢迎");
		return new ModelAndView("hellos/form", "helloModel", model);
	}

	/**
	 * 新建欢迎
	 * @param hello
	 * @param result
	 * @param redirect
	 * @return
	 */
	@PostMapping("/create")
	public ModelAndView create(Hello hello) {
 		hello = helloRepository.save(hello);
		return new ModelAndView("redirect:/hello/lists");
	}

	/**
	 * 删除欢迎
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id, Model model) {
		helloRepository.deleteById(id);
 
		model.addAttribute("helloList", getHellolist());
		model.addAttribute("title", "删除欢迎");
		return new ModelAndView("hellos/list", "helloModel", model);
	}

	/**
	 * 修改欢迎
	 * @param hello
	 * @return
	 */
	@GetMapping(value = "/modify/{id}")
	public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
		Optional<Hello> hellos = helloRepository.findById(id);
		model.addAttribute("hello", hellos.get());
		model.addAttribute("title", "修改欢迎");
		return new ModelAndView("hellos/form", "helloModel", model);
	}


	
}
