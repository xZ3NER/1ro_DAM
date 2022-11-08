function calculoNomina() {
//DEVENGOS
    var salarioBase = document.getElementById("inputSalarioBase").value;
    if(salarioBase<0) return;
    var extra = pagasExtras(salarioBase);
    totalDev = totalDevengado(salarioBase, extra);

//DEDUCCIONES
    var segSocialDeduc = seguridadSocial(totalDev);
    var irpfDeduc = irpf(totalDev);
    var extrasDeduc = extrasDeducciones();
    totalDeduc = totalDeducciones(segSocialDeduc,irpfDeduc,extrasDeduc);

//TOTAL A RECIBIR
    totalARecibir(totalDev,totalDeduc);
}

function pagasExtras(salarioBase) {
    var extra = (salarioBase*2)/12;
    extra = extra.toFixed(2);
    document.getElementById("inputPagasExtras").value = extra;

    return extra;
}

function totalDevengado(salarioBase, extra) {
    var total = parseFloat(salarioBase) + parseFloat(extra);
    if(isNaN(total)) return;
    document.getElementById("inputTotalDevengado").value = total;

    return total;
}

function seguridadSocial(totalDev) {
    var seguridadSocial = totalDev*0.064;
    seguridadSocial = seguridadSocial.toFixed(2);
    if(isNaN(seguridadSocial)) return;
    document.getElementById("inputSegSocial").value = seguridadSocial;

    return seguridadSocial;
}

function irpf(totalDev) {
    var irpfPorcentaje = document.getElementById("input%IRPF").value;
    if (irpfPorcentaje<0 || irpfPorcentaje>100) {
    document.getElementById("inputIRPF").value = 0;
    return;
    }

    var irpf = totalDev*irpfPorcentaje/100;
    irpf = irpf.toFixed(2);
    if(isNaN(irpf)) return;
    document.getElementById("inputIRPF").value = irpf;

    return irpf;
}

function extrasDeducciones() {
    var anticipos = document.getElementById("inputAnticipos").value;
     if(anticipos<0) return;
    var embargos = document.getElementById("inputEmbargos").value;
     if(embargos<0) return;
    var ajustes = document.getElementById("inputAjustes").value;
     if(ajustes<0) return;

    var total = parseFloat(anticipos)+parseFloat(embargos)+parseFloat(ajustes);
    return total;
}

function totalDeducciones(segSocialDeduc,irpfDeduc,extrasDeduc) {
    var totalDeducciones = parseFloat(segSocialDeduc)+parseFloat(irpfDeduc)+parseFloat(extrasDeduc);
    totalDeducciones = totalDeducciones.toFixed(2);
    if(isNaN(totalDeducciones)) return;
    document.getElementById("inputTotalDeducido").value = totalDeducciones;

    return totalDeducciones;
}

function totalARecibir(totalDev,totalDeduc) {
    var totalARecibir = parseFloat(totalDev)-parseFloat(totalDeduc);
    totalARecibir = totalARecibir.toFixed(2);
    if(isNaN(totalARecibir)) return;
    document.getElementById("inputTotal").value = totalARecibir;
}


//FINIQUITO
function calculoFiniquito() {

    var oldNomina = document.getElementById("inputSB").value;
    if(nomina<0) return;
    var extraNomina = extraNominaFini(oldNomina);
    var nomina = nominaBruto(oldNomina, extraNomina);

    var extra = extrasFiniquito();
    var vacaciones = vacacionesNoDisfru(oldNomina);
    var totalProvisionalFini= totalARecibirFin(nomina, extra, vacaciones);
    var anios = document.getElementById("inputAnios").value;

    totalProvisionalFini = reducciones(totalProvisionalFini);
    var indemnizaciones = indemnizacionesFin(nomina,anios);

    totalFiniquito(totalProvisionalFini,indemnizaciones);
}

function nominaBruto(oldNomina, extraNomina) {
    var total = parseFloat(oldNomina) + parseFloat(extraNomina);
    if(isNaN(total)) return;
    document.getElementById("inputNomina").value = total;

    return total;
}

function extraNominaFini(oldNomina) {
    var extra = (oldNomina*2)/12;
    extra = extra.toFixed(2);

    return extra;
}

function extrasFiniquito() {
    var pagasExtras = document.getElementById("inputPagasExtrasNI").value;
     if(pagasExtras<0) return;
    var atrasos = document.getElementById("inputAtrasos").value;
     if(atrasos<0) return;
    var ajustes = document.getElementById("inputAjustesFiniquito").value;
     if(ajustes<0) return;
    var comisiones = document.getElementById("inputComisiones").value;
     if(comisiones<0) return;
    var diasNoPreaviso = document.getElementById("inputDiasNoAviso").value;
     if(diasNoPreaviso<0) return;

    var total = parseFloat(pagasExtras)+parseFloat(atrasos)+parseFloat(ajustes)+parseFloat(comisiones)+parseFloat(diasNoPreaviso);
    return total;
}

