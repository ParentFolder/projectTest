<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<div class="box box-info">
	<form action="">

		<table>
			<tr>
				<td>검색</td>
			<tr />
			<tr>
				<td colspan="2">
					<div class="form-group">
						<select class="form-control" id="cate">
							<option>상품명</option>
							<option>주문번호</option>
						</select>
					</div> 
				</td>
				<td>
					<div class="input-group margin">
						<input type="text" class="form-control"> <span class="input-group-btn">
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
						<th>결제상태</th>
						<th>결제일</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><a href="pages/examples/invoice.html">OR9842</a></td>
						<td>Call of Duty IV</td>
						<td><span class="label label-success">Shipped</span></td>
						<td>
							<div class="sparkbar" data-color="#00a65a" data-height="20">
								<canvas width="34" height="20" style="display: inline-block; width: 34px; height: 20px; vertical-align: top;"></canvas>
							</div>
						</td>
					</tr>
					
				</tbody>
			</table>
		</div>

	</div>

	<div class="box-footer clearfix">
		<a href="javascript:void(0)" class="btn btn-sm btn-info btn-flat pull-left">Place New Order</a> <a href="javascript:void(0)" class="btn btn-sm btn-default btn-flat pull-right">View All Orders</a>
	</div>

</div>







<%@ include file="../include/footer.jsp"%>