<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jsp"%>
<!-- <link rel="stylesheet" -->
<!-- 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<!-- <script -->
<!-- 	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script> -->
<!-- <script -->
<!-- 	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->

<h1>상품등록,수정,조회(productManage.jsp)</h1>
<!-- include -->
<!-- <div class="left"> -->
<!-- 	<div class="shop_container"> -->
<!-- 		<p class="left_subject">상점 메뉴</p> -->
<!-- 		<p class="left_list">상점 메인페이지</p> -->
<!-- 		<p class="left_list">상점 추천상품</p> -->
<!-- 	</div> -->
<!-- 	<div class="product_container"> -->
<!-- 		<p class="left_subject">상품/주문 관리</p> -->
<!-- 		<p class="left_list">상품등록/수정/조회</p> -->
<!-- 		<p class="left_list">주문관리</p> -->
<!-- 	</div> -->
<!-- 	<div class="talk_container"> -->
<!-- 		<p class="left_subject">판다톡 관리</p> -->
<!-- 		<p class="left_list">자주쓰는 문구</p> -->
<!-- 		<p class="left_list">자동응답설정</p> -->
<!-- 	</div> -->
<!-- </div> -->
<!-- include -->
<div>
	<p>상품 등록/수정/조회</p>
</div>

<div class="container">
	<div class="search_container">
		<input type="button" value="상품등록" class="btn btn-success"
			data-toggle="modal" data-target="#modal-default"
			data-own_id="${ent.own_id }"
			data-modal_cate=0>
		<form action="" method="post">
			<table class="table table-hover">
				<tr>
					<td>상품명</td>
					<td colspan="2"><input type="search" name="prod_name"
						id="search_name" class="form-control" value=""></td>
					<td>
				</tr>

				<tr>
					<td>카테고리</td>
					<td><select name="prod_cate" class="form-control">
							<option value="">선택</option>
							<option value="category1">카테고리1</option>
							<option value="category2">카테고리2</option>
							<option value="category3">카테고리3</option>
							<option value="category4">카테고리4</option>
							<option value="category5">카테고리5</option>
							<option value="category6">카테고리6</option>
					</select></td>
					<td>상품상태</td>
					<td colspan="2">
						<input type="radio" name="prod_con" value="중고"
						id="radio1"><label for="radio1">중고</label> <input
						type="radio" name="prod_con" value="새상품" id="radio2"><label
						for="radio2">새상품</label></td>
				
				</tr>

			</table>
			<input type="submit" value="조회하기" class="btn btn-info">
		</form>
	</div>

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
									<button type="button" class="btn btn-success"
										data-toggle="modal" data-target="#modal-default"
<%-- 										data-prod="${list }" --%>
										data-prod_no="${list.prod_no }"
										data-prod_name="${list.prod_name }"
										data-prod_con="${list.prod_con }"
										data-prod_price="${list.prod_price }"
										data-prod_content="${list.prod_content }"
										data-prod_cate="${list.prod_cate }"
										data-prod_img="${list.prod_img }"
										data-own_id="${list.own_id }"
										data-modal_cate=1>수정</button>
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
<div class="modal modal-default fade" id="modal-default"
	style="display: none;">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<h4 class="modal-title">상품 등록/수정하기</h4>
			</div>
			<div class="modal-body">
				<div class="box box-primary">
					<div class="box-header with-border">
					</div>


					<form role="form" action="/ent/productUpdate" method="post">
						<c:if test="${modal_cate eq 1 }">
							<input type="hidden" name="prod_no" id="prod_no">
						</c:if>
						<input type="hidden" name="own_id" id="own_id">
						<input type="hidden" name="modal_cate" id ="modal_cate">
						<div class="box-body">
							<div class="form-group">
								<label for="prod_name">상품명</label> <input type="text"
									class="form-control" id="prod_name" name="prod_name">
							</div>
							<div class="form-group">
								<label for="prod_price">가격</label> <input type="text"
									class="form-control" name="prod_price" id="prod_price">
							</div>
							<div class="form-group">
								<label>제품상태</label>
								
								<input type="radio" name="prod_con" value="중고" id="p_radio1">
								<label for="p_radio1">중고</label> <input type="radio"
									name="prod_con" value="새상품" id="p_radio2"> <label
									for="p_radio2">새상품</label>
							</div>
							<div class="form-group">
								<label>상품설명</label>
								<textarea class="form-control" rows="3" id="prod_content"
									name="prod_content"></textarea>
							</div>
							<div class="form-group">
								<label>Select</label> <select class="form-control"
									id="prod_cate" name="prod_cate">
									<option value="category1">option 1</option>
									<option value="category2">option 2</option>
									<option value="category3">option 3</option>
									<option value="category4">option 4</option>
									<option value="category5">option 5</option>
									<option value="category6">option 6</option>
								</select>
							</div>
							<div class="form-group">
								<label for="prod_img">상품이미지</label> <input type="file"
									id="prod_img" name="prod_img">
								<p class="help-block">Example block-level help text here.</p>
							</div>
						</div>

						<div class="box-footer">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
					</form>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default pull-right"
					data-dismiss="modal">Close</button>
			</div>
		</div>

	</div>
</div>
<script type="text/javascript">
	// 	var input = document.getElementById("search_name");
	// 	input.value = null;
	// 	console.log(input.value);
	$(function() {
		$('.bnt_modal').click(function() {
			$('#modal-default').modal('show');
		});
		$('#modal-default').on("show.bs.modal", function(e) {
			$('.box-title').remove();
// 			var prod = $(e.relatedTarget).data('prod');
			console.log(e.relatedTarget);
			var prod_no = $(e.relatedTarget).data('prod_no')*1;
			var prod_name = $(e.relatedTarget).data('prod_name');
			var prod_con = $(e.relatedTarget).data('prod_con');
			var prod_price = $(e.relatedTarget).data('prod_price');
			var prod_content = $(e.relatedTarget).data('prod_content');
			var prod_cate = $(e.relatedTarget).data('prod_cate');
			var prod_img = $(e.relatedTarget).data('prod_img');
			var own_id = $(e.relatedTarget).data('own_id')*1;
			var modal_cate = $(e.relatedTarget).data('modal_cate')*1;
			console.log(own_id);
			console.log(prod_con);
			if (prod_con == '새상품') {
				$('#p_radio2').attr("checked", true);
			} else {
				$('#p_radio1').attr("checked", true);
			}

			$('#prod_no').val(prod_no);
			$('#prod_name').val(prod_name);
			$('#prod_price').val(prod_price);
			$('#prod_content').val(prod_content);
			$('#prod_cate').val(prod_cate).prop("selected", true);
			// 			$('#prod_img').val(prod_img);
			$('#own_id').val(own_id);
			$('#modal_cate').val(modal_cate);
			
			if(modal_cate == 1){
				$('.box-header').append('<h3 class="box-title">상품 수정하기</h3>')
			}else{
				$('.box-header').append('<h3 class="box-title">상품 등록하기</h3>')
			}
			
		});
	});
</script>
<%@ include file="../include/footer.jsp"%>
