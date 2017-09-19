chrome.runtime.onMessage.addListener(function(response, sender, sendResponse){
	if(response == "runScript"){
		var email = "'" + localStorage.email + "'";
		var pass = "'" + localStorage.pass + "'";
		var cName = "'" + localStorage.cName + "'";
		var cHour = "'" + localStorage.cHour + "'";
		chrome.tabs.executeScript(null, {
			code: 'localStorage.setItem("email",' + email + '); localStorage.setItem("pass",' + pass + '); localStorage.setItem("cName",' + cName + '); localStorage.setItem("cHour",' + cHour + ');'
		});
		chrome.tabs.executeScript(null, {file: 'src/js/login.js'});
	}
	if(response == "goToClasses"){
		chrome.tabs.executeScript(null, {file: 'src/js/goToClasses.js'});
	}
	if(response == "reserveClass"){
		chrome.tabs.executeScript(null, {file: 'src/js/reserveClass.js'});
	}
	if(response == "logout"){
		chrome.tabs.executeScript(null, {file: 'src/js/logout.js'});
	}
});
