package com.pt15305ud.config;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class MySimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	protected Log logger = LogFactory.getLog(this.getClass());

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException {

		handle(request, response, authentication);
		clearAuthenticationAttributes(request);
	}

	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {

		String targetUrl = determineTargetUrl(authentication);

		if (response.isCommitted()) {
			logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
			return;
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	protected String determineTargetUrl(final Authentication authentication) {

//		String url = req.getParameter("ref");
//		if (url == null)
//			url = "home";
//		Map<String, String> roleTargetUrlMap = new HashMap<>();
//		roleTargetUrlMap.put("ADMIN", "/" + url);
//		roleTargetUrlMap.put("USER", url.contains("admin") ? "/home" : "/" + url);

		Map<String, String> roleTargetUrlMap = new HashMap<>();
		roleTargetUrlMap.put("ROLE_DIRE", "/assets/admin/index.html#!/authorize");
		roleTargetUrlMap.put("ROLE_CUST", "/product/list");
		roleTargetUrlMap.put("ROLE_STAF", "/assets/admin/index.html#!/product");

		final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		if (authorities.contains(new SimpleGrantedAuthority("ROLE_DIRE"))) {
			return roleTargetUrlMap.get("ROLE_DIRE");
		}
		if (authorities.contains(new SimpleGrantedAuthority("ROLE_STAF"))) {
			return roleTargetUrlMap.get("ROLE_STAF");
		}
		if (authorities.contains(new SimpleGrantedAuthority("ROLE_CUST"))) {
			return roleTargetUrlMap.get("ROLE_CUST");
		}

//		for (final GrantedAuthority grantedAuthority : authorities) {
//			String authorityName = grantedAuthority.getAuthority();
//			if (roleTargetUrlMap.containsKey(authorityName)) {
//				return roleTargetUrlMap.get(authorityName);
//			}

		throw new IllegalStateException();

	}

	protected void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

}
