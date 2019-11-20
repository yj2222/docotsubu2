window.onload = function(){
	var form = document.getElementById('form');
	var formText = document.getElementById('formText');
	var formEmail = document.getElementById('formEmail');
	var formPass = document.getElementById('formPass');
	var validationMessage;

	formText.addEventListener('change', (e) => {
		var formTextVal = formText.value;
		var msg = checkHalfWidthChara(formTextVal);
		console.log(msg);
	});

	formEmail.addEventListener('change', (e) => {
//		var type = e.target.type;
		validationMessage = e.target.validationMessage;
		console.log(validationMessage);
	});

	formPass.addEventListener('change', (e) => {
		var formPassVal = formPass.value;
		var msgFlag = checkIncludeSymbol(formPassVal);
		console.log(msgFlag);
		validationMessage = putErorrMsg(msgFlag);
		console.log(validationMessage);
	});
}

function checkHalfWidthChara(val){

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
	    	erorrMsg = "使えない文字が含まれています。";
	        break;
	    case 3:
	    	erorrMsg = "条件を満たしていません。";
	        break;
	    case 4:
	    	erorrMsg = "入力してください。";
	        break;
	    case 5:
	    	erorrMsg = "入力が長すぎるか、短すぎます。";
	        break;
	}
	return erorrMsg;
}

