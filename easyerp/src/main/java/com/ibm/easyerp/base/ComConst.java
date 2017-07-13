package com.ibm.easyerp.base;

/*******************************************************************************
 * <pre>
 * アプリケーション定数クラス
 * </pre>
 *
 * @author　
 * @version 1.00.00.00
 ******************************************************************************/
public class ComConst {


    public static final String ENCODING_UTF_8 = "UTF-8";
    /** システム名 */
    public static final String SYS_NAME = "erp";


    /** requestのキー */
    public static final String REQUEST_KEY_FOCUS = "OnFocus";
    /** リクエストのパラメータ. */
    public static final String ARG = "Argument";
    /** ブランク */
    public static final String BLANK = "";
    /** ユーザｃのセッションキー */
    public static final String USER_INFO = "UserInfo";


    /** 通用フラグ - 0 */
    public static final String CONST_ZERO = "0";
    /** 通用フラグ - 1 */
    public static final String CONST_ONE = "1";
    /** 通用フラグ - 2 */
    public static final String CONST_TWO = "2";
    /** 通用フラグ - 3 */
    public static final String CONST_THREE = "3";
    /** 通用フラグ - 4 */
    public static final String CONST_FOUR = "4";
    /** 通用フラグ - 5 */
    public static final String CONST_FIVE = "5";
    /** 通用フラグ - 7 */
    public static final String CONST_SEVEN = "7";
    /** 通用フラグ - 8 */
    public static final String CONST_EIGHT = "8";
    /** 通用フラグ - 9 */
    public static final String CONST_NINE = "9";
    /** 通用フラグ - , */
    public static final String CONST_COMMA = ",";
    /** 通用フラグ - / */
    public static final String CONST_SLASH = "/";
    /** 通用フラグ - - */
    public static final String CONST_HYPHEN = "-";
    /** 通用フラグ SPACE */
    public static final String CONST_SPACE = " ";
    /** メニューのキー */
    public static final String SESSION_MENU_TITLE = "menu";

    /** 最小日付 */
    public static final String MIN_DATE="1900/01/01";
    /** 最大日付 */
    public static final String MAX_DATE="9999/12/31";


    /** 日付フォーマット */
    public static final String SYSDATE_FORMAT_YMD = "yyyymmdd";
    /** 日付フォーマット yyyy/MM/dd*/
    public static final String SYSDATE_YMD = "yyyy/MM/dd";


    /** タウンロードの一時ファイルパス */
    public static final String DOWN_FILE_PATH = "down_file_path";
    /** タウンロードの一時ファイル名前 */
    public static final String DOWN_FILE_FILE = "down_file_file";
    
    /** 改行 */
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
    /** ファイル区切り文字 */
    public static final String FILE_SEPARATOR = System.getProperty("file.separator");
    /** パス区切り文字 */
    public static final String PATH_SEPARATOR = System.getProperty("path.separator");

    /** 確認メッセージのキー */
    public static final String SHOW_CONFIRM = "confirm";

    /** 一意制約 */
    public static final int SQLEXCEPTION_SAME_PK = 1;

    /** 実行権限 */
    public static final String AUTH_KBN = "authKbn";


}
