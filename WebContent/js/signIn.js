window.onload = function(){
	// 各フォームの要素を指定。
	var form = document.getElementById('form');
	var formNickName = document.getElementById('formNickName');
	var formEmail = document.getElementById('formEmail');
	var formPass = document.getElementById('formPass');
	var validationMessage;
	var signInBtn = document.getElementById('signInBtn');
	var errorMsg = document.getElementsByClassName('errorMsg');
	var btnFlag1 = 1;
	var btnFlag2 = 1;
	var btnFlag3 = 1;

	signInBtn.disabled = true;

	// ニックネームフォームのバリデーション。
	formNickName.addEventListener('change', (e) => {
		var formNickNameVal = formNickName.value;
		// 半角英数字のチェック。チェック後フラグに応じて出力メッセージを選定。
		var msgFlag = checkHalfWidthChara(formNickNameVal);
		validationMessage = putErorrMsg(msgFlag);
		ChangeText(formNickName, validationMessage);
		btnFlag1 = msgFlag;
		ChangButtonState();
	});

	// メールフォームのバリデーション。
	formEmail.addEventListener('change', (e) => {
		var type = e.target.type;
		// デフォルトのバリデーションメッセージを使用。
		if (e.target.validationMessage){
			validationMessage = "※" + e.target.validationMessage;
			btnFlag2 = 1;
		} else{
			validationMessage = "";
			btnFlag2 = 0;
		}
		ChangeText(formEmail, validationMessage);
		ChangButtonState();
	});

	// パスワードフォームのバリデーション。
	formPass.addEventListener('change', (e) => {
		var formPassVal = formPass.value;
		// 半角英数字＋記号が含まれているかチェック。チェック後フラグに応じて出力メッセージを選定。
		var msgFlag = checkIncludeSymbol(formPassVal);
		validationMessage = putErorrMsg(msgFlag);
		ChangeText(formPass, validationMessage);
		btnFlag3 = msgFlag;
		ChangButtonState();
	});

	// ボタン有効化関数
	function ChangButtonState() {
		if (formNickName.value != "" && formEmail.value != "" && formPass.value != ""){
			var flagTotal = btnFlag1 + btnFlag2 + btnFlag3;
			if(flagTotal == 0){
				signInBtn.disabled = false;
				signInBtn.style.backgroundColor = "#00BFFF";
			}
		}
	}
}

// 半角のチェック関数。
function checkHalfWidthChara(val){
	var flag = 1;
	if(val.length >= 4 && val.length <= 8){
		if(val.match(/[^a-zA-Z0-9]/)){
			flag = 2;
		}else if( val.match(/[a-zA-Z0-9]/) ){
			flag = 0;
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

//半角＋記号のチェック関数。
function checkIncludeSymbol(val){
	var flag = 1;
	if(val.length >= 4 && val.length <= 8){
		if(val.match(/[^a-zA-Z0-9\+\-=!%]/)){
			flag = 2;
		}else if( (val.match(/[a-zA-Z0-9]/)) && (val.match(/[\+\-=!%]/)) ){
			flag = 0;
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

// バリデーションメッセージ選定の関数。
function putErorrMsg(num){
	var erorrMsg;
	switch(num) {
		case 0:
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

// バリデーションメッセージのHTMLのテキスト書き換え関数。
function ChangeText(ele, txt) {
	ele.nextElementSibling.innerHTML = txt;
}

