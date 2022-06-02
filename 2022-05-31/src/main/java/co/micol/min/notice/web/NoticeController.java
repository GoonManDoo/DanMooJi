package co.micol.min.notice.web;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.apache.tiles.autotag.core.runtime.annotation.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.micol.min.notice.service.NoticeService;
import co.micol.min.notice.vo.NoticeVO;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeDao;

	@Autowired
	private String saveDir; // IoC 에서 저장된 것을 가져온다.

	 @RequestMapping("/noticeList.do")
	   public String noticeList(Model model) {
	      model.addAttribute("notices", noticeDao.noticeSelectList(1, "전체"));
	      return "notice/noticeList";
	   }

	   @RequestMapping("/noticeInsertForm.do")
	   public String noticeInsertForm() {
	      return "notice/noticeInsertForm";
	   }

	   @PostMapping("/noticeInsert.do")

	   public String noticeInsert(NoticeVO vo, MultipartFile file, Model model) {
	      String fileName = file.getOriginalFilename();

	      if (fileName != null && !fileName.isEmpty() && fileName.length() != 0) {
	         // UUID 사용하여 파일 명 변경
	         // UUID : 범용 고유 식별자
	         String uid = UUID.randomUUID().toString();
	         String saveFileName = uid + fileName.substring(fileName.indexOf("."));
	         // uuid.xml

	         // UUID로 만든 파일명 넣기
	         File target = new File(saveDir, saveFileName);

	         vo.setNoticeAttech(fileName); // 논리적인 파일 이름 담기
	         vo.setNoticeDir(saveFileName); // 실제 저장 경로 담기
	         try {
	            FileCopyUtils.copy(file.getBytes(), target); // 실제 파일을 저장
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	      }

	      noticeDao.noticeInsert(vo); // 파일이 있을 경우, 파일을 먼저 업로드하고 DB 저장
	      return "redirect:noticeList.do";
	   }

	   //@RequestMapping("/getContent.do")
	   @PostMapping("/getContent.do")
	   // getConent.do?noticeId=? : ? 부분을 requestParam을 통해 GET 방식으로 넣을 수 있음.
	   public String getContent(NoticeVO vo, Model model) {
	      noticeDao.noticeHitUpdate(vo.getNoticeId());
	      model.addAttribute("content", noticeDao.noticeSelect(vo));
	      return "notice/noticeContent";
	   }

	   @RequestMapping("/downLoad.do")
	   public void downLoad(@RequestParam ("saveName") String saveName, @RequestParam ("fileName") String fileName, HttpServletResponse resp) {
	      
		   try {
	    	  // file을 배열로 전환
	         byte fileBtye[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File(saveDir + File.separator+saveName));
	         resp.reset(); //response 객체 초기화
	         // 모든 타입 데이터 전송 시 사용
	         resp.setContentType("application/octet-stream");
	         // 파일 길이만큼 사이즈 설정
	         resp.setContentLength(fileBtye.length);
	         // 파일 다운 받기 위해 설정
	         resp.setHeader("Content-Disposition",
	               "attachment; filename=\"" + URLEncoder.encode(fileName, "UTF-8") + "\"");

	         resp.getOutputStream().write(fileBtye); //실제 파일 저장
	         resp.getOutputStream().flush();
	         resp.getOutputStream().close();
	      } catch (Exception e) {

	      }

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
	   public String noticeModify(NoticeVO vo, MultipartFile file) {
	      String fileName = file.getOriginalFilename();

	      if (fileName != null && !fileName.isEmpty() && fileName.length() != 0) {
	         // UUID 사용하여 파일 명 변경
	         // UUID : 범용 고유 식별자
	         String uid = UUID.randomUUID().toString();
	         String saveFileName = uid + fileName.substring(fileName.indexOf("."));
	         // uuid.xml

	         // UUID로 만든 파일명 넣기
	         File target = new File(saveDir, saveFileName);

	         vo.setNoticeAttech(fileName); // 논리적인 파일 이름 담기
	         vo.setNoticeDir(saveFileName); // 실제 저장 경로 담기
	         try {
	            FileCopyUtils.copy(file.getBytes(), target); // 실제 파일을 저장
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	      }

	      noticeDao.noticeUpdate(vo); // 파일이 있을 경우, 파일을 먼저 업로드하고 DB 저장
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