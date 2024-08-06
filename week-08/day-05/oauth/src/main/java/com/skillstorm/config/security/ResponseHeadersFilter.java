package com.skillstorm.config.security;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;

// the function of this class is to add a series of headers to any response from our server
// the intention is to state some rules about how our responses may be used
// must have @Component annotation to be found and used
@Component
public class ResponseHeadersFilter implements Filter {

	// this method takes request and/or response and does something with it before passing it along
	// in our case, we're just concerned with the response
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// casting the response to this type to get access to headers we can set
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		// we're going to set a series of security-related headers on the response in the next several lines
		// prevents cross-site scripting attacks
		httpResponse.setIntHeader("X-XSS-Protection", 0);
		// this forces HTTPS
        httpResponse.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains");
        // prevents the page from being displayed in an iFrame
        httpResponse.setHeader("X-Frame-Options", "deny");
        // this one forces the recipient to use the content-type specified and not try to detect it
        httpResponse.setHeader("X-Content-Type-Options", "nosniff");
        httpResponse.setHeader("Content-Security-Policy", "default-src 'self'; frame-ancestors 'none';");
        // these two denies the use of caching
        httpResponse.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, max-age=0, must-revalidate");
        httpResponse.setHeader(HttpHeaders.PRAGMA, "no-cache");
        // this one makes the headers immediately expire
        httpResponse.setIntHeader(HttpHeaders.EXPIRES, 0);
        
        chain.doFilter(request, response);
		
	}

}
