package kr.or.ddit.jstl;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter("/localeSelect")
public class localeSelectFilter implements Filter {
	
	private Logger logger = LoggerFactory.getLogger(localeSelectFilter.class);
	
    public localeSelectFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		HttpServletRequest req = (HttpServletRequest)request;
		
		logger.debug(req.getRequestURI()+ " : localeSelectFilter doFilter");
		
		localeSelectWrapper localeselectWrapper = new localeSelectWrapper(req);
		
		chain.doFilter(localeselectWrapper, response);
		
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
