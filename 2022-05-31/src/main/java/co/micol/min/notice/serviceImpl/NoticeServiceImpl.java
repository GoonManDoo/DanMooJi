package co.micol.min.notice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.micol.min.notice.service.NoticeMapper;
import co.micol.min.notice.service.NoticeService;
import co.micol.min.notice.vo.NoticeVO;
@Repository("noticeDao")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper map;
	@Override
	public List<NoticeVO> noticeSelectList(int state, String key) {
		
		return map.noticeSelectList(state, key);
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		
		return map.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		
		return map.noticeInsert(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		
		return map.noticeUpdate(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		
		return map.noticeDelete(vo);
	}

	@Override
	public int noticeHitUpdate(int id) {
		
		return map.noticeHitUpdate(id);
	}

}
