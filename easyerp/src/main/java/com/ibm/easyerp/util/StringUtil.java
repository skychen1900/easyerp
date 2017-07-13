package com.ibm.easyerp.util;

import com.ibm.easyerp.base.ComConst;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 文字列編集クラス
 */

public class StringUtil {

    /** 全角カナ文字列 */
    private static final char[] ZENKAKU_KATAKANA = {'ァ', 'ア', 'ィ', 'イ', 'ゥ', 'ウ', 'ェ', 'エ', 'ォ', 'オ', 'カ', 'ガ', 'キ',
            'ギ', 'ク', 'グ', 'ケ', 'ゲ', 'コ', 'ゴ', 'サ', 'ザ', 'シ', 'ジ', 'ス', 'ズ', 'セ', 'ゼ', 'ソ', 'ゾ', 'タ', 'ダ', 'チ', 'ヂ',
            'ッ', 'ツ', 'ヅ', 'テ', 'デ', 'ト', 'ド', 'ナ', 'ニ', 'ヌ', 'ネ', 'ノ', 'ハ', 'バ', 'パ', 'ヒ', 'ビ', 'ピ', 'フ', 'ブ', 'プ',
            'ヘ', 'ベ', 'ペ', 'ホ', 'ボ', 'ポ', 'マ', 'ミ', 'ム', 'メ', 'モ', 'ャ', 'ヤ', 'ュ', 'ユ', 'ョ', 'ヨ', 'ラ', 'リ', 'ル', 'レ',
            'ロ', 'ヮ', 'ワ', 'ヰ', 'ヱ', 'ヲ', 'ン', 'ヴ', 'ヵ', 'ヶ'};

    /** 半角カナ文字列 */
    private static final String[] HANKAKU_KATAKANA = {"ｧ", "ｱ", "ｨ", "ｲ", "ｩ", "ｳ", "ｪ", "ｴ", "ｫ", "ｵ", "ｶ", "ｶﾞ", "ｷ",
            "ｷﾞ", "ｸ", "ｸﾞ", "ｹ", "ｹﾞ", "ｺ", "ｺﾞ", "ｻ", "ｻﾞ", "ｼ", "ｼﾞ", "ｽ", "ｽﾞ", "ｾ", "ｾﾞ", "ｿ", "ｿﾞ", "ﾀ", "ﾀﾞ",
            "ﾁ", "ﾁﾞ", "ｯ", "ﾂ", "ﾂﾞ", "ﾃ", "ﾃﾞ", "ﾄ", "ﾄﾞ", "ﾅ", "ﾆ", "ﾇ", "ﾈ", "ﾉ", "ﾊ", "ﾊﾞ", "ﾊﾟ", "ﾋ", "ﾋﾞ", "ﾋﾟ",
            "ﾌ", "ﾌﾞ", "ﾌﾟ", "ﾍ", "ﾍﾞ", "ﾍﾟ", "ﾎ", "ﾎﾞ", "ﾎﾟ", "ﾏ", "ﾐ", "ﾑ", "ﾒ", "ﾓ", "ｬ", "ﾔ", "ｭ", "ﾕ", "ｮ", "ﾖ",
            "ﾗ", "ﾘ", "ﾙ", "ﾚ", "ﾛ", "ﾜ", "ﾜ", "ｲ", "ｴ", "ｦ", "ﾝ", "ｳﾞ", "ｶ", "ｹ", "ﾞ", "ﾟ", "ｰ"};

    /** 全角カナ 'ァ'を取得 */
    private static final char ZENKAKU_KATAKANA_FIRST_CHAR = ZENKAKU_KATAKANA[0];

    /** 全角カナ 'ヶ'を取得 */
    private static final char ZENKAKU_KATAKANA_LAST_CHAR = ZENKAKU_KATAKANA[ZENKAKU_KATAKANA.length - 1];

    /**
     * 隠蔽されたコンストラクタ
     */
    private StringUtil() {
    }
    
