function obtenerId(id){
    //alert(id);
    var auxid = id.id.substring(0,id.id.lastIndexOf(":"));
    var button = document.getElementById(auxid+":btnReactiva");
    button.click();
}

function obtenerIdBajaBecario(id){
    var auxid = id.id.substring(0, id.id.lastIndexOf(":"));
    var button = document.getElementById(auxid+":btnBajaBecario");
    button.click();
}

function obtenerIdModificarBecario(id){
    var auxid = id.id.substring(0, id.id.lastIndexOf(":"));
    var button = document.getElementById(auxid+":btnModBecario");
    button.click();
}

function obtenerIdDetalleBecario(id){    
    var auxid = id.id.substring(0, id.id.lastIndexOf(":"));
    var button = document.getElementById(auxid+":btnDBecario");
    button.click();    
}

function reactivarBecario(button){
    var string = button.id.substring(0, button.id.lastIndexOf(':'));
    bootbox.dialog({
        message: "<strong>¿Esta seguro que desea reactivar al becario?</strong>",
        buttons: {
            success: {
                label: "Reactivar",
                className: "btn-danger",
                callback: function() {
                    var eliminar = document.getElementById(string+":btnReactivarBecario1");
                    eliminar.click();
                }
            },
            danger: {
                label: "Cancelar",
                className: "btn-primary",
                callback: function() {
                }
            }
        }
    });
    e.preventdefault();
    return false;
}

function confirmBajaBecario(button){
    var string = button.id.substring(0, button.id.lastIndexOf(':'));
    bootbox.dialog({
        message: "<strong>¿Esta seguro que desea dar de baja a este becario?</strong>",
        buttons: {
            success: {                
                label: "Confirma",
                className: "btn-danger",
                callback: function() {
                    var eliminar = document.getElementById(string+":btnEnviarBajaBecario1");
                    eliminar.click();
                    $("#messageBajaBecario").html("<div class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡La baja del becario se realizó correctamente!</strong></div>");
                }
            },
            danger: {
                label: "Cancelar",
                className: "btn-primary",
                callback: function() {
                }
            }
        }
    });
    e.preventdefault();
    return false;
}

function confirmarModificarBecario(button){
    var string = button.id.substring(0, button.id.lastIndexOf(':'));
    bootbox.dialog({
        message: "<strong>¿Esta seguro que desea modificar los datos de este becario?</strong>",
        buttons: {
            success: {                
                label: "Confirma",
                className: "btn-danger",
                callback: function() {
                    var btn = document.getElementById(string+":btnConfModBecario1");
                    btn.click();
                    $("#messageModificarBecario").html("<div class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡La modificación del becario se realizó correctamente!</strong></div>");
                }
            },
            danger: {
                label: "Cancelar",
                className: "btn-primary",
                callback: function() {
                }
            }
        }
    });
    e.preventdefault();
    return false;
}

