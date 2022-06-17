package com.yedam.myserver.todo.service;

import java.util.List;

import com.yedam.myserver.todo.vo.TodoVO;

public interface TodoService {
	public List<TodoVO> findAll();
	public void persist(TodoVO vo);
	public void merge(TodoVO vo);
	public void remove(TodoVO vo);
} 
