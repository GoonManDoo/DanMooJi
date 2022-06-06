<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table tr:hover {
   cursor: pointer;
   background: gray;
}
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
#title {
padding-top : 75px;
}
</style>
</head>
<body>
	<div align="center">
		<div><h1>게시글 등록</h1></div>
		<div>
			<form id="frm" action="noticeInsert.do" method="post">
				<div>
					<table border="1" class="type11" id="td">
					<thead>
						<tr>
							<th width="100">작성자</th>
							<td width="150"><input type="text" id="noticeName" name="noticeName"></td>
						</tr>
						<tr>
							<th width="100">작성일자</th>
							<td width="150"><input type="date" id="noticeDate" name="noticeDate"></td>
						</tr>
						<tr>
							<th width="100">제 목</th>
							<td colspan="3"><input type="text" size="30" id="noticeTitle" name="noticeTitle"></td>
						</tr>
						<tr>
							<th width="100" id="title">내 용</th>
							<td colspan="3"><textarea rows="10" cols="40" id="noticeContents" name="noticeContents"></textarea></td>
						</tr>
					</table>
				</div><br>
				<div>
					<div id = "btn"> <input class="w-btn-outline w-btn-yellow-outline" type="submit" value="등록">&nbsp;&nbsp;
					<input class="w-btn-outline w-btn-yellow-outline" type="reset" value="취소">&nbsp;&nbsp;
					<input class="w-btn-outline w-btn-yellow-outline" type="button" value="목록" onclick="location.href='noticeList.do'"></div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>