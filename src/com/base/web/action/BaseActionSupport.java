package com.base.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionSupport;

import com.base.except.SessionTimeoutException;
import com.base.service.BaseManager;
import com.base.value.AppProperty;
import com.base.value.MiscCode;
import com.base.value.NameValue;
import com.base.value.SessionUser;
import com.base.value.UploadedFile;
import com.base.util.Constant;
import campus.tool.util.security.Util;
//圖片確認
import nl.captcha.servlet.Constants;
import nl.captcha.servlet.SimpleCaptcha;

import java.net.*;
import java.io.*;

public abstract class BaseActionSupport extends ActionSupport {
	private BaseManager mgr;
	public static final String HTTP_REQUEST = "com.opensymphony.xwork.dispatcher.HttpServletRequest";
	public static final String HTTP_REQUEST_HEADER_ACCEPT_LANGUAGE = "Accept-Language";
	public static final String DELETE = "delete";

	private String delete;
	private String title;
	private String viewonly; // "true" or "false" (same as "" or null)
	private String xworkParam;
	private String captcha;
	private String cd;

	public BaseActionSupport() {
		super();
	}

	public void setBaseManager(BaseManager m) {
		mgr = m;
	}

	public BaseManager getBaseManager() {
		return mgr;
	}

	public SessionUser getSessionUser() {
		HttpSession ses = getSession();
		SessionUser user = (SessionUser) ses.getAttribute("user");
		if (user == null)
			throw new SessionTimeoutException(getText("common.sessionTimeout"));

		return user;
	}

	public String getErrorMessage(String key) {
		return super.getText("inputValidation." + key);
	}

	public void appendFieldError(String key, String msgKey) {
		addFieldError(key, getErrorMessage(msgKey));
	}

	public String getTextWithArgs(String key, String arg0, String arg1) {
		String args[] = new String[] { arg0, arg1 };

		return getText(key, args);
	}

	public String getTextWithArgs(String key, String arg) {
		String args[] = new String[] { arg };

		return getText(key, args);
	}

	public String getTextWithArgs(String key) {
		String args[] = new String[] { getContextRootRealPath() };

		return getText(key, args);
	}

	public HttpSession getSession() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest req = (HttpServletRequest) ctx.get(HTTP_REQUEST);
		HttpSession session = req.getSession();

