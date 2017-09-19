$(function(){
	$("#settings").click(function(e){
		e.preventDefault();
		window.open("src/html/settings.html", "popup", "width=360, height=230");
	});
});

$(function(){
	var firstStep = false;
	var secondStep = false;
	$("#firstStep").click(function(e){
		if(localStorage.getItem("email") != null){
			e.preventDefault();
			var cName = $("#cName").val();
			var cHour = $("#cTime").val();
			localStorage.setItem("cName", cName);
			localStorage.setItem("cHour", cHour);
			if(cName.length <= 0 || cHour.length <= 0){
				alert("No class name or class time set.");
			}else{
				chrome.runtime.sendMessage('runScript');
			}
		}else{
			firstStep = true;
			window.open("src/html/settings.html", "popup", "width=360, height=230");
		}
	});
	$("#secondStep").click(function(e){
		e.preventDefault();
		firstStep = true;
		if(firstStep){
			secondStep = true;
			chrome.runtime.sendMessage('goToClasses');
		}else{
			alert("You need to run the first step!");
		}
	});
	$("#thirdStep").click(function(e){
		e.preventDefault();
		chrome.runtime.sendMessage('reserveClass');
	});
		$("#fourthStep").click(function(e){
		e.preventDefault();
		chrome.runtime.sendMessage('logout');
	});
});