package com.ibm.easyerp.util;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.beanutils.BeanUtils;

/**
 * ユーティリティクラス
 */
public class Util {

    /**
     * コンストラクタ
     */
    public Util() {
    }

    /**
     * null文字列を空文字に変換する。
     *
     * @param str
     *            処理対象文字列
     * @return 処理済文字列
     */
    public static String nullToStr(String str) {
        if (str == null)
            return "";
        else
            return str;
    }

    /**
     * 対象文字列がnullであれば&nbsp;に変換します。
     *
     * @param str
     *            対象文字列
     * @return 変換後文字列
     */
    public static String nbspOrStr(String str) {
        if (str == null)
            return "&nbsp;";
        if (str.length() == 0)
            return "&nbsp;";
        else
            return str;
    }

    /**
     * 対象文字列を指定した倍数を増えます。
     *
     * @param str
     *            対象文字列
     * @return 変換後文字列
     */
    public static String duplicator(String str, int i) {
        StringBuffer stringbuffer = new StringBuffer(i * str.length());
        for (int j = i; j > 0; j--)
            stringbuffer.append(str);

        return stringbuffer.toString();
    }


    /**
     * 指定されたThrowableの内容を出力します。
     *
     * @param throwable
     *            Throwable
     * @return Throwableの内容
     */
    public static String getStackTrace(Throwable throwable) {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        PrintWriter printwriter = new PrintWriter(bytearrayoutputstream, true);
        throwable.printStackTrace(printwriter);
        return bytearrayoutputstream.toString();
    }


    /**
     * 開始文字列と終了文字列の比較
     *
     * @param from
     *            開始文字列
     * @param to
     *            終了文字列
     * @return 終了文字列は開始文字列より小さいはfalse。その他はtrueてす。
     */
    public static boolean isFromSmallerThenTo(String from, String to) {
        if (!StringUtil.isNull(from) && !StringUtil.isNull(to)) {
            if (from.compareTo(to) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 開始と終了の比較（数字）
     *
     * @param from
     *            開始文字列
     * @param to
     *            終了文字列
     * @return 終了文字列は開始文字列より小さいはfalse。その他はtrueてす。
     */
    public static boolean isFromSmallerThenToNum(String from, String to) {
        if (!StringUtil.isNull(from) && !StringUtil.isNull(to)) {
            if ((Integer.parseInt(from))  > Integer.parseInt(to)) {
                return false;
            }
        }
        return true;
    }
    /**
     * 時間の形式変換
     *
     * @return "yyyy/MM/dd"時間
     */
    public static String formatDateString(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        return format.format(date);
    }


    /**
     * IPは正しいかどうかをチェックする。 nullの場合はtrue扱いとする。
     *
     * @param ip
     *            ＩＰアドレス
     * @return trueは正常完了 falseはエラー
     */
    public static boolean isIpCheck(String ip) {
        try {
            if (!StringUtil.isNull(ip)) {
                String regx = "((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)";
                if (ip.matches(regx)) {
                    return true;
                } else {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 金額フォーマット
     *
     * @param money
     *            ＩＰアドレス
     * @return trueは正常完了 falseはエラー
     */
    public static String getDecimalFormat(String money) {
        DecimalFormat   fmt   =   new   DecimalFormat("#,##0");
        String outMoney = null;
        double douMoney;
        try {
            if (!StringUtil.isNull(money)) {
                douMoney = Double.parseDouble(money);
                outMoney = fmt.format(douMoney);

            } else {
                outMoney = "0";
            }

        } catch (Exception e) {
        }
        return outMoney;
    }

    /**
     * 和暦フォーマット
     * @param yymmdd 和暦
     * @return 和暦フォーマット
     */
    public static String getYYMMDDFormat(String yymmdd) {
        if (yymmdd.length() != 6) {
            return yymmdd;
        }
        return yymmdd.substring(0, 2) + "年" + yymmdd.substring(2, 4) + "月" + yymmdd.substring(4) + "日";
    }

    /**
     * 文字列バイト取得
     * @param source 文字列
     * @param start 開始位置
     * @param end　終了位置
     * @return 取得した文字列
     */
    public static String getSubString(String source, int start, int end) {
        byte[] bytes = source.getBytes();
        byte[] tmp = new byte[end-start];
        for (int i = start; i < end; i ++) {
        	tmp [i - start] = bytes[i];
        }
        return new String(tmp);
    }

    /**
     * 文字列頭の０削除
     * @param source 文字列
     * @return 文字列
     */
    public static String removeZero(String source) {
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            if (c != '0') {
                return source.substring(i);
            }
        }
        return "0";
    }
}