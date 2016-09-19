package cn.liuminhua.demo.filter;


import cn.liuminhua.demo.model.Result;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by lmh on 2016/9/18.
 */

public class LoginInterceptor implements HandlerInterceptor {
	private static final Logger logger = LoggerFactory
			.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
		HandlerMethod method = (HandlerMethod) o;
		System.out.println("handler " + method.getMethod().toString());
		if (!(o instanceof HandlerMethod)) {
			return true;
		}
		if (method != null) {
			((HandlerMethod) o).getMethod();
			boolean hasSecurity = method.hasMethodAnnotation(Security.class);
			if (hasSecurity) {
				System.out.println("需要登录");
				httpServletResponse.setStatus(401);
				httpServletResponse.setCharacterEncoding("UTF-8");
				httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
				httpServletResponse.getWriter().print(JSONObject.toJSONString(Result.FaildResult(10, "请登录")));
				return false;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
		logRequest(httpServletRequest);
	}


	private void logRequest(HttpServletRequest request) {
		logger.debug("-------------------------           请求部分             ----------------------------");
		StringBuffer requestURL = request.getRequestURL();
		String method = request.getMethod();
		String contentType = request.getContentType();
		Enumeration<String> headerNames = request.getHeaderNames();
		Map<String, String[]> parameterMap = request.getParameterMap();
		Enumeration<String> attributeNames = request.getAttributeNames();
		logger.debug("{} {}", method, requestURL);
		logger.debug("request ContentType:{}", contentType);
		logger.debug("request headerNames:{}", printHeader(request));
		logger.debug("request body:{}", JSONObject.toJSONString(parameterMap));
	}


	public String printHeader(HttpServletRequest request) {
		Enumeration<String> headerNames = request.getHeaderNames();
		StringBuffer result = new StringBuffer();
		if (headerNames != null && headerNames.hasMoreElements()) {
			for (; headerNames.hasMoreElements(); ) {
				String name = headerNames.nextElement();
				String value = request.getHeader(name);
				result.append(name);
				result.append("=");
				result.append(value);
				result.append(";");
			}

		}
		return result.toString();

	}


//


}
