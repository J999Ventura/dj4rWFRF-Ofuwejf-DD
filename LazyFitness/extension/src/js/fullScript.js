/* sleep */
function sleep (time) {
  return new Promise((resolve) => setTimeout(resolve, time));
}


/* login */
async function login(email, pass){
		document.getElementById('myhut-login-email').value = email;
		document.getElementById('myhut-login-password').value = pass;
		document.getElementById('b-login-form').click();
}

/* Close inicial popup */
async function closePopup(){	
		alert("enter");
		var btnPopUpL = document.getElementsByTagName('button').length;
		for(var i = 0 ; i < btnPopUpL; i++){
			alert("for = " + i);
			var element = document.getElementsByTagName('button')[i];
			if(element.innerHTML == "FECHAR"){
				element.click();
				break;
			}
		}
}

/* Click on Reserv Class menu */
async function goToclassesMenu(){
	var btnReservClassesL = document.getElementsByTagName('a').length;
	var element = null;
	for(var i = 0 ; i < btnReservClassesL; i++){
			element = document.getElementsByTagName('a')[i];
			if(element.innerHTML == "Reservar Aulas"){
				element.click();
				break;
			}
	}
}

/* Click on Reserv Class menu */
async function reserveClass(cName, cHour){
	alert(cName + " " + cHour);
	var btnMyClassL = document.getElementsByTagName('span').length;
	var hour = false;
	var myClassDiv = null;
	for(i = 0 ; i < btnMyClassL; i++){
        var element = document.getElementsByTagName('span')[i];
		if(hour && element.innerHTML == cName){
			element.scrollIntoView()
			element.click()
			break;
		}else{
			hour = false
		}
		if(element.innerHTML == cHour){     /* This code need to be at this order */
			hour = true
        }
	}
    
	/* Select element that contains all information about the 'YourClass' */
	sleep(4000).then(() => {
		var myClassDiv = element.parentNode.parentNode.parentNode.parentNode.parentNode;
			 
		/* Click on Reserve button */
		var btnResClassL = myClassDiv.getElementsByTagName('a').length;
			for(var i = 0 ; i < btnResClassL; i++){
				element = myClassDiv.getElementsByTagName('a')[i];
				if(element.innerHTML == "RESERVAR AULA"){
					element.scrollIntoView();
					element.click();
				}
			}
	});
}

sleep(2000).then(() => {
	login(localStorage.email, localStorage.pass).then(function(){
		sleep(3000).then(() => {
			closePopup().then(function(){
				sleep(2000).then(() => {
					reserveClass(localStorage.cName, localStorage.cHour);
				});
			});
		});
	});
});