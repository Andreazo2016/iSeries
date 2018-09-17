<form action="updateSerie" method="POST" enctype="multipart/form-data">
		<div class="row">
				
				<input id="id" name="id" type="text" value="${serie.id}" hidden="true"> 
				
				<div class="input-field col s6">
					<i class="material-icons prefix">movie</i>
					<input id="nome" name="nome" type="text" value="${serie.nome}"> 
					<label for="nome" class="center-align">Nome da Serie</label>
				</div>

				<div class="input-field col s3">
					<i class="material-icons prefix">today</i>
					<input id="ano" name="ano" type="text" maxlength="4" value="${serie.ano}"> 
					<label for="ano" class="center-align">Ano de Lan�amento</label>
				</div>
				
				<div class="input-field col s3">
					<select id="genero" name="genero" class="icons">
				      <option value="" disabled selected>Selecione o genero...</option>
				      <option value="Terror" data-icon="/img/generos/terror.jpg" class="circle">Terror</option>
				      <option value="Suspense" data-icon="/img/generos/suspense.png" class="circle">Suspense</option>
				      <option value="Com�dia" data-icon="/img/generos/comedia.jpg" class="circle">Com�dia</option>
				      <option value="A��o" data-icon="/img/generos/acao.jpg" class="circle">A��o</option>
				      <option value="Romance" data-icon="/img/generos/romance.jpg" class="circle">Romance</option>
					</select>
				</div>
				
				<div class="input-field col s6">
					<input id="diretor" name="diretor" type="text" value="${serie.diretor}"> 
					<label	for="diretor" class="center-align">Diretor da Serie</label>
				</div>
				
				<div class="input-field col s6">
					<input id="origem" name="origem" type="text" value="${serie.origem }"> 
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
	       			<textarea id="sinopse" name="sinopse" class="materialize-textarea">${serie.sinopse}</textarea>
	       			<label for="sinopse">Sinopse</label>
	       		</div>
	
				<div class="row">
					<div class="input-field">
						<button class="btn waves-effect waves-light col s12">Register</button>
					</div>
				</div>
		</div>
</form>
