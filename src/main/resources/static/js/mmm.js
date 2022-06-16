function log(){
    correo= document.getElementById('correo');
    contra = document.getElementById('pass');
    if (contra.value == "1234" & correo.value == "hennessy@gmail.com") {
        alert("Bienvenido a su cuenta");
        
       
    } else {
        alert("Credenciales Incorrectas");
    }
}
