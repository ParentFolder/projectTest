<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/entHeader.jsp"%>



<div class="small-box bg-aqua">
	<div class="inner">
		<h3>홈페이지 광고</h3>
	</div>
	<div class="icon">
		<i class="fa fa-shopping-cart"></i>
	</div>
	<div class="small-box-footer icon-ad" data-toggle="modal" data-target="#modal-default">
		신청하기 <i class="fa fa-arrow-circle-right"></i>
	</div>
</div>

<div class="small-box bg-yellow">
	<div class="inner">
		<h3>체험단 신청</h3>
	</div>
	<div class="icon">
		<i class="ion ion-person-add"></i>
	</div>
	<a href="#" class="small-box-footer"> 신청하기 <i class="fa fa-arrow-circle-right"></i>
	</a>
</div>





<!-- modal -->
<div class="modal modal-default fade" id="modal-default" style="display: none;">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<h4 class="modal-title">상품 광고 등록</h4>
			</div>
			<div class="modal-body">
				<div class="box box-primary">
					<div class="box-header with-border"></div>
					<div class="form-group">
						<label>업로드 기한</label> <select class="form-control" name="ad_upload">
							<option value="30">30일</option>
							<option value="60">60일</option>
							<option value="90">90일</option>
						</select>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary pull-left">Save</button>
					<button type="button" class="btn btn-default pull-right" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	$(function() {
		
	});
</script>

<%@ include file="../include/footer.jsp"%>