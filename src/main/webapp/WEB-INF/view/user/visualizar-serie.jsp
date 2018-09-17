<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Materialize -->
<link href="<c:url value='resources/css/materialize.min.css' />"
	rel="stylesheet" type="text/css" />
<!-- Icones -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!-- CSS -->
<link href="<c:url value='resources/css/estilo.css' />" rel="stylesheet"
	type="text/css" />
<title>${serie.nome}</title>
</head>
<body>

	<!-- Cabeçario -->
	<!-- -------------------------------------------------------------------------------- -->
	<nav>
		<div class="nav-wrapper">
			<a href="#" class="brand-logo right"> <img width="50" height="50"
				src="img/logo.png" alt="logo do site" class="responsive-img">
			</a>
			<ul id="nav-mobile" class="left hide-on-med-and-down">
				<li><a href="#" id="ativa_side_nav" data-activates="slide-out"><i
						class="material-icons">menu</i></a></li>
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

	<!-- Serie -->
	<!-- -------------------------------------------------------------------------------- -->
	<div id="dados_serie" class="container">

		<div class="row">

			<div class="col s4">
				<figure class="branco xfigure">
					<img width="200" height="250" src="resources/img/noticias/${serie.path}">
				</figure>
			</div>

			<div class="col s8 sinopse">
				<p>${serie.sinopse}</p>
			</div>

			<br>
			<hr>
			<br>

			<div class="col s4  informacoes">
				<div class="container cinza">
					<h5 style="text-align: center;">Informações</h5>
					<h6>
						Título Original: <label>${serie.nome}</label>
					</h6>
					<h6>
						Diretor: <label>${serie.diretor}</label>
					</h6>
					<h6>
						Gênero: <label>${serie.genero}</label>
					</h6>
					<h6>
						Ano de Lançamento: <label>${serie.ano}</label>
					</h6>
					<h6>
						Origem: <label>${serie.origem}</label>
					</h6>

					<a href="homeUsuario" class="waves-effect waves-teal btn-flat left">
						<i class="material-icons">reply</i>
					</a>

					<c:choose>
						<c:when test="${usuario.admin == true}">
							<a id="button_edit"
								class="waves-effect waves-teal btn-flat right"> <i
								class="material-icons"> edit </i>
							</a>
						</c:when>
						<c:otherwise>
							<a id="button_add"
								href="addInMyList?idUser=${usuario.id}&idSerie=${serie.id}"
								class="waves-effect waves-teal btn-flat right"> <i
								class="material-icons"> add </i>
							</a>
						</c:otherwise>
					</c:choose>

				</div>
			</div>

			<!-- 		Lista de Temporadas 		-->
			<div class="col s8">
				<c:if test="${usuario.admin == true}">
					<div id="form-add-temporada">
						<jsp:include page="../forms/form_add_temporada.jsp" />
					</div>
				</c:if>
				<table>
					<thead>
						<tr>
							<th>Nome/Número</th>
							<th>Duração</th>
							<th></th>
							<th></th>
							<c:if test="${usuario.admin == true}">
								<th id="ativar-form-add-temporada"><a href="#"> <i
										class="material-icons">add</i>
								</a></th>
								<th id="ocultar-form-add-temporada"><a href="#"> <i
										class="material-icons">keyboard_arrow_up</i>
								</a></th>
							</c:if>

						</tr>
					</thead>

					<tbody>
						<c:forEach var="t" items="${temporadas}">
							<tr>
								<td>${t.numero}</td>
								<td>${t.duracao}</td>
								<c:if test="${usuario.admin == true}">
									<td>
										<h6 class="center">
											<a href="#" id="addEpisodio"> <i class="material-icons">add</i>
											</a>
										</h6>
									</td>
									<td>
										<h6 class="center">
											<a href="#" id="editTemporada"> <i class="material-icons">edit</i>
											</a>
										</h6>
									</td>
									<td>
										<h6 class="center">
											<a href="deleteTemp?id_tmp=${t.id}&id_serie=${serie.id}">
												<i class="material-icons">delete</i>
											</a>
										</h6>
									</td>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>
	</div>

	<!-- Comentários -->
	<!-- -------------------------------------------------------------------------------- -->
	<c:if test="${usuario.admin == false }">
	<div class="container">
		<hr>
		<h5 class="texto-centro">Comentários</h5>
		<hr>
		
		<div id="comentarios" align="left"	style="height: 250px; overflow: scroll;">
			
			<c:forEach var="comentario" items="${serie.comentarios}">
				<blockquote	style="margin: 20px 0; padding-left: 1.5rem; border-left: 5px solid #4a148c;">
					<h6>${comentario.texto}</h6>
					<p>${comentario.usuario.login} [<fmt:formatDate value="${comentario.data.time}" type="date" dateStyle="short" />]</p>
					<c:if test="${usuario.id == comentario.id_usuario }">
					<a id="deleteComentario" href="deletarComentario?id=${comentario.id}"><i class="material-icons">remove_circle_outline</i></a>
					</c:if><hr>
				</blockquote>
			</c:forEach>
			<a href="#" id="end"></a>
			
		</div>
		
		<div class="container">
			<c:if test="${not empty usuario }">
					<div id="registrarComentario">
						<input type="hidden" id="serie" name="serie" value="${serie.id}" />
						<input type="hidden" id="user" name="user" value="${usuario.id}" />
						<div class="input-field col m8">
						<i class="material-icons prefix">comment</i>
						<input type="text" id="texto"/>
						<label for="icon_telephone">Seu comentário</label>
						</div>
						<button class="btn" id="comentar">Enviar</button>
					</div>
			</c:if>
		</div>

	</div>
	<br><br><br><br>
	</c:if>
	
	<!-- -------------------------------------------------------------------------------- -->

	<!-- Formulários -->
	<!-- -------------------------------------------------------------------------------- -->
	<c:if test="${usuario.admin == true}">
		<div id="form_update_serie" class="container">

			<div>
				<h6 id="dados_serie2" class="center">
					<a href="#"> <i class="material-icons">keyboard_arrow_down</i>
					</a>
				</h6>
			</div>

			<jsp:include page="../forms/form_update_serie.jsp" />

		</div>
	</c:if>
	
	<jsp:include page="../static/footer.jsp" />
	<!-- -------------------------------------------------------------------------------- -->

	<script type="text/javascript"
		src="<c:url value="resources/js/jquery.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="resources/js/materialize.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="resources/js/script.js"/>"></script>
	<!-- Controllers -->
	<script type="text/javascript"
		src="<c:url value="resources/js/controllers/materializeController.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="resources/js/controllers/comentarioController.js"/>"></script>

</body>
</html>