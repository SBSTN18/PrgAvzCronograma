document.getElementById("loginbtn").addEventListener("click", function(event) {
    event.preventDefault();
    window.location.href = "Principal.html";
    
});
document.getElementById("inicios").addEventListener("click", () => {
  window.location.href = "Login.html";
});

document.getElementById("registro").addEventListener("click", () => {
  window.location.href = "Registrar.html";
});