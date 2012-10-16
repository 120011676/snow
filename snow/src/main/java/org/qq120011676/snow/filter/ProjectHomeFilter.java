package org.qq120011676.snow.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.qq120011676.snow.util.ProjectHomeUtils;
import org.qq120011676.snow.util.StringUtils;

public class ProjectHomeFilter extends ProjectHomeUtils implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		if (StringUtils.isNull(ProjectHomeUtils.getHome())) {
			HttpServletRequest request = (HttpServletRequest) servletRequest;
			String url = request.getRequestURL().toString();
			int index = 0;
			for (int i = 0; i < 3; i++) {
				index = url.indexOf("/", index + 1);
			}
			super.init(url.substring(0, index));
		}
		chain.doFilter(servletRequest, response);
	}

	@Override
	public void destroy() {

	}

}
