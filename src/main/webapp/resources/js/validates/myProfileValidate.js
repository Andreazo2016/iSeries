$(document).keyup(function(e) {

	if(!($("#login").val() === "" && $("#senha").val() === "")){
		$("#button-add-user").removeAttr('disabled');
	}else{
		$("#button-add-user").attr('disabled', 'disabled');
	}
});

