package co.micol.kym.notice.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private int noticeId;          //순번
	private String noticeName;     //작성자
	private String noticeTitle;    //제목
	private String noticeContents; //내용
	private Date noticeDate;	   //작성일자
	
}
