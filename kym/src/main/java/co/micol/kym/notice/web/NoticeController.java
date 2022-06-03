package co.micol.kym.notice.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.micol.kym.notice.service.NoticeService;
import co.micol.kym.notice.vo.NoticeVO;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeDao;

	 @RequestMapping("/noticeList.do")
	   public String noticeList(Model model) {
	      model.addAttribute("notices", noticeDao.noticeSelectList(1, "전체"));
	      return "notice/noticeList";
	   }

	
	   @PostMapping("/getContent.do")
	   public String getContent(NoticeVO vo, Model model) {
	      model.addAttribute("content", noticeDao.noticeSelect(vo));
	      return "notice/noticeContent";
	   
	   }
	   @RequestMapping("/noticeInsertForm.do")
	   public String noticeInsertForm() {
	      return "notice/noticeInsertForm";
	   }

	   @PostMapping("/noticeInsert.do")

	   public String noticeInsert(NoticeVO vo, Model model) {
	      noticeDao.noticeInsert(vo); 
	      return "redirect:noticeList.do";
	   }
	     

	   @RequestMapping("/noticeDeleteForm.do")
	   public String noticeDelete(NoticeVO vo, Model model) {
	      noticeDao.noticeDelete(vo);
	      return "redirect:noticeList.do";
	   }

	   @RequestMapping("/noticeModifyForm.do")
	   public String noticeModifyForm(NoticeVO vo, Model model) {
	      model.addAttribute("notice", noticeDao.noticeSelect(vo));
	      return "notice/noticeModifyForm";
	   }
	   @RequestMapping("/noticeModify.do")
	   public String noticeModify(NoticeVO vo) {
		   noticeDao.noticeUpdate(vo); 
		      return "redirect:noticeList.do";
		   }
	   

	   
	   @RequestMapping("/noticeDelete.do")
	   public String noticeDelete(NoticeVO vo) {
	      noticeDao.noticeDelete(vo);
	      return "redirect:noticeList.do";
	   }
	   
	   @PostMapping("/ajaxSearchList.do")
	   @ResponseBody
	   public List<NoticeVO> ajaxSearchList(@RequestParam("state") int state, @RequestParam("key") String key) {
		   
		   return noticeDao.noticeSelectList(state, key);
	   }

	}