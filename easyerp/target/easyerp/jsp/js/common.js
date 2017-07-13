// ソード
    //反転用のフラグ
    var rev;
    var  old_obj;
    function shwIcon(thobj,num){
        //反転用のフラグの初期化
        if(window.rev == undefined ){
        	window.rev = Object();
        	window.rev.n = -1;
        }

        if(window.rev.n==num){
            // 同じＴＤをクリック
        	window.rev.f = ! window.rev.f;
            // 反転
            if(window.rev.f){
                thobj.setAttribute("className", "tablesorter-headerDesc");
            }else{
                thobj.setAttribute("className", "tablesorter-headerAsc");
            }
        } else {
            thobj.setAttribute("className", "tablesorter-headerAsc");
            //前のTDに復旧
            if( window.old_obj != undefined ){
            	window.old_obj.setAttribute("className", "tablesorter-header");
            }
            window.rev.n = num;
            window.rev.f = false;
        }
        window.old_obj = thobj;
        return window.rev.f;
    }

 // ================================
 // ウィンドを開けるの処理
 // ================================
   function open_FullWin(url){
       	window.open(url, '', 'left=0,top=0,WIDTH=' + (window.screen.availWidth - 10) +',HEIGHT='+ (window.screen.availHeight-50) +',resizable=yes, scrollbars=no,status=yes');
    }
	//800*600のPOP画面を開ける
	function open_newWin(url)
	{
		window.open(url, '', 'left=0,top=0,WIDTH=800,HEIGHT=600,scrollbars=yes,status=yes');
	}

	//1024*768のPOP画面を開ける
	function open_newWin2(url)
	{
		window.open(url, '', 'left=0,top=0,WIDTH=1012,HEIGHT=710,resizable=yes, scrollbars=no,status=yes');
	}

	//指定幅さと高さのPOP画面を開ける
	function open_newWinSetXYWH(url,x,y,w,h)
	{
		window.open(url, '', 'left='+ x +',top='+ y +',WIDTH='+ w +',HEIGHT='+ h +', scrollbars=no, status=yes');
	}

	//指定IFRAME中に、指定URLの画面を開ける
	function open_subfrmWin(url,subframename)
	{
		document.all(subframename).src = url;
	}

	//同じウインド中に、指定URLの画面を開ける
	function open_samefrmWin(url)
	{
		window.location.href = url;
	}


// ================================
// ウィンドを閉めるの処理
// ================================

	//該当画面を閉める
	function frm_close()
	{
		window.close();
	}

	//該当画面の親画面を閉める
	function subfrm_close()
	{
		parent.window.close();
	}


// ================================
// 画面項目の処理
// ================================

	//明細データのヘッドとボディをスクロールで移動関連
	function doScroll()
	{
		parent.frames.Fr_THead.document.body.scrollLeft=document.body.scrollLeft;
	}

	//明細データのヘッドとボディをスクロールで移動関連
	function doScroll_head2()
	{
		parent.frames.Fr_MTHead.document.body.scrollLeft=document.body.scrollLeft;
	}

