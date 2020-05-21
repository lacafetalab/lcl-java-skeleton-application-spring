package pe.lacafetalab.pao.framework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;
import pe.lacafetalab.pao.shared.domain.UserIdentification;
import pe.lacafetalab.pao.shared.domain.valueobject.Role;
import pe.lacafetalab.pao.shared.exceptions.LoginException;
import pe.lacafetalab.pao.shared.framework.ApplicationContext;
import pe.lacafetalab.pao.shared.utils.AuthenticatorUtils;
import pe.lacafetalab.pao.shared.utils.EncriptService;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	static Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	private EncriptService encriptService;
	private Role roleAccepted;

	public AuthInterceptor(EncriptService encriptService, Role roleAccepted) {
		this.encriptService = encriptService;
		this.roleAccepted = roleAccepted;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String token = AuthenticatorUtils.findToken(httpRequest);
		UserIdentification userIdentification = encriptService.decript(token);

		if (roleAccepted != null && !roleAccepted.equals(userIdentification.getRole())) {
			throw new LoginException(String.format("Role [%s] wrong, only [%s] accepted",
					userIdentification.getRole().value(), roleAccepted.value()), ErrorConstantsShared.ROLE_INVALID);
		}
		logger.info("User logged: UserId [{}] in role [{}]", userIdentification.getUserId().value(),
				userIdentification.getRole().value());
		ApplicationContext.getContext().setUser(userIdentification);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
