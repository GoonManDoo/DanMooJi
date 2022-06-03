<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
@import
	url('https://cdn.jsdelivr.net/gh/orioncactus/pretendard/dist/web/static/pretendard.css')
	;

body {
	font-family: font-family : Pretendard, -apple-system, BlinkMacSystemFont,
		system-ui, Roboto, 'Helvetica Neue', 'Segoe UI', 'Apple SD Gothic Neo',
		'Noto Sans KR', 'Malgun Gothic', sans-serif;
}

a {
	text-decoration: none;
	color : pink;
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
</style>
</head>
<body>
	<div align="center">
		<div>
			<h1>영민이 사이트에 오신걸 환영함다.</h1>
		</div>
		<div>
			<div id = "btn"><button class="w-btn-outline w-btn-yellow-outline" onclick="location.href='noticeList.do' ">게시글목록</button></div>
			<p>
		</div>
	</div>
</body>
</html>