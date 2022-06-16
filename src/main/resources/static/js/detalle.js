$(document).ready(function () {
    listar();
    llenarP();
    llenarC();
});

function llenarP() {
    $.ajax({
        url: "/pro/all",
        type: 'GET',
        success: function (x) {
            for (var i = 0; i < x.length; i++) {
                $("#idproducto").append(
                        "<option value='" + x[i].idproducto + "'> " + x[i].nombre + "</option>");
                $("#editar_idproducto").append(
                        "<option value='" + x[i].idproducto + "'> " + x[i].nombre + "</option>");
            }
        }
    });
function llenarC() {
    $.ajax({
        url: "/cliente/all",
        type: 'GET',
        success: function (x) {

            for (var i = 0; i < x.length; i++) {
                $("#idcliente").append(
                        "<option value='" + x[i].idcliente + "'> " + x[i].nombre + "</option>");
                $("#editar_editorial").append(
                        "<option value='" + x[i].idcliente + "'> " + x[i].nombre + "</option>");
            }
        }
    });

}

function listar() {
    $.ajax({
        url: "/det/all",
        type: 'GET',
        success: function (x) {
            $("#tablita tbody tr").remove();
            for (var i = 0; i < x.length; i++) {
                $("#tablita").append(
                        "<tr><td>" + (i + 1) + "</td><td>" + x[i].iddetalle + "</td><td>" + 
                        x[i].idproducto+ "</td><td>" + 
                        x[i].idcliente + "</td><td>" + 
                        x[i].cantidad + "</td><td>" + 
                        x[i].costounitario + "</td><td>" + 
                        x[i].importe + "</td>\n\
                        <td><a href='#' onclick='editar("
                        + x[i].iddetalle + ")'><i class='fa-solid fa-pen-to-square yelow'></i></a></td><td><a href='#' onclick='eliminar(" + x[i].iddetalle + ")'><i class='fa-solid fa-trash-can red'></i></a></td></tr>");
            }
        }
    });
}
function editar(id) {
    $.ajax({
        url: "/det/" + id,
        type: 'GET',
        success: function (w) {
            $("#editar_idproducto").val(w.idproducto);
            $("#editar_idcliente").val(w.idcliente);
            $("#editar_cantidad").val(w.cantidad);
            $("#editar_costounitario").val(w.costounitario);
            $("#iddetalle").val(w.iddetalle);
        }
    });
    $("#modalEditar").modal('show');
}
function eliminar(id) {
    bootbox.confirm({
        message: "Realmente desea Eliminar?",
        buttons: {
            confirm: {
                label: 'SI',
                className: 'btn-success'
            },
            cancel: {
                label: 'NO',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.ajax({
                    url: "/det/" + id,
                    type: 'DELETE',
                    success: function (w) {
                        bootbox.alert({
                            message: "Registro eliminado correctamente...!",
                            callback: function () {
                                console.log('This was logged in the callback!');
                            }
                        });
                        listar();
                    }
                });
            } else {
                bootbox.alert({
                    message: "Registro no eliminado!",
                    size: 'small'
                });
            }
        }
    });
}
$("#guardar").click(function () {
    var idproducto = $("#idproducto").val();
    var idcliente = $("#idcliente").val();
    var cantidad = $("#cantidad").val();
    var costounitario = $("#costounitario").val();
    var importe = $("#importe").val();
    $.ajax({
        url: "/det/add",
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({'idproducto': idproducto, 'idcliente': idcliente, 'cantidad': cantidad,'costounitario':costounitario, 'importe':importe}),
        cache: false,
        success: function (w) {
            bootbox.alert({
                message: "Registro guardado correctamente...!",
                callback: function () {
                    console.log('This was logged in the callback!');
                }
            });
            limpiar();
            listar();
        }
    });
    $("#modalGuardar").modal('hide');
});
function limpiar() {
    $("#idproducto").val("");
    $("#idcliente").val("");
    $("#cantidad").val("");
    $("#costounitario").val("");
    $("#importe").val("");
}
$("#modificar").click(function () {
    var idproducto = $("#editar_idproducto").val();
    var idcliente = $("#editar_idcliente").val();
    var cantidad = $("#editar_cantidad").val();
    var costounitario = $("#editar_costounitario").val();
    var importe= $("#editar_importe").val();
    var id = $("#iddetalle").val();
    bootbox.confirm({
        message: "Realmente desea Modificar?",
        buttons: {
            confirm: {
                label: 'SI',
                className: 'btn-success'
            },
            cancel: {
                label: 'NO',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.ajax({
                    url: "/det/edit",
                    type: 'PUT',
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify({'iddetalle': id, 'idptoducto':idproducto, 'idcliente':idcliente,'costounitario': costounitario,'importe': importe}),
                    cache: false,
                    success: function (w) {
                        bootbox.alert({
                            message: "Registro Modificado correctamente...!",
                            callback: function () {
                                console.log('This was logged in the callback!');
                            }
                        });
                        limpiar();
                        listar();
                    }
                });
                $("#modalEditar").modal('hide');
            } else {
                bootbox.alert({
                    message: "Registro no Modificado!",
                    size: 'small'
                });
            }
        }
    });
});

