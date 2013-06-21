package com.babailiren.ec.web.filter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.collect.ImmutableMap;

import eu.medsea.mimeutil.MimeUtil;

public class ThemesSourceFilter implements Filter {
	
	ImmutableMap<String, String> mimeMap = ImmutableMap.of("js", "text/javascript", "css", "text/css");
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		ServletContext servletContext = request.getSession().getServletContext();
		File file = new File(servletContext.getRealPath("/WEB-INF/jsp/"+ request.getRequestURI().replaceFirst(request.getContextPath(), "")));
		String ext = file.getName().substring(file.getName().lastIndexOf(".")+1);
		String extensionMime = mimeMap.get(ext);
		if(extensionMime!=null) {
			response.setContentType(extensionMime);
		} else {
			Collection<?> mimeTypes = MimeUtil.getMimeTypes(file);
			//System.out.println(mimeTypes.toString());
			response.setContentType(mimeTypes.toString());
		}

		OutputStream outp = null;
		FileInputStream in = null;
		try {
			outp = response.getOutputStream();
			in = new FileInputStream(file);

			byte[] b = new byte[4096];
			int i = 0;

			while ((i = in.read(b)) > 0) {
				outp.write(b, 0, i);
			}
			//
			outp.flush();

		} catch (FileNotFoundException e) {
			response.setStatus(404);
		} catch (Exception e) {
			response.setStatus(500);
			System.out.println("Error!");
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
				in = null;
			}
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		MimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.MagicMimeMimeDetector");
	}

}
