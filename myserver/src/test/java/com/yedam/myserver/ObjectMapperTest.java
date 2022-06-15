package com.yedam.myserver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.myserver.todo.vo.TodoVO;

public class ObjectMapperTest {

	@Test
	public void test2() throws MalformedURLException, IOException {
		ObjectMapper om = new ObjectMapper();
		String url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20220614";
		JsonNode result = om.readTree(new URL(url));
		String nm = result.get("boxOfficeResult")
						  .get("dailyBoxOfficeList")
						  .get(0)
						  .get("movieNm").asText();
		System.out.println(nm);
	}
	
	//@Test
	public void test1() throws JsonProcessingException {
		TodoVO vo = new TodoVO();
		vo.setContents("test");
		vo.setNo("1");
		
		ObjectMapper om = new ObjectMapper();
		String result = om.writeValueAsString(vo);       //@ResponseBody : 자바객체 => 스트링(json)
		System.out.println(result);
		
		TodoVO vo2 = om.readValue(result, TodoVO.class); //@RequestBody : String(json구조) => 자바객체
		System.out.println(vo2.getContents());
	}
}
