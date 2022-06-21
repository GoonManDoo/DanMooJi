package com.yedam.myserver.users.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yedam.myserver.users.mapper.UserMapper;
import com.yedam.myserver.users.service.UserService;
import com.yedam.myserver.users.vo.UserVO;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	
	@Autowired UserMapper mapper;
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO vo = new UserVO();
		vo.setId(username);
		vo = mapper.findById(vo);
		if(vo == null) {
			throw new UsernameNotFoundException("no user");
		}
		logger.info(vo.toString());
		return vo;
	}

	@Override
	public List<UserVO> find() {
	
		return mapper.find();
	}

	@Override
	public List<Map> findByName(UserVO vo) {
		
		return mapper.findByName(vo);
	}

	@Override
	public UserVO findById(UserVO vo) {
		
		return mapper.findById(vo);
	}

	@Override
	public void persist(UserVO vo) {
		
		mapper.persist(vo);
	}

	@Override
	public void merge(UserVO vo) {
		
		mapper.merge(vo);
	}

	@Override
	public void remove(UserVO vo) {
		mapper.remove(vo);
		
	}
	
	

}
