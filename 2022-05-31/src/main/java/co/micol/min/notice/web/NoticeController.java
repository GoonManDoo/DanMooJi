package co.micol.min.notice.web;

import java.io.File;
import javax.naming.directory.InvalidSearchFilterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import co.micol.min.notice.service.NoticeService;
import co.micol.min.notice.vo.NoticeVO;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeDao;

	@Autowired
	private String saveDir; // IoC 에서 저장된 것을 가져온다.

	@RequestMapping("/noticeList.do") // 전체목록보기
	public String noticeList(Model model) {
		model.addAttribute("notices", noticeDao.noticeSelectList(1, "전체"));
		return "notice/noticeList";
	}

	@RequestMapping("/noticeInsertForm.do")
	public String noticeInsertForm() {
		return "notice/noticeInsertForm";
	}

	@PostMapping("/noticeInsert.do")
	public String noticeInsert(NoticeVO vo, MultipartFile file) {
		String fileName = file.getOriginalFilename();
		if (fileName != null) {
			File target = new File(saveDir, fileName);
			vo.setNoticeAttech(fileName); //파일명
			vo.setNoticeDir(target.toString()); //실제저장 담고
			try {
				FileCopyUtils.copy(file.getBytes(), target); // 실제 파일을 저장
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		noticeDao.noticeInsert(vo); //파일이 있을경우 파일을 먼저 업로드하고 DB저장
		return "redirect:noticeList.do";
	}
}
