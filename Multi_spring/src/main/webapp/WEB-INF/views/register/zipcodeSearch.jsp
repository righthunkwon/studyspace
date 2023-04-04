<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	header, footer {
		display:none;
	}
	#zipcodeList>li:hover {
		cursor:pointer;
		background-color:lightgray;
	}
</style>
<script>
	$(function(){
		// 사용할 주소를 클릭하면 메인페이지에 표시하기
		$(document).on('click','#zipcodeList>li', function() {
			var address = $(this).text();
			var zip = address.substring(0, 5);
			var addr = address.substring(6);
			opener.document.getElementById("zipcode").value = zip;
			opener.document.getElementById("addr").value = addr;
			window.close(); // self.close();
		});
	});
</script>
<div class="container">
	<div>
		도로명 주소를 입력 후 우편번호를 검색하세요.<br/>
		(예:삼성로1길)<br/>
		<form method="get" action="zipcodeSearch" id="zipSearchForm">
			도로명주소 : <input type="text" name="doroname" id="doroname"/>
			<input type="submit" value="검색"/>
		</form>	
	</div>
	<hr/>
	<div>
		<ul id="zipcodeList">
			<!-- 검색 데이터가 있을 때 -->
			<c:if test="${zipList!=null}">
				<c:forEach var="zipDTO" items="${zipList}">
					<li>${zipDTO.zipcode} ${zipDTO.sido} ${zipDTO.doroname} ${zipDTO.bungi1}<c:if test="${zipDTO.bungi2>0}">-${zipDTO.bungi2}</c:if> (${zipDTO.dong}<c:if test="${zipDTO.buildname!=null}">, ${zipDTO.buildname}</c:if>)</li>
				</c:forEach>				
			</c:if>
			
			<!-- 검색 데이터가 없을 때 -->
			<c:if test="${zipList==null}">
				<li>
					검색한 주소가 없습니다.
				</li>
			</c:if>
		</ul>
	</div>
</div>