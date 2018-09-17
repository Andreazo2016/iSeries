<form action="cadastraSerie" method="POST" enctype="multipart/form-data">
<div class="row">
		<div class="input-field col s6">
			<i class="material-icons prefix">movie</i>
			<input id="nome" name="nome" type="text"> 
			<label	for="nome" class="center-align">Nome da Serie</label>
		</div>

		<div class="input-field col s3">
			<i class="material-icons prefix">today</i>
			<input id="ano" name="ano" type="text" maxlength="4"> 
			<label for="ano" class="center-align">Ano de Lançamento</label>
		</div>
				
		<div class="input-field col s3">
		    <select id="genero" name="genero" class="icons">
		      <option value="" disabled selected>Escolha um genero</option>
		      <option value="Terror" data-icon="/img/generos/terror.jpg" class="circle">Terror</option>
		      <option value="Suspense" data-icon="/img/generos/suspense.png" class="circle">Suspense</option>
		      <option value="Comédia" data-icon="/img/generos/comedia.jpg" class="circle">Comédia</option>
		      <option value="Ação" data-icon="/img/generos/acao.jpg" class="circle">Ação</option>
		      <option value="Romance" data-icon="/img/generos/romance.jpg" class="circle">Romance</option>
			 </select>
		</div>
				
		<div class="input-field col s6">
			<input id="diretor" name="diretor" type="text"> 
			<label	for="diretor" class="center-align">Diretor da Serie</label>
		</div>
		
		<div class="input-field col s6">
			<input id="origem" name="origem" type="text"> 
			<label	for="origem" class="center-align">Origem</label>
		</div>
				
		<div  class="input-field col s12">
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

		<div class="input-field col s12">
			<i class="material-icons prefix">description</i>
			<textarea id="sinopse" name="sinopse" class="materialize-textarea"></textarea>
			<label for="sinopse">Sinopse</label>
		</div>
	
		<div class="row">
			<div class="input-field">
				<button class="btn waves-effect waves-light col s12">Register</button>
			</div>
		</div>
</div>
</form>
