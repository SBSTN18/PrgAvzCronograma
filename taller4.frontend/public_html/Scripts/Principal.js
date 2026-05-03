// Ejemplo de arreglo de actividades (en un futuro vendrán de tu backend o base de datos en memoria)
const actividades = [
    { fecha: "2026-05-05", titulo: "Limpiar sala" },
    { fecha: "2026-05-10", titulo: "Hacer compras" }
];

function generarCalendario(anio, mes) {
    const contenedor = document.getElementById("dias-calendario");
    contenedor.innerHTML = ""; // Limpiamos la cuadrícula

    const primerDia = new Date(anio, mes, 1).getDay();
    const totalDias = new Date(anio, mes + 1, 0).getDate();

    // Rellenamos los espacios vacíos del inicio si el mes no empieza en lunes
    for (let i = 0; i < primerDia; i++) {
        const celdaVacia = document.createElement("div");
        celdaVacia.classList.add("dia-celda");
        celdaVacia.style.backgroundColor = "transparent";
        celdaVacia.style.border = "none";
        contenedor.appendChild(celdaVacia);
    }

    // Dibujamos los días del mes
    for (let dia = 1; dia <= totalDias; dia++) {
        const celda = document.createElement("div");
        celda.classList.add("dia-celda");

        const numero = document.createElement("span");
        numero.classList.add("dia-numero");
        numero.innerText = dia;
        celda.appendChild(numero);

        // Formato de fecha para comparar (YYYY-MM-DD)
        const mesFormateado = String(mes + 1).padStart(2, '0');
        const diaFormateado = String(dia).padStart(2, '0');
        const fechaStr = `${anio}-${mesFormateado}-${diaFormateado}`;

        // Buscamos actividades para este día
        const actividadesDelDia = actividades.filter(a => a.fecha === fechaStr);

        actividadesDelDia.forEach(actividad => {
            const chip = document.createElement("button");
            chip.classList.add("actividad-btn");
            chip.innerText = actividad.titulo;

            chip.addEventListener("click", function() {
                window.location.href = "Actividad.html";
            });

            celda.appendChild(chip);
        });

        contenedor.appendChild(celda);
    }
}

// Inicializamos en Mayo de 2026
document.addEventListener("DOMContentLoaded", function() {
    generarCalendario(2026, 4); // El mes en JS va de 0 a 11
});

document.getElementById("añadir").addEventListener("click", function() {
    window.location.href = "AñadirActividad.html";
});

document.getElementById("Consultar").addEventListener("click", function() {
    window.location.href = "Principal.html";
});