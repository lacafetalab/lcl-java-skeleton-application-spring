package pe.lacafetalab.pao.framework;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import pe.lacafetalab.pao.shared.framework.ApplicationContext;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalFilter implements Filter {

	static Logger logger = LoggerFactory.getLogger(GlobalFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		try {
			long start = System.currentTimeMillis();
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			ApplicationContext.getContext().setTransactionId(UUID.randomUUID().toString());
			ApplicationContext.getContext().setAddress(request.getRemoteAddr());

			httpResponse.addHeader("Access-Control-Allow-Origin", "*");
			httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
			httpResponse.addHeader("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD, PUT, POST, PATCH, DELETE");
			httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Key, Authorization");

			logger.info(String.format("PAO-FILTER Started [%s] | [%s] - [%s]- [%s]", new Date(start), ApplicationContext.getContext().getTransactionId(), httpRequest.getMethod(), httpRequest.getRequestURI()));

			if ("OPTIONS".equalsIgnoreCase(httpRequest.getMethod())) {
				((HttpServletResponse) response).setStatus(HttpServletResponse.SC_OK);
			} else {
				chain.doFilter(request, response);
			}

			Long end = System.currentTimeMillis();
			logger.info(String.format("PAO-FILTER Finished [%s] | [%s] - [%s]- [%s] -> Duration [%d ms]", new Date(end), ApplicationContext.getContext().getTransactionId(), httpRequest.getMethod(),
					httpRequest.getRequestURI(), end - start));

		} finally {
			ApplicationContext.remove();
		}
	}

}
