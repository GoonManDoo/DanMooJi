<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
		<div><h1>게시글 수정</h1></div>
		<div>
			<form id="frm" action="noticeModify.do" method="post">
				<div>
					<table border="1">
						<tr>
							<th width="100">작성자</th>
							<td width="150">
							<input type="hidden" id="noticeId" name="noticeId" value="${notice.noticeId }">
							${notice.noticeName }</td>
						</tr>
						<tr>
							<th width="100">작성일자</th>
							<td width="150">${notice.noticeDate }</td>
						</tr>
						<tr>
							<th width="100">제 목</th>
							<td colspan="3"><input type="text" size="30" id="noticeTitle" name="noticeTitle" value="${notice.noticeTitle }"></td>
						</tr>
						<tr>
							<th width="100">내 용</th>
							<td colspan="3"><textarea rows="10" cols="40" id="noticeContents" name="noticeContents">
							${notice.noticeContents }
							</textarea></td>
						</tr>
					</table>
				</div><br>
				<div>
					<input type="submit" value="수정">&nbsp;&nbsp;
					<input type="button" value="취소" onclick="location.href='noticeList.do'">
				</div>
			</form>
		</div>
	</div>


</body>
</html>