function validarCamposAltaBecario(button){    
    var string = button.id.substring(0, button.id.lastIndexOf(':'));
    var numeroID = document.getElementById("formAltaBecario:txtNumeroID").value;
    var auxNumeroID = document.getElementById("formAltaBecario:auxClaveBecario").value;
    var fechaRegistro = document.getElementById("formAltaBecario:txtFechaRegistro").value; 
    var area = document.getElementById("formAltaBecario:txtArea").value;
    var nivel = document.getElementById("formAltaBecario:cmbxNivelBeca").value;
    var tipoBeca = document.getElementById("formAltaBecario:cmbxTipoBeca").value;
    var fechaInicio = document.getElementById("formAltaBecario:txtFechaInicioBeca").value;
    var fechaFin = document.getElementById("formAltaBecario:txtFechaFinalBeca").value;
    var solicitante = document.getElementById("formAltaBecario:txtSolicitante").value;
    var adscripcion = document.getElementById("formAltaBecario:txtAdcripcion").value;
    var zona = document.getElementById("formAltaBecario:cmbxZona").value;
    
    //MANIPULACION DE LA FECHAS
    var auxfechaIncio = fechaInicio.split("-");
    var auxfechaFin = fechaFin.split("-");
    
//    alert(auxfechaIncio[2]+" "+auxfechaIncio[1]+" "+auxfechaIncio[0]);
    var dateInicio = new Date(auxfechaIncio[2],(auxfechaIncio[1]-1),auxfechaIncio[0]);
    var dateFin = new Date(auxfechaFin[2], (auxfechaFin[1]-1), auxfechaFin[0]);
//    alert(dateInicio);
    if(numeroID != auxNumeroID){
       $("#messageAltaBecario").html("<div class='alert alert-info'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡No ha presionado el boton Buscar...!</strong> </div>"); 
//       cambiaColorCamposVaciosAltaBecario();
    }else if((numeroID == "0" || numeroID == null || numeroID.length == 0 || /^\s+$/.test(numeroID)) || (fechaRegistro == null || fechaRegistro.length == 0 || /^\s+$/.test(fechaRegistro)) || (area == null || area.length == 0 || /^\s+$/.test(area)) || (nivel == null || nivel.length == 0 || /^\s+$/.test(nivel)) || (tipoBeca == null || tipoBeca.length == 0 || /^\s+$/.test(tipoBeca)) || (fechaInicio == null || fechaInicio.length == 0 || /^\s+$/.test(fechaInicio)) || (fechaFin == null || fechaFin.length == 0 || /^\s+$/.test(fechaFin)) || (solicitante == null || solicitante.length == 0 || /^\s+$/.test(solicitante)) || (adscripcion == null || adscripcion.length == 0 || /^\s+$/.test(adscripcion)) || (zona == null || zona.length == 0 || /^\s+$/.test(zona))){
        $("#messageAltaBecario").html("<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡No se han rellenado campos obligatorios!</strong> </div>");
        cambiaColorCamposVaciosAltaBecario();        
    }else if(dateFin < dateInicio){
        $("#messageAltaBecario").html("<div class='alert alert-info'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡La fecha final debe ser mayor a la fecha inicial!</strong> </div>"); 
        cambiaColorCamposVaciosAltaBecario();
    }else{
        var altaBecario = document.getElementById(string+":btnAltaBecario1");
        altaBecario.click();
        $("#messageAltaBecario").html("<div class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡La alta del becario se realizó correctamente!</strong></div>");
        cambiaColorCamposVaciosAltaBecario()
    }
   
}

function validarCamposReactivacionBeca(button){
    var string = button.id.substring(0, button.id.lastIndexOf(':'));
    var area = document.getElementById("formReactivacionBeca:txtArea").value;
    var nivel = document.getElementById("formReactivacionBeca:cmbxNivelBeca").value;
    var tipoBeca = document.getElementById("formReactivacionBeca:cmbxTipoBeca").value;
    var fechaInicio = document.getElementById("formReactivacionBeca:txtFechaInicioBeca").value;
    var fechaFin = document.getElementById("formReactivacionBeca:txtFechaFinalBeca").value;
    var solicitante = document.getElementById("formReactivacionBeca:txtSolicitante").value;
    var adscripcion = document.getElementById("formReactivacionBeca:txtAdcripcion").value;
    var zona = document.getElementById("formReactivacionBeca:cmbxZona").value;
    
        //MANIPULACION DE LA FECHAS
    var auxfechaIncio = fechaInicio.split("-");
    var auxfechaFin = fechaFin.split("-");
    var dateInicio = new Date(auxfechaIncio[2],(auxfechaIncio[1]-1),auxfechaIncio[0]);
    var dateFin = new Date(auxfechaFin[2], (auxfechaFin[1]-1), auxfechaFin[0]);
    
    if((area == null || area.length == 0 || /^\s+$/.test(area)) || (nivel == null || nivel.length == 0 || /^\s+$/.test(nivel)) || (tipoBeca == null || tipoBeca.length == 0 || /^\s+$/.test(tipoBeca)) || (fechaInicio == null || fechaInicio.length == 0 || /^\s+$/.test(fechaInicio)) || (fechaFin == null || fechaFin.length == 0 || /^\s+$/.test(fechaFin)) || (solicitante == null || solicitante.length == 0 || /^\s+$/.test(solicitante)) || (adscripcion == null || adscripcion.length == 0 || /^\s+$/.test(adscripcion)) || (zona == null || zona.length == 0 || /^\s+$/.test(zona))){
        $("#message").html("<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡No se han rellenado campos obligatorios!</strong> </div>");
        CambiaColorCamposVacios();        
    }else if(dateFin < dateInicio){
        $("#message").html("<div class='alert alert-info'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡La fecha final debe ser mayor a la fecha inicial!</strong> </div>"); 
        CambiaColorCamposVacios();
    }else{
        var reactivarBeca = document.getElementById(string+":reactivarBecario");
        reactivarBeca.click();
        $("#message").html("<div class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡La reactivación de la beca se realizó correctamente!</strong></div>");
        CambiaColorCamposVacios();
    }
//    alert(area);
}

