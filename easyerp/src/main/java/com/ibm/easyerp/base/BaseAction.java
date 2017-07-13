package com.ibm.easyerp.base;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.ibm.easyerp.util.BeanUtil;
import com.ibm.easyerp.util.StringUtil;
import com.ibm.easyerp.util.WebUtil;
import com.opensymphony.xwork2.ActionSupport;
/*******************************************************************************
 * <pre>
 * ベースアクションクラス
 * </pre>
 *
 * @author　
 * @version 1.00.00.00
 ******************************************************************************/
public class BaseAction extends ActionSupport  {
	
    protected HttpServletRequest request;

    protected HttpServletResponse response;
    
	public Integer page;	//当前页信息
	public String query;	//是否为条件查询
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 3012485993546819990L;
	
	public Integer getPage() {//获得当前页信息
		return page = (page==null || page<1)? 1 : page;
	}
	public void setPage(Integer page) {//设置当前页信息
		this.page = page;
	}
	public String getQuery() {//获得query信息
		return query;
	}
	public void setQuery(String query) {//设置query信息
		this.query = query;
	}

	@SuppressWarnings("rawtypes")
	protected Map getParams() {
        return WebUtil.getParameterMap(getHttpRequest());
    }
	
	protected void getParams(Object bean) {
        BeanUtil.copyProperties(bean, getParams());  //属性設定 getParams -> bean
    }
	
	protected HttpServletRequest getHttpRequest() {
        request = ServletActionContext.getRequest();
        return request;
    }
	
	/**
	 * メッセージに設定する。
	 * 
	 * @param messageId
	 *          リソースのキー
	 */
	protected void setMessage(String messageId){
		String message = getText(messageId);
		if(StringUtil.isNull(message)){
			message = messageId;
		}
		addActionMessage(message);
	}
	
	/**
	 * メッセージに設定する。
	 * 
	 * @param messageId
	 *        リソースのキー
	 * @param parms
	 *        パラメータ
	 */
	protected void setMessage(String messageId,String... parms){
		String message;
		message = getText(messageId,parms);
		
		if(StringUtil.isNull(message)){
			message = messageId;
		}
		addActionMessage(message);
	}
	
	/**
	 * エラーに設定する。
	 * 
	 * @param messageId
	 *          リソースのキー
	 */
	protected void setError(String messageId){
		String message = getText(messageId);
		if(StringUtil.isNull(message)){
			message = messageId;
		}
		addActionError(message);
	}
	
	/**
	 * エラーに設定する。
	 * 
	 * @param messageId
	 *          リソースのキー
	 * @param parms
	 *          パラメータ
	 */
	protected void setError(String messageId,String... parms){
		String message = getText(messageId,parms);
		
		if(StringUtil.isNull(message)){
			message = messageId;
		}
		addActionError(message);
	}
	
	/**
	 * フィールドエラーメッセージに設定する。
	 *
	 * @param fieldName
	 *         フィールド名前
	 * @param messageId
	 *         リソースのキー
	 */
	protected void setFieldError(String fieldName,String messageId){
		String message = getText(messageId);
		if(StringUtil.isNull(message)){
			message = messageId;
		}
		
		addFieldError(fieldName, message);
	}
	
	/**
	 * フィールドエラーメッセージに設定する。
	 * 
	 * @param fieldName
	 *         フィールド名前
	 * @param messageId
	 *         リソースのキー
	 * @param parms
	 *         パラメータ
	 */
	protected void setFieldError(String fieldName,String messageId,String... parms){
		String message = getText(messageId,parms);
		
		if(StringUtil.isNull(message)){
			message = messageId;
		}
		
		addFieldError(fieldName, message);
	}
	
    /**
     * ファイルダウンロードCSV共通
     *
     * @param mapping
     *            ActionMappingオブジェクト
     * @param form
     *            アクションフォームオブジェクト
     * @param request
     *            HttpServletRequestオブジェクト
     * @param response
     *            HttpServletResponseオブジェクト
     * @return 転送画面
     * @throws Exception
     *             例外
     */
    public void doDownload() throws Exception {

        try {

            // 一時ファイル名を
            File fileName = new File((String) request.getSession().getAttribute(ComConst.DOWN_FILE_PATH) + "/"
                    + (String) request.getSession().getAttribute(ComConst.DOWN_FILE_FILE));

            String tmpFileNm = java.net.URLEncoder.encode(fileName.getName(),ComConst.ENCODING_UTF_8);

            FileInputStream in = new FileInputStream((String) request.getSession().getAttribute(ComConst.DOWN_FILE_PATH) + "/"
                    + (String) request.getSession().getAttribute(ComConst.DOWN_FILE_FILE));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;
            while ((b = in.read()) != -1) {
                baos.write(b);
            }
            int cLength = baos.size(); // length

            // 応答のヘッダにcharsetを自動付加させないための暫定処理
            //response.setLocale(new Locale("", ""));
            response.reset();
            // キャッシュの無効化
            Calendar objCal1 = Calendar.getInstance();
            Calendar objCal2 = Calendar.getInstance();
            objCal2.set(1970, 0, 1, 0, 0, 0);
            response.setDateHeader("Last-Modified", objCal1.getTime().getTime());
            response.setDateHeader("Expires", objCal2.getTime().getTime());
            response.setHeader("pragma", "no-cache");

            response.setHeader("Cache-Control", "no-cache");
            // CSVはダウンロード
            response.setContentType("application/csv");

            response.setHeader("Content-Disposition", "attachment;filename=" + tmpFileNm);
            response.setContentLength(cLength);

            ServletOutputStream sos = response.getOutputStream();
            baos.writeTo(sos);
            baos.close();
            baos = null;// 後処理

            in.close();
            sos.flush();
            sos.close();
            sos = null;// 後処理

            fileName.delete();


        } catch (Exception e) {
        	// TODO
        	e.printStackTrace();
        }
    }
}
