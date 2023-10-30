<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<link
	href="${pageContext.request.contextPath }/resources/plugins/timepicker/bootstrap-timepicker.min.css"
	rel="stylesheet" type="text/css" />
<script
	src="${pageContext.request.contextPath }/resources/plugins/timepicker/bootstrap-timepicker.min.js"></script>

<script type="text/javascript">
	console.log('${ent}');
	
</script>


<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">상점 메인 페이지 수정하기</h3>
	</div>


	<form role="form" action="" method="post">

		<div class="box-body">
			<div class="form-group">
				<label>가게 소개글</label>
				<div class="form-group">
					<textarea class="form-control" rows="3" name="ent_info">${ent[0].ent_info}</textarea>
				</div>
			</div>
			<div class="form-group">
				<label>공지사항</label>
				<div class="form-group">
					<textarea class="form-control" rows="3" name="ent_notice">${ent[0].ent_notice}</textarea>
				</div>
			</div>
			<div class="bootstrap-timepicker">
				<div class="form-group">
					<label>가게 운영시간</label>
					<div class="input-group">
						<div class="input-group-addon">
							<i class="fa fa-clock-o"></i>
						</div>
						<input type="text" class="form-control timepicker" name="ent_ot" value="${ent[0].ent_ot }">
					</div>
				</div>
			</div>
			<div class="bootstrap-timepicker">
				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">
							<i class="fa fa-clock-o"></i>
						</div>
						<input type="text" class="form-control timepicker" name="ent_ct" value="${ent[0].ent_ct }">
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="exampleInputFile">File input</label> <input type="file"
					id="exampleInputFile" name="ent_img">
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
		});
		
		

	})
</script>
<%@ include file="../include/footer.jsp"%>