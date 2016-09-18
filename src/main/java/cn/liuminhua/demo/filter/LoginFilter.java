package cn.liuminhua.demo.filter;


import org.jboss.logging.Logger;
import org.springframework.web.filter.RequestContextFilter;

import javax.servlet.annotation.WebFilter;

/**
 * Created by lmh on 2016/9/18.
 */

@WebFilter(filterName = "logFilter", urlPatterns = "/*")
public class LoginFilter extends RequestContextFilter {

	private Logger logger = Logger.getLogger(LoginFilter.class.getName());

//
}
