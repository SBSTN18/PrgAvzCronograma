const baseUrl = "http://localhost:8080/actividades";

// Crear actividad
document.getElementById("actividadForm").addEventListener("submit", e => {
  e.preventDefault();
  const actividad = {
    titulo: document.getElementById("titulo").value,
    descripcion: document.getElementById("descripcion").value,
    fechaInicio: document.getElementById("fechaInicio").value,
    fechaTerminacion: document.getElementById("fechaFin").value,
    tipoActividad: document.getElementById("tipoActividad").value,
    idQuehacer: document.getElementById("idQuehacer").value,
    idTutor: document.getElementById("idTutor").value,
    idHijo: document.getElementById("idHijo").value
  };

  fetch(baseUrl, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(actividad)
  })
  .then(res => res.json())
  .then(data => document.getElementById("resultado").innerText = "Creada con ID: " + data.idActividad)
  .catch(err => console.error(err));
});

// Consultar todas
document.getElementById("consultarBtn").addEventListener("click", () => {
  fetch(baseUrl)
    .then(res => res.json())
    .then(data => {
      let html = "<h3>Actividades</h3><ul>";
      data.forEach(a => {
        html += `<li>ID: ${a.idActividad}, Título: ${a.titulo}, Tutor: ${a.idTutor}, Hijo: ${a.idHijo}</li>`;
      });
      html += "</ul>";
      document.getElementById("resultado").innerHTML = html;
    })
    .catch(err => console.error(err));
});

// Modificar actividad
document.getElementById("modificarForm").addEventListener("submit", e => {
  e.preventDefault();
  const id = document.getElementById("modId").value;
  const actividad = {
    titulo: document.getElementById("modTitulo").value,
    descripcion: document.getElementById("modDescripcion").value,
    fechaInicio: document.getElementById("modFechaInicio").value,
    fechaTerminacion: document.getElementById("modFechaFin").value,
    tipoActividad: document.getElementById("modTipoActividad").value,
    idQuehacer: document.getElementById("modIdQuehacer").value,
    idTutor: document.getElementById("modIdTutor").value,
    idHijo: document.getElementById("modIdHijo").value
  };

  fetch(`${baseUrl}/${id}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(actividad)
  })
  .then(res => res.json())
  .then(data => document.getElementById("resultado").innerText = "Actividad modificada: " + data.titulo)
  .catch(err => console.error(err));
});

// Borrar actividad
document.getElementById("borrarForm").addEventListener("submit", e => {
  e.preventDefault();
  const id = document.getElementById("borrarId").value;

  fetch(`${baseUrl}/${id}`, { method: "DELETE" })
    .then(() => document.getElementById("resultado").innerText = "Actividad borrada con ID: " + id)
    .catch(err => console.error(err));
});
