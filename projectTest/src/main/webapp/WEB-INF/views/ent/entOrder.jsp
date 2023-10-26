<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>주문관리(order.jsp)</h1>

	<form action="">
		<table>
			<tr>
				<td>검색</td>
				
				<td colspan="2">
					<label for=cate>검색조건</label>
					<select name="category" id=cate>
						<option value="test1">상품명</option>
						<option value="test2">주문번호</option>
					</select>
				</td>
				<td colspan="2"><input type="search" name="prod_search"></td>
				<td><input type="submit" value="조회하기"></td>
			</tr>
		</table>
		<table>
			<tr>
				<th>주문번호</th>
				<th>상품명</th>
				<th>상품상태</th>
				<th>가격</th>
				<th>결제상태</th>
			</tr>
		</table>
	</form>
</body>
</html>