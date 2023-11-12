<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/entHeader.jsp"%>

<div class="box box-info">
	<form action="" method="post">
		<%-- 		<input type="hidden" name="own_id" value="${own_id }" > --%>
		<table>
			<tr>
				<td>검색</td>
			<tr />
			<tr>
				<td colspan="2">
					<div class="form-group">
						<select class="form-control" name="search_cate">
							<option value="prod_name">상품명</option>
							<option value="tr_no">주문번호</option>
						</select>
					</div>
				</td>
				<td>
					<div class="input-group margin">
						<input type="text" class="form-control" name="search"> <span
							class="input-group-btn">
							<button type="submit" class="btn btn-info btn-flat">Go!</button>
						</span>
					</div>
				</td>
			</tr>
		</table>
	</form>
	<div class="box-header with-border">
		<h3 class="box-title">주문관리</h3>
		<div class="box-tools pull-right">
			<button type="button" class="btn btn-box-tool" data-widget="collapse">
				<i class="fa fa-minus"></i>
			</button>
			<button type="button" class="btn btn-box-tool" data-widget="remove">
				<i class="fa fa-times"></i>
			</button>
		</div>
	</div>

	<div class="box-body">
		<div class="table-responsive">
			<table class="table no-margin">
				<thead>
					<tr>
						<th>상품번호</th>
						<th>상품명</th>
						<th>구매자</th>
						<th>가격</th>
						<th>관리</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${tlist }" var="tlist">
						<tr>
							<td><a href="">${tlist.tr_no }</a></td>
							<td>${tlist.prodVO.prod_name }</td>
							<td><span class="label label-success">${tlist.tr_buy }</span></td>
							<td>${tlist.prodVO.prod_price }</td>
							<td>
								<button type="button" class="btn btn-danger" data-toggle="modal"
									data-target="#modal-danger" data-tr_no=${tlist.tr_no }>환불</button>
							</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>

	</div>
</div>




<!-- modal -->
<div class="modal modal-danger fade" id="modal-danger"
	style="display: none;">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<h4 class="modal-title">환불</h4>
			</div>
			<div class="modal-body">
				<p>환불하시겠습니까?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-outline pull-left"
					data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-outline" id="refund">환불하기</button>
			</div>
		</div>

	</div>

</div>
<!-- modal -->

<script type="text/javascript">
$(function() {
	$('#modal-danger').on("show.bs.modal", function(e) {
		console.log(e);
		var tr_no = $(e.relatedTarget).data('tr_no') * 1;
		console.log(tr_no);
		$('#refund').click(function() {
			location.href='/ent/refund?tr_no='+tr_no;
		});
	});
	
	
});
</script>


<%@ include file="../include/footer.jsp"%>