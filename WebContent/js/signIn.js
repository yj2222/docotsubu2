window.onload = function(){
	var form = document.getElementById('form');
	var formNickName = document.getElementById('formNickName');
	var formEmail = document.getElementById('formEmail');
	var formPass = document.getElementById('formPass');
	var validationMessage;

	formNickName.addEventListener('change', (e) => {
		var formNickNameVal = formNickName.value;
		var msgFlag = checkHalfWidthChara(formNickNameVal);
		validationMessage = putErorrMsg(msgFlag);
		ChangeText(formNickName, validationMessage);
	});

	formEmail.addEventListener('change', (e) => {
		var type = e.target.type;
		validationMessage = "※" + e.target.validationMessage;
		ChangeText(formEmail, validationMessage);
	});

	formPass.addEventListener('change', (e) => {
		var formPassVal = formPass.value;
		var msgFlag = checkIncludeSymbol(formPassVal);
		validationMessage = putErorrMsg(msgFlag);
		ChangeText(formPass, validationMessage);
	});
}

function checkHalfWidthChara(val){
	var flag = 0;
	if(val.length >= 4 && val.length <= 8){
		if(val.match(/[^a-zA-Z0-9]/)){
			flag = 2;
		}else if( val.match(/[a-zA-Z0-9]/) ){
			flag = 1;
		} else{
			flag = 3;
		}
	} else {
		if(val.length == 0){
			flag = 4;
		}else if(val.length <= 3 || val.length >= 9){
			flag = 5;
		}
	}
	return flag;
}

function checkIncludeSymbol(val){
	var flag = 0;
	if(val.length >= 4 && val.length <= 8){
		if(val.match(/[^a-zA-Z0-9\+\-=!%]/)){
			flag = 2;
		}else if( (val.match(/[a-zA-Z0-9]/)) && (val.match(/[\+\-=!%]/)) ){
			flag = 1;
		} else{
			flag = 3;
		}
	} else {
		if(val.length == 0){
			flag = 4;
		}else if(val.length <= 3 || val.length >= 9){
			flag = 5;
		}
	}
	return flag;
}

function putErorrMsg(num){
	var erorrMsg;
	switch(num) {
		case 1:
	    	erorrMsg = "";
	        break;
	    case 2:
	    	erorrMsg = "※使えない文字が含まれています。";
	        break;
	    case 3:
	    	erorrMsg = "※条件を満たしていません。";
	        break;
	    case 4:
	    	erorrMsg = "※入力してください。";
	        break;
	    case 5:
	    	erorrMsg = "※入力が長すぎるか、短すぎます。";
	        break;
	}
	return erorrMsg;
}

function ChangeText(ele, txt) {
	ele.nextElementSibling.innerHTML = txt;
}


