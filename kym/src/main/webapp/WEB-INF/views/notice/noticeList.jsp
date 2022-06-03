<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/jquery-3.6.0.min.js"></script>
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
</style>
</head>
<body>
   <div align="center">
      <div>
         <h1>공지사항 목록</h1>
      </div>
      <div>
         <form id="frm" name="state">
            <select id="state" name="state">
               <option value="1">전 체</option>
               <option value="2">작성자</option>
               <option value="3">제 목</option>
               <option value="4">내 용</option>
            </select>&nbsp; <input type="text" id="key" name="key">&nbsp;
            <div id = "btn"><button type="button" class="w-btn-outline w-btn-yellow-outline" onclick="searchList()">검색</button></div>
            
         </form>
      </div>
      <br>
      <div>
         <table id="tb" border="1" class="type11">
            <thead>
               <tr>
                  <th width="70">순번</th>
                  <th width="150">작성자</th>
                  <th width="300">제 목</th>
                  <th width="150">작성일자</th>
               </tr>
            </thead>
            <tbody>
               <c:if test="${!empty notices }">
                  <c:forEach items="${notices }" var="n">
                     <tr onclick="eventList(${n.noticeId })">
                        <td>${n.noticeId }</td>
                        <td>${n.noticeName }</td>
                        <td>${n.noticeTitle }</td>
                        <td>${n.noticeDate }</td>
                     </tr>
                  </c:forEach>
               </c:if>
               <c:if test="${empty notices}">
                  <tr>
                     <td colspan="6" align="center">게시글이 존재하지 않습니다.</td>
                  </tr>
               </c:if>
            </tbody>

         </table>
         <form id="frm2" action="" method="post">
            <input type="hidden" id="noticeId" name="noticeId">

         </form>
      </div>
      <br />
      <div>
         <div id = "btn"><button class="w-btn-outline w-btn-yellow-outline" onclick="location.href='noticeInsertForm.do'">글등록</button></div>
      </div>
   </div>
</body>


<script type="text/javascript">
function eventList(data){

      frm2.noticeId.value = data;
      frm2.action="getContent.do";
      frm2.submit();
 
}
   
   function searchList(){
      let state = $("#state").val(); 
      let key = $("#key").val();
      
      $.ajax({
         url : "ajaxSearchList.do", //url
         type : "post", // 전송방식
         data : {"state" : state, "key": key}, // 전달데이터
         dataType : "json", // 돌려받을데이터 타입
         success : function(data){ // 성공했을때 실행할 함수 결과는 data에 담김
            //수행할 함수
         htmlConvert(data);
         
         },
         error : function(){ // 실패했을때 수행할 함수
            alert("실패");
         }
      })
   
   
   function htmlConvert(data){
      $("tbody").remove(); //tbody 삭제
      let tbody = $("<tbody/>");
      $.each(data,function(index, n){
         var row = $("<tr onclick='eventList("+n.noticeId+")'/>").append(
         $("<td/>").text(n.noticeId),      
         $("<td/>").text(n.noticeName),
         $("<td/>").text(n.noticeTitle),
         $("<td/>").text(n.noticeDate),
         );
      tbody.append(row); //행을 추가
                  
      });
      $("#tb").append(tbody); // tbody를 추가
   }
}
</script>




</html>