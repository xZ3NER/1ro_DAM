function fecha() {
    var fecha = new Date();
    var dia = fecha.getDate();
    var mes = fecha.getMonth();
    var año= fecha.getFullYear();
    var newMes;
    switch(mes) {
        case 0: newMes='Enero';
            break;
        case 1: newMes='Febrero';
            break;
        case 2: newMes='Marzo';
            break;
        case 3: newMes='Abril';
            break;
        case 4: newMes='Mayo';
            break;
        case 5: newMes='Junio';
            break;
        case 6: newMes='Julio';
            break;
        case 7: newMes='Agosto';
            break;
        case 8: newMes='Septiembre';
            break;
        case 9: newMes='Octubre';
            break;
        case 10: newMes='Noviembre';
            break;
        case 11: newMes='Diciembre';
            break;
        default:
    }
    document.write('<h1 align="center";>¡Bienvenido, estamos a '+dia+' de '+newMes+' del '+año+'!</h1>');
}

function hora() {
    var tiempo = new Date();
    var horas = tiempo.getHours();
    var minutos = tiempo.getMinutes();
    var segundos = tiempo.getSeconds();
    if(horas<10) horas='0'+horas;
    if(minutos<10) minutos='0'+minutos;
    if(segundos<10) segundos='0'+segundos;
    var reloj = horas+':'+minutos+':'+segundos;
    document.forms[0].horaactual.value=reloj;
    setTimeout("hora()",1000);
}
