<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<link rel="stylesheet" href="../css/style.css">

<title>전화번호부</title>
</head>
<body>
	<form
		class="container shadow mt-5 p-5 needs-validation was-validated fs-6" >
		<h3>${userid}님, 안녕하세요 !</h3>
		<hr>
		<div class="tab-content" id="myTabContent">
			<ul class="nav nav-tabs" id="myTab" role="tablist">
				<li class="nav-item" role="presentation">
					<button class="nav-link active" id="all-tab" data-bs-toggle="tab"
						data-bs-target="#all-tab-pane" type="button" role="tab"
						aria-controls="all-tab-pane" aria-selected="true">전체(-)</button>
				</li>
				
				<li class="nav-item" role="presentation">
					<button class="nav-link" id="familly-tab" data-bs-toggle="tab"
						data-bs-target="#familly-tab-pane" type="submit" role="tab" 
						aria-controls="familly-tab-pane" aria-selected="false">가족(-)</button>
				</li>
				
				<li class="nav-item" role="presentation">
					<button class="nav-link" id="freind-tab" data-bs-toggle="tab"
						data-bs-target="#freind-tab-pane" type="button" role="tab"
						aria-controls="freind-tab-pane" aria-selected="false">친구(-)</button>
				</li>
				<li class="nav-item" role="presentation">
					<button class="nav-link" id="any-tab" data-bs-toggle="tab"
						data-bs-target="#any-tab-pane" type="button" role="tab"
						aria-controls="any-tab-pane" aria-selected="false">기타(-)</button>
				</li>
			</ul>
		</div>
		<div class="tab-pane fade show active" id="all-tab" role="tabpanel"
			aria-labelledby="all-tab" tabindex="0">
			<c:forEach var="phone" items="${phoneList}" varStatus="status">
				<li
					class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
					[${status.count}] ${phone.mbnm} ${phone.mbph} ${phone.mbad}
					${phone.groupname}
					<a href="/phone/update/${phone.mbph}"><span class="btn btn-outline-secondary bg-light mb-3">수정하기</span></a>
					<button class="btn btn-outline-secondary bg-light mb-3" type="button" data-bs-toggle="collapse" data-bs-target="#addForm" aria-expanded="false" aria-controls="addForm">수정</button>
					<a href="/phone/delete/${phone.mbph}"><span class="badge bg-secondary">&times;</span></a>
				</li>
			</c:forEach>
		</div>
		<div class="tab-pane fade" id="familly-tab-pane" role="tabpanel"
			aria-labelledby="familly-tab" tabindex="0">가족</div>
		<div class="tab-pane fade" id="freind-tab-pane" role="tabpanel"
			aria-labelledby="freind-tab" tabindex="0">친구</div>
		<div class="tab-pane fade" id="any-tab-pane" role="tabpanel"
			aria-labelledby="any-tab" tabindex="0">기타</div>
			<a href="../phone/addButton">회원추가</a>
			<a href="../phone/login">로그아웃</a>
	</form>
			${msg}
</body>
</html>
