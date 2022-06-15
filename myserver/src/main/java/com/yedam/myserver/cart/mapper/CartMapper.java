package com.yedam.myserver.cart.mapper;

import java.util.List;

import com.yedam.myserver.cart.vo.CartVO;

public interface CartMapper {
	List<CartVO> findAll();   	//전체조회
	int removeAll();		  	//전체삭제
	int remove(CartVO vo);		//단건삭제
	int merge(CartVO vo);		//수량변경
}