function cambiaColorCamposVaciosAltaBecario(){
    var numeroID = document.getElementById("formAltaBecario:txtNumeroID").value;
    var fechaRegistro = document.getElementById("formAltaBecario:txtFechaRegistro").value;  
    var area = document.getElementById("formAltaBecario:txtArea").value;
    var nivel = document.getElementById("formAltaBecario:cmbxNivelBeca").value;
    var tipoBeca = document.getElementById("formAltaBecario:cmbxTipoBeca").value;
    var fechaInicio = document.getElementById("formAltaBecario:txtFechaInicioBeca").value;
    var fechaFin = document.getElementById("formAltaBecario:txtFechaFinalBeca").value;
    var solicitante = document.getElementById("formAltaBecario:txtSolicitante").value;
    var adscripcion = document.getElementById("formAltaBecario:txtAdcripcion").value;
    var zona = document.getElementById("formAltaBecario:cmbxZona").value;   
    
    if(numeroID == "0" || numeroID == null || numeroID.length == 0 || /^\s+$/.test(numeroID)){
        document.getElementById('formAltaBecario:txtNumeroID').style.border='1px solid red'; 
    }else{
        document.getElementById('formAltaBecario:txtNumeroID').style.border='';
    }
    if(fechaRegistro == null || fechaRegistro.length == 0 || /^\s+$/.test(fechaRegistro)){
        document.getElementById('formAltaBecario:txtFechaRegistro').style.border='1px solid red'; 
    }else{
      document.getElementById('formAltaBecario:txtFechaRegistro').style.border='';   
    }    
    if(area == null || area.length == 0 || /^\s+$/.test(area)){
        document.getElementById('formAltaBecario:txtArea').style.border='1px solid red'; 
    }else{
      document.getElementById('formAltaBecario:txtArea').style.border='';   
    }
    if(nivel == null || nivel.length == 0 || /^\s+$/.test(nivel)){
        document.getElementById('formAltaBecario:cmbxNivelBeca').style.border='1px solid red'; 
    }else{
      document.getElementById('formAltaBecario:cmbxNivelBeca').style.border='';   
    } 
    if(tipoBeca == null || tipoBeca.length == 0 || /^\s+$/.test(tipoBeca)){
        document.getElementById('formAltaBecario:cmbxTipoBeca').style.border='1px solid red'; 
    }else{
      document.getElementById('formAltaBecario:cmbxTipoBeca').style.border='';   
    }
    if(fechaInicio == null || fechaInicio.length == 0 || /^\s+$/.test(fechaInicio)){
        document.getElementById('formAltaBecario:txtFechaInicioBeca').style.border='1px solid red'; 
    }else{
      document.getElementById('formAltaBecario:txtFechaInicioBeca').style.border='';   
    }
    if (fechaFin == null || fechaFin.length == 0 || /^\s+$/.test(fechaFin)) {
        document.getElementById('formAltaBecario:txtFechaFinalBeca').style.border = '1px solid red';
    } else {
        document.getElementById('formAltaBecario:txtFechaFinalBeca').style.border = '';
    } 
    if (solicitante == null || solicitante.length == 0 || /^\s+$/.test(solicitante)) {
        document.getElementById('formAltaBecario:txtSolicitante').style.border = '1px solid red';
    } else {
        document.getElementById('formAltaBecario:txtSolicitante').style.border = '';
    }
    if (adscripcion == null || adscripcion.length == 0 || /^\s+$/.test(adscripcion)) {
        document.getElementById('formAltaBecario:txtAdcripcion').style.border = '1px solid red';
    } else {
        document.getElementById('formAltaBecario:txtAdcripcion').style.border = '';
    }
    if (zona == null || zona.length == 0 || /^\s+$/.test(zona)) {
        document.getElementById('formAltaBecario:cmbxZona').style.border = '1px solid red';
    } else {
        document.getElementById('formAltaBecario:cmbxZona').style.border = '';
    }    
}

