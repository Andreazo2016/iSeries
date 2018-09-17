<form action="cadastraTemporada" method="POST" enctype="multipart/form-data">
<div class="row">

		<input id="serie" name="serie"  value="${serie.id}" hidden="true">
		
		<div class="input-field col s5">
			<i class="material-icons prefix"></i>
			<input id="numero" name="numero" type="text"> 
			<label for="numero" class="center-align">Nome/Número</label>
		</div>
		
		<div class="input-field col s5">
			<i class="material-icons prefix"></i>
			<input id="duracao" name="duracao" type="text"> 
			<label	for="duracao" class="center-align">T. duração..</label>
		</div>
		
		<div class="input-field">
			<button class="btn-floating green">
				<i class="material-icons">add</i>
			</button>
		</div>

	</div>
</form>
