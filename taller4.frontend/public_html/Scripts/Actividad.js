const actividades = [
    { id: 1, titulo: "Limpiar la sala",      descripcion: "Barrer y trapear la sala principal",               tipoActividad: "Quehaceres y orden", fechaTerminacion: "2026-05-03", id_tutor: 1, id_hijo: 1 },
    { id: 2, titulo: "Lavar los platos",     descripcion: "Lavar y secar todos los platos del almuerzo",      tipoActividad: "Cocina y alimentos", fechaTerminacion: "2026-05-05", id_tutor: 1, id_hijo: 2 },
    { id: 3, titulo: "Tender la cama",       descripcion: "Tender la cama cada mañana antes del desayuno",    tipoActividad: "Quehaceres y orden", fechaTerminacion: "2026-05-15", id_tutor: 1, id_hijo: 1 },
    { id: 4, titulo: "Sacar la basura",      descripcion: "Llevar las bolsas de basura al contenedor",        tipoActividad: "Limpieza profunda",  fechaTerminacion: "2026-05-12", id_tutor: 1, id_hijo: 2 },
    { id: 5, titulo: "Preparar el desayuno", descripcion: "Preparar desayuno sencillo para la familia",       tipoActividad: "Cocina y alimentos", fechaTerminacion: "2026-05-20", id_tutor: 1, id_hijo: 1 }
];

document.addEventListener("DOMContentLoaded", function() {

    const id = parseInt(sessionStorage.getItem("idActividad"));

    const actividad = actividades.find(a => a.id === id);

    if (actividad) {
        document.getElementById("activity-title").textContent = actividad.titulo;
        document.getElementById("activity-type").innerHTML = `<strong>Tipo:</strong> ${actividad.tipoActividad}`;
        document.getElementById("activity-date").innerHTML = `<strong>Fecha límite:</strong> ${actividad.fechaTerminacion}`;
        document.getElementById("activity-description").textContent = actividad.descripcion;
        document.getElementById("actividad-tutor").textContent = "Tutor " + actividad.id_tutor;
    } else {
        document.getElementById("activity-title").textContent = "Actividad no encontrada";
        document.getElementById("activity-description").textContent = "Vuelve al calendario y selecciona una actividad.";
    }
});

document.getElementById("back").addEventListener("click", function() {
    history.back();
});

document.getElementById("editar").addEventListener("click", function() {
    window.location.href = "Modificar.html";
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
    document.getElementById("confirmar-eliminacion").style.display = "none";
    document.getElementById("activity-title").textContent = "Actividad eliminada";
    document.getElementById("activity-description").textContent = "La actividad fue eliminada correctamente.";
    document.getElementById("activity-type").textContent = "";
    document.getElementById("activity-date").textContent = "";

    setTimeout(function() {
        window.location.href = "Principal.html";
    }, 2000);
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