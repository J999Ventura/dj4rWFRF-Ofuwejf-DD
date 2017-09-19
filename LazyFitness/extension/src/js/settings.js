$(function(){
	function checkParameters(data){
		if(data.length <= 0) return false;
		return true;
	}
	$("#saveBtn").click(function(e){
		e.preventDefault();
		$("#checkResponse").remove();
		var emailData = $("#email").val();
		var passData = $("#pass").val();
		var correctEmail = checkParameters(emailData);
		var correctPass = checkParameters(passData);
		
		if(correctEmail && correctPass){
			localStorage.setItem("email", emailData);
			localStorage.setItem("pass", passData);
			$("body").append('<center><span id = "checkResponse"><b>Sucessfully saved</b></span>')
			$("#checkResponse").fadeOut(3500);
		}else{
			$("body").append('<center><span id = "checkResponse"><b style="color: red !important">Missing credencials!</b></span>')
			$("#checkResponse").fadeOut(3500);
		}
	});
	$("#checkCEmail").click(function(e){
		e.preventDefault();
		$("#checkResponse").remove();
		var cEmail;
		if(localStorage.email){
			cEmail = localStorage.getItem("email");
		}else{
			cEmail = "No email storage!";
		}
		$("body").append('<center><span id = "checkResponse"><b>Email = ' + cEmail + '</b></span>')	
		$("#checkResponse").fadeOut(3500);
	});
});