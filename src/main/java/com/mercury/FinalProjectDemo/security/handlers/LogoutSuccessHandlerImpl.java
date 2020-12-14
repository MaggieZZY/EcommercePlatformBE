package com.mercury.FinalProjectDemo.security.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.mercury.FinalProjectDemo.security.SecurityUtil;

@Component
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication arg2)
			throws IOException, ServletException {
		SecurityUtil.sendResponse(response, HttpServletResponse.SC_OK, "Logout successfully.", null);
	}

}
