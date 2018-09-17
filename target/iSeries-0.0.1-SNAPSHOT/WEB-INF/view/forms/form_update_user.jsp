<form action="updateUsuario" method="POST" class="container" enctype="multipart/form-data">

	<p style="text-align: center">
		<img src="img/logo.png" alt="" class="responsive-img">
	</p>
	
	<input name="id" value="${usuario.id}" hidden="true" >
	
	<i class="material-icons">account_circle</i>
	<div class="input-field">
		<input id="login1" name="login" type="text" class="validate" value="${usuario.login}"/> 
		<label for="login1" class="center-align">Username</label>
	</div>

	<i class="material-icons">email</i>
	<div class="input-field">
		<input id="email1" name="email" type="email" class="validate" value="${usuario.email}"/> 
		<label	for="email1" class="center-align">Email</label>
	</div>

	<i class="material-icons">lock_outline</i>
	<div class="input-field">
		<input id="senha" name="senha" type="password" class="validate" value="${usuario.senha}" maxlength="10"> 
		<label	for="senha" class="center-align">Password</label>
	</div>

	<label>Insira uma foto de Perfil</label>
	<div  class="input-field">
		<i class="tiny material-icons prefix">insert_photo</i>
		<div class="file-field input-field">
		   	<div>
	       		<input name="imagem" type="file">
			</div>
			<div class="file-path-wrapper">
	       		<input class="file-path validate" type="text">
		   	</div>
	   	</div>
	</div>
	
	<div class="row">
		<div class="col s6">
			<div class="input-field">
				<button id="button-add-user" class="btn waves-effect waves-light" disabled="disabled">Register</button>
			</div>
		</div>

		<div class="col s6">
			<a href="#" id="loginActive" class="right">Login!</a> <br>
		</div>
	</div>
	
</form>