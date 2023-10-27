<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jsp"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- <script -->
<!-- 	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script> -->
<!-- <script -->
<!-- 	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->

<h1>상품등록,수정,조회(productManage.jsp)</h1>
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
	<div>
		<p>상품 등록/수정/조회</p>
	</div>
	<div class="">
		<input type="button" value="상품등록">
		<form action="" method="post">
			<table border="1">
				<tr>
					<td>상품명</td>
					<td colspan="2"><input type="search" name="prod_name" id="search_name" value=""></td>
					<td>카테고리</td>
					<td><select name="prod_cate">
							<option value="">선택</option>
							<option value="category1">카테고리1</option>
							<option value="category2">카테고리2</option>
							<option value="category3">카테고리3</option>
					</select></td>
				</tr>
				<tr>
					<td>상품상태</td>
					<td colspan="2"><input type="radio" name="prod_con" value="중고" id="radio1"><label for="radio1">중고</label>
					 <input type="radio" name="prod_con" value="새상품" id="radio2"><label for="radio2">새상품</label></td>
				</tr>

			</table>
			<input type="submit" value="조회하기">
		</form>

	</div>

<div class="container">
	<div class="box">
		<div class="box-body table-responsive no-padding">
			<table class="table table-hover">
				<tbody>
					<tr>
						<th>제품번호</th>
						<th>구매자</th>
						<th>제품상태</th>
						<th>가격</th>
						<th>수정</th>
					</tr>
					<c:if test="${!empty plist }">
						<c:forEach items="${plist }" var="list">
							<tr>
								<td>${list.prod_no }</td>
								<td class="name_value">${list.prod_name }</td>
								<td class="con_value">${list.prod_con }</td>
								<td class="price_value">${list.prod_price }</td>
								<td>
									<button type="button" class="btn btn-success" data-toggle="modal" 
									data-target="#modal-default" data-prod_name="${list.prod_name }"
									data-prod_con="${list_prod_con }"  data-prod_price=${list.prod_price }>
										수정
									</button>
								</td>
							</tr>
						</c:forEach>
					</c:if>

				</tbody>
			</table>
		</div>

	</div>

</div>
<!-- modal -->
<div class="modal modal-default fade" id="modal-default" style="display: none;">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<h4 class="modal-title">상품 수정하기</h4>
			</div>
			<div class="modal-body">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">Quick Example</h3>
					</div>


					<form role="form" action="">
						<div class="box-body">
							<div class="form-group">
								<label for="prod_name">상품명</label> <input type="text" class="form-control" id="prod_name">
							</div>
							<div class="form-group">
								<label for="prod_price">가격</label> <input type="text" class="form-control" id="prod_price">
							</div>
							<div class="form-group">
								<label>제품상태</label> 
								<c:if test=""></c:if>
								<input type="radio" name="prod_con" value="중고" id="p_radio1">
								<label for="p_radio1">중고</label>
								<input type="radio" name="prod_con" value="새상품" id="p_radio2">
								<label for="p_radio2">새상품</label>
							</div>
							<div class="form-group">
								<label for="exampleInputFile">가게이미지</label> <input type="file" id="exampleInputFile">
								<p class="help-block">Example block-level help text here.</p>
							</div>
							<div class="checkbox">
								<label> <input type="checkbox"> Check me out
								</label>
							</div>
						</div>

						<div class="box-footer">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
					</form>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Save changes</button>
			</div>
		</div>

	</div>
</div>
<script type="text/javascript">
// 	var input = document.getElementById("search_name");
// 	input.value = null;
// 	console.log(input.value);
	$(function() {
		var prod_name;
		var prod_con;
		var prod_price;
		$('.bnt_modal').click(function() {
			$('#modal-default').modal('show');
		});
		$('#modal-default').on("show.bs.modal",function (e) {
			prod_name = $(e.relatedTarget).data('prod_name');
			prod_con = $(e.relatedTarget).data('prod_con');
			prod_price = $(e.relatedTarget).data('prod_price');
			$('#prod_name').val(prod_name);
			$('#prod_con').val(prod_con);
			$('#prod_price').val(prod_price);
		});
// 		$('button').parent('td').click(function(){
// 			prod_name = $(this).attr("data-prod_name");
// 			prod_con = $(this).attr("data-prod_name");
// 			prod_price = $(this).attr("data-prod_name");
// 		});
		console.log(prod_name);
		console.log(prod_con);
		console.log(prod_price);
		$('.bnt-outline').click(function() {
			$('#modal-default').style.display = "none";
		});
		$('.close').click(function() {
			$('#modal-default').style.display = "none";
		});
	});
</script>
<%@ include file="../include/footer.jsp"%>
</body>
</html>