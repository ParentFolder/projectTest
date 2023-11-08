<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ include file="../include/header.jsp"%>
<div class="ent_container">
	<div class="img_container">
		<!-- 			<div class="ent_img"> -->
		<%-- 				<img src="${ent[0].img}"> --%>
		<!-- 			</div> -->
		<c:forEach items="${fileList }" var="img">
					<div>
						<p>${img }</p>
						<img src="<c:url value="${pageContext.request.contextPath }/resources/upload/${img }"/>"/>
						<img src="${pageContext.request.contextPath }/resources/upload/${img }">
						<img src="http://localhost:8088/resources/upload/${img }">
						<img src="<spring:url value='${pageContext.request.contextPath }/resources/upload/${img }'/>">
							
					</div>
		</c:forEach>
	</div>
	<div class="notice_container">
		<p> 공지사항 </p>
		${ent[0].ent_notice}
	</div>
	<div id="map" style="width: 500px; height: 400px;"></div>
	<div class="menu_container">
		<table>
			<c:forEach items="${plist }" var="prod">
				<tr class="prod_name">
					<td> 제품명 </td>
					<td>${prod.prod_name }</td>
				</tr>
				<tr class="prod_content">
					<td> 제품 설명 </td>
					<td>${prod.prod_content }</td>
				</tr>
			</c:forEach>
		</table>
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

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a41c6623d85b187520b3d92f4b708850&libraries=services"></script>
​
<script type="text/javascript">
	
	var container = document.getElementById('map'), //지도를 담을 영역의 DOM 레퍼런스
		options = { //지도를 생성할 때 필요한 기본 옵션
		center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
		level: 3 //지도의 레벨(확대, 축소 정도)
	};

	var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();

	// 주소로 좌표를 검색합니다
// 	geocoder.addressSearch(${ent[0].ent_addr}, function(result, status) {
	geocoder.addressSearch('부산시 영도구 영선대로 34', function(result, status) {

		// 정상적으로 검색이 완료됐으면 
		if (status === kakao.maps.services.Status.OK) {

		var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

		// 결과값으로 받은 위치를 마커로 표시합니다
		var marker = new kakao.maps.Marker({
			map: map,
		    position: coords
		});

		// 인포윈도우로 장소에 대한 설명을 표시합니다
		var infowindow = new kakao.maps.InfoWindow({
// 			content: '<div style="width:150px;text-align:center;padding:6px 0;">${ent[0].ent_name}</div>'
			content: '<div style="width:150px;text-align:center;padding:6px 0;">검색한 위치</div>'
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

