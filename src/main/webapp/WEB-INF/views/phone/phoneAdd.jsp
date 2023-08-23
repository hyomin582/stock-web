<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <title>회원 추가 목록</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/style.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="../js/JS_login.js"></script>
</head>
 <body>
    <form class="container shadow mt-5 p-5 needs-validation was-validated" novalidate="" action="/phone/add" method="post">
    <h3>Together !</h3>
    <hr>
      <div class="memberImp">
        <label for="inputName " class="form-label">이름</label>
        <input type="text" placeholder="ex) 홍길동" class="form-control" id="inputName" name="mbnm" required="" onblur="abc123()">
        <span id="abcde" class="nameErrorColor"></span>
      </div>
      <hr>
      <div class="memberImp">
        <label for="inputPhone" class="form-label">전화번호</label>
        <input type="tel" placeholder="ex) 01012345678" class="form-control" id="inputPhone" name="mbph" required="" maxlength="11">
        <div class="invalid-feedback"> 번호를 입력하지 않았습니다.</div>
      </div>
      <hr>
      <div class="memberImp">
        <label for="inputAdress" class="form-label">주소</label>
        <input type="text" placeholder="ex) 서울특별시 강남구" class="form-control" id="inputAdress" name="mbad" required="">
        <div class="invalid-feedback"> 주소를 입력하지 않았습니다. </div>
      </div>
	  <hr>
      <div class="memberImp">
        <label for="inputGroup" class="form-label">그룹</label>
        <input type="text" placeholder="ex) 가족, 친구, 기타 중 선택" class="form-control" id="inputGroup" name="groupname" required="">
        <div class="invalid-feedback"> 그룸을 입력하지 않았습니다. </div>
<!--         <select class="form-select" id="inputGroup" name="groupname" required="">
          <option selected="" disabled="" value="">선택</option>
          <option>가족</option>
          <option>친구</option>
          <option>기타</option>
        </select> -->
<!--         <div class="invalid-feedback">
          그룹을 선택하세요. 
        </div> -->
      </div>
      <hr>
      <div class="d-grid gap-2">
         <button class="btn" type="submit" >등록하기</button> 
      </div>
    </form>
</body>
</html>