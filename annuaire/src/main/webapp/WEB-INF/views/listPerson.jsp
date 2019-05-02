<%@ include file="/WEB-INF/views/assets/header.jsp"%>
<%@ include file="/WEB-INF/views/assets/navbar.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

		<table style ="width:100%">
			<thead>
				<tr>
					<th>id</th>
					<th>Username</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Mail</th>
					<th>Site Web</th>
					<th>Birthday</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="listPerson" items="${listPerson}">
					<tr>
						<td>${listPerson.getId() }</td>
						<td>${listPerson.getUsername() }</td>
						<td>${listPerson.getFirstName() }</td>
						<td>${listPerson.getLastName() }</td>
						<td>${listPerson.getMail() }</td>
						<td>${listPerson.getSite() }</td>
						<td>${listPerson.getBirthday() }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

<%@ include file="/WEB-INF/views/assets/footer.jsp"%>