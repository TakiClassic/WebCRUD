var Producto = (function(){
    //todo lo provida
    function getDataForm(){
        
        return {
                name : $('#nombre').val(),
                state: $('#estado').val(),
                price: $('#precio').val(),
                marca: $('#marca').val()
        };
			
    }
    
    //todo lo publico
    return {
        getFormAdd : function(){
            $.ajax({
                method:"POST",
                contentTypes:"application/x-www-form-urlencoded",
                dataType: "html",
                url:"operaciones",
                data:{ACTION:"GET_FORM"},
                beforeSend : function(){
                    $("#divInformacion").html("Procesando...");
                }
            }).done(function(response){
                $("#divInformacion").html(response);
                //$("#saveProducto").bind("click",Producto.saveProducto);
                $("#btnGuardar").bind("click",function(){
                                                    Producto.saveProducto();
                                                });
            });
        },
        saveProducto : function(){
            let objProducto = getDataForm();
            $.post('operaciones'
                    , {ACTION:"ADD_DATA",DATA:JSON.stringify(objProducto)} 
                    , function(responseText) {
                        $('#divInformacion').append('<br/>');
                        $('#divInformacion').append(responseText);
                    });
        }
    }
})();