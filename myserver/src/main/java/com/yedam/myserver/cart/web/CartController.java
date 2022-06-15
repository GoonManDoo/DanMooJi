package com.yedam.myserver.cart.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.myserver.cart.mapper.CartMapper;
import com.yedam.myserver.cart.vo.CartVO;

@RestController
public class CartController {
	
	@Autowired CartMapper mapper;
	
	//장바구니 전체조회
	@RequestMapping("/cartSelectList")
	public List<CartVO> cartSelectList() {
		return mapper.findAll();
	}	
	
	//장바구니 단건삭제
	@RequestMapping("/cartDelete")
	public CartVO cartDelete(CartVO vo) {
		mapper.remove(vo);
		return vo;
	}
	
	//장바구니 선택삭제
	@RequestMapping("/cartDeleteCheck")
	public boolean cartDelete(String[] nos) {
		for(String no : nos) {
			CartVO vo = new CartVO();
			vo.setNo(no);
			mapper.remove(vo);
		}
		return true;
	}
	
	//장바구니 전체삭제
	@RequestMapping("/cartDeleteAll")
	public boolean cartDeleteAll() {
		mapper.removeAll();
		return true;
	}

}
