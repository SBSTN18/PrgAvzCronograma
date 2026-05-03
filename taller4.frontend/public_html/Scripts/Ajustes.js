document.getElementById("rol").addEventListener("change", function() {
    var tutorRow = document.getElementById("if_children");
    
    if (this.value === "hijo") {
        tutorRow.style.display = "block";
    } else {
        tutorRow.style.display = "none";
    }
});

document.getElementById("back").addEventListener("click", function() {
    window.history.back();
});

document.getElementById("cancelar").addEventListener("click", function() {
    window.history.back();
});

document.getElementById("añadir").addEventListener("click", function() {
    window.location.href = "AñadirActividad.html";
});

document.getElementById("Consultar").addEventListener("click", function() {
    window.location.href = "Principal.html";
});

document.getElementById("ajustes").addEventListener("click", function() {
    window.location.href = "Ajustes.html";
});