package com.yedam.myserver;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.myserver.cart.mapper.CartMapper;
import com.yedam.myserver.cart.vo.CartVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/*-context.xml")
public class CartMapperTest {
	
	@Autowired CartMapper mapper;
	
	//@Test
	public void cartDelete() {
		
		CartVO vo = new CartVO();
		vo.setNo("1");
		mapper.remove(vo);
	}	
	
	@Test
	public void cartSelectList() {
		List<CartVO> list = mapper.findAll();
		System.out.println(list.size());
	}
}
