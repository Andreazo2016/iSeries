
//Animação Index
//***************************************************************************//
$('#sign').hide(); // Formulário de Cadastro

$('#sign-up').click(()=>{
	$('#sign').toggle(1000);
	$('#login').toggle(1000);
});

$('#loginActive').click(()=>{
	$('#sign').toggle(1000);
	$('#login').toggle(1000);
});

$("#msg").fadeOut(3000);

//Tela de Listar Series
//***************************************************************************//
$('#form_add_serie').hide(); // Ocultando formulario de add Serie
$("#lista_series").hide(); // Ocultando lista de Series

$("#add_series").click(()=>{	
	$('#form_add_serie').toggle();
	$('#listagem_series_adm').toggle();	
	$("#add_series").toggle();
	$("#lista_series").toggle();
});

$("#lista_series").click(()=>{	
	$('#form_add_serie').toggle();
	$('#listagem_series_adm').toggle();	
	$("#add_series").toggle();
	$("#lista_series").toggle();
});

//***************************************************************************//

//	Cick
//	Oculta os dados da Serie
//	Mostrar o Formulario p/ Edição da Serie

$("#form_update_serie").hide(); // Ocultando Formulario de Editar Serie
$("#button_edit").click(()=>{
	$("#form_update_serie").toggle(1000);
	$("#dados_serie").hide(1000); // Ocultando os Dados da Serie
});

//	Click
//	Oculta o Formulario de Editar Serie
//	Mostra Dados da Serie 
$("#dados_serie2").click(()=>{
	$("#form_update_serie").toggle(1000);
	$("#dados_serie").toggle(1000);
});

//***************************************************************************//

//	Ocultando o Formulário de add Temporada
$("#form-add-temporada").hide();
$("#ocultar-form-add-temporada").hide();

$("#ativar-form-add-temporada").click(()=>{
	$("#form-add-temporada").toggle(1000); //Mostrando 
	$("#ocultar-form-add-temporada").show();
	
	$("#ativar-form-add-temporada").hide(); // THIS
})

$("#ocultar-form-add-temporada").click(()=>{
	$("#form-add-temporada").toggle(1000); // Ocultando
	$("#ativar-form-add-temporada").show();
	
	$("#ocultar-form-add-temporada").hide(); // THIS
})










