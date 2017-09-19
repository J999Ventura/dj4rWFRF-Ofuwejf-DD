/* login */
async function login(email, pass){
		document.getElementById('myhut-login-email').value = email;
		document.getElementById('myhut-login-password').value = pass;
		document.getElementById('b-login-form').click();
}

/* sleep */
function sleep (time) {
  return new Promise((resolve) => setTimeout(resolve, time));
}

/* main */
sleep(2000).then(() => {
	login(localStorage.email, localStorage.pass);
});


