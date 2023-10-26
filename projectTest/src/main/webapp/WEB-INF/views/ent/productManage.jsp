<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품등록,수정,조회(productCRUD.jsp)</h1>
	<!-- include -->
	<div class="left"> 
		<div class="shop_container">
			<p class="left_subject">상점 메뉴</p>
			<p class="left_list">상점 메인페이지</p>
			<p class="left_list">상점 추천상품</p>
		</div>
		<div class="product_container">
			<p class="left_subject">상품/주문 관리</p>
			<p class="left_list">상품등록/수정/조회</p>
			<p class="left_list">주문관리</p>
		</div>
		<div class="talk_container">
			<p class="left_subject">판다톡 관리</p>
			<p class="left_list">자주쓰는 문구</p>
			<p class="left_list">자동응답설정</p>
		</div>
	</div>
	<!-- include -->
	
	<div class="container">
		<div><p>상품 등록/수정/조회</p></div>
		<div class="">
			<input type="button" value="상품등록">
			<form action="" method="post">			
				<table border="1">
					<tr>
						<td>상품조회</td>
						<td colspan="2"><input type="search" name="prod_search"></td>
						<td>카테고리</td>
						<td><select name="category">
								<option value="test1">카테고리1</option>
								<option value="test2">카테고리2</option>
								<option value="test3">카테고리3</option>
								<option value="test4">카테고리4</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>상품상태</td>
						<td colspan="2">
							<input type="radio" name="p_state" value="0" id="radio1"><label for="radio1">중고</label>
							<input type="radio" name="p_state" value="1" id="radio2"><label for="radio2">새상품</label>
						</td>
						<td>판매상태</td>
						<td>
							<input type="checkbox" name="s_state" id="check1"><label for="check1">판매중</label>
							<input type="checkbox" name="s_state" id="check2"><label for="check1">완료</label>
						</td>
					</tr>
			
				</table>
				<input type="submit" value="조회하기">
			</form>
			<div>
				<table border="1">
					<tr>
						<th>번호</th>
						<th>제품이름</th>
						<th>제품상태</th>
						<th>가격</th>
						<th>수정</th>
					</tr>
<%-- 					<c:forEach items="${search }" var=list> --%>
<!-- 					<tr> -->
<%-- 						<td>${list.bno }</td> --%>
<%-- 						<td>${list.name }</td> --%>
<%-- 						<td>${list.state }</td> --%>
<%-- 						<td>${list.price }</td> --%>
<!-- 						<td><a>수정</a></td> -->
<!-- 					</tr> -->
<%-- 					</c:forEach> --%>
				</table>
			</div>
		</div>
	
	</div>
	

</body>
</html>