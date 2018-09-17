//	Se Click Button Comentar
//	Verifico se o Texto esta Vazio
//	Caso não
//		>Chamar Função Comentar Passando os Paramentros
$(function(){
	$("#comentar").click(function(){
		if($("#texto").val() === ""){
			alert("Insera algum texto no comentário!");
		}else{
			comentar($("#user").val(),$("#serie").val(),$("#texto").val());
		}
	});
	
	$("#deleteComentario").click(function(){
		if(confirm("Tem certeza desta ação ?!")){
			return true;
		}else{
			return false;
		}
	});
	
});

//Função para Comentar com AJAX
function comentar(user,serie,texto){
	console.log(user +" "+  serie)
	$.ajax({
        url:"/adicionarComentario", //	@RequestMapping("/adicionarComentario")
        type:"GET",
        data: "user="+user+"&serie="+serie+"&texto="+texto,
        success: function(data){	// Recebo os Dados
        	data  = JSON.parse(data); // Transformo em JSON
            mostrarComentario(data); // Chamo a Função Mostrar Comentário
        }
	});
}

// Função para Mostrar Comentario
function mostrarComentario(comentario){
	$("#texto").val(""); // Limpando o Campo Texto
	
	var date = new Date(comentario.data)
	
	$("div[id=comentarios]").append("<blockquote style=\" margin: 20px 0; padding-left: 1.5rem; border-left: 5px solid #4a148c;\">" +
			"<h6>"+comentario.texto + "</h6>"+
			"<p>"+comentario.autor+", "+date.getDate()+"/"+(date.getMonth()+1)+"/"+(date.getYear()-100)+"</p>" +
			"<c:if test=" + "${usuario.id == comentario.id_usuario }>" +
			"</c:if>" + "<hr>" +
			"</blockquote>");
	
	window.location.href='#end';
}






