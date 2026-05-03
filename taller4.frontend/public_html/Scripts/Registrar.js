document.getElementById("rol").addEventListener("change", function() {
    var tutorRow = document.getElementById("if_children");
    
    if (this.value === "hijo") {
        tutorRow.style.display = "table-row"; // Muestra la fila como elemento de tabla
    } else {
        tutorRow.style.display = "none";
    }
});

document.getElementById("registerbtn").addEventListener("click", function(event) {
    event.preventDefault();
    window.location.href = "Login.html";
});