function vacacionesNoDisfru(oldNomina) {
    var dias = document.getElementById("inputVacacionesDias").value;
    if(dias<0) return;
    var vacaciones = parseFloat(oldNomina)/30*parseFloat(dias);
    vacaciones = vacaciones.toFixed(2);
    if(isNaN(vacaciones)) return;

    document.getElementById("inputVacacionesEuros").value = vacaciones;

    return vacaciones;
}

function totalARecibirFin(nomina, extra,vacaciones) {
    var totalARecibir = parseFloat(nomina)+parseFloat(extra)+parseFloat(vacaciones);
        totalARecibir = totalARecibir.toFixed(2);
        if(isNaN(totalARecibir)) return;

    return totalARecibir;
}

function reducciones(totalProvisionalFini) {
      var segSocial = seguridadSocialFin(totalProvisionalFini);
      var irpf = irpfFin(totalProvisionalFini);

      var totalTrasReducc = totalProvisionalFini-segSocial-irpf;
      if(isNaN(totalTrasReducc)) return;

      return totalTrasReducc;
}

function seguridadSocialFin(totalProvisionalFini) {
    var seguridadSocial = totalProvisionalFini*0.064;
    seguridadSocial = seguridadSocial.toFixed(2);
    if(isNaN(seguridadSocial)) return;
    document.getElementById("inputSegSocialFini").value = seguridadSocial;

    return seguridadSocial;
}

function irpfFin(totalProvisionalFini) {
    var irpfPorcentaje = document.getElementById("input%IRPFFini").value;
    if (irpfPorcentaje<0 || irpfPorcentaje>100) {
    document.getElementById("inputIRPFFini").value = 0;
    return;
    }

    var irpf = totalProvisionalFini*irpfPorcentaje/100;
    irpf = irpf.toFixed(2);
    if(isNaN(irpf)) return;
    document.getElementById("inputIRPFFini").value = irpf;

    return irpf;
}

function indemnizacionesFin(nomina,anios) {
    var tipoIndem = document.getElementById("seleccionIndemnizacion").value;
    var valorIndem;

    switch(tipoIndem) {
        case "despidoProcedente":
            valorIndem = nomina/30*20*anios;
            if(20*anios>365 || isNaN(valorIndem)) return;
            valorIndem = parseFloat(valorIndem.toFixed(2));
            document.getElementById("inputIndemnizacionEuros").value = valorIndem;
            break;
        case "despidoImprocedente":
            valorIndem = nomina/30*33*anios;
            if(33*anios>730 || isNaN(valorIndem)) return;
            valorIndem = parseFloat(valorIndem.toFixed(2));
            document.getElementById("inputIndemnizacionEuros").value = valorIndem;
            break;
        case "contratoTemporal":
            valorIndem = nomina/30*12*anios;
            if(isNaN(valorIndem)) return;
            valorIndem = parseFloat(valorIndem.toFixed(2));
            document.getElementById("inputIndemnizacionEuros").value = valorIndem;
            break;
        case "muerteInvalidez":
            valorIndem = nomina;
            if(isNaN(valorIndem)) return;
            valorIndem = parseFloat(valorIndem.toFixed(2));
            document.getElementById("inputIndemnizacionEuros").value = valorIndem;
            break;
        case "jubilacion":
            valorIndem = nomina/2;
            if(isNaN(valorIndem)) return;
            valorIndem = parseFloat(valorIndem.toFixed(2));
            document.getElementById("inputIndemnizacionEuros").value = valorIndem;
            break;
        case "fuerzaMayor":
            valorIndem = nomina/30*20*anios;
            if(20*anios>365 || isNaN(valorIndem)) return;
            valorIndem = parseFloat(valorIndem.toFixed(2));
            document.getElementById("inputIndemnizacionEuros").value = valorIndem;
            break;
        default:
        {
        valorIndem = 0;
        document.getElementById("inputIndemnizacionEuros").value = valorIndem;
        }
    }

    return valorIndem;
}

function totalFiniquito(totalProvisionalFini,indemnizaciones) {
     var total = totalProvisionalFini+indemnizaciones;
      if(isNaN(total)) return;
      total = total.toFixed(2);
     document.getElementById("inputTotalFini").value = total;
}

function flaotingDiv(){ //copiado y pegado de internet, pero funciona :)

    //How much the screen has been zoomed.
    var zoomLevel = ((screen.width)/(window.innerWidth));
    //By what factor we must scale the div for it to look the same.
    var inverseZoom = ((window.innerWidth)/(screen.width));
    //The div whose size we want to remain constant.
    var h = document.getElementById("fontSizeDiv");

    //This ensures that the div stays at the top of the screen at all times. For some reason, the top value is affected by the zoom level of the Div. So we need to multiple the top value by the zoom level for it to adjust to the zoom.
    h.style.top = (((window.pageYOffset) + 5) * zoomLevel).toString() + "px";

    //This ensures that the window stays on the right side of the screen at all times. Once again, we multiply by the zoom level so that the div's padding scales up.
    h.style.paddingLeft = ((((window.pageXOffset) + 5) * zoomLevel).toString()) + "px";

    //Finally, we shrink the div on a scale of inverseZoom.
    h.style.zoom = inverseZoom;

}

//We want the div to readjust every time there is a scroll event:
window.onscroll = flaotingDiv;

