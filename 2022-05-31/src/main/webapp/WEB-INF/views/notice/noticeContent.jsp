<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div>
	<h1>공지사항</h1>
	</div>
	<br />
	<div>
		<table id = "tb" border="1">
						<tr>
							<th width="70">작성자</th>
							<td width="870">${content.noticeName } </td>
						</tr>
						<tr>
							<th>제 목</th>
							<td>${content.noticeTitle }</td>
						</tr>
						<tr>
							<th>작성일</th>
							<td>${content.noticeDate }</td>
						</tr>
						<tr>
							<th>조회수</th>
							<td>${content.noticeHit }</td>
						</tr>
						<tr>
							<th height="400">작성글</th>
							<td>${content.noticeContents }</td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td>
							<c:choose>
							<c:when test="${not empty content.noticeAttech }">
							<a href="downLoad.do?saveName=${content.noticeDir }&fileName=${content.noticeAttech}">
								${content.noticeAttech } </a>
							</c:when>
							<c:otherwise>
							등록된 첨부파일이 없습니다.
							</c:otherwise>
							</c:choose>
							
							</td>
						</tr>
			</tbody>
		</table>
	</div><br>
	<div>
		<button type="button" onclick="location.href='noticeModifyForm.do?noticeId=${content.noticeId}'">글 수정</button>
		<button type="button" onclick="if(confirm('해당 게시글을 삭제하시겠습니까?')){
				location.href='noticeDelete.do?noticeId='+${content.noticeId}
			} ">글 삭제</button>
		<button type="button" onclick="location.href='noticeList.do'">글 목록</button>
	</div>
</div>
</body>

</html>