<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>RESTful 웹서비스 클라이언트(JSON)</title>
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="./resources/json.min.js"></script>
<script type="text/javascript" >
   let conPath = '${pageContext.request.contextPath}';
   $(function(){
      userList();

      userSelect();
      
      userDelete();
      
      userInsert();
   
      userUpdate();
      
      init();
   });
   
   //초기화
   function init() {
      //초기화 버튼 클릭
      $('#btnInit').on('click',function(){
         $('#form1').each(function(){
            this.reset();
         });
      });
   }//init
   
   //사용자 삭제 요청
   function userDelete() {
      //삭제 버튼 클릭
      $('body').on('click','#btnDelete',function(){
         //var userId = $(this).closest('tr').find('#hidden_userId').val();
         var result = confirm(user +" 사용자를 정말로 삭제하시겠습니까?");
         var userId = $(this).closest('tr').data('id');
         if(! result) 
            return;

         $.ajax({
            url:conPath + '/users/' + userId,
            type:'delete',
            dataType:'json'
         }).done(function(xhr) {
            console.log(xhr.result);
            userList();
         }).fail( function(xhr,status,msg){
            console.log("상태값 :" + status + " Http에러메시지 :"+msg);
         });     
      }); //삭제 버튼 클릭
   }//userDelete
   
   //사용자 조회 요청
   function userSelect() {
      //조회 버튼 클릭
      $('body').on('click','#btnSelect',function(){
         //var userId = $(event.target).closest('tr').find('#hidden_userId').val();
         var userId = $(this).closest("tr").data("id");
         //특정 사용자 조회
         $.ajax({
            url:conPath + '/users/' + userId,
            dataType:'json'
         }).done(
            userSelectResult
         ).fail(function(xhr,status,msg){
            alert("상태값 :" + status + " Http에러메시지 :"+msg);
         });
      }); //조회 버튼 클릭
   }//userSelect
   
   //사용자 조회 응답
   function userSelectResult(user) {
      $('input:text[name="id"]').val(user.id);
      $('input:text[name="name"]').val(user.name);
      $('input:text[name="password"]').val(user.password);
      $('select[name="role"]').val(user.role).attr("selected", "selected");
   }//userSelectResult
   
   //사용자 수정 요청
   function userUpdate() {
      //수정 버튼 클릭
      $('#btnUpdate').on('click',function(){
         var id = $('input:text[name="id"]').val();
         var name = $('input:text[name="name"]').val();
         var password = $('input:text[name="password"]').val();
         var role = $('select[name="role"]').val();      
         $.ajax({ 
             url: conPath + '/users', 
             type: 'PUT', 
             dataType: 'json',     //응답결과가 json
             contentType : 'application/json', //요청파라미터가 json
             data: JSON.stringify( {id, name, password, role} ),
           //data: {id:id, name:name}
           //data: $("#form1").serialize() // 필드명과 변수명이동일하면 변수명만 적으면됨
             
         }).done( function(data) { 
                 userList();
         }).fail( function(xhr, status, message) { 
                 alert(" status: "+status+" er:"+message);
         });
      });//수정 버튼 클릭
   }//userUpdate
   
   //사용자 등록 요청
   function userInsert(){
      //등록 버튼 클릭
      $('#btnInsert').on('click',function(){
          var id = $('input:text[name="id"]').val();
         var name = $('input:text[name="name"]').val();
         var password = $('input:text[name="password"]').val();
         var role = $('select[name="role"]').val();      
         $.ajax({ 
             url: conPath + '/users',  
             type: 'POST',  
             data: {id, name, password, role },
             dataType: 'json', 
          }).done( function(response) {
                   userList();
          }).fail(function(xhr, status, message) { 
                 alert(" status: "+status+" er:"+message);
          });  
      });//등록 버튼 클릭
   }//userInsert
   
   
   //사용자 등록 요청
   function userInsert2(){
      //등록 버튼 클릭
      $('#btnInsert').on('click',function(){
         
          var id = $('input:text[name="id"]').val();
         var name = $('input:text[name="name"]').val();
         var passsword = $('input:text[name="password"]').val();
         var role = $('select[name="role"]').val();      
         $.ajax({ 
             url: "users",  
             type: 'POST',  // == method
             dataType: 'json', 
             data: { id:id, name:name, 
                    password:password, role:role },
             success: function(response) {
                if(response.result == true) {
                   userList();
                } 
             }, 
             error:function(xhr, status, message) { 
                 alert(" status: "+status+" er:"+message);
             }
          });
      });//등록 버튼 클릭
   }//userInsert
   //사용자 목록 조회 요청
   function userList() {
      $.ajax({
         url:conPath + '/users',
         type:'GET',
         dataType:'json'
      }).fail(function(xhr,status,msg){
         alert("상태값 :" + status + " Http에러메시지 :"+msg);
      }).done(function(datas){
         $("tbody").empty();
         for(item of datas){
            $('<tr>')
            .data("id",item.id)
            .append($('<td>').html(item.id))
            .append($('<td>').html(item.name))
            .append($('<td>').html(item.password))
            .append($('<td>').html(item.role))
            .append($('<td>').html('<button id=\'btnSelect\'>조회</button>'))
            .append($('<td>').html('<button id=\'btnDelete\'>삭제</button>'))
            //.append($('<input type=\'hidden\' id=\'hidden_userId\'>').val(item.id))
            .appendTo('tbody');
         };//each
      });
   }//userList
</script>
</head>
<body>
<div class="container">
   <form id="form1"  class="form-horizontal">
      <h2>사용자 등록 및 수정</h2>
      <div class="form-group">      
         <label >아이디:</label>
         <input type="text"  class="form-control" name="id" >
      </div>   
      <div class="form-group">
         <label>이름:</label>
         <input type="text"  class="form-control"  name="name" >
      </div>   
      <div class="form-group">
         <label>패스워드:</label>
         <input type="text"  class="form-control"  name="password" >
      </div>           
      <div class="form-group">   
         <label>역할:</label>
            <select class="form-control" name="role">
                        <option value="Admin">관리자</option>
                        <option value="User">사용자</option>
            </select>
      </div>  
      <div class="btn-group">      
            <input type="button"  class="btn btn-primary" value="등록"  id="btnInsert" /> 
            <input type="button"  class="btn btn-primary" value="수정"  id="btnUpdate" />
            <input type="button"  class="btn btn-primary" value="초기화" id="btnInit" />
      </div>
   </form>
</div>      
<hr/>      
<div class="container">   
   <h2>사용자 목록</h2>
   <table class="table text-center">
      <thead>
      <tr>
         <th class="text-center">아이디</th>
         <th class="text-center">이름</th>
         <th class="text-center">성별</th>
         <th class="text-center">권한</th>
      </tr>
      </thead>
      <tbody></tbody>
   </table>
</div>   
</body>
</html>