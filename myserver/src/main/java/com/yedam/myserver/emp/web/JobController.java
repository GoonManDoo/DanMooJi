package com.yedam.myserver.emp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.myserver.emp.mapper.EmployeeMapper;

@Controller
public class JobController {
	
	@Autowired EmployeeMapper mapper;

	@RequestMapping("jobs")
	public String jobs(Model model) {
		model.addAttribute("jobs", mapper.findJobs());
		model.addAttribute("emp", mapper.findEmployees());
		return "jobs";
	}
}
