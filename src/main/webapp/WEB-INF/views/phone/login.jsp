<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../phone/joinUser.jsp">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="../js/JS_login.js"></script>
<title>로그인</title>
</head>
<body>
 	<form class="container shadow mt-5 p-5 " action="/phone/loginSuccess" method="post">
	<h3> Login !</h3>
	<hr>
        <div class="mb-3">
          <label for="Email1" class="form-label">Email address</label>
          <input type="email" name="userid" class="form-control" id="Email1" placeholder="email@example.com">
        </div>
        <div class="mb-3">
          <label for="Password1" class="form-label">Password</label>
          <input type="password" name="userpw" class="form-control" id="Password1" placeholder="Password">
        </div>
        <button type="submit" class="btn btn-green">login</button>
        <hr>
      <div class="dropdown-divider"></div>
      <a class="dropdown-item" href="../phone/join">회원이 아니십니까?</a>
      </form>
      ${error}
</body>
</html>