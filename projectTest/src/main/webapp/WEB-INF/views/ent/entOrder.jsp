<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp"%>

<div class="box box-info">
	<form action="">
		<input type="hidden" name="own_id" value="${own_id }" >
		<table border=1>
			<tr>
				<td>검색</td>
			<tr/>
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
						<input type="text" class="form-control" name="search"> <span class="input-group-btn">
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
						<th>결제일</th>
						<th>관리</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${tlist }" var="tlist">
					<tr>
						<td><a href="">${tlist.tr_no }</a></td>
						<td>${tlist.tr_prod }</td>
						<td><span class="label label-success">${plist.pay_state }</span></td>
						<td>
							${plist.pay_date }
						</td>
						<td>
							<button type="button" class="btn btn-block btn-danger">환불</button>
						</td>
					</tr>
					</c:forEach>
					
				</tbody>
			</table>
		</div>

	</div>
</div>







<%@ include file="../include/footer.jsp"%>