package com.yedam.myserver.pet.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.myserver.pet.mapper.PetMapper;
import com.yedam.myserver.pet.vo.AdoptVO;
import com.yedam.myserver.pet.vo.PetVO;

@RestController
public class PetController {

	@Autowired PetMapper mapper;
	
	//pet 전체조회 
	@GetMapping("/petSelect")
	public List<PetVO> petSelectList() {
		return mapper.findPetAll();
	}

	//분양정보 등록
	@GetMapping("/adoptSelect")
	public List<AdoptVO> adoptSelectList() {
		return mapper.findAdoptAll();
	}	

	//분양정보 등록
	@PostMapping("/adoptInsert")
	public PetVO petInsert(PetVO vo) {
		 mapper.persist(vo);
		 return vo;
	}
}
