package cn.modules.base.annex.controller;

import cn.common.utils.FileUtils;
import cn.modules.base.annex.entity.BaseAnnexEntity;
import cn.modules.base.annex.service.BaseAnnexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 展示图片API
 *
 * @author jianconglee
 * @date 2019-04-08
 */
@RestController
@RequestMapping("/api")
public class BaseAnnexApiController {

	@Autowired
	private BaseAnnexService baseAnnexService;

	@RequestMapping(value="/viewImage")
	public void viewImage(HttpServletRequest request,
	                      HttpServletResponse response, @RequestParam("id")String id) throws IOException {
		ServletContext cntx= request.getServletContext();
		BaseAnnexEntity annex = baseAnnexService.selectById(id);
		String localFullPath = FileUtils.joinDirectory(annex.getAbsolutePath(), annex.getFileName());
		File localFile = new File(localFullPath);
		String mime = cntx.getMimeType(localFullPath);
		if (mime == null) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return;
		}
		response.setContentLength((int)localFile.length());
		response.setContentType(mime);
		FileInputStream in = new FileInputStream(localFile);
		OutputStream out = response.getOutputStream();

		byte[] buf = new byte[1024];
		int count = 0;
		while ((count = in.read(buf)) >= 0) {
			out.write(buf, 0, count);
		}
		out.close();
		in.close();
	}
}