	/**
	 * 有効文字列に判断、""は無効です。
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isValidStr(String str) {
		
		return str != null && str.trim().length() > 0;
	}

	/**
	 * 文字列にBigDecimalに転換する。
	 * 
	 * @param str
	 * @return　BigDecimal
	 */
	public static BigDecimal getStrToBigDecimal(String str) {
		BigDecimal result = new BigDecimal(0);
		if (!isValidStr(str)) {
			return result;
		}
		try {
			result = new BigDecimal(str);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		return result;
	}

    /**
     * 引数numが整数で構成された文字列であるかを判定する
     *
     * @param num
     * @return boolean
     */
    public static boolean isNum(String num) {
		 if(num==null || "".equals(num))
		 return true;
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(num).matches();
    }
    /**
     * 引数numが浮動小数で構成された文字列であるかを判断する。
     *
     * @param str
     * @return
     */
	public static boolean isDecimal(String num) {
		 if(num==null || "".equals(num))
		 return true;
		 Pattern pattern = Pattern.compile("-?[0-9]*(\\.)?[0-9]{0,2}");
		 return pattern.matcher(num).matches();
		 }
    /**
     * 引数numが整数で構成された文字列であるかを判定する
     *
     * @param num
     * @return boolean
     */
    public static boolean isInteger(String num) {
        Pattern pattern = Pattern.compile("\\-?[0-9]*");
        return pattern.matcher(num).matches();
    }
    /**
     * 文字列の文字がヌル又は長さ0判定
     *
     * @param checkField
     *            String
     * @param field
     *            String
     * @param errors
     *            ActionErrors
     * @return 正しければtrue
     */
    public static boolean isNull(String fieldValue) {
        boolean flg = false;
        if (fieldValue == null || fieldValue.length() == 0) {
            flg = true;
        }
        return flg;
    }
    /**
     * リストがヌル又は長さ0判定
     *
     * @param list
     *            List
     * @return 正しければtrue
     */
    public static boolean isNull(List<?> list){
    	boolean flg = false;

    	if(list == null || list.size() == 0){
    		flg = true;
    	}
    	return flg;
    }
    /**
     * 文字列の桁数として正しいかどうかをチェックする。 nullの場合はtrue扱いとする。
     *
     * @param checkField
     *            String
     * @param fixedlen
     *            int
     * @param field
     *            String
     * @param errors
     *            ActionErrors
     * @return 正しければtrue
     */
    public static boolean isFixedLen(String fieldValue, int fixedlen) {
        boolean fixedlenFlg = true;
        try {
            if (!isBlankOrNull(fieldValue)) {
                if (fieldValue.length() != fixedlen) {
                    fixedlenFlg = false;
                }
            }
        } catch (Exception e) {
            fixedlenFlg = false;
        }
        return fixedlenFlg;
    }
        
    /**
     * 文字列が全角文字のみで構成された文字列かどうかをチェックする。 ただし、Unicodeの文字表と比較するのは迂遠なので、
     * utf-8に変換したときのバイト長がちょうど文字列長の3倍 になっているかどうかのチェックで代用する。
     * nullの場合はtrue扱いとする。
     *
     * @param checkField
     *            String
     * @param field
     *            String
     * @param errors
     *            ActionErrors
     * @return 正しければtrue
     */
    public static boolean isZenkaku(String fieldValue) {
        boolean flg = true;
        try {
            if (!isBlankOrNull(fieldValue)) {
                byte[] b = fieldValue.getBytes(ComConst.ENCODING_UTF_8);
                if (b.length != 3 * fieldValue.length()) {
                    flg = false;
                }
            }
        } catch (Exception e) {
            flg = false;
        }
        return flg;
    }

    /**
     * 半角カナは正しいかどうかをチェックする。 nullの場合はtrue扱いとする。
     *
     * @param checkField
     *            String
     * @param field
     *            String
     * @param errors
     *            ActionErrors
     * @return 正しければtrue
     */
    public static boolean isHankana(String fieldValue) {
        boolean flg = true;
        try {
            if (!isBlankOrNull(fieldValue)) {
                String str1 = "";
                for (int i = 0; i < fieldValue.length(); i++) {

                    // 文字列を１文字ずつ調べる
                    String str = fieldValue.substring(i, i + 1);
                    // カナ配列長度取得
                    int ikanalength = HANKAKU_KATAKANA.length;
                    for (int j = 0; j < ikanalength; j++) {
                        str1 = HANKAKU_KATAKANA[j];

                        if (str1.equals(str)) {
                            break;
                        }
                        if (j == ikanalength - 1) {
                            return false;

                        }
                    }
                }

            }
        } catch (Exception e) {
            flg = false;
        }
        return flg;
    }
    /**
     * 文字列が半角文字のみで構成された文字列かどうかをチェックする。 ただし、Unicodeの文字表と比較するのは迂遠なので、
     * UTF-8に変換したときのバイト長がちょうど文字列長と等しい かどうかのチェックで代用する。 nullの場合はtrue扱いとする。
     *
     * @param checkField
     *            String
     * @param field
     *            String
     * @param errors
     *            ActionErrors
     * @return 正しければtrue
     */
    public static boolean isHankaku(String fieldValue) {
        boolean flg = true;
        try {
            if (!isBlankOrNull(fieldValue)) {
                byte[] b = fieldValue.getBytes(ComConst.ENCODING_UTF_8);
                if (b.length != fieldValue.length()) {
                    flg = false;
                }
            }
        } catch (Exception e) {
            flg = false;
        }
        return flg;
    }

    /**
     * 半角数字は正しいかどうかをチェックする。 nullの場合はtrue扱いとする。
     *
     * @param checkField
     *            String
     * @param field
     *            String
     * @param errors
     *            ActionErrors
     * @return 正しければtrue
     */
    public static boolean isNumber(String fieldValue) {
        boolean flg = true;
        try {
            if (!isBlankOrNull(fieldValue)) {
                for (int i = 0; i < fieldValue.length(); i++) {
                    char c = fieldValue.charAt(i);
                    char c1 = '0';
                    char c2 = '9';
                    if (c < c1 || c > c2) {
                        flg = false;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            flg = false;
        }
        return flg;
    }
    /**
     * 半角英数字は正しいかどうかをチェックする。 nullの場合はtrue扱いとする。
     *
     * @param checkField
     *            String
     * @param field
     *            String
     * @param errors
     *            ActionErrors
     * @return 正しければtrue
     */
    public static boolean isAlphaNumber(String fieldValue) {
        boolean flg = true;
        try {
            if (!isBlankOrNull(fieldValue)) {
                for (int i = 0; i < fieldValue.length(); i++) {
                    char c = fieldValue.toLowerCase().charAt(i);
                    char c1 = '0';
                    char c2 = '9';
                    char c3 = 'A';
                    char c4 = 'z';
                    if ((c < c1 || c > c2) && (c < c3 || c > c4)) {
                        flg = false;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            flg = false;
        }
        return flg;
    }

    /**
     * 日付は正しいかどうかをチェックする。 nullの場合はtrue扱いとする。
     *
     * @param checkField
     *            String
     * @param field
     *            String
     * @param errors
     *            ActionErrors
     * @return 正しければtrue
     */
    public static boolean isDate(String fieldValue) {
        boolean flg = true;

        try {
            if (!isBlankOrNull(fieldValue)) {
//                if (!isNum(fieldValue)) {
//                    return false;
//                }
                String format = "yyyyMMdd";
                if (fieldValue.length() != 8) {
                    if  (fieldValue.length() != 10) {
                        return false;
                    } else {
                        format = "yyyy/MM/dd";
                    }
                }
//                System.out.println(format);
//                System.out.println(fieldValue);
                DateFormat df = new SimpleDateFormat(format);
                df.setLenient(false);
                df.parse(fieldValue);
            }
        } catch (Exception e) {
            flg = false;
        }
        return flg;
    }
    /**
     * 引数の文字列が null または空文字列かどうかをチェックする。 StrutsのGenericValidatorの同名メソッドと異なり、 文字列を
     * trim() せずにそのままチェックする。
     *
     * @param value
     *            チェック対象文字列
     * @return nullまたは空ならtrue、それ以外はfalse
     */
    private static boolean isBlankOrNull(String value) {
        return value == null || value.length() == 0;
    }
    
    
    /**
     * 左側の空白（半角・全角スペース）を除去する。
     *
     * @param value
     *            文字列
     * @return 空白を除去した文字列
     */
    public static String lTrim(String value) {
        char[] val = value.toCharArray();
        int len = val.length;
        int pos = 0;

        while ((pos < len) && (val[pos] <= ' ' || val[pos] == '　')) {
            pos++;
        }
        return (pos > 0) ? value.substring(pos) : value;
    }

    /**
     * 右側の空白（半角・全角スペース）を除去する。
     *
     * @param value
     *            文字列
     * @return 空白を除去した文字列
     */
    public static String rTrim(String value) {
        char[] val = value.toCharArray();
        int len = val.length;
        int pos = len;

        while ((0 < pos) && (val[pos - 1] <= ' ' || val[pos - 1] == '　')) {
            pos--;
        }
        return (pos > 0) ? value.substring(0, pos) : value;
    }

    /**
     * 両側の空白（半角・全角スペース）を除去する。
     *
     * @param value
     *            文字列
     * @return 空白を除去した文字列
     */
    public static String trim(String value) {
        return rTrim(lTrim(value));
    }

    /**
     * 指定サイズになるようにtargetStringの前をゼロ埋めする
     *
     * @param targetString
     * @param size
     * @return targetを前ゼロ埋めした文字列
     */
    static public String padZero(String targetString, int size) {

        targetString = convertNullToBlank(targetString);

        int targetSize = targetString.length();
        while (targetSize++ < size) {
            targetString = "0" + targetString;
        }

        return targetString;
    }

    /**
     * 指定サイズになるようにtargetの前をゼロ埋めする
     *
     * @param target
     * @param size
     * @return targetを前ゼロ埋めした文字列
     */
    static public String padZero(int target, int size) {
        String targetString = String.valueOf(target);
        return padZero(targetString, size);
    }

    /**
     * 指定サイズになるようにtargetStringの後ろをゼロ埋めする
     *
     * @param targetString
     * @param size
     * @return targetを後ろゼロ埋めした文字列
     */
    static public String padZeroAfter(String targetString, int size) {

        targetString = convertNullToBlank(targetString);

        int targetSize = targetString.length();
        while (targetSize++ < size) {
            targetString = targetString + "0";
        }

        return targetString;
    }

    /**
     * 指定サイズになるようにtargetStringの前をスペース埋めする
     *
     * @param targetString
     * @param size
     * @return targetを前スペース埋めした文字列
     */
    static public String padSpace(String targetString, int size) {

        targetString = convertNullToBlank(targetString);

        int targetSize = targetString.length();
        while (targetSize++ < size) {
            targetString = " " + targetString;
        }

        return targetString;
    }

    /**
     * 指定サイズになるようにtargetStringの前をスペース埋めする
     *
     * @param targetString
     * @param size
     * @return targetを前スペース埋めした文字列
     */
    static public String padSpaceAfter(String targetString, int size) {

        targetString = convertNullToBlank(targetString);
        int targetSize = targetString.getBytes().length;
        if (targetSize > size) {
            return targetString.substring(0, size);
        }
        while (targetSize++ < size) {
            targetString = targetString + " ";
        }

        return targetString;
    }

    /**
     * 対象文字列がnullであれば空文字に変換します。
     *
     * @param str
     *            対象文字列
     * @return 変換後文字列
     */
    public static String convertNullToBlank(String str) {
        return (str == null) ? "" : str;
    }

    /**
     * 対象文字列がnullであれば空欄に変換します。
     *
     * @param str
     *            対象文字列
     * @return 変換後文字列
     */
    public static String convertNullToSpace(String str) {
        if (str == null)
            return ("&nbsp;");

        StringBuffer result = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '<')
                result.append("&lt;");
            else if (ch == '>')
                result.append("&gt;");
            else if (ch == '&')
                result.append("&amp;");
            else if (ch == '"')
                result.append("&quot;");
            else if (ch == '\r')
                result.append("<BR>");
            else if (ch == '\n') {
                if (i > 0 && str.charAt(i - 1) == '\r') {

                } else {
                    result.append("<BR>");
                }
            } else if (ch == '\t')
                result.append("&nbsp;&nbsp;&nbsp;&nbsp");
            else if (ch == ' ')
                result.append("&nbsp;");
            else
                result.append(ch);
        }
        return (result.toString());
    }

    /**
     * 指定サイズの空文字を返す
     *
     * @param size
     * @return 空文字
     */
    static public String makeSpace(int size) {

        int spaceSize = 0;
        String space = "";
        while (spaceSize < size) {
            space = space + " ";
            spaceSize++;
        }

        return space;
    }

    /**
     * 数値を#,##0フォーマットの文字列に変換する
     *
     * @param num
     * @return String
     */
    public static String getFormatNumber(int num) {

        DecimalFormat dfZ9 = new DecimalFormat("#,##0");
        String fmtNum = "";

        try {

            fmtNum = dfZ9.format(num);

            return fmtNum;

        } catch (Exception e) {
            return fmtNum;
        }

    }

    /**
     * 数値を#,##0フォーマットの文字列に変換する
     *
     * @param num
     * @return String
     */
    public static String getFormatNumber(long num) {

        DecimalFormat dfZ9 = new DecimalFormat("#,##0");
        String fmtNum = "";

        try {

            fmtNum = dfZ9.format(num);

            return fmtNum;
        } catch (Exception e) {
            return fmtNum;
        }

    }
    /**
     * 文字列をバイト指定で左から切り出す
     *
     * @param str
     *            文字列
     * @param size
     *            バイト長
     * @return 切り出した文字列
     */
    public static String leftB(String str, int size) {
        int len = str.length();
        try {
            int outLen = 0;
            int strLen = str.length();
            char chr = ' ';
            String outStr = "";
            for (int i = 0; i < strLen; ++i) {
                chr = str.charAt(i);
                outLen += String.valueOf(chr).getBytes("Shift_JIS").length;
                if (outLen > size) {
                    outStr = str.substring(0, i);
                    return outStr;
                }
            }
            return str;
        } catch (UnsupportedEncodingException ex) {
            // だめなら通常の切り出し
            if (len > size) {
                len = size;
            }
            return str.substring(0, len);
        }
    }
    /**
     * 文字列をバイト指定でChar 長を取得
     *
     * @param str
     *            文字列
     * @param size
     *            バイト長
     * @return Char 長
     */
    public static int getCharLength(String str, int size) {
        int len = str.length();
        try {
            int outLen = 0;
            int strLen = str.length();
            char chr = ' ';
            for (int i = 0; i < strLen; ++i) {
                chr = str.charAt(i);
                outLen += String.valueOf(chr).getBytes(ComConst.ENCODING_UTF_8).length;
                if (outLen > size) {
                    return i;
                }
            }
            return size;
        } catch (UnsupportedEncodingException ex) {
            // だめなら通常の切り出し
            if (len > size) {
                len = size;
            }
            return len;
        }
    }
    
    /**
     * 半角数字を全角数字に変換
     *
     * @param s
     * @return 全角数字
     */
    public static String convertHankakuNumToZenkakuNum(String s) {
        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                sb.setCharAt(i, (char) (c - '0' + '０'));
            }
        }
        return sb.toString();
    }

    /**
     * 全角数字を半角数字に変換
     *
     * @param s
     * @return 半角数字
     */
    public static String convertZenkakuNumToHankakuNum(String s) {
        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c >= '０' && c <= '９') {
                sb.setCharAt(i, (char) (c - '０' + '0'));
            }
        }
        return sb.toString();
    }
    
    /**
     * 最大文字数チェック
     *
     * @param arg
     *            預処理的文字串
     * @param maxLen
     *            最大長度（半角）
     * @return true - 最大長度以内(包括最大長度); false - 超出最大長度
     */
    public static boolean maxLengthCheck(String arg, int maxLen) {

        int len = 0;
        int strLen = arg.length();
        char chr = ' ';
        try {
            for (int i = 0; i < strLen; ++i) {
                chr = arg.charAt(i);
                len += String.valueOf(chr).getBytes(ComConst.ENCODING_UTF_8).length;
            }
        } catch (UnsupportedEncodingException e) {
            return false;
        }
        if (len > maxLen)
            return false;
        return true;

    }
    
    /**
     * 外字チェック
     *
     * @param str
     * @return boolean
     */
    public static boolean isJISWord(String str) {
        boolean rtnBln = true;
        try {
            for (int i = 0; i < str.length(); i++) {
                byte[] bstr = str.substring(i, i + 1).getBytes("Shift_JIS");
                // 第一水準の判定
                int int0 = 0x000000FF & bstr[0];
                int int1 = 0x000000FF & bstr[1];

                if (int0 > 0x81 && int0 < 0x87) {
                    continue;
                } else if ((int0 == 0x81 && int1 >= 0x40) || (int0 == 0x87 && int1 <= 0xFF)) {
                    continue;
                }

                if (int0 > 0x88 && int0 < 0x98) {
                    continue;
                } else if ((int0 == 0x88 && int1 >= 0x90) || (int0 == 0x98 && int1 <= 0x8F)) {
                    continue;
                } else {
                    rtnBln = false;
                    break;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return rtnBln;
    }
    /**
     * 全角数字を半角に変換します。
     *
     * @param s
     *            変換元文字列
     * @return 変換後文字列
     */
    public static String zenkakuNumToHankaku(String s) {
        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c >= '０' && c <= '９') {
                sb.setCharAt(i, (char) (c - '０' + '0'));
            }
        }
        return sb.toString();
    }

    /**
     * 全角カタカナを半角カタカナに変換します。
     *
     * @param c変換元文字列
     * @return 半角カタカナ
     */
    public static String zenkakuKatakanaToHankakuKatakana(char c) {
        if (c >= ZENKAKU_KATAKANA_FIRST_CHAR && c <= ZENKAKU_KATAKANA_LAST_CHAR) {
            return HANKAKU_KATAKANA[c - ZENKAKU_KATAKANA_FIRST_CHAR];
        } else {
            return String.valueOf(c);
        }
    }
    /**
     * 全角カタカナを半角カタカナに変換します。
     *
     * @param s
     *            変換元文字列
     * @return 半角カタカナ
     */
    public static String zenkakuKatakanaToHankakuKatakana(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char originalChar = s.charAt(i);
            String convertedChar = zenkakuKatakanaToHankakuKatakana(originalChar);
            sb.append(convertedChar);
        }
        return sb.toString();
    }

    /**
     * 全角英字を半角英字に変換します。
     *
     * @param s
     * @return 半角英字
     */
    public static String zenkakuAlphabetToHankaku(String s) {
        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c >= 'ａ' && c <= 'ｚ') {
                sb.setCharAt(i, (char) (c - 'ａ' + 'a'));
            } else if (c >= 'Ａ' && c <= 'Ｚ') {
                sb.setCharAt(i, (char) (c - 'Ａ' + 'A'));
            }
            if(c == '-'){
            	sb.setCharAt(i, '－');
            }
        }
        return sb.toString();
    }
    /**
     * 半角を全角に変更
     *
     * @param s
     * @return
     */
    public static String hankakuNumberToZenkakuNumber(String s) {
    	    StringBuffer sb = new StringBuffer(s);
    	    for (int i = 0; i < s.length(); i++) {
    	      char c = s.charAt(i);
    	      if (c >= '0' && c <= '9') {
    	        sb.setCharAt(i, (char) (c - '0' + '０'));
    	      }
    	    }
    	    return sb.toString();
    }
    /**
     *  半角を全角に変更
     *
     * @param s
     * @return
     */
    public static String hankakuAlphabetToZenkakuAlphabet(String s) {
        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          if (c >= 'a' && c <= 'z') {
            sb.setCharAt(i, (char)(c - 'a' + 'ａ'));
          } else if (c >= 'A' && c <= 'Z') {
            sb.setCharAt(i, (char)(c - 'A' + 'Ａ'));
          }
        }
        return sb.toString();
      }

    public static String han2zen(String s){
    	String rtnStr = s;
    	if(!isNull(s)){
    		rtnStr=hankakuNumberToZenkakuNumber(s);
    		rtnStr=hankakuAlphabetToZenkakuAlphabet(rtnStr);
    	}
    	return rtnStr;
    }
    /**
     * 全角文字を半角文字に変換します。
     *
     * @param s
     *            String
     * @return 半角文字
     */
    public static String zen2han(String s) {
        String rtnStr = s;
        if (!"".equals(rtnStr) && rtnStr != null) {
            rtnStr = zenkakuNumToHankaku(rtnStr);
            rtnStr = zenkakuKatakanaToHankakuKatakana(rtnStr);
            rtnStr = zenkakuAlphabetToHankaku(rtnStr);
            return rtnStr;
        }
        return rtnStr;
    }

    /**
     * 全角文字を半角文字に変換します。
     *
     * @param s
     *            String
     * @return 半角文字
     */
    public static String zen2han2(String s) {
        String rtnStr = s;
        if (!"".equals(rtnStr) && rtnStr != null) {
            rtnStr = zenkakuNumToHankaku(rtnStr);
            rtnStr = zenkakuKatakanaToHankakuKatakana(rtnStr);
            rtnStr = zenkakuAlphabetToHankaku(rtnStr);

            return rtnStr;
        }
        return rtnStr;
    }
    
   /**
    * ｃｓｖファイル項目を取得する。
    *
    * @param line
    * @return
    */
   public static String[] getCSV2Arry(String line){
   	String[] var={};
   	if(isNull(line)){
   		return var;
   	}
   	var = line.split("^\"|\",\"|\",$",-1);
   	return var;
   }
}
