package com.rs.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFailureHandler implements org.springframework.security.web.authentication.AuthenticationFailureHandler
{
	@Override
	public void onAuthenticationFailure( HttpServletRequest request, HttpServletResponse response, AuthenticationException exception ) throws IOException, ServletException
	{
		if ( exception instanceof BadCredentialsException )
		{
			response.setContentType( "text/plain" );
			response.sendError( HttpServletResponse.SC_UNAUTHORIZED, exception.getMessage() );
		}

		if ( exception instanceof LockedException || exception instanceof DisabledException )
		{
			response.setContentType( "text/plain" );
			response.sendError( HttpServletResponse.SC_FORBIDDEN, exception.getMessage() );
		}

		if ( exception instanceof CredentialsExpiredException )
		{
			response.setContentType( "text/plain" );
			response.sendError( HttpServletResponse.SC_NOT_ACCEPTABLE, exception.getMessage() );
		}
	}
}
