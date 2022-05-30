package co.micol.kym.student.service;

import java.util.List;

import co.micol.kym.student.vo.StudentVO;

public interface StudentMapper { //mybatis에서 사용하는 인터페이스
	List<StudentVO> studentSelectList(); //전체회원
	StudentVO studentSelect(StudentVO vo); //한명조회 or 로그인 처리
	int studentInsert(StudentVO vo); //회원추가
	int studentUpdate(StudentVO vo); //회원정보 수정
	int studentDelete(StudentVO vo); //회원삭제
	
	boolean idCheck(String id); //ID 중복체크
}