		return session;
	}

	public String getClientIP() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest req = (HttpServletRequest) ctx.get(HTTP_REQUEST);

		return req.getRemoteAddr();
	}

	public HttpServletRequest getHttpServletRequest() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest req = (HttpServletRequest) ctx.get(HTTP_REQUEST);
		return req;
	}

	public String getContextRootPath() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest req = (HttpServletRequest) ctx.get(HTTP_REQUEST);
		return req.getContextPath();
	}

	public String getContextRootName() {
		String p = getContextRootPath();
		if (p != null && p.length() > 0)
			return p.substring(1);

		return null;
	}

	public String getClientAcceptLanguage() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest req = (HttpServletRequest) ctx.get(HTTP_REQUEST);

		java.util.StringTokenizer st = new java.util.StringTokenizer(req.getHeader(HTTP_REQUEST_HEADER_ACCEPT_LANGUAGE), ",;");
		String al = "zh-tw";
		if (st.hasMoreTokens()) {
			al = st.nextToken();
		}
		return al;
	}

	public String getClientCountry() {
		String lan = getClientAcceptLanguage();
		if (lan.indexOf("-") > 0) {
			return lan.substring(lan.indexOf("-") + 1);
		} else {
			return "tw";
		}
	}

	public String getContextRootRealPath() {
		java.io.File f = new File(getSession().getServletContext().getRealPath("/"));
		String ff = f.getAbsolutePath();

		return ff.replace('\\', '/');
	}

	public String showHtmlErrorMessage(String field) {
		Map fieldErrors = getFieldErrors();
		if (fieldErrors == null) {
			fieldErrors = Collections.EMPTY_MAP;
		}
		if (fieldErrors.containsKey(field)) {
			Object errors = (Object) fieldErrors.get(field);
			return errors.toString();
		} else {
			return "";
		}
	}

	public List getAppPropertyListByIds(Long[] ids) {
		ArrayList al = new ArrayList();
		for (int i = 0; ids != null && i < ids.length; i++) {
			if (ids[i] == null)
				continue;
			AppProperty mc = mgr.getAppPropertyById(ids[i]);
			if (mc != null)
				al.add(mc);
		}
		return al;
	}

	public List getAppPropertyListByIdList(List ids) {
		ArrayList al = new ArrayList();
		for (int i = 0; ids != null && i < ids.size(); i++) {
			if (ids.get(i) == null)
				continue;

			AppProperty mc = mgr.getAppPropertyById((Long) ids.get(i));
			if (mc != null)
				al.add(mc);
		}
		return al;
	}

	public List getMiscCodeListByIds(Long[] ids) {
		ArrayList al = new ArrayList();
		for (int i = 0; ids != null && i < ids.length; i++) {
			if (ids[i] == null)
				continue;
			MiscCode mc = mgr.getMiscCodeById(ids[i]);
			if (mc != null)
				al.add(mc);
		}
		return al;
	}

	public MiscCode getMiscCodeByCodeKeyName(String codeName, String keyName) {
		return mgr.getMiscCodeByCodeKeyName(codeName, keyName);
	}

	public AppProperty getAppPropertyById(Long id) {
		if (id != null)
			return mgr.getAppPropertyById(id);
		else
			return null;
	}

	public List getCountryList() {
		return mgr.getCountryList();
	}

	public List getWeekdayList() {
		ArrayList al = new ArrayList();
		al.add("星期一");
		al.add("星期二");
		al.add("星期三");
		al.add("星期四");
		al.add("星期五");
		al.add("星期六");
		al.add("星期日");
		return al;
	}

	public List getAppPropertyList(String kind) {
		return mgr.getAppPropertyList(kind);
	}

	public List getCountyList() {
		return mgr.getCountyList();
	}

	public List getCityList() {
		return new ArrayList(); // TODO;
	}

	public List getCityListByCountyId(Long countyId) {
		MiscCode county = getMiscCodeById(countyId);
		List ls = mgr.getMiscCodeListByCodeName(county.getCodeName() + "." + county.getKeyName());

		return ls;
	}

	public MiscCode getMiscCodeById(Long id) {
		if (id != null)
			return mgr.getMiscCodeById(id);
		else
			return null;
	}

	public List getMiscCodeListByCodeName(String codeName) {
		if (codeName != null)
			return mgr.getMiscCodeListByCodeName(codeName);
		else
			return new ArrayList();
	}

	public static Long[] getIdsFromAppPropertyList(List al) {
		if (al == null)
			return null;

		Long la[] = new Long[al.size()];

		int i = 0;
		for (Iterator iterator = al.iterator(); iterator.hasNext();) {
			AppProperty item = (AppProperty) iterator.next();
			la[i++] = item.getId();
		}
		return la;
	}

	public static Long getIdFromAppProperty(AppProperty obj) {
		if (obj == null)
			return null;

		return obj.getId();
	}

	public static Long getIdFromMiscCode(MiscCode obj) {
		if (obj == null)
			return null;

		return obj.getId();
	}

	public static Long[] getIdsFromMiscCodeList(List al) {
		if (al == null)
			return null;

		Long la[] = new Long[al.size()];

		int i = 0;
		for (Iterator iterator = al.iterator(); iterator.hasNext();) {
			MiscCode item = (MiscCode) iterator.next();
			la[i++] = item.getId();
		}
		return la;
	}

	public List getYearList(int num, int offset) {
		List al = new ArrayList();
		Calendar cal = new GregorianCalendar();

		int i = 0;
		int y = cal.get(Calendar.YEAR) + offset;
		while (i < num) {
			al.add(new Integer(y));
			y--;
			i++;
		}
		return al;
	}

	public List getYearList() {
		return getYearList(5, 1);
	}

	public String twoDigit(int n) {
		if (n < 10)
			return "0" + n;
		else
			return "" + n;
	}

	public String twoDigit(Integer n) {
		if (n == null)
			return "";

		return twoDigit(n.intValue());
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getViewonly() {
		return viewonly;
	}

	public void setViewonly(String viewonly) {
		this.viewonly = viewonly;
	}

	public boolean removeUploadedFile(String filename) {
		File f = new File(filename);
		boolean d = f.delete();
		System.out.println("delete " + filename + " is " + d);

		return d;
	}

	public boolean removeUploadedFile(String uploadedFileDir, Long id, String filename) {
		return removeUploadedFile(computeUploadedFilePath(uploadedFileDir, id, filename));
	}

	public UploadedFile computeUploadedFile(String filename, Long size) {
		UploadedFile uf = null;
		if (filename != null && filename.length() > 0)
			uf = new UploadedFile(filename, size);

		return uf;
	}

	public UploadedFile computeUploadedFile(String filename, File file) {
		long size = 0;
		if (file != null && filename != null && filename.length() > 0)
			size = file.length();

		return computeUploadedFile(filename, new Long(size));
	}

	public String computeUploadedFilePath(String uploadedFileDir, Long id, String filename) {
		String p = getText(uploadedFileDir);

		java.io.File f = new java.io.File(p);
		if (!f.exists()) {
			f.mkdirs();
		}

		return f.getAbsolutePath() + java.io.File.separatorChar + id + java.io.File.separatorChar + filename;
	}

	public boolean saveFileToLocal(String fileName, File file, String uploadedFileDir, Long id) {
		if (fileName != null && file != null) {
			ActionContext context = ActionContext.getContext();
			context.getValueStack();

			File ff = new File(uploadedFileDir);
			ff = new File(ff.getAbsolutePath() + java.io.File.separatorChar + id.longValue());
			if (ff.exists() == false)
				ff.mkdirs();
			File target = new File(ff, fileName);
			if (target.exists()) {
				target.delete();
			}
			boolean b = file.renameTo(target);
			System.out.println("save " + fileName + " ...... " + b);
			return b;
		}
		return false;
	}

	public boolean saveFileToLocal1(String fileName, File file, String uploadedFileDir, String id) {
		if (fileName != null && file != null) {
			ActionContext context = ActionContext.getContext();
			context.getValueStack();

			File ff = new File(uploadedFileDir);
			ff = new File(ff.getAbsolutePath() + java.io.File.separatorChar + id);
			if (ff.exists() == false)
				ff.mkdirs();
			File target = new File(ff, fileName);
			if (target.exists()) {
				target.delete();
			}
			boolean b = file.renameTo(target);
			System.out.println("save " + fileName + " ...... " + b);
			return b;
		}
		return false;
	}

	public List getSubmitList()
    {
        ArrayList al = new ArrayList();
        al.add(new NameValue(1, "查詢"));
        al.add(new NameValue(2,"更新或新增"));
        return al;  
    }

	public List getSexList() {
		ArrayList al = new ArrayList();
		al.add(new NameValue(Constant.SEX_LIST_MALE, getText("common.male")));
		al.add(new NameValue(Constant.SEX_LIST_FEMALE, getText("common.female")));
		return al;
	}

	public List getYesNoList() {
		ArrayList al = new ArrayList();
		al.add(new NameValue(Constant.YES_NO_LIST_YES, getText("common.yes")));
		al.add(new NameValue(Constant.YES_NO_LIST_NO, getText("common.no")));
		return al;
	}

	public boolean isYesNo(int i) {
		if (i == 1) {
			return true;
		} else {
			return false;
		}

	}

	public List getConditionList() {
		ArrayList al = new ArrayList();
		al.add(new NameValue(Constant.YES_NO_LIST_YES, getText("common.and")));
		al.add(new NameValue(Constant.YES_NO_LIST_NO, getText("common.or")));
		return al;
	}

	public List getHaveNoneList() {
		ArrayList al = new ArrayList();
		al.add(new NameValue(Constant.HAVE_NONE_LIST_HAVE, getText("common.have")));
		al.add(new NameValue(Constant.HAVE_NONE_LIST_NONE, getText("common.none")));
		return al;
	}

	public String newline2Br(String s) {
		if (s == null)
			return null;

		return campus.tool.util.Text.newlineToBr(s);
	}

	// pass parameter
	public String getXworkParam() {
		return xworkParam;
	}

	public void setXworkParam(String xworkParam) {
		this.xworkParam = xworkParam;
	}

	public void appendXworkParam(String param) {
		if (param == null)
			return;
		if (xworkParam == null) {
			xworkParam = "?" + param;
		} else {
			xworkParam = xworkParam + "&" + param;
		}
	}

	// pass parameter

	// Captcha Check
	public boolean checkCaptcha() {
		String capText = Util.decrypt(getCd());
		System.out.println("captcha answer=" + capText);
		if (getCaptcha() != null) {
			try {
				int answer = Integer.parseInt(capText);
				int userInput = Integer.parseInt(getCaptcha());
				if (answer == userInput)
					return true;
			} catch (Exception ex) {
				return false;
			}
		}
		return false;
	}

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	// Captcha Check

	//
	public String URLDecoder(String url) {
		try {
			return URLDecoder.decode(url, "UTF-8");
		} catch (Exception ex) {
			System.out.println("URLDecoder error..");
			return "Error";
		}
	}

	// Local
	public String getLocal() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest req = (HttpServletRequest) ctx.get(HTTP_REQUEST);

		return req.getLocalName();
	}

	public int getPageSize() {
		Integer s = (Integer) getSession().getAttribute("GLOBAL_pagesize");
		return s;
	}

	public String getPageIndexName() {
		String pageIndexName = new org.displaytag.util.ParamEncoder("row").encodeParameterName(org.displaytag.tags.TableTagParameters.PARAMETER_PAGE);
		return pageIndexName;
	}

	public int getPageIndex(String tableId) {
		String pageIndexName = new org.displaytag.util.ParamEncoder(tableId).encodeParameterName(org.displaytag.tags.TableTagParameters.PARAMETER_PAGE);
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest req = (HttpServletRequest) ctx.get(HTTP_REQUEST);
		String page = req.getParameter(pageIndexName);
		int pageIndex;
		if (page == null) {
			pageIndex = 0;
		} else {
			pageIndex = Integer.parseInt(page) - 1;
		}
		return pageIndex;
	}

	public int getPageIndex() {
		String pageIndexName = new org.displaytag.util.ParamEncoder("row").encodeParameterName(org.displaytag.tags.TableTagParameters.PARAMETER_PAGE);
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest req = (HttpServletRequest) ctx.get(HTTP_REQUEST);
		String page = req.getParameter(pageIndexName);
		int pageIndex;
		if (page == null) {
			pageIndex = 0;
		} else {
			pageIndex = Integer.parseInt(page) - 1;
		}
		return pageIndex;
	}

	public void fileCopy(File file, File target, String targetDirPath) {
		try {

			new File(targetDirPath).mkdirs();

			InputStream in = new FileInputStream(file);
			OutputStream out = new FileOutputStream(target);
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();
			out.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
