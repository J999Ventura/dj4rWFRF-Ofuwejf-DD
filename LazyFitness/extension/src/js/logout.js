/* logout */
async function login(){
		var slideElement = document.getElementById('side-menu');
		var first = slideElement.firstElementChild;
		first.getElementsByTagName('a')[0].click();
		sleep(500).then(() => {
			slideElement = document.getElementById('collapse1One');
			buttons = slideElement.getElementsByTagName('a')
			var lastPosition = slideElement.getElementsByTagName('a').length - 1;
			buttons[lastPosition].click();
		});
}

/* sleep */
function sleep (time) {
  return new Promise((resolve) => setTimeout(resolve, time));
}

/* main */
sleep(2000).then(() => {
	login();
});


