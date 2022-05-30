package co.micol.kym.student.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.micol.kym.student.service.StudentService;
import co.micol.kym.student.vo.StudentVO;

@Controller
public class StudentController {
	
	//Conntroller에서 사용하는 4가지
	// 1. RequestMapping
	// 2. PostMapping
	// 3. GetMapping
	// 4. Autowired

	@Autowired
	private StudentService studentDao;
	
	@RequestMapping("/studentList.do") //전체회원 목록 보기
	public String studentList(Model model) {
		model.addAttribute("students", studentDao.studentSelectList());
		return "student/studentList";
	}
	@RequestMapping("/studentJoinForm.do")
	public String studentJoinForm() {
		return "student/studentJoinForm";
	}
	@PostMapping("/studentJoin.do")
	public String studentJoin(StudentVO vo, Model model){
		int n = studentDao.studentInsert(vo);
		if(n != 0) {
			model.addAttribute("message", "회원가입이 성공적으로 처리되었습니다.");
		} else {
			model.addAttribute("message", "회원가입을 실패하였습니다!!!!.");
		}
		return "student/studentJoin";
	}
	
	@GetMapping("/ajaxIdCheck.do")
	@ResponseBody
	public String ajaxIdCheck(String id) {
		boolean b = studentDao.idCheck(id);
		String data = "N"; //존재하는 아이디
		if(!b) {
			data = "Y"; //사용할 수 있는 아이디
		} 
		return data;
	}
}
