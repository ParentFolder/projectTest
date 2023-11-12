<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="../include/entHeader.jsp"%>
<div class="ent_container">
	<div class="img_container">
		<div class="ent_img">
			<img
				src="${pageContext.request.contextPath }/ent/download?imageFileName=${ent[0].ent_img}"
				width="1200px">
		</div>
		<div class="small-box bg-yellow">
			<div class="inner">
				<h3>체험단 신청</h3>
			</div>
			<div class="icon">
				<i class="ion ion-person-add"></i>
			</div>
			<a href="#" class="small-box-footer">신청하기 <i
				class="fa fa-arrow-circle-right"></i></a>
		</div>
	</div>
	<div class="nav-tabs-custom">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#tab_1" data-toggle="tab"
				aria-expanded="true">공지사항</a></li>
			<li class=""><a href="#tab_2" data-toggle="tab"
				aria-expanded="false">가게 소개글</a></li>
		</ul>
		<div class="tab-content">
			<div class="tab-pane active" id="tab_1">
				${ent[0].ent_notice}
			</div>

			<div class="tab-pane" id="tab_2">
				${ent[0].ent_info}
			</div>
		</div>

	</div>
	<div class="notice_container"></div>
	<div class="box box-success">
		<div class="box-header with-border">
			<h3 class="box-title">가게 위치</h3>
			<div class="box-tools pull-right">
				<button type="button" class="btn btn-box-tool"
					data-widget="collapse">
					<i class="fa fa-minus"></i>
				</button>

			</div>
		</div>

		<div class="box-body no-padding">
			<div id="map" style="width: 500px; height: 400px;"></div>
		</div>
	</div>

	<!-- 		<div class="review_container"> -->
	<%-- 			<c:forEach items="${review }" var="rv"> --%>
	<!-- 				<tr class="review"> -->
	<%-- 					<td class="reviewer">${rv.buy }</td> --%>
	<%-- 					<td class="review_content">${rv.content }</td> --%>
	<!-- 				</tr> -->
	<%-- 			</c:forEach> --%>
	<!-- 		</div> -->
</div>
<div class="box box-danger">
	<div class="box-header with-border">
		<h3 class="box-title">제품 소개</h3>
		<div class="box-tools pull-right">
			<button type="button" class="btn btn-box-tool" data-widget="collapse">
				<i class="fa fa-minus"></i>
			</button>
		</div>
	</div>

	<div class="box-body no-padding">
		<ul class="users-list clearfix">
			<c:forEach items="${plist }" var="prod">
				<li><img
					src="${pageContext.request.contextPath }/ent/download?imageFileName=${prod.prod_img }">
					<p>${prod.prod_name }</p> <span class="users-list-date">${prod.prod_content }</span></li>
			</c:forEach>
		</ul>

	</div>
</div>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a41c6623d85b187520b3d92f4b708850&libraries=services"></script>
​
<script type="text/javascript">
	var container = document.getElementById('map'), //지도를 담을 영역의 DOM 레퍼런스
	options = { //지도를 생성할 때 필요한 기본 옵션
		center : new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
		level : 3
	//지도의 레벨(확대, 축소 정도)
	};

	var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();

	// 주소로 좌표를 검색합니다
	// 	geocoder.addressSearch(${ent[0].ent_addr}, function(result, status) {
	geocoder
			.addressSearch(
					'부산시 영도구 영선대로 34',
					function(result, status) {

						// 정상적으로 검색이 완료됐으면 
						if (status === kakao.maps.services.Status.OK) {

							var coords = new kakao.maps.LatLng(result[0].y,
									result[0].x);

							// 결과값으로 받은 위치를 마커로 표시합니다
							var marker = new kakao.maps.Marker({
								map : map,
								position : coords
							});

							// 인포윈도우로 장소에 대한 설명을 표시합니다
							var infowindow = new kakao.maps.InfoWindow(
									{
										// 			content: '<div style="width:150px;text-align:center;padding:6px 0;">${ent[0].ent_name}</div>'
										content : '<div style="width:150px;text-align:center;padding:6px 0;">검색한 위치</div>'
									});
							infowindow.open(map, marker);

							// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
							map.setCenter(coords);
						}
					});
	/* prod 이미지  */
	$(function() {
		console.log('${fileList}');
		// 		console.log(pList);
		// 		for(var i=0; i< fileList.length(); i++){
		// 			fileList.split("@");
		// 			console.log(fileList);
		// 		}

		// 		console.log(file);
	});
</script>
<%@ include file="../include/footer.jsp"%>

