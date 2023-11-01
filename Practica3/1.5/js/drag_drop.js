function allowDrop(event) {
    event.preventDefault();
}

function drag(event) {
    // Almacenar el texto y el color del elemento arrastrado en dataTransfer
    event.dataTransfer.setData("text", event.target.textContent);
    event.dataTransfer.setData("color", event.target.style.backgroundColor);
}

function drop(event) {
    event.preventDefault();
    // Obtener el texto y el color del elemento arrastrado desde dataTransfer
    var data = event.dataTransfer.getData("text");
    var color = event.dataTransfer.getData("color");
    // Asignar el texto y el color al elemento donde se suelta el elemento arrastrado
    event.target.textContent = data;
    event.target.style.backgroundColor = color;
}