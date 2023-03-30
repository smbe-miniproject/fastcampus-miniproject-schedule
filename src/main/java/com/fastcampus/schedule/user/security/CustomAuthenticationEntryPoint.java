package com.fastcampus.schedule.user.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.fastcampus.schedule.exception.constant.ErrorCode;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws
		IOException,
		ServletException {
		response.setContentType("application/json");
		response.setStatus(ErrorCode.INVALID_TOKEN.getStatus().value());
		response.getWriter().write(ErrorCode.INVALID_TOKEN.name());
	}
}