window.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnPotencia').addEventListener("click", () => {
        calcularGananciaPotencia();
    })
});

function calcularGananciaPotencia() {
    circuitoSelect = document.getElementById('circuitoSelect');
    cocheSelect = document.getElementById('cocheSelect');

    circuitoSeleccionado = circuitoSelect.options[circuitoSelect.selectedIndex];
    cocheSeleccionado = cocheSelect.options[cocheSelect.selectedIndex];

    numVueltas = parseInt(circuitoSeleccionado.getAttribute('data-numvueltas'));
    numCurvas = parseInt(circuitoSeleccionado.getAttribute('data-numcurvas'));
    gananciaPotenciaPorCurva = parseInt(cocheSeleccionado.getAttribute('data-gananciapotenciaporcurva'));

    gananciaTotal = numVueltas * numCurvas * gananciaPotenciaPorCurva;

    document.getElementById('resultadoPotencia').innerHTML = 'Ganancia de potencia total: ' + gananciaTotal + ' kW';
}