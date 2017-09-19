/* Close inicial popup */
async function closePopup(){	
		var btnPopUpL = document.getElementsByTagName('button').length;
		for(var i = 0 ; i < btnPopUpL; i++){
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

/* Sleep */
function sleep (time) {
  return new Promise((resolve) => setTimeout(resolve, time));
}

sleep(2000).then(() => {
	closePopup().then(function(){
		sleep(1000).then(() => {
			goToclassesMenu();
		});
	});
});