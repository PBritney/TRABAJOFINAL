$(document).ready(function () {
    listar();

});
function listar() {
    $.ajax({
        url: "/empleado/all",
        type: 'GET',
        success: function (x) {
            $("#tablita tbody tr").remove();
            for (var i = 0; i < x.length; i++) {
                $("#tablita").append(
                        "<tr><td>" + (i + 1) + "</td><td>" + x[i].idempleado + "</td><td>" + x[i].nombres
                        + "</td><td>" + x[i].dni + "</td><td>" + x[i].sueldo + "</td><td>" + x[i].cargo + "</td><td>" + x[i].telefono + "</td><td>" + x[i].direccion + "</td><td><a href='#' onclick='editar("
                        + x[i].idempleado + ")'><i class='fa-solid fa-pen-to-square yelow'></i></a></td><td><a href='#' onclick='eliminar(" + x[i].idempleado + ")'><i class='fa-solid fa-trash-can red'></i></a></td></tr>");
            }
        }
    });
}
function editar(id) {
    $.ajax({
        url: "/empleado/" + id,
        type: 'GET',
        success: function (w) {
            $("#editar_nombres").val(w.nombres);
            $("#editar_dni").val(w.dni);
            $("#editar_sueldo").val(w.sueldo);
            $("#editar_cargo").val(w.cargo);
            $("#editar_telefono").val(w.telefono);
            $("#editar_direccion").val(w.direccion);
            $("#idempleado").val(w.idempleado);
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
                    url: "/empleado/" + id,
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
    var nombres = $("#nombres").val();
    var dni = $("#dni").val();
    var sueldo = $("#sueldo").val();
    var cargo = $("#cargo").val();
    var telefono = $("#telefono").val();
    var direccion = $("#direccion").val();
    $.ajax({
        url: "/empleado/add",
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({'nombres': nombres, 'dni': dni, 'sueldo': sueldo, 'cargo': cargo, 'telefono': telefono, 'direccion': direccion}),
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
    $("#nombres").val("");
    $("#dni").val("");
    $("#sueldo").val("");
    $("#cargo").val("");
    $("#telefono").val("");
    $("#direccion").val("");


}
$("#modificar").click(function () {
    var nombres = $("#editar_nombres").val();
    var dni = $("#editar_dni").val();
    var sueldo = $("#editar_sueldo").val();
    var cargo = $("#editar_cargo").val();
    var telefono = $("#editar_telefono").val();
    var direccion = $("#editar_direccion").val();
    var id = $("#idempleado").val();
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
                    url: "/empleado/edit",
                    type: 'PUT',
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify({'idempleado': id, 'nombres': nombres, 'dni': dni, 'sueldo': sueldo, 'cargo': cargo, 'telefono': telefono, 'direccion': direccion}),
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