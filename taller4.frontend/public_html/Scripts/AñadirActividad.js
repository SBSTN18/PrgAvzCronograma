document.getElementById("añadir").addEventListener("click", function() {
    window.location.href = "AñadirActividad.html";
});

document.getElementById("Consultar").addEventListener("click", function() {
    window.location.href = "Principal.html";
});

document.getElementById("ajustes").addEventListener("click", function() {
    window.location.href = "Ajustes.html";
});

document.getElementById("cancelar").addEventListener("click", function() {
    window.location.href = "Principal.html";
});

document.getElementById("guardar").addEventListener("click", function() {

    // 1. Leemos los valores del formulario
    const titulo           = document.getElementById("titulo").value.trim();
    const descripcion      = document.getElementById("descripcion").value.trim();
    const tipoActividad    = document.getElementById("tipoActividad").value;
    const fechaInicio      = document.getElementById("fechaInicio").value;
    const fechaTerminacion = document.getElementById("fechaTerminacion").value;
    const idQuehacer       = document.getElementById("idQuehacer").value.trim();
    const idTutor          = document.getElementById("idTutor").value.trim();
    const idHijo           = document.getElementById("idHijo").value.trim();

    // 2. Validación — todos los campos son obligatorios
    if (!titulo || !descripcion || !tipoActividad || !fechaInicio || !fechaTerminacion || !idQuehacer || !idTutor || !idHijo) {
        mostrarMensaje("Por favor completa todos los campos.", "error");
        return;
    }

    // 3. Validación de fechas
    if (fechaTerminacion < fechaInicio) {
        mostrarMensaje("La fecha de terminación no puede ser anterior a la de inicio.", "error");
        return;
    }

    // 4. Confirmación visual de éxito
    mostrarMensaje("¡Actividad creada correctamente!", "exito");

    // 5. Limpiamos el formulario
    document.getElementById("create-activity-form").reset();

    // 6. Volvemos al calendario después de 2 segundos
    setTimeout(function() {
        window.location.href = "Principal.html";
    }, 2000);
});

/**
 * Muestra un mensaje visual en la página.
 * @param {string} texto - El mensaje a mostrar
 * @param {string} tipo - "error" o "exito"
 */
function mostrarMensaje(texto, tipo) {
    const mensaje = document.getElementById("mensaje-resultado");
    mensaje.textContent = texto;
    mensaje.style.display = "block";
    mensaje.style.color = tipo === "error" ? "#ff6b6b" : "#a6e3a1";
}