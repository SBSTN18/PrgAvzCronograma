document.getElementById("loginbtn").addEventListener("click", function(event) {
    event.preventDefault();
    if (document.getElementById("role").value === "tutor") {
        window.location.href = "Principal.tutor.html";
    }else {
        window.location.href = "Principal.html";
    }
    
});