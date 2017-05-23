function comprobarDatosEquipo(){
	var fecha=document.getElementById("fechaInstalacion");
	var ubicacion=document.getElementById("ubicacion");
	var modelo=document.getElementById("modelo");
	ubicacion.value=ubicacion.value.trim();
	modelo.value=modelo.value.trim();
	
	if(fecha.value!="" && ubicacion.value!="" && modelo.value!=""){
		return true;
	}
	else{
		window.alert(advertenciaDatos);
		return false;
	}
	
}

function comprobarDatosUsuario(){
	var password=document.getElementById("password");
	var username=document.getElementById("username");
	username.value=username.value.trim();
	if( password.value!="" && username.value!=""){
		return true;
	}
	else{
		window.alert(advertenciaDatos);
		return false;
	}
}