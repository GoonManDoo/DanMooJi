package co.micol.kym.student.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.micol.kym.student.service.StudentMapper;
import co.micol.kym.student.service.StudentService;
import co.micol.kym.student.vo.StudentVO;
@Repository("studentDao")
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentMapper map; //student-map.xml을 자동 주입한다.

	@Override
	public List<StudentVO> studentSelectList() {
		
		return map.studentSelectList();
	}

	@Override
	public StudentVO studentSelect(StudentVO vo) {
		
		return map.studentSelect(vo);
	}

	@Override
	public int studentInsert(StudentVO vo) {
		
		return map.studentInsert(vo);
	}

	@Override
	public int studentUpdate(StudentVO vo) {
		
		return map.studentUpdate(vo); // 이름만 변경 가능.
	}

	@Override
	public int studentDelete(StudentVO vo) {
		
		return map.studentDelete(vo);
	}

	@Override
	public boolean idCheck(String id) {
		return map.idCheck(id);
	}

}
