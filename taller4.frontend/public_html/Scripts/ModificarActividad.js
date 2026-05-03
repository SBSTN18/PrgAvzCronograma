const actividades = [
    { id: 1, titulo: "Limpiar la sala",      descripcion: "Barrer y trapear la sala principal",             tipoActividad: "Quehaceres y orden", fechaInicio: "2026-05-01", fechaTerminacion: "2026-05-03", idQuehacer: 1, idTutor: 1, idHijo: 1 },
    { id: 2, titulo: "Lavar los platos",     descripcion: "Lavar y secar todos los platos del almuerzo",    tipoActividad: "Cocina y alimentos", fechaInicio: "2026-05-05", fechaTerminacion: "2026-05-05", idQuehacer: 1, idTutor: 1, idHijo: 2 },
    { id: 3, titulo: "Tender la cama",       descripcion: "Tender la cama cada mañana antes del desayuno",  tipoActividad: "Quehaceres y orden", fechaInicio: "2026-05-10", fechaTerminacion: "2026-05-15", idQuehacer: 2, idTutor: 1, idHijo: 1 },
    { id: 4, titulo: "Sacar la basura",      descripcion: "Llevar las bolsas de basura al contenedor",      tipoActividad: "Limpieza profunda",  fechaInicio: "2026-05-12", fechaTerminacion: "2026-05-12", idQuehacer: 2, idTutor: 1, idHijo: 2 },
    { id: 5, titulo: "Preparar el desayuno", descripcion: "Preparar desayuno sencillo para la familia",     tipoActividad: "Cocina y alimentos", fechaInicio: "2026-05-20", fechaTerminacion: "2026-05-20", idQuehacer: 3, idTutor: 1, idHijo: 1 }
];

document.addEventListener("DOMContentLoaded", function() {

    document.getElementById("modId").addEventListener("change", function() {
        const id = parseInt(this.value);
        const actividad = actividades.find(a => a.id === id);

        if (actividad) {
            document.getElementById("modTitulo").value          = actividad.titulo;
            document.getElementById("modDescripcion").value     = actividad.descripcion;
            document.getElementById("modTipoActividad").value   = actividad.tipoActividad;
            document.getElementById("modFechaInicio").value     = actividad.fechaInicio;
            document.getElementById("modFechaTerminacion").value = actividad.fechaTerminacion;
            document.getElementById("modIdQuehacer").value      = actividad.idQuehacer;
            document.getElementById("modIdTutor").value         = actividad.idTutor;
            document.getElementById("modIdHijo").value          = actividad.idHijo;

            mostrarMensaje("Actividad cargada. Edita los campos que desees.", "info");
        } else {
            mostrarMensaje("No existe una actividad con ese ID.", "error");
            document.getElementById("modificarForm").reset();
        }
    });

    document.getElementById("modificarForm").addEventListener("submit", function(event) {
        event.preventDefault();

        const modId            = document.getElementById("modId").value;
        const modTitulo        = document.getElementById("modTitulo").value.trim();
        const modDescripcion   = document.getElementById("modDescripcion").value.trim();
        const modFechaInicio   = document.getElementById("modFechaInicio").value;
        const modFechaTerminacion = document.getElementById("modFechaTerminacion").value;
        const modTipoActividad = document.getElementById("modTipoActividad").value;
        const modIdQuehacer    = document.getElementById("modIdQuehacer").value;
        const modIdTutor       = document.getElementById("modIdTutor").value;
        const modIdHijo        = document.getElementById("modIdHijo").value;

        // Validación
        if (!modId) {
            mostrarMensaje("Ingresa el ID de la actividad a modificar.", "error");
            return;
        }

        if (!modTitulo || !modDescripcion || !modTipoActividad || !modFechaInicio || !modFechaTerminacion || !modIdQuehacer || !modIdTutor || !modIdHijo) {
            mostrarMensaje("Por favor completa todos los campos.", "error");
            return;
        }

        if (modFechaTerminacion < modFechaInicio) {
            mostrarMensaje("La fecha de terminación no puede ser anterior a la de inicio.", "error");
            return;
        }

        // Confirmación visual
        mostrarMensaje("¡Actividad modificada correctamente!", "exito");

        // Volvemos al calendario después de 2 segundos
        setTimeout(function() {
            window.location.href = "Principal.html";
        }, 2000);
    });
});

function mostrarMensaje(texto, tipo) {
    const mensaje = document.getElementById("mensaje-resultado");
    mensaje.textContent = texto;
    mensaje.style.display = "block";
    mensaje.style.color = tipo === "error" ? "#ff6b6b" : tipo === "exito" ? "#a6e3a1" : "#cba6f7";
}