    var paypal = document.getElementById("paypal"); 
    var user = document.getElementById("user"); 
    var pass = document.getElementById("password"); 
    var nombreTajeta = document.getElementById("nombre-tarjeta");
    var codigoSeguridad = document.getElementById("codigoSeguridad");
    var nombrePropietario = document.getElementById("nombre-propietario");
    var tarjetaCredito = document.getElementById("tarjetaCredito");
    var tarjetaDebito = document.getElementById("tarjetaDebito");
    var visa = document.getElementById("visa");
    var masterCard = document.getElementById("masterCard");
    var americanExpres = document.getElementById("americanExpres");
    var datos = document.getElementById("dat");
    var boton = document.getElementById("boton");
    var region = document.getElementById("region"); 
    var regiones = document.getElementById("regiones"); 
    var tarjeta = document.getElementById("tarjet"); 
    var check = document.getElementById("check");
    var checkTarje = document.getElementById("chack");
    var buttom = document.getElementById("buttom");
    var buttomMargin = document.getElementById("botomMargin");
    var date = document.getElementById("exemplo");
    var accion = document.getElementById("botonProbar");
    var form = document.getElementById("form");
    const numero1= 0;
function verificacion() {
    
    /*var labelVista = document.getElementById("labelVisa");
    var labelMaster = document.getElementById("labelMaster");
    var labelAmerica = document.getElementById("labelAmerican");
    var labelDebito = document.getElementById("labelDebito");
    var labelCredito = document.getElementById("labelCredito");*/
    
    if(tarjeta.checked == true){
      habilitar();
      nombreTajeta.disabled = false;
      codigoSeguridad.disabled = false;
      nombrePropietario.disabled = false;
      visa.disabled = false;
      masterCard.disabled = false;
      americanExpres.disabled = false;
      regiones.disabled = false;
      tarjetaCredito.disabled = false;
      tarjetaDebito.disabled = false;
      boton.style.display = 'none';
      buttomMargin.style.display = 'none';
      date.style.display = 'block';
      date.disabled = false;
      accion.disabled = false;
      form.style.display='block';
      
    }else if(paypal.checked == true ){ 
        nombreTajeta.style.display = 'none';
        codigoSeguridad.style.display = 'none';
        nombrePropietario.style.display = 'none';
        datos.style.display='none';
        form.style.display='none';
        boton.style.display = 'block';
        buttomMargin.style.display = 'block';
      
        checkTarje.style.display ='none';
        check.style.display ='none';
        region.style.display = 'none';
        buttom.style.display = 'none';

        date.style.display = 'none';


        borrarDatos();

    }else if(tarjeta.checked == false){
      deshabilitar();

      
      tarjetaCredito.checked = false;
      tarjetaDebito.checked = false;
      visa.checked = false;
      masterCard.checked = false;
      americanExpres.checked = false;

      regiones.disabled = true;
      borrarDatos();
      accion.disabled = true;
    }
    
    

}

function myFunction() {
    /*var nombreTajeta = document.getElementById("nombre-tarjeta").value;
    var codigoSeguridad = document.getElementById("codigoSeguridad").value;

    console.log(nombreTajeta);
    console.log(codigoSeguridad);

    //enviar un valor a un p
    //document.getElementById("demo").innerHTML = x;
    */


   if(nombreTajeta.value==""){
    return false;
   }if(nombrePropietario.value=="" /*&& soloLetras(nombrePropietario)== true*/){
   return false;
   }if(codigoSeguridad.value==""){
    return false;
   }if(visa.checked == false){
   return false;
   }if(paypal.checked == false){
    return false;
  }
  return true;
}
/*
  function soloLetras(e) {
    var key = e.keyCode || e.which,
      tecla = String.fromCharCode(key).toLowerCase(),
      letras = " áéíóúabcdefghijklmnñopqrstuvwxyz",
      especiales = [8, 37, 39, 46],
      tecla_especial = false;

    for (var i in especiales) {
      if (key == especiales[i]) {
        tecla_especial = true;
        break;
      }
    }

    if (letras.indexOf(tecla) == -1 && !tecla_especial) {
      return false;
    }
  }
  */
  function createDataList(){
    var values = ['Afghanistan', 'Åland Islands', 'Albania', 'Algeria', 'American Samoa','Brasil'];
    
    var dataList = document.createElement('datalist');
    dataList.id = "country_list";
    
    values.forEach(value =>{
        var option = document.createElement('option');
        option.innerHTML = value;
        option.value = value;
        dataList.appendChild(option);

        
    })
    var region = document.getElementById("region");
    console.log(region);
    document.body.appendChild(dataList);
    
}

createDataList();



/* Bootstrap 5 JS included */
/* vanillajs-datepicker 1.1.4 JS included */

const getDatePickerTitle = elem => {
    // From the label or the aria-label
    const label = elem.nextElementSibling;
    let titleText = '';
    if (label && label.tagName === 'LABEL') {
      titleText = label.textContent;
    } else {
      titleText = elem.getAttribute('aria-label') || '';
    }
    return titleText;
  }
  
  const elems = document.querySelectorAll('.datepicker_input');
  for (const elem of elems) {
    const datepicker = new Datepicker(elem, {
      'format': 'dd/mm/yyyy', // UK format
      title: getDatePickerTitle(elem)
    });
  }
  function habilitar(){
    nombreTajeta.style.display = 'block';
    codigoSeguridad.style.display = 'block';
    nombrePropietario.style.display = 'block';
    datos.style.display='block';
    check.style.display = 'block';
    checkTarje.style.display = 'block';
    region.style.display = 'block';
    buttom.style.display = 'block';
    date.style.display = 'block';

  }
  function deshabilitar(){
      nombreTajeta.disabled = true;
      codigoSeguridad.disabled = true;
      nombrePropietario.disabled = true;
      visa.disabled = true;
      masterCard.disabled = true;
      americanExpres.disabled = true;
      tarjetaCredito.disabled = true;
      tarjetaDebito.disabled = true;
      date.disabled = true;
  }
  function borrarDatos(){
    tarjetaCredito.checked = false;
    tarjetaDebito.checked = false;
    visa.checked = false;
    masterCard.checked = false;
    americanExpres.checked = false;
  }

  $('#exemplo').datepicker({	
    format: "dd/mm/yyyy",	
    language: "pt-BR",
    startDate: '+0d',
  });

  (function () {
    'use strict'
  
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.querySelectorAll('.needs-validation')
  
    // Loop over them and prevent submission
    Array.prototype.slice.call(forms)
      .forEach(function (form) {
        form.addEventListener('submit', function (event) {
          if (!form.checkValidity()) {
            event.preventDefault()
            event.stopPropagation()
          }
  
          form.classList.add('was-validated')
          
        }, false)
      })
  })()
  
function todo(){
    if(myFunction()){
      location.href='../vista-usuario.jsp';
}
}