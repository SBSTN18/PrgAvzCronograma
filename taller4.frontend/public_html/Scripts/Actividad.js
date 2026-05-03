document.getElementById('back').addEventListener('click', function() {
    history.back();
});

document.getElementById("eliminar").addEventListener("click", function() {
    document.getElementById("confirmar-eliminacion").style.display = "block"; 
    document.getElementById("editar-actividad").style.display = "none";
});

document.getElementById("cancelar-eliminacion").addEventListener("click", function() {
    document.getElementById("confirmar-eliminacion").style.display = "none"; 
    document.getElementById("editar-actividad").style.display = "block";
});

document.getElementById("confirmar-eliminar").addEventListener("click", function() {
    history.back();
});