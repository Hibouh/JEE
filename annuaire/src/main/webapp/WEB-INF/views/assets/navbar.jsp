<div class="container">
<div class="navbar navbar-light">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand ${springViewName == 'welcome' ? 'active' : ''}" href="${pageContext.request.contextPath}">Annuaire</a>
    </div>
    <div class="navbar-collapse collapse navbar-responsive-collapse">
      <ul class="nav navbar-nav">
        <li class="${springViewName == '/listGroup' ? 'active' : ''}"><a href="${pageContext.request.contextPath}/listGroup">Groupes</a></li>
        <li class="${springViewName == '/listPerson' ? 'active' : ''}"><a href="${pageContext.request.contextPath}/listPerson">Personnes</a></li>
      </ul>
      <form action="${pageContext.request.contextPath}/person/search" method="POST" class="navbar-form navbar-left">
        <div class="form-group">
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
          <input name="search-value" type="text" class="form-control col-sm-8" placeholder="Rechercher" />
        </div>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a id="ddnavright" href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          	Compte
            <b class="caret"></b>
          </a>
          <ul class="dropdown-menu" aria-labelledby="ddnavright">
            <li class="dropdown-header"><a href="javascript:void(0)">Bonjour <c:out value="${pageContext.request.userPrincipal.name}"/> !</a></li>
            <li class="divider"></li>
            <c:choose>
			  <c:when test="${pageContext.request.userPrincipal.name != null}">
			    </form>
			    <li><a href="${pageContext.request.contextPath}/account/${pageContext.request.userPrincipal.name}">Paramètres</a></li>
           	  	<li><a href ="${pageContext.request.contextPath}/logout" onclick="document.forms['logoutForm'].submit()">Déconnexion</a></li>
			  </c:when>
			  <c:otherwise>
           	  	<li><a href="${pageContext.request.contextPath}/login">Connexion</a></li>
           	  	<li><a href="${pageContext.request.contextPath}/registration">Inscription</a></li>
			  </c:otherwise>
			</c:choose>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</div>