/* Click on Reserv Class menu */
async function reserveClass(cName, cHour){
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
	sleep(5000).then(() => {
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

/* sleep */
function sleep (time) {
  return new Promise((resolve) => setTimeout(resolve, time));
}

sleep(2000).then(() => {
	reserveClass(localStorage.cName, localStorage.cHour);
});