$(document).keyup(function(e) {

	if(!($("#login").val() === "" && $("#senha").val() === "")){
		$("#button-login").removeAttr('disabled');
	}else{
		$("#button-login").attr('disabled', 'disabled');
	}
});

