package com.saiyad.auth;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class LoginFailureHandler implements AuthenticationFailureHandler {

	@Autowired
	private Logger logger;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse res, AuthenticationException auth)
			throws IOException, ServletException {
		
		AuthenticationException exception = new AuthenticationException("Incorrect Username or Password!"){
			
		};
		exception.setStackTrace(auth.getStackTrace());
		HttpSession session = req.getSession();
		session.setAttribute("SPRING_SECURITY_LAST_EXCEPTION", exception);
		logger.info("Login Failure! Username: "+req.getParameter("username")+"\n");
		res.sendRedirect("login");
	}

}
