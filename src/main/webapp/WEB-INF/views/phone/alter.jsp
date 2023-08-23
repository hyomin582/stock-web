<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <title>회원 수정 메뉴</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/style.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="../js/JS_login.js"></script>
</head>
 <body>
    <form class="container shadow mt-5 p-5 needs-validation was-validated" action="/phone/updateMem" method="post">
    <h3>회원 수정 메뉴</h3> 
    <hr>
      <div class="memberImp">
        <label for="inputName " class="form-label">이름</label>
        <input type="text" placeholder="변경할 이름을 입력하시오 " class="form-control" id="inputName" name="mbnm" required="">
        <span id="abcde" class="nameErrorColor"></span>
      </div>
      <hr>
      <div class="memberImp">
        <label for="inputPhone" class="form-label">전화번호</label>
        <input type="tel" placeholder="변경할 번호를 입력하시오" class="form-control" id="inputPhone" name="mbph" maxlength="11" required="">
        <div class="invalid-feedback"> 번호를 입력하지 않았습니다.</div>
      </div>
      <hr>
      <div class="memberImp">
        <label for="inputAdress" class="form-label">주소</label>
        <input type="text" placeholder="변경할 주소를 입력하시오" class="form-control" id="inputAdress" name="mbad" required="">
        <div class="invalid-feedback"> 주소를 입력하지 않았습니다. </div>
      </div>
	  <hr>
      <div class="memberImp">
        <label for="inputGroup" class="form-label">그룹</label>
        <input type="text" placeholder="ex) 가족, 친구, 기타 중 선택" class="form-control" id="inputGroup" name="groupname" >
        <div class="invalid-feedback"> 그룸을 입력하지 않았습니다. </div>
      </div>
      <hr>
      <div class="d-grid gap-2">
         <button class="btn" type="submit" >변경내용 저장하기</button> 
      </div>
    </form>
</body>
</html>