// ================================
// 入力項目のチェック
// ================================

	// 文字左側に指定の文を記入
	function padCharLeft(strStr, num, strFillChar) {
		var temp = "";
		var intLength = num - strStr.length;
		for(var i=0; i < intLength; i++) {
			temp += strFillChar;
		}
		temp = temp + strStr;
		return temp;
	}

	// 閏年のチェック
	function checkLeapYear(strDate) {
		var dateValue = new Date(strDate);
		var intYear = dateValue.getFullYear();

		if (((intYear % 4 == 0) && (intYear % 100 != 0)) || (intYear % 400 == 0)) {
			 return true;
		}
		return false;
	}

	// 日付書式の変換 YYYY/MM/DD
	function changeDateFormat(strYYYYMMDD) {
		var strTemp, strYMD, stryear, strmonth, strdate;
		var tmp, strNewDate;

		strTemp = strYYYYMMDD;
		strTemp = strTemp.replace(/-/g,"/");
		strYMD = strTemp.split("/");
		stryear  = strYMD[0];
		strmonth = strYMD[1];
		strdate  = strYMD[2];

		strNewDate  = padCharLeft(stryear,4,"0");
		strNewDate += "/" + padCharLeft(strmonth,2,"0");
		strNewDate += "/" + padCharLeft(strdate,2,"0");

		return strNewDate;
	}

	// 日付書式の変換 YYYYMMDD
	function changeDateFormatYMD2(strYYYYMMDD) {
		var strTemp, strYMD, stryear, strmonth, strdate;
		var tmp, strNewDate;

		strTemp = strYYYYMMDD;
		stryear = strTemp.substr(0,4);
		strmonth = strTemp.substr(4,2);
		strdate = strTemp.substr(6,2);

		strNewDate  = padCharLeft(stryear,4,"0");
		strNewDate += "/" + padCharLeft(strmonth,2,"0");
		strNewDate += "/" + padCharLeft(strdate,2,"0");

		return strNewDate;
	}

	// 日付書式の変換 YYYY/MM
	function changeDateFormat2(strYYYYMM) {
		var strTemp, strYMD, stryear, strmonth;
		var tmp, strNewDate;

		strTemp = strYYYYMM;
		strTemp = strTemp.replace(/-/g,"/");
		strYMD = strTemp.split("/");
		stryear  = strYMD[0];
		strmonth = strYMD[1];

		strNewDate  = padCharLeft(stryear,4,"0");
		strNewDate += "/" + padCharLeft(strmonth,2,"0");

		return strNewDate;
	}

	// 日付書式の変換 YYYYMM
	function changeDateFormatYM2(strYYYYMM) {
		var strTemp, strYMD, stryear, strmonth, strdate;
		var tmp, strNewDate;

		strTemp = strYYYYMM;
		stryear = strTemp.substr(0,4);
		strmonth = strTemp.substr(4,2);

		strNewDate  = padCharLeft(stryear,4,"0");
		strNewDate += "/" + padCharLeft(strmonth,2,"0");

		return strNewDate;
	}

	// 日付書式のチェック YYYY/MM/DD
	function checkDateYYYYMMDD(strDate) {
		var strValue, strArrayDate, intYear, intMonth, intDate, strTemp;
		strTemp = strDate;
		strTemp = strTemp.replace(/-/g,"/");
		strValue = new String(strTemp);
		var regex = /^[0-9]{4}(-|\/)[0-9]{1,2}(-|\/)[0-9]{1,2}$/g;
		if (!regex.test(strValue)) return false;
		strArrayDate = strTemp.split("/");
		intYear = strArrayDate[0] * 1;
		intMonth = strArrayDate[1] * 1;
		intDate = strArrayDate[2] * 1;
		if (intMonth == 1 || intMonth == 3 || intMonth == 5 || intMonth == 7 || intMonth == 8 || intMonth == 10 || intMonth == 12) {
			if (intDate > 31 || intDate <= 0) return false;
		}else if(intMonth == 4 || intMonth == 6 || intMonth == 9 || intMonth == 11) {
			if (intDate > 30 || intDate <= 0) return false;
		}else if(intMonth == 2){
			if (checkLeapYear(strTemp)) {
				if (intDate > 29 || intDate <= 0) return false;
			} else {
				if (intDate > 28 || intDate <= 0) return false;
			}
		}else{
			return false;
		}
		return true;
	}

	// 日付書式のチェック2 YYYYMMDD
	function checkDateYYYYMMDD2(strDate) {

		var strValue, intYear, intMonth, intDate, strTemp;
		strTemp = strDate;
		strValue = strTemp;

		var regex = /^[0-9]{8}$/g;
		if (!regex.test(strValue)) return false;

		intYear = strValue.substr(0,4) * 1;
		intMonth = strValue.substr(4,2) * 1;
		intDate = strValue.substr(6,2) * 1;

		if (intMonth == 1 || intMonth == 3 || intMonth == 5 || intMonth == 7 || intMonth == 8 || intMonth == 10 || intMonth == 12) {
			if (intDate > 31 || intDate <= 0) return false;
		}else if(intMonth == 4 || intMonth == 6 || intMonth == 9 || intMonth == 11) {
			if (intDate > 30 || intDate <= 0) return false;
		}else if(intMonth == 2){
			if (checkLeapYear(strTemp)) {
				if (intDate > 29 || intDate <= 0) return false;
			} else {
				if (intDate > 28 || intDate <= 0) return false;
			}
		}else{
			return false;
		}
		return true;
	}

	// 日付書式のチェック YYYY/MM
	function checkDateYYYYMM(strDate) {

		var strValue, strArrayDate, intYear, intMonth, intDate, strTemp;
		strTemp = strDate;
		strTemp = strTemp.replace(/-/g,"/");
		strValue = new String(strTemp);

		var regex = /^[0-9]{4}(-|\/)[0-9]{1,2}$/g;
		if (!regex.test(strValue)) return false;

		strArrayDate = strTemp.split("/");
		intYear = strArrayDate[0] * 1;
		intMonth = strArrayDate[1] * 1;
		intDate = 1;

		if (intMonth < 1 || intMonth > 12) {
			return false;
		}

		return true;
	}

	// 日付書式のチェック YYYYMM
	function checkDateYYYYMM2(strDate) {

		var strValue, strArrayDate, intYear, intMonth, intDate, strTemp;
		strTemp = strDate;
		strValue = strTemp;

		var regex = /^[0-9]{6}$/g;
		if (!regex.test(strValue)) return false;

		intYear = strValue.substr(0,4) * 1;
		intMonth = strValue.substr(4,2) * 1;

		if (intMonth < 1 || intMonth > 12) {
			return false;
		}

		return true;
	}

	// 入力年月日の書式を「yyyy/mm/dd」へ変換
	function inputYYYYMMDD(objInput)
	{
		if (!objInput.disabled) {
			if ((objInput.value).length > 0) {
				if (checkDateYYYYMMDD2(objInput.value)) {
					// 日付書式の変換
					objInput.value = changeDateFormatYMD2(objInput.value);
				}else if (checkDateYYYYMMDD(objInput.value)) {
					// 日付書式の変換
					objInput.value = changeDateFormat(objInput.value);
				}
			}
		}
	}


	// 入力年月の書式を「yyyy/mm」へ変換
	function inputYYYYMM(objInput)
	{
		if (!objInput.disabled) {
			if ((objInput.value).length > 0) {
				if (checkDateYYYYMM2(objInput.value)) {
					// 日付書式の変換
					objInput.value = changeDateFormatYM2(objInput.value);
				}else if(checkDateYYYYMM(objInput.value)) {
					// 日付書式の変換

					objInput.value = changeDateFormat2(objInput.value);
					}
			}
		}
	}

	// 数字かのチェック
	function checkNum(strValue){
		var regex = /^((-)?\d{1,3}(\,\d{3})*(\.\d+)?|(-)?\d+(\.\d+)?)$/g;
		if (regex.test(strValue)) {
			return true;
		}
		return false;
	}

	// 数字の変換（9,999 => 9999）
	function remCommas(strValue){
		var regex = /\,/;
		var temp = strValue;
		while (regex.test(temp)) {
			temp = temp.replace(regex,'');
			temp = temp.replace(' ','');
		}
		return temp;
	}

	// 数字の変換（9999 => 9,999）
	function addCommas(strValue)
	{
		strValue += '';
		x = strValue.split('.');
		x1 = x[0];
		x2 = x.length > 1 ? '.' + x[1] : '';
		var regex = /(\d+)(\d{3})/;
		while (regex.test(x1)) {
			x1 = x1.replace(regex, '$1' + ',' + '$2');
		}
		return x1 + x2;
	}


	// 電話とFAXかのチェック
	function checkTEL_FAX(strValue){
		if (strValue == null || strValue == "") return true;
		var regex = /[^0123456789 -]/g;
		if (regex.test(strValue)) {
			return false;
		}
		return true;
	}

	// 文字の半角長さを判断
	function ChkLen(str){
		var len = 0;
		for(var i = 0; i < str.length; i++) {
			var c = str.charCodeAt(i);
			if(c < 256 || (c >= 0xff61 && c <= 0xff9f)) {
				len=len+1;	// 半角
			}else{
				len=len+2;	// 全角
			}
		}
		return len;
	}


    scrollFunc = function(e){
    	e=e?e:event;
        $("#divData_r").scrollTop($("#divData_r").scrollTop()+(e.wheelDelta*-1));
    };
