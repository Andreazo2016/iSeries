$(document).keyup(function(e) {

	if(!($("#senha1").val() === "" && $("#senha2").val() === "")){
		if($("#senha1").val() === $("#senha2").val()){
			$("#button-add-user").removeAttr('disabled');
		}else{
			$("#button-add-user").attr('disabled', 'disabled');
		}
	}
});

$("#button-add-user").click(function() {
	if($("#login1").val() === ""){
		alert("login esta vazio")
		return false;
	}
});