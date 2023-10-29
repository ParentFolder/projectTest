<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<link
	href="${pageContext.request.contextPath }/resources/plugins/timepicker/bootstrap-timepicker.min.css"
	rel="stylesheet" type="text/css" />
<script
	src="${pageContext.request.contextPath }/resources/plugins/timepicker/bootstrap-timepicker.min.js"></script>
<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">상점 메인 페이지 수정하기</h3>
	</div>


	<form role="form">

		<div class="box-body">
			<div class="form-group">
				<label>가게 소개글</label>
				<div class="form-group">
					<textarea class="form-control" rows="3"></textarea>
				</div>
			</div>
			<div class="form-group">
				<label>공지사항</label>
				<div class="form-group">
					<textarea class="form-control" rows="3"></textarea>
				</div>
			</div>
			<div class="form-group">
				<label>가게 전화번호</label>
			</div>
			<div class="input-group">
				<span class="input-group-addon"><i class="fa fa-fw fa-mobile"></i></span>
				<input type="text" class="form-control">
			</div>
			<div class="bootstrap-timepicker">
				<div class="form-group">
					<label>가게 운영시간</label>
					<div class="input-group">
						<div class="input-group-addon">
							<i class="fa fa-clock-o"></i>
						</div>
						<input type="text" class="form-control timepicker">
					</div>
				</div>
			</div>
			<div class="bootstrap-timepicker">
				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">
							<i class="fa fa-clock-o"></i>
						</div>
						<input type="text" class="form-control timepicker">
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="exampleInputFile">File input</label> <input type="file"
					id="exampleInputFile">
				<p class="help-block">Example block-level help text here.</p>
			</div>
		</div>

		<div class="box-footer">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form>
</div>
<script>
	$(function() {

		//Timepicker
		$('.timepicker').timepicker({
			showInputs : false
		})

	})
</script>
<%@ include file="../include/footer.jsp"%>