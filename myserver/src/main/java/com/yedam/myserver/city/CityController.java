package com.yedam.myserver.city;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CityController {

	@PutMapping("/modifyData")
	@ResponseBody
	public boolean modifyData(@RequestBody modifyVO<CityVO> mvo) {
		System.out.println(mvo);
		return true;
	}
}
