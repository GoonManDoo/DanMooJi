package co.micol.kym.notice.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.micol.kym.notice.vo.NoticeVO;

public interface NoticeService {
	List<NoticeVO> noticeSelectList(int state, String key); // 전체글 조회
	NoticeVO noticeSelect(NoticeVO vo); //한개 조회
	int noticeInsert(NoticeVO vo); //한건 입력
	int noticeUpdate(NoticeVO vo); //한건 수정
	int noticeDelete(NoticeVO vo); //한건 삭제
	
	
	
}
