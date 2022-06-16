$(document).ready(function () {
    listar();
});
function listar() {
    $.get("pc", {"opc": 1}, function (data) {
        var x = JSON.parse(data);
        $("#tablita tbody tr").remove();
        for (var i = 0; i < x.length; i++) {
            $("#tablita").append(
                    "<tr><td>" + (i + 1) + "</td><td>"
                    + x[i].idalumno + "</td><td>"
                    + x[i].nombres + "</td><td>"
                    + x[i].dni + "</td><td>"
                    + x[i].telefono + "</td><td>"
                    + x[i].direccion + "</td><td>\n\
<a href='#' onclick='editar(" + x[i].idalumno + ")' class='text-warning'>\n\
<i class='fa-solid fa-pen-to-square yelow'></i>\n\
</a></td><td><a href='#' onclick='eliminar(" + x[i].idalumno + ")' class='text-danger'>\n\
<i class='fa-solid fa-trash-can red'></i></a></td></tr>");
        }
    });
}

$("#guardar").click(function () {
    var nombres = $("#nombres").val();
    var dni = $("#dni").val();
    var telefono = $("#telefono").val();
    var direccion = $("#direccion").val();
    $.post("pc", {"nombres": nombres, "dni": dni,"telefono":telefono,"direccion":direccion, "opc": 2}, function () {
        bootbox.alert({
            message: "Registro guardado correctamente...!",
            callback: function () {
                console.log('This was logged in the callback!');
            }
        });
        listar();
    });
    $("#modalGuardar").modal('hide');
});
function editar(id) {
    $.get("pc", {"id": id, "opc": 4}, function (data) {
        var w = JSON.parse(data);
        $("#editar_nombres").val(w.nombres);
        $("#editar_dni").val(w.dni);
        $("#editar_telefono").val(w.telefono);
        $("#editar_direccion").val(w.direccion);
        $("#idalumno").val(w.idalumno);
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
                $.get("pc", {"id": id, "opc": 3}, function () {
                    bootbox.alert({
                        message: "Registro eliminado correctamente...!",
                        callback: function () {
                            console.log('This was logged in the callback!');
                        }
                    });
                    listar();
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
$("#modificar").click(function () {
    var nombres = $("#editar_nombres").val();
    var dni = $("#editar_dni").val();
    var telefono = $("#editar_telefono").val();
    var direccion = $("#editar_direccion").val();
    var id = $("#idalumno").val();
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
                $.get("pc", {"id": id, "nombres": nombres, "dni": dni,"telefono": telefono,"direccion": direccion, "opc": 5}, function () {
                    bootbox.alert({
                        message: "Registro Modificado correctamente...!",
                        callback: function () {
                            console.log('This was logged in the callback!');
                        }
                    });
                    listar();
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
