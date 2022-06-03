<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
button {
    margin: 20px;
}
.w-btn {
    position: relative;
    border: none;
    display: inline-block;
    padding: 15px 30px;
    border-radius: 15px;
    font-family: "paybooc-Light", sans-serif;
    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
    text-decoration: none;
    font-weight: 600;
    transition: 0.25s;
background: url( "https://play-lh.googleusercontent.com/W43xj43ErMIs5BQgCdMKEa0NXCoUUW8DjQc5SxcDfLrC26H8sHDmoFIUWLYmsQahpo0" ) no-repeat;
}
.w-btn-outline {
    position: relative;
    padding: 15px 30px;
    border-radius: 15px;
    font-family: "paybooc-Light", sans-serif;
    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
    text-decoration: none;
    font-weight: 600;
    transition: 0.25s;
     border: #fff200;
}
.w-btn:hover {
    letter-spacing: 2px;
    transform: scale(1.2);
    cursor: pointer;
}
.w-btn-outline:hover {
    letter-spacing: 2px;
    transform: scale(1.2);
    cursor: pointer;
}
.w-btn:active {
    transform: scale(1.5);
}
.w-btn-outline:active {
    transform: scale(1.5);
  
}
.w-btn-yellow-outline:hover {
     background-color:rgb(35, 35, 35);
    color: white;
}
.w-btn-yellow {
    background-color: #fce205;
    color: #6e6e6e;
    width : 124px;
    height : 54px;
}
table.type11 {
  border-collapse: separate;
  border-spacing: 1px;
  text-align: center;
  line-height: 1.5;
  margin: 20px 10px;
}
table.type11 th {
  width: 155px;
  padding: 10px;
  font-weight: bold;
  vertical-align: top;
  color: #fff;
  background: #ce4869 ;
}
table.type11 td {
  width: 155px;
  padding: 10px;
  vertical-align: top;
  border-bottom: 1px solid #ccc;
  background: #eee;
}
</style>
</head>
<body>
<div align="center">
	<div>
	<h1>공지사항</h1>
	</div>
	<br />
	<div>
		<table id = "tb" border="1" class="type11">
						<thead>
						<tr>
							<th width="70">작성자</th>
							<th>제 목</th>
							<th>작성일</th>
							<th width="150">작성글</th>
						</tr>
						</thead>
			<tbody>
			<tr>
			<td>${content.noticeName } </td>
			<td>${content.noticeTitle }</td>
			<td>${content.noticeDate }</td>
			<td>${content.noticeContents }</td>
			</tr>
			</tbody>
		</table>
	</div><br>
	<div>
		<div id = "btn"><button type="button" class="w-btn-outline w-btn-yellow-outline" onclick="location.href='noticeModifyForm.do?noticeId=${content.noticeId}'">글 수정</button>
		<button type="button" class="w-btn-outline w-btn-yellow-outline" onclick="if(confirm('해당 게시글을 삭제하시겠습니까?')){
				location.href='noticeDelete.do?noticeId='+${content.noticeId}
			} ">글 삭제</button>
		<button type="button" class="w-btn-outline w-btn-yellow-outline" onclick="location.href='noticeList.do'">글 목록</button></div>
		
		
	</div>
</div>
</body>

</html>