$("#form-user-edicao-my-profile").hide();

$("#editprofile").click(function() {
	$("#form-user-edicao-my-profile").show(1000);
	$("#dados_user_profile").hide(1000);
});

$("#back").click(function() {
	$("#form-user-edicao-my-profile").hide(1000);
	$("#dados_user_profile").show(1000);
});

