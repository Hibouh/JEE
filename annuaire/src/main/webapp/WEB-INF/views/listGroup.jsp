<%@ include file="/WEB-INF/views/assets/header.jsp"%>
<%@ include file="/WEB-INF/views/assets/navbar.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<table style="width: 100%">
	<thead>
		<tr>
			<th>id</th>
			<th>Name</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="listGroup" items="${listGroup}">
			<tr>
				<td>${listGroup.getId() }</td>
				<td>${listGroup.getName() }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="/WEB-INF/views/assets/footer.jsp"%>