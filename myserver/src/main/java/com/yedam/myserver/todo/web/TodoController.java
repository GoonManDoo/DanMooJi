package com.yedam.myserver.todo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.myserver.todo.service.TodoService;
import com.yedam.myserver.todo.vo.TodoVO;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500", maxAge = 3600)
public class TodoController {

	@Autowired TodoService service;
	
	@GetMapping("/todoSelect")
	public List<TodoVO> todoSelectList(TodoVO vo) {
		return service.findAll();
	}
		
	@GetMapping("/todoInsert")
	public TodoVO todoInsert(TodoVO vo) {
		 service.persist(vo);
		 return vo;
	}
	
	@GetMapping("/todoUpdate")
	public TodoVO todoUpdate(TodoVO vo) {
		 service.merge(vo);
		 return vo;
	}	
	@GetMapping("/todoDelete")
	public TodoVO todoDelete(TodoVO vo) {
		 service.remove(vo);
		 return vo;
	}		
}
