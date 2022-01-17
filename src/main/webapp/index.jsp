<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Productos</title>
<script src="http://code.jquery.com/jquery-latest.js">

</script>
<script>
	$(document).ready(function() {
		$('#submit').click(function(event) {
			var nombreVar = $('#nombre').val();
			var estadoVar = $('#estado').val();
			var precioVar = $('#precio').val();
			var marcaVar = $('#marca').val();
			// Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
			$.post('ActionServlet', {
				nombre : nombreVar,
				apellido: estadoVar,
				edad: precioVar,
                                marca: marcaVar
			}, function(responseText) {
				$('#tabla').html(responseText);
			});
		});
	});
</script>
</head>
<body>
	<h2>Productos</h2>
	<form id="form1">
		Nombre:<input type="text" id="nombre" /> <br>
		Estado <input type="text" id="estado" /> <br>
		Precio: <input type="text" id="precio" /> <br>
		Marca: <input type="text" id="marca" /> <br>
		<input type="button" id="submit" value="Añadir" /> 
	</form>
	<br>
	<!-- 	En este div metemos el contenido de la tabla con AJAX -->
	<div id="tabla"></div>
</body>
</html>