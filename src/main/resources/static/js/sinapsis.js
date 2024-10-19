// Función para el botón "More Info"
document.getElementById("moreInfoBtn").addEventListener("click", function() {
    var modal = document.getElementById("synopsisModal");
    modal.style.display = "flex"; // Mostrar modal
});

// Función para el botón "Play"
document.getElementById("playBtn").addEventListener("click", function() {
    window.location.href = "pelicula.html";  // Redirigir a pelicula.html
});

// Función para mostrar u ocultar el modal del tráiler
document.getElementById("trailerBtn").addEventListener("click", function() {
    var modal = document.getElementById("trailerModal");
    var iframe = document.getElementById("trailerVideo");
    modal.style.display = "flex"; // Mostrar modal
    iframe.src = "https://www.youtube.com/embed/Tp_YZNqNBhw"; // Cargar el video
});

// Función para cerrar los modales cuando se hace clic en el botón "Close"
document.querySelectorAll(".close").forEach(function(closeBtn) {
    closeBtn.addEventListener("click", function() {
        var modal = this.closest(".modal");
        var iframe = modal.querySelector("iframe");
        if (iframe) {
            iframe.src = ""; // Detener el video si es un iframe
        }
        modal.style.display = "none"; // Ocultar modal
    });
});

// Cerrar el modal si se hace clic fuera de él
window.onclick = function(event) {
    var modals = document.querySelectorAll(".modal");
    modals.forEach(function(modal) {
        if (event.target == modal) {
            modal.style.display = "none";
            var iframe = modal.querySelector("iframe");
            if (iframe) {
                iframe.src = ""; // Detener el video
            }
        }
    });
}
