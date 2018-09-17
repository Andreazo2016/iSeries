<form action="efeturarLogin" method="POST">
	<div>
		<p style="text-align: center">
			<img src="img/logo.png" alt="" class="responsive-img">
		</p>
	</div>
	<div class="container">
		<div>
			<i class="material-icons">perm_identity</i>
		</div>
		<div class="input-field">
			<input id="login" name="login" type="text"> <label
				for="login" class="center-align">Username</label>
		</div>

		<div>
			<i class="material-icons">lock_outline</i>
		</div>
		<div class="input-field">
			<input id="senha" name="senha" type="password"> <label
				for="senha" class="center-align">Password</label>
		</div>

		<div class="row">
			<div class="col s6">
				<div class="input-field">
					<button id="button-login" class="btn waves-effect waves-light" disabled="disabled">Login</button>
				</div>
			</div>
			<div class="col s6">
				<a href="#" id="sign-up" class="right">Sign Up!</a> <br>
			</div>
		</div>

	</div>
</form>
