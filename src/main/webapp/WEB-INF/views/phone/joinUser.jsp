<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <title>회원 가입</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/style.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="../js/JS_login.js"></script>
</head>
 <body>
    <form class="container shadow mt-5 p-5" action="/phone/newMember" method="post">
    <h3>Join the membership !</h3>
    <hr>
      <div class="memberImp">
        <label for="inputName " class="form-label">Email address</label>
        <input type="email" placeholder="Example@example.com" name="userid" class="form-control" id="inputName" required="">
      </div>
      <hr>
      <div class="memberImp">
        <label for="nickname" class="form-label">닉네임</label>
        <input type="text" placeholder="사용할 닉네임을 입력하세요." name="nickname"class="form-control" id="nickname" required=""> <!-- userTb의 닉네임으로 보내기 -->
      </div>
      <hr>
      <div class="memberImp">
     	  <label for="Password1" class="form-label">Password</label>
          <input type="password" class="form-control" id="Password1" name="userpw" placeholder="Password" required="">
      </div>
      <hr>
      <div class="memberImp">
	   	  <label for="Password1" class="form-label">Password Check</label>   <!-- 유효성검사 -->
		  <input type="password" placeholder="Password Check" name="checkpw" class="form-control" id="inputPhone" required="" >
      </div>
      <hr>
      <div class="d-grid gap-2">
         <button class="btn" type="submit">등록하기</button> 
      </div>
    </form>
	      ${msg}
</body>
</html>