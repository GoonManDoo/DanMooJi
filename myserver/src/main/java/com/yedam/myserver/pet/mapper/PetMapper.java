package com.yedam.myserver.pet.mapper;

import java.util.List;

import com.yedam.myserver.pet.vo.AdoptVO;
import com.yedam.myserver.pet.vo.PetVO;

public interface PetMapper {
	public List<PetVO> findPetAll();
	public List<AdoptVO> findAdoptAll();
	public void persist(PetVO vo);
} 
