package cn.base;

import cn.modules.sys.entity.SysUserEntity;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Controller公共组件
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月9日 下午9:42:26
 */
public abstract class AbstractController {
	protected Logger logger = LoggerFactory.getLogger(getClass());


	protected static String SUCCESS = "SUCCESS";
	protected static String ERROR = "ERROR";

	protected static String REDIRECT = "redirect:";
	protected static String FORWARD = "forward:";

	public static final Integer EXPORT_MAX = 10000;

	@Autowired
	protected Validator validator;

	/**
	 * 判断是否为IE浏览器
	 * @param request
	 * @return
	 */
	protected static boolean isIE(HttpServletRequest request) {
		return request.getHeader("USER-AGENT").toLowerCase().indexOf("msie") > 0 || request.getHeader("USER-AGENT").toLowerCase().indexOf("rv:11.0") > 0 || request.getHeader("USER-AGENT").toLowerCase().indexOf("edge") > 0;
	}

	protected SysUserEntity getUser() {
		return (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}


	protected void renderExcel(HttpServletRequest request, HttpServletResponse response, String filename, Workbook workbook) throws IOException {

		if (workbook instanceof HSSFWorkbook) {
			filename = filename + ".xls";
		} else {
			filename = filename + ".xlsx";
		}
		response.setHeader("name",URLEncoder.encode(filename,"UTF-8"));
		if (isIE(request)) {
			filename = URLEncoder.encode(filename, "UTF8");
		} else {
			filename = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
		}

		response.setHeader("content-disposition", "attachment;filename=" + filename);
//		跨域设置

		response.setContentType("multipart/form-data");
		response.setHeader("Access-Control-Expose-Headers","content-disposition,Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers,name");
		ServletOutputStream out = response.getOutputStream();
		workbook.write(out);
		out.flush();
	}

}