function CambiaColorCamposVacios(){
    var area = document.getElementById("formReactivacionBeca:txtArea").value;
    var nivel = document.getElementById("formReactivacionBeca:cmbxNivelBeca").value;
    var tipoBeca = document.getElementById("formReactivacionBeca:cmbxTipoBeca").value;
    var fechaInicio = document.getElementById("formReactivacionBeca:txtFechaInicioBeca").value;
    var fechaFin = document.getElementById("formReactivacionBeca:txtFechaFinalBeca").value;
    var solicitante = document.getElementById("formReactivacionBeca:txtSolicitante").value;
    var adscripcion = document.getElementById("formReactivacionBeca:txtAdcripcion").value;
    var zona = document.getElementById("formReactivacionBeca:cmbxZona").value;
    if(area == null || area.length == 0 || /^\s+$/.test(area)){
        document.getElementById('formReactivacionBeca:txtArea').style.border='1px solid red'; 
    }else{
      document.getElementById('formReactivacionBeca:txtArea').style.border='';   
    }
    if(nivel == null || nivel.length == 0 || /^\s+$/.test(nivel)){
        document.getElementById('formReactivacionBeca:cmbxNivelBeca').style.border='1px solid red'; 
    }else{
      document.getElementById('formReactivacionBeca:cmbxNivelBeca').style.border='';   
    } 
    if(tipoBeca == null || tipoBeca.length == 0 || /^\s+$/.test(tipoBeca)){
        document.getElementById('formReactivacionBeca:cmbxTipoBeca').style.border='1px solid red'; 
    }else{
      document.getElementById('formReactivacionBeca:cmbxTipoBeca').style.border='';   
    }
    if(fechaInicio == null || fechaInicio.length == 0 || /^\s+$/.test(fechaInicio)){
        document.getElementById('formReactivacionBeca:txtFechaInicioBeca').style.border='1px solid red'; 
    }else{
      document.getElementById('formReactivacionBeca:txtFechaInicioBeca').style.border='';   
    }
    if (fechaFin == null || fechaFin.length == 0 || /^\s+$/.test(fechaFin)) {
        document.getElementById('formReactivacionBeca:txtFechaFinalBeca').style.border = '1px solid red';
    } else {
        document.getElementById('formReactivacionBeca:txtFechaFinalBeca').style.border = '';
    } 
    if (solicitante == null || solicitante.length == 0 || /^\s+$/.test(solicitante)) {
        document.getElementById('formReactivacionBeca:txtSolicitante').style.border = '1px solid red';
    } else {
        document.getElementById('formReactivacionBeca:txtSolicitante').style.border = '';
    }
    if (adscripcion == null || adscripcion.length == 0 || /^\s+$/.test(adscripcion)) {
        document.getElementById('formReactivacionBeca:txtAdcripcion').style.border = '1px solid red';
    } else {
        document.getElementById('formReactivacionBeca:txtAdcripcion').style.border = '';
    }
    if (zona == null || zona.length == 0 || /^\s+$/.test(zona)) {
        document.getElementById('formReactivacionBeca:cmbxZona').style.border = '1px solid red';
    } else {
        document.getElementById('formReactivacionBeca:cmbxZona').style.border = '';
    }    
}




