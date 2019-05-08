<%@ include file="/WEB-INF/views/assets/header.jsp"%>
<%@ include file="/WEB-INF/views/assets/navbar.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:choose>
	<c:when
		test="${pageContext.request.userPrincipal.name} == ${pageContext.request.userPrincipal.name}}">
		<form:form method="POST" modelAttribute="userForm" class="form-signin">
			<h2 class="form-signin-heading">Create your account</h2>
			<spring:bind path="username">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="username" class="form-control"
						placeholder="Username" autofocus="true"></form:input>
					<form:errors path="username"></form:errors>
				</div>
			</spring:bind>
			<spring:bind path="firstName">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:label path="firstName" class="control-label">First Name</form:label>
					<form:input type="firstName" path="firstName" class="form-control"
						placeholder="First Name"></form:input>
					<form:errors path="firstName"></form:errors>
				</div>
			</spring:bind>
			<spring:bind path="lastName">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:label path="lastName" class="control-label">Last Name</form:label>
					<form:input type="lastName" path="lastName" class="form-control"
						placeholder="last Name"></form:input>
					<form:errors path="lastName"></form:errors>
				</div>
			</spring:bind>
			<spring:bind path="mail">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:label path="mail" class="control-label">mail</form:label>
					<form:input type="mail" path="mail" class="form-control"
						placeholder="Mail"></form:input>
					<form:errors path="mail"></form:errors>
				</div>
			</spring:bind>
			<spring:bind path="site">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:label path="site" class="control-label">Site Web</form:label>
					<form:input type="site" path="site" class="form-control"
						placeholder="Site"></form:input>
					<form:errors path="site"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="birthday">
				<div
					class="form-group ${status.error ? 'has-error' : ''} label-floating">
					<form:label path="birthday" class="control-label">Birthday</form:label>
					<form:input type="date" path="birthday"
						class="form-control datetimepicker"></form:input>
					<form:errors path="birthday"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="role">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:label path="role" class="control-label">role</form:label>
					<form:select type="role" path="role" class="form-control">
						<c:forEach var="listGroup" items="${listGroup}">
							<option value=${listGroup.getName() }>${listGroup.getName() }</option>
						</c:forEach>
					</form:select>
					<form:errors path="role"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="password">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:label path="password" class="control-label">Password</form:label>
					<form:input type="password" path="password" class="form-control"
						placeholder="Password"></form:input>
					<form:errors path="password"></form:errors>
				</div>
			</spring:bind>
			<spring:bind path="passwordConfirm">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:label path="passwordConfirm" class="control-label">Confirm Password</form:label>
					<form:input type="password" path="passwordConfirm"
						class="form-control" placeholder="Confirm your password"></form:input>
					<form:errors path="passwordConfirm"></form:errors>
				</div>
			</spring:bind>

			<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
		</form:form>
	</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
<%@ include file="/WEB-INF/views/assets/footer.jsp"%>