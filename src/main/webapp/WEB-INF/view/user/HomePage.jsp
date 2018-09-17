<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Materialize -->
<link href="<c:url value='resources/css/materialize.min.css' />" rel="stylesheet"
	type="text/css" />
<!-- Icones -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!-- CSS -->
<link href="<c:url value='resources/css/estilo.css' />" rel="stylesheet"
	type="text/css" />
<title> Lista de Series</title>
</head>
<body>

	<!-- Header -->
	<!-- -------------------------------------------------------------------------------- -->
	<nav>
		<div class="nav-wrapper">
			<a href="#" class="brand-logo right">
				<img width="50" height="50" src="img/logo.png" alt="logo do site" class="responsive-img">
			</a>
			<ul id="nav-mobile" class="left hide-on-med-and-down">
				<li><a href="#" id="ativa_side_nav" data-activates="slide-out"><i
						class="material-icons">menu</i></a></li>
				<li>
					<c:if test="${usuario.admin == true}">
						<a id="add_series" href="#" >Add Series</a>
						<a id="lista_series" href="#" >Lista de Series</a>
					</c:if>
				</li>
			</ul>
		</div>
	</nav>
	
	<br>
	<div  id="msg" class="container texto-centro">
		<h6 class="msgOK">${msgOk}</h6>
		<h6 class="msgErro">${msgErro}</h6>
	</div>
	<br>
	
	<!-- Menu -->
	<!-- -------------------------------------------------------------------------------- -->
	<ul id="slide-out" class="side-nav">
		<li>
			<div class="userView">
				<div class="background">
					<img  height="500" class="responsive-img" src="<c:url value="/img/cinema.jpg"/>" />
				</div>
			
				<a href="#!user"><img width="120" height="130"  class="circle" src="resources/img/usuarios/${usuario.path}"></a>
				<a href="#!name"><span class="white-text name">${usuario.login}</span></a>
			</div>
		</li>

		<li><div class="divider"></div></li>

		<li><a href="homeUsuario"><i class="material-icons">
					store </i> Home </a></li>
		<c:if test="${usuario.admin == false}">
			<li><a href="myProfile"><i class="material-icons">account_circle</i> My Profile </a></li>
			<li><a href="mySeries"><i class="material-icons"> movie </i> My Series </a></li>
		</c:if>
		
		<c:if test="${usuario.admin == true}">
			<li><a href="listOfUsers"><i class="material-icons">store </i> List Of Users </a></li>
		</c:if>
		
		<li><div class="divider"></div></li>

		<li><a href="about" class="waves-effect"> <i
				class="material-icons"> exit_to_app </i> About Us
		</a></li>

		<li><a href="logout" class="waves-effect"> <i
				class="material-icons"> exit_to_app </i> Exit
		</a></li>
	</ul>
	<!-- -------------------------------------------------------------------------------- -->
		
	<div id="listagem_series_adm" class="row container">
		<c:forEach var="serie" items="${lista_series}">
		<div class="col s3 ">
			<div class="card">
				<div class="card-image">
					<img width="100" height="200" src="resources/img/noticias/${serie.path}"> 
				</div>
				<div class="card-content">
					<span class="card-title">${serie.nome}</span>
					<label>Genero: ${serie.genero}</label> <br> 
					<label>Ano de Lançamento: ${serie.ano}</label>
				</div>
				<div class="card-action">
					<a href="viewSerie?id=${serie.id}">View more</a>
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
	
	<!-- -------------------------------------------------------------------------------- -->
	
	<!-- Formulario Adicionar Serie -->
	<div id="form_add_serie" class="container">
		<jsp:include page="../forms/form_add_serie.jsp" />
	</div>
	
	<jsp:include page="../static/footer.jsp" />
	<!-- -------------------------------------------------------------------------------- -->
	<script type="text/javascript" src="<c:url value="resources/js/jquery.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="resources/js/materialize.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="resources/js/script.js"/>"></script>
	<!-- Controllers -->
	<script type="text/javascript"
		src="<c:url value="resources/js/controllers/materializeController.js"/>"></script>

</body>
</html>