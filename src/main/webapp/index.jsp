<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Productos</title>
</head>
<body>
    <label id="labelMostrarForm"><a href="#">Nuevo Producto</a></label><br/>
    
    <label id="labelMostrarListado"><a href="#">Lista Productos</a></label><br/>
    <div id="divInformacion"></div>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="vista/js/Producto.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
            $("#labelMostrarForm").bind("click",function(){
                Producto.getFormAdd();
            });
		/**/
	});
</script>
</